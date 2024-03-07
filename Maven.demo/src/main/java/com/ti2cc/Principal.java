package com.ti2cc;

import java.util.Scanner;

public class Principal {
    
    public static void main(String[] args) {
        
        DAO dao = new DAO();
        dao.conectar();
        
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("\n==== Menu ====");
            System.out.println("1) Listar usuários");
            System.out.println("2) Inserir usuário");
            System.out.println("3) Excluir usuário");
            System.out.println("4) Atualizar usuário");
            System.out.println("5) Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    listarUsuarios(dao);
                    break;
                case 2:
                    inserirUsuario(dao);
                    break;
                case 3:
                    excluirUsuario(dao);
                    break;
                case 4:
                    atualizarUsuario(dao);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
        
        scanner.close();
        dao.close();
    }
    
    private static void listarUsuarios(DAO dao) {
        System.out.println("==== Listar usuários ====");
        Usuario[] usuarios = dao.getUsuarios();
        if (usuarios != null) {
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.toString());
            }
        } else {
            System.out.println("Nenhum usuário encontrado.");
        }
    }
    
    private static void inserirUsuario(DAO dao) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== Inserir usuário ====");
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Sexo (M/F): ");
        char sexo = scanner.nextLine().charAt(0);
        
        Usuario usuario = new Usuario(codigo, login, senha, sexo);
        if (dao.inserirUsuario(usuario)) {
            System.out.println("Usuário inserido com sucesso.");
        } else {
            System.out.println("Falha ao inserir usuário.");
        }
    }
    
    private static void excluirUsuario(DAO dao) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== Excluir usuário ====");
        System.out.print("Digite o código do usuário a ser excluído: ");
        int codigo = scanner.nextInt();
        
        if (dao.excluirUsuario(codigo)) {
            System.out.println("Usuário excluído com sucesso.");
        } else {
            System.out.println("Falha ao excluir usuário.");
        }
    }
    
    private static void atualizarUsuario(DAO dao) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== Atualizar usuário ====");
        System.out.print("Digite o código do usuário a ser atualizado: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        
        System.out.print("Novo login: ");
        String novoLogin = scanner.nextLine();
        System.out.print("Nova senha: ");
        String novaSenha = scanner.nextLine();
        System.out.print("Novo sexo (M/F): ");
        char novoSexo = scanner.nextLine().charAt(0);
        
        Usuario usuario = new Usuario(codigo, novoLogin, novaSenha, novoSexo);
        if (dao.atualizarUsuario(usuario)) {
            System.out.println("Usuário atualizado com sucesso.");
        } else {
            System.out.println("Falha ao atualizar usuário.");
        }
    }
}
