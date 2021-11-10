import java.util.Hashtable;
import java.util.Scanner;
import java.util.Stack;


/**
 * Problema 442-  Multiplicacao de Matrizes *

Autores: Alexandre Isaac Siqueira
Guilherme Bortoto de Moraes
Maraiza Adami Pereira   
Jorge Luis Neves Aranha 

 */
// P442
public class Main {
	// hash que guarda para cada matriz representada por um caracter suas dimensoes (numero de linhas e colunas)
	static Hashtable<Character, int[]> ht = new Hashtable<Character, int[]>(); 
	public static void main (String args[])
	{
		Scanner scan = new Scanner (System.in);
		int matrizes = scan.nextInt();
		String nome;
		int l;
		int c;

		char t;
		for (int i=0;i<matrizes;i++){
			nome = scan.next();
			l = scan.nextInt();
			c = scan.nextInt();
			int[] temp = new int[2];
			temp[0] = l;
			temp[1] = c;
			t = nome.charAt(0);
			ht.put(t, temp);
		}
		while (scan.hasNext()){
			executar(scan.next());
		}
	}

	static void executar(String l){

		if(l.length() == 1){
			System.out.println("0");
			return;
		}
		
		int answ = 0;
		Stack<int[]> pilha = new Stack<int[]>();
		
		
		// Para cada caractere
		for(int i=0; i<l.length(); i++){
			if(l.charAt(i) == '('){
				continue;
			}
			
			if(l.charAt(i) == ')'){
				
				// Desempilha
				int[] b = pilha.pop();
				
				// Desempilha
				int[] a = pilha.pop();
				
				if(isValid(a, b)){
					
					answ += a[0] * a[1] * b[1];
					
					int[] tmp = new int [2];
					tmp[0] = a[0];
					tmp[1] = b[1];
					pilha.push(tmp);
				} else {
					System.out.println("error");
					return;
				}
				
				continue;
			}
			
			pilha.push( ht.get(l.charAt(i)) );
		}
		
		System.out.println(answ);
	}
	
	static boolean isValid(int[] m1, int[] m2){
		if(m1[1] == m2[0]){
			return true;
		}
		return false;
	}
	
}
