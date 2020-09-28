/*
 	
 	Desenvolvido por Jonathas Rocha de Souza;
 	Para o Teste Pr�tico lan�ado pela P�blica, feito com muito carinho, capricho e qualidade, com base em meus conhecimentos :)
 	link da empresa - http://publicainformatica.com.br/
 	
 	linkedin
 	https://www.linkedin.com/in/jonathasrochadesouza/
 	
 	gitHub
 	https://github.com/jonathasrochadesouza
 	
*/

package tabelaTemporada;

import java.util.Scanner;

public class PlacarMain {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Placar acess = new Placar(); // acess - permite acessar a classe Placar
		
		String read; // salvar String
		int readInt; // salvar inteiro
		
		System.out.println("Bem vinda de volta Maria! Esperamos que esteja tudo bem!");
		
		int op = 0 ;
		
		while (op != 4) {
			acess.getMenu();
			op = ler.nextInt();
			
			switch (op) {
			// atualizar o placar
			case 1:
				do {
					System.out.printf("\nQual foi o placar do jogo " + acess.nextJogo() + "? 	");
					readInt = ler.nextInt();
					if (readInt > 0 && readInt <=1000) {
						acess.setPlacar(readInt);
					} else {
						System.out.println("Algo deu errado! Maria, voc� deve ter digitado errado, por favor, digite novamente o placar"); 
					}
				} while (readInt< 0 || readInt >1000);
			break;
			
			// mostrar o placar at� o momento
			case 2:
				// acess.teste();
				acess.getPlacar();
			break;
			
			case 3:
				// qual foi o placar do jogo?
				do {
					int jogo = acess.getQualJogo();
					
					// jogo pr�-definido?
					if (jogo <= 3) {
						System.out.println("Os jogos 1, 2, 3 e 4 n�o podem ser editados, pois j� est�o definidos como base no sistema");
						break;
					}
					
					System.out.printf("\nQual foi o placar do jogo " + (jogo+1) + "?   ");
					readInt = ler.nextInt();
					if (readInt > 0 && readInt < 1000) {
							acess.setEditar(jogo, readInt); // onde o jogo � editado
					} else {
						System.out.println("Algo deu errado! Maria, voc� deve ter digitado errado, por favor, digite novamente o placar"); 
					}
				} while (readInt< 0 || readInt >1000);
			break;
			
			// 4 - exit System
			
			default:
				if (op == 4) {
					System.out.println("\nVoc� escolheu: Sair!\nObrigado por usar nosso sistema Maria :)");
				} else {
					System.out.println("Op��o Inv�lida! Por favor, escolha uma op��o v�lida");
				}
			break;
			}
		}
		
	} // main
} // class
