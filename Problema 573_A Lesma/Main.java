import java.util.Scanner;

/**
 * Problema Uva 573-A Lesma *

Autores: Alexandre Isaac Siqueira
Guilherme Bortoto de Moraes  
Maraiza Adami Pereira 
Jorge Luis Neves Aranha 
 */


public class Main {
	public static void main (String args[]) 
	{
		Scanner scan = new Scanner (System.in);
		
		int alturaFinal = -1;
		int capacidade = -1;
		int escorrega = -1;
		int fadiga = -1;
		
		
		while(true){
			alturaFinal = scan.nextInt();
			capacidade = scan.nextInt();
			escorrega = scan.nextInt();
			fadiga = scan.nextInt();
			
			if(alturaFinal == 0){
				break;
			}
					
					
			executar(alturaFinal, capacidade, escorrega, fadiga);
			//System.out.println("\n\n\n");
		}
		
		
		
	}
	
	public static void executar(int alturaFinal, int capacidade, int escorrega, int fadiga){
		
		double d_alturaFinal = (double) alturaFinal;
		double d_capacidade = (double) capacidade;
		double d_escorrega = (double) escorrega;
		double d_fadiga = d_capacidade * (fadiga/100.0);
		
		int diaAtual = 1;
		double d_alturaAtual = 0.0;
		double d_alturaAnterior = 0.0;
		
		while(true){
			
			// --------------------------------------------------------- Anda
			if(d_capacidade > 0){
				d_alturaAtual += d_capacidade;
			}
			
			
			// --------------------------------------------------------- CP1 = Chegamos?
			if(d_alturaAtual > d_alturaFinal){
				System.out.println("success on day " + diaAtual);
				break;
			}
			
			d_capacidade -= d_fadiga;
			
			// --------------------------------------------------------- Escorrega
			d_alturaAtual -= d_escorrega;
			
			// --------------------------------------------------------- CP2 = Chão
			if(d_alturaAtual < 0){
				System.out.println("failure on day " + diaAtual);
				break;
			}
			
			// --------------------------------------------------------- Dia ++
			diaAtual++;
			
		}
	};
}
