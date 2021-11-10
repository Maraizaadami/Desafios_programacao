import java.util.Scanner;

/**
 * Problema 1112- Os Ratos e o Labirinto *

Autores: Alexandre Isaac Siqueira
Guilherme Bortoto de Moraes
Maraiza Adami Pereira   
Jorge Luis Neves Aranha 

 */


public class Main {
	private static Scanner scan;
	private static int celulas, saida, tempoInicial, arestas;
	private static int[][] adjacencias;
	private static boolean[] visitados;
	private static int[] distancias;
	
	public static void main(String[]a){
		scan = new Scanner(System.in);
		int nTestes = scan.nextInt();
		
		visitados = new boolean[100];
		adjacencias = new int[100][100];

		int ini, fim, peso;
		while(nTestes>0){
			scan.nextLine();
			
			celulas = scan.nextInt();
			saida = scan.nextInt();
			saida--;
			tempoInicial = scan.nextInt();
			arestas = scan.nextInt();
			
			
			for(int i=0; i<celulas; i++){
				for(int j=0; j<celulas; j++){
					adjacencias[i][j] = Integer.MAX_VALUE/4;
				}
			}
			
			for(int i=0; i<arestas; i++){
				ini = scan.nextInt();
				fim = scan.nextInt();
				peso = scan.nextInt();
				adjacencias[ini-1][fim-1]=peso;
			}
			
			distancias = new int[celulas];
			
			executar(nTestes);
			
			reinicializar();
			nTestes--;
		}
	}

	private static void executar(int nTestes) {
		int answ = 0;
		
		//System.out.println("saida: " + saida);
		
		Bellman_Ford(saida);
		
		for(int i=0; i<distancias.length; i++){
			if(distancias[i] <= tempoInicial){
				answ++;
			}
		}
		
		
		if(nTestes > 1){
			System.out.println(answ);
			System.out.println();
		} else {
			System.out.println(answ);
		}
		
		/*
		for(int i=0; i<distancias.length; i++){
			if(distancias[i] == 536870911){
				System.out.print("_ ");
			} else {
				System.out.print(distancias[i] + " ");
			}
		}
		System.out.println();
		*/

	}
	
	private static void Bellman_Ford(int inicial){
	
		for(int i=0; i<celulas; i++){
			if(i == inicial){
				distancias[i] = 0;
			} else {
				distancias[i] = Integer.MAX_VALUE/4;
			}
		}
		
		
		// Para cada vértice
		for(int k=0; k<celulas; k++){
			for(int i=0; i<celulas; i++){
				if(i == inicial)
					continue;
				
				// Para cada aresta
				for(int j=0; j<celulas; j++){
					if(distancias[i] > distancias[j] + adjacencias[i][j]){
						//System.out.println("Entrou: (i: " + i + ", j: " + j + ")");
						distancias[i] = distancias[j] + adjacencias[i][j];
					}
				}
			}
		}
	}
	
	private static void reinicializar() {
		visitados = new boolean[100];
		adjacencias = new int[100][100];
	}
	
}
