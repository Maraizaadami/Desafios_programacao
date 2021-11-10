import java.util.Scanner;

/**
 * Problema URI 352- Guerras Sazonais *

Autores:Alexandre Isaac Siqueira
Guilherme Bortoto de Moraes  
Maraiza Adami Pereira 
 */

public class Main {
	static boolean imagem[][];
	
	public static void main (String args[]) 
	{
		Scanner scan = new Scanner (System.in);
		int N = scan.nextInt();
		int contImagens = 1;
		String sTrue = "1";
		while (N != 0){
			imagem = new boolean[N][N];
			String linha = scan.nextLine();
			for (int i=0;i<N;i++){
				linha = scan.nextLine();
				for (int j=0;j<N;j++){
					if (linha.substring(j,j+1).equals(sTrue)) imagem[i][j] = true;
				}
			}
			executar(contImagens);
			contImagens++;
			if (scan.hasNext()){
				N = scan.nextInt();
			}else{
				N = 0;
			}
		}
	}
	
	static void executar(int numeroDaImagem){
		int numeroDeAeronavess = 0;	
		int larguraImagem = imagem.length;

		/*
		 A imagem atual esta na matriz booleana imagem (que eh um atributo estatico desta classe)
		*/

		numeroDeAeronavess = correArray(larguraImagem, numeroDeAeronavess);
		
		
		System.out.println("Image number "+numeroDaImagem+" contains "+numeroDeAeronavess+" war eagles.");
	}
	
	
	// Retorna true se passar por toda matriz e não achar um caça
	static int correArray(int larguraImagem, int numeroDeAeronavess){
		for(int i=0; i<larguraImagem; i++){
			for(int j=0; j<larguraImagem; j++){
				if(imagem[i][j]){
					numeroDeAeronavess++;
					achaAeronave(i, j, larguraImagem);
				}
			}	
		}
		return numeroDeAeronavess;
	}
	
	static void achaAeronave(int x, int y, int larguraImagem){
		
		// Limpa a posição atual
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
