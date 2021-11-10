import java.io.IOException;
import java.util.Arrays;


/**
 * Problema URI 146-Códigos de Identificação *

Autores: Alexandre Isaac Siqueira
Guilherme Bortoto de Moraes  
Maraiza Adami Pereira 
 */


class Main
{
    public static void main (String args[])
    {
    	while(true){
            char lin[] = new char[255];
            int lg = 0, car = -1;
            try
            {
                while (lg < 255)
                {
                    car = System.in.read();
                    if ((car < 0) || (car == '\n')) break;
                    	if (car != 13){
                    		lin[lg] = (char)car;
                    		lg++;
                    }
                }
            }
            catch (IOException e)
            {
                return;
            }
            if (lin[0] == '#') return;
            if ((car > 0) && (lg != 0)) executar(lin,lg);
    	}
    }


	static void executar(char[] codigo, int tamanho){
		
		char alfabeto[] = new char[26];
		
		char max = codigo[tamanho-1];
		int index = -1;
		
		for(int i=tamanho-2; i>=0; i--){
			if(codigo[i] < max){
				index = i+1;
				break;
			} else {
				max = codigo[i];
			}
		}
		
		if(index == -1){
			System.out.println("No Successor");
			return;
		}
		
		
		for(int i=0; i<tamanho; i++){
			// Atualiza o alfabeto com novas letras
			if( alfabeto[charToInt(codigo[i])] == 0 ){
				alfabeto[charToInt(codigo[i])] = codigo[i];
			}
		}
		
		
		//System.out.println("len codigo: " + tamanho);
		/*
		for(int i=0; i<alfabeto.length; i++){
			System.out.print(alfabeto[i]);
		}
		*/
		//System.out.println();
		
		
		
		
		for(int i = charToInt(codigo[index-1])+1; i<26; i++){
			if(alfabeto[i] != 0){
				for(int j = index; j<tamanho; j++){
					//System.out.println("codigo j: " + codigo[j]);
					//System.out.println("alfabeto i: " + alfabeto[i]);
					if(codigo[j] == alfabeto[i]){
						
						// codigo[j] é o elemento a entrar no lugar
						// codigo[index-1] é o elemento a ser trocado
						
						
						
						char temp = codigo[index-1];
						codigo[index-1] = codigo[j];
						codigo[j] = temp;
						
						char sobra[] = new char[tamanho - index];
						
						int c = 0;
						
						//System.out.println("len sobra: " + sobra.length);
						
						for(int k=index; k<tamanho; k++){
							sobra[c] = codigo[k];
							c++;
						}
						
						/*
						for(int k=0; k < sobra.length; k++){
							System.out.print(sobra[k]);
						}
						System.out.println();
						*/
						Arrays.sort(sobra);
						/*
						for(int k=0; k < sobra.length; k++){
							System.out.print(sobra[k]);
						}
						System.out.println();
						*/
						c = 0;
						
						for(int k=index; k<tamanho; k++){
							codigo[k] = sobra[c];
							c++;
						}
						
						for(int k=0; k < tamanho; k++){
							System.out.print(codigo[k]);
						}
						System.out.println();
						
						return;
					}
				}
			}
		}
		
	}
	
	static int charToInt(char x){
		return Character.getNumericValue(x) - 10;
	}
}
