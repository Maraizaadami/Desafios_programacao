import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Problema URI 151. Crise Elétrica *

Autores: Alexandre Isaac Siqueira
Guilherme Bortoto de Moraes
Maraiza Adami Pereira   
Jorge Luis Neves Aranha 

 */



class Main
{
	
	static int powerStation = 13;
	
	static ArrayList<Integer> cidades = new ArrayList<Integer>();
	
    public static void main (String args[])
    {
    	int x = 0;
    	Scanner scan = new Scanner (System.in);  
    	while (scan.hasNext()){
   			x = scan.nextInt();
   			if (x==0) break;
    	  	executar(x);   			
		}
	}
    
    static void popula(int m){
    	//System.out.println("Recebeu: " + m);
    	cidades.clear();
    	for(int i=0; i<m; i++){
    		cidades.add(i+1);
    	}
    }
    
    static void executar(int x){
    	
    	int i = 1;
    	popula(x);
    	while(!mValido(i)){
    		popula(x);
    		i++;
    	}
    	System.out.println(i);
    }
    
    static boolean mValido(int m){
    	
    	int current = 0;
    	 	
    	while(cidades.get(current) != powerStation){
    		//System.out.println(cidades.get(current));
    		cidades.remove(current);
    		
    		current = (current + m - 1) % cidades.size();
    	}
    	
    	if(cidades.size() == 1){
    		return true;
    	}
    	
    	return false;
    }
}
