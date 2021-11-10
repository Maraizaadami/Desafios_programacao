import java.util.Scanner;

 
/**
 * Problema URI 639-Colocando Torres de Xadrez *

Autores: Alexandre Isaac Siqueira
Guilherme Bortoto de Moraes 
Igor Nunes Victor Ferreira 
Maraiza Adami Pereira 
 */

public class Main {

	static int n;
	static int tabuleiro[][];
	static int max = 0;

	public static void main (String[] args){
		Scanner scan = new Scanner (System.in);
		n = scan.nextInt();
		char[] caracteres;
		while (n != 0 && scan.hasNext()){
			tabuleiro = new int[n][n];
			for (int i=0;i<n;i++){
				caracteres = scan.next().toCharArray();
				for (int j=0;j<n;j++){
					if (caracteres[j] == 'X') tabuleiro[i][j] = 1;
				}
			}
			executar(0, 0, 0);
			System.out.println(max);
			max = 0;
			if (scan.hasNextInt()) n = scan.nextInt();
		}
	}

	private static void executar(int x, int y, int qtd) {
		
		
		// Chame a próxima interação
		if(y < n-1){
			executar(x, y+1, qtd);
		} else {
			if(x < n-1){
				executar(x+1, 0, qtd);
			}
		}
		
		if(isValid(x, y)){
			
			//System.out.println(x + " " + y);
			//printaTabuleiro();
			//System.out.println("qtd: " + qtd);
			
			tabuleiro[x][y] = 2;
			
			qtd++;
			
			if(qtd > max){
				max = qtd;
			}
			
			if(y < n-1){
				executar(x, y+1, qtd);
			} else {
				if(x < n-1){
					executar(x+1, 0, qtd);
				} else {
					tabuleiro[x][y] = 0;
					return;
				}
			}
			
			tabuleiro[x][y] = 0;
		}		
	}
	
	private static boolean isValid(int x, int y){
		if(tabuleiro[x][y] == 1){
			return false;
		}
		
		boolean firstTower = false;
		
		// Cheque na horizontal
		for(int l=0; l < n; l++){
			
			// Estou me checando?
			if(l == x){
				if(firstTower){
					return false;
				} else {
					firstTower = true;
				}
			}
			
			// É uma torre?
			if(tabuleiro[l][y] == 2){
				if(firstTower){
					return false;
				} else {
					firstTower = true;
				}
			}
			
			// É uma parede?			
			if(tabuleiro[l][y] == 1){
				if(l > x){
					break;
				}
				firstTower = false;
			}
		}
		
		// Reseta firstTower
		firstTower = false;
		
		
		// Cheque na vertical
		for(int c=0; c < n; c++){
			
			// Estou me checando?
			if(c == y){
				if(firstTower){
					return false;
				} else {
					firstTower = true;
				}
			}
			
			// É uma torre?
			if(tabuleiro[x][c] == 2){
				if(firstTower){
					return false;
				} else {
					firstTower = true;
				}
			}
			
			// É uma parede?			
			if(tabuleiro[x][c] == 1){
				if(c > y){
					break;
				}
				firstTower = false;
			}
		}
		
		return true;
	}
	
	public static void printaTabuleiro(){
		System.out.println();
		for(int i=0; i < n; i++){
			for(int j=0; j < n; j++){
				System.out.print(tabuleiro[i][j] + " ");
			}
			System.out.println();
		}
	}
}


/*
Exemplo de Entrada
4
.X..
....
XX..
....
2
XX
.X
3
.X.
X.X
.X.
3
...
.XX
.XX
4
....
....
....
....
3
...
..X
.X.
3
.X.
X..
...
0

Exemplo de Saida
5
1
5
2
4
4
4

 */
