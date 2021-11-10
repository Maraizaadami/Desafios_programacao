import java.util.Scanner;
import java.util.ArrayList;

/**
 * Problema URI 580- Massa Crítica *

Autores:  Guilherme Bortoto de Moraes 
Maraiza Adami Pereira 
Jorge Luis Neves Aranha 
 */


class Main
{
	static ArrayList<Integer> pilha = new ArrayList<Integer>();
	
	public static void main (String args[])
	{
		// n = 1
		pilha.add(0);
		
		// n = 2
		pilha.add(0);
		
		// n = 3
		pilha.add(1);
		
		int x = 0;
		Scanner scan = new Scanner (System.in);
		while (scan.hasNext()){
			x = scan.nextInt();
			if (x == 0) break;
			executar(x);
			scan.nextLine();

		}
	}

	static void executar(int x){
		System.out.println(calculaProblemas(x));
		//System.out.println(pilha);
	}
	
	static int calculaProblemas(int n){
		if(n < 1){
			return 0;
		}
		
		if(pilha.size() >= n){
			//System.out.println("Entrou");
			//System.out.println("resultado para " + n + ": " + pilha.get(n-1));
			return pilha.get(n-1);
		}
		
		int a = calculaProblemas(n-1);
		
		//System.out.println("n: " + n);
		
		int novasPossibilidades = ((int) (Math.pow(2, n-4)) - calculaProblemas(n-4));
		
		//System.out.println("Novas p: " + novasPossibilidades);
		
		int resultado = a + a + novasPossibilidades;
		
		
		
		pilha.add(resultado);
		
		//System.out.println("resultado para " + n + ": " + resultado);
		return resultado;
	}
		
}
