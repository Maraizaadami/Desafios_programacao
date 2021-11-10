import java.util.Scanner;
 
/**
 *Problema 1583- Gerados de Digitos 

Autores: Alexandre Isaac Siqueira
Guilherme Bortoto de Moraes  
Maraiza Adami Pereira 
Jorge Luis Neves Aranha 
 */


public class Main {
	
	static int[] results = new int[100000];
	
	public static void main (String args[])
	{
		Scanner scan = new Scanner (System.in);
		
		int T = scan.nextInt();
		
		for(int i=0; i<T; i++){
			executar(scan.nextInt());
		}
	}

	static void executar(int m){
		int counter = 0;
		if(m > 45){
			counter = m - 45;
		}		
		
		while(counter < m){
			if(results[counter] == 0){
				results[counter] = gera(counter);
			}
			if(results[counter] == m){
				System.out.println(counter);
				return;
			}
			
			counter++;
		}
		
		System.out.println("0");
		
	}
	
	static int gera(int n){
        int soma = 0;
        int a = 0;
        int original = n;
        
		while(n > 0)
        {
            a = n % 10;
            soma = soma + a;
            n = n / 10;
        }
		return original + soma;
	}
}
