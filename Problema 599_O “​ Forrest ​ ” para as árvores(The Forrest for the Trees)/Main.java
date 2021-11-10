import java.util.Scanner;

/**
 *Problema 599 - O “​ Forrest ​ ” para as árvores
(The Forrest for the Trees) *

Autores: Alexandre Isaac Siqueira
Guilherme Bortoto de Moraes  
Maraiza Adami Pereira 
Jorge Luis Neves Aranha 
 */

public class Main {
	
	
	static int adj[][] = new int[27][27];
	static int[] vert = new int[27];
	static int arvores = 0;
	static int acorns = 0;
	
//	reinicia o array com os vertices do teste
	static void reiniciaVert(){
		for(int i = 0; i<27;i++){
			vert[i] = 0;
		}
	}
	
// faz a recursão para zerar as arestas na matriz de adjacências	
	static void recursivo(int x){
		for(int i = 0; i<adj.length;i++){
			if(adj[x][i] == 1){
				adj[x][i] = 0;

				recursivo(i);
			}
		}
	}
	
// Conta as árvores. Para cada nó raiz que encontrar, percorre a árvore e zera.	
	static void contaArvores(){
		for(int i = 0; i<adj.length;i++){
			for(int j = 0; j<adj.length;j++){
				if(adj[i][j] == 1){
					adj[i][j] = 0;
					recursivo(j);
					arvores++;
				}
			}
		}
	}
	
	
// Coloca cada uma das arestas na matriz de adjacências
	static void povoaMatriz(String vertices){
		
		int i =  vertices.charAt(1) - 65;
		int j = vertices.charAt(3) - 65;
		adj[i][j] = 1;
		adj[j][i] = 1;
		vert[i] = 1;
		vert[j] = 1;

	}
	


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testes = sc.nextInt();
		
//		chama cada caso de teste
		for(int i = 0; i<testes;i++){

//			Lê os vértices e chama o método de povoar a matriz de adjacência
			String vertices = sc.next();
			while(vertices.charAt(0) == '('){
				povoaMatriz(vertices);
				vertices = sc.next();
				
			}
			String nos;
			
//			Lê todos os vértices da floresta
			if(vertices.charAt(0)!= '*'){
				nos = vertices;
				sc.reset();
			} else {
				nos = sc.next();
				sc.reset();
			}
			contaArvores();

//			confere se os vértices pertences a alguma árvore.
//			se não pertencerem, são 'acorns'
			for(int j = 0; j<nos.length();j = j + 2){
				
				int t = nos.charAt(j) - 65;
				if(vert[t] != 1){
					acorns++;
				}
			}
			
			
			System.out.println("There are "+arvores+" tree(s) and "+acorns+" acorn(s).");
			arvores = 0;
			acorns = 0;
			reiniciaVert();
		}
		
		

		
		
	}
	
	
	
}
