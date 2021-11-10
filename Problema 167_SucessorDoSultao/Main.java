import java.util.Scanner;



/**
 * Problema 167- Os Sucessores do Sultão *

Autores: Alexandre Isaac Siqueira
Guilherme Bortoto de Moraes
Maraiza Adami Pereira   
Jorge Luis Neves Aranha 

 */


class Main
{
	
	static int globalAnsw = 0;
	static int currentAnsw = 0;
	
    public static void main (String args[]) 
    {
    	int m[][];
    	Scanner scan = new Scanner (System.in);
    	int n = scan.nextInt();
    	m = new int[8][8];
    	int i = 0;
    	int j = 0;
    	int k = 0;
    	for (k=0;k<n;k++){
    		while (scan.hasNext()){	
	    		m[i][j] = scan.nextInt();
	    	  	j = (j + 1) % 8;
	    	  	if (j==0) i++;
	    	  	if (i==8) break;
	    	}
    		j=0;
    		i=0;
    		executar(m);
    	}
    }
    
    // Soma os valores das rainhas
    static int soma(int[][] m, int[] rainhas){
    	int soma = 0;
    	for(int i=0;i<8;i++){
    		soma += m[rainhas[i]][i];
    	}
    	return soma;
    }
    
    // Último print
    static void printFinal(int result){
    	int length = (int) (Math.log10(result) + 1);
    	
    	for(int i=0; i < 5 - length; i++){
    		System.out.print(" ");
    	}
    	System.out.println(result);
    	
    }
    
    // Printa a matriz
    static void printa(int[][] m){
    	for (int i=0;i<8;i++){
    		for (int j=0;j<8;j++){
    			System.out.print(m[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
    
    // Colocar a rainha é plausível?
    static boolean plausivel(int i, int j, int[] rainhas){
    	
    	// Se houver uma rainha na mesma coluna
    	if(rainhas[j] != -1){
    		return false;
    	}
    	
    	// Se houver uma rainha na mesma linha
		for(int k=0; k<8; k++){
			if(rainhas[k] == i){
				return false;
			}
		}
		
		// Se houver uma rainha na diagonal
		
		for(int k=0; k<8; k++){
			if(rainhas[k] != -1){
				if( Math.abs(i - rainhas[k]) == Math.abs(j - k) ){
					return false;
				}
			}
		}
    	
    	return true;
    }
    
    static void executar(int m[][]){
    	
    	globalAnsw = 0;
    	currentAnsw = 0;

    	
    	int[] rainhas = new int [8];
    	for(int i=0; i<8; i++){
    		rainhas[i] = -1;
    	}
    	
    	int col = 0;    	
    	
    	tentar(col, rainhas, m);
    	
    	printFinal(globalAnsw);

    }
    
    // Recursão
    static void tentar(int col, int[] rainhas, int[][] m){
    		if(col == 8){
    			
    			/*
    			System.out.print("Rainhas: ");
    			for(int k=0; k<8; k++){
    				System.out.print(rainhas[k] + " ");
    			}
    			System.out.println();
    			*/
    			
    			currentAnsw = soma(m, rainhas);
    		
    			
    			if(currentAnsw > globalAnsw){
    				globalAnsw = currentAnsw;
    			}
    			return;
    		}
    		
    		for(int i=0; i<8; i++){
    			if(plausivel(i, col, rainhas)){
    				rainhas[col] = i;
    				tentar(col + 1, rainhas, m);
    				rainhas[col] = -1;
    			}    			
    		}
    }
}
