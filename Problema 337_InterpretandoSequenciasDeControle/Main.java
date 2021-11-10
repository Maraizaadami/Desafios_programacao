import java.util.Scanner;


/**
 * Problema URI 337-Interpretando Sequências de Controle *

Autores: Alexandre Isaac Siqueira
Guilherme Bortoto de Moraes
Maraiza Adami Pereira   
Jorge Luis Neves Aranha 

 */


public class Main {

	//TODO : DADOS DO TERMINAL, nao esqueca de inicializa-los (se necessario)
	static char[][] terminal = new char[10][10];
	static int cursorX = 0;
	static int cursorY = 0;
	static boolean modoDeSobrescrita = true;

	public static void main (String args[]) 
	{
		Scanner scan = new Scanner (System.in);
		int N = scan.nextInt();
		int numeroDoTeste = 1;
		while (N != 0){
			String linha = scan.nextLine();
			cursorX = 0;
			cursorY = 0;
			iniciarTerminal();
			System.out.println("Case " + numeroDoTeste);
			for (int contLinhas = 0; contLinhas < N; contLinhas++){
				linha = scan.nextLine();
				try{
					executar(linha);
				} catch(Exception e){
					imprimirTerminal();
					//System.out.println("Quebrou\n\n\n");
				}
			}
			imprimirTerminal();
			N = scan.nextInt();
			numeroDoTeste++;
		}
	}		  	

	static void iniciarTerminal(){
		for (int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				terminal[i][j] = ' ';
			}
		}
	}

	static void imprimirTerminal(){
		System.out.println("+----------+");
		for (int i=0;i<10;i++){
			System.out.print("|");
			for (int j=0;j<10;j++){
				System.out.print(terminal[i][j]);
			}
			System.out.println("|");
		}
		System.out.println("+----------+");
	}
	
	static void executar(String linha){
		//System.out.println("Executar");
		for(int i=0; i<linha.length(); i++){
			//System.out.println("\nIteração: " + i);
			//System.out.println("Letra: " + linha.charAt(i));
			
			if(linha.charAt(i) == '^'){
				//System.out.println("Comando detectado: " + linha.charAt(i+1));
				switch(linha.charAt(i+1)){
					case 'b':
						// Move para o início da linha
						cursorY = 0;
						break;
						
					case 'c':
						// Reset
						iniciarTerminal();
						break;
						
					case 'd':
						// Move uma linha para baixo
						if(cursorX < 9){
							cursorX++;
						}
						break;
						
					case 'e':
						// Apaga tudo a direita
						for(int e=cursorY; e<10; e++){
							terminal[cursorX][e] = ' ';
						}
						break;
						
					case 'h':
						// Move o cursor para linha 0, coluna 0
						cursorX = 0;
						cursorY = 0;
						break;
						
					case 'i':
						// Modo de entrada
						modoDeSobrescrita = false;
						break;
						
					case 'l':
						// Move uma coluina para a esquerda
						if(cursorY > 0){
							cursorY--;
						}
						break;
						
					case 'o':
						// Ativa o modo de subscrita
						modoDeSobrescrita = true;
						break;
						
					case 'r':
						// Move o cursor uma coluna para a direita
						if(cursorY < 9){
							cursorY++;
						}
						break;
						
					case 'u':
						// Move o cursor uma linha para cima
						if(cursorX > 0){
							cursorX--;
						}
						break;
						
					case '^':
						// Escreve o acento na posição atual
						escreveNoTerminal('^');
						break;
					
					default:
						//System.out.println("Número - Iteração " + i);
						cursorX = linha.charAt(i+1) - '0';
						cursorY = linha.charAt(i+2) - '0';
						//System.out.println("Posição: (X: " + cursorX + ", Y: " + cursorY + ")");
						
						
						i++;
				}
				
				i++;
					
			} else {
				escreveNoTerminal(linha.charAt(i));
			}
		}// fim do for
	}// fim do executar
	
	static void escreveNoTerminal(char elemento){
		//System.out.println("escreve no terminal: " + elemento);
		//System.out.println("Posição: (X: " + cursorX + ", Y: " + cursorY + ")");
		if(modoDeSobrescrita){
			terminal[cursorX][cursorY] = elemento;
		} else {
			for(int i=9; i>cursorY; i--){
				terminal[cursorX][i] = terminal[cursorX][i-1];
			}
			terminal[cursorX][cursorY] = elemento;
		}
		
		if(cursorY < 9){
			cursorY++;
		}
		
	}
	
	
	/* uma maneira de se pegar um dado caracter eh assim: char atual = linha.charAt(i);
    caracteres sao comparados usando aspas simples e nao duplas: if (atual == '^'){
    para limpar o terminal é necessario inserir espacos em branco nele: ' ' (note que este nao eh o valor padrao de um char recem inicializado) */
}
