package aplicaco;
import java.util.Scanner;

import entidades.Mensagem;
import fila.FilaMensagens;
public class AtendimentoMensagem {

	//Henrique Mosseri RM:552240
	
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		FilaMensagens filaReclamacao= new FilaMensagens();
		FilaMensagens filaSugestao= new FilaMensagens();
		FilaMensagens filaResolucao= new FilaMensagens();
		inicializacao(filaReclamacao, filaSugestao, filaResolucao);
		int opcao;
		do {
			System.out.println(" 1 - Recebimento de mensagem");
			System.out.println(" 2 - Atendimento mensagem");
			System.out.println(" 3 - Recebimento e encaminhamento para resolução");
			System.out.println(" 0 - Encerrar atendimento");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				
				break;
				
			case 2:
				
				break;
				
			case 3:
				
				break;
				
			case 0:
				System.out.println("Obrigado por usar nosso sistema :)");
				break;
				
			default:
				System.out.println("Opcao Invalida");
			}
		} while (opcao != 0);
		
		
		
		
		sc.close();
	}
	
	public static void inicializacao(FilaMensagens filaReclamacao,FilaMensagens filaSugestao, FilaMensagens filaResolucao){

		filaReclamacao.init();
		filaSugestao.init();
		filaResolucao.init();
	}
}
