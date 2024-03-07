import java.util.*;

class SomarDoisNumeros 
{
   public static Scanner sc = new Scanner(System.in);
   
   public static void main(String[]args)
   {
	   int num1 , num2 , soma;
	   System.out.println("Digite o primeiro numero: ");
	   num1 = sc.nextInt();
	   
	   System.out.println("Digite segundo numero: ");
	   num2 = sc.nextInt();
	   
	   soma = num1 + num2;
	   
	   System.out.println("A soma = " + soma);
	   
   }
}
