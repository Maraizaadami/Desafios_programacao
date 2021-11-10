
import java.util.Scanner;

/**
 * Problema Uva 871 - Contando Células na Bolha*

Autores: Alexandre Isaac Siqueira
Guilherme Bortoto de Moraes  
Maraiza Adami Pereira 
Jorge Luis Neves Aranha 
 */

public class Main {
	static boolean imagem[][];
	
	static int atual;
	static int max;
	
	public static void main (String args[]) 
	{		
		Scanner scan = new Scanner (System.in);
		int N = scan.nextInt();
		scan.nextLine();
		scan.nextLine();
		//System.out.println("N: " + N);
		String sTrue = "1";
		

		
		
		String linha;
		for(int k=0; k<N; k++){
			// Pula uma linha
			
			//System.out.println("Dump: " + dump);
			
			imagem = new boolean[25][25];
			
			for (int i=0;i<25;i++){
				linha = scan.nextLine();
			
				
				if(linha.length() == 0){
					break;
				}
				
				
				//System.out.println("Linha: " + linha);
				for (int j=0;j<linha.length();j++){					
					if( linha.charAt(j) == '1') imagem[i][j] = true;
				}
				
				if(k == N){
					scan.close();
				}

			}
			
			// Imagem populada
			
			System.out.println(executar());
			System.out.println("");
			
		}
		scan.close();
		
		
		//System.out.println("End");
	}
	
	static int executar(){
		int max = 0;
		
		for(int i=0; i<imagem.length; i++){
			for(int j=0; j<imagem.length; j++){
				if(imagem[i][j]){
					atual = 0;
					achaAeronave(i, j, imagem.length);
					if(atual > max){
						max = atual;
					}
				}
			}	
		}
		
		return max;
		
	}
	
	static void achaAeronave(int x, int y, int larguraImagem){
		
		// Limpa a posição atual
		atual++;
		imagem[x][y] = false;
		
		// Coluna
		for(int offset_y=1; offset_y>-2; offset_y--){
				
			// Linha
			for(int offset_x=-1; offset_x<2; offset_x++){
				
				if(x+offset_x < larguraImagem
						&& y+offset_y < larguraImagem
						&& x+offset_x >= 0
						&& y+offset_y >= 0){
					//System.out.println("x: " + (x+offset_x) + ", y: " + (y+offset_y));
					if(imagem[x+offset_x][y+offset_y]){
						achaAeronave(x+offset_x, y+offset_y, larguraImagem);
					}
				}
			}		
		}
	}
}
