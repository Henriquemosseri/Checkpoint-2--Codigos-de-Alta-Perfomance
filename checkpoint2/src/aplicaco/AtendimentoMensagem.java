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
			System.out.println("Digite o seu nome (opcional)");
			String nome= sc.nextLine();
			sc.nextLine();
			
			System.out.println("Digite seu email ou telefone (obrigatório)");
			String email=sc.nextLine();
			
			if(email.equalsIgnoreCase("")) { 
				opcao=1;
				System.out.println("Opção invalida, vamos te redirecionar ao menu principal");
				break;
			}
			System.out.println("Digite o motivo do seu contato: ");
			System.out.println("1- para reclamação");
			System.out.println("2- para sugestão");
			int motivo= sc.nextInt();
			
			System.out.println("Por fim, digite sua mensagem");
			String mensagem= sc.nextLine();
			sc.nextLine();
			if(mensagem.equalsIgnoreCase("")) { 
				opcao=1;
				System.out.println("Opção invalida, vamos te redirecionar ao menu principal");
				break;
			}
			
			if(motivo==1) 
				filaReclamacao.enqueue(new Mensagem(nome, email, motivo, mensagem));
			
			else if (motivo==2)
				filaSugestao.enqueue(new Mensagem(nome,email,motivo,mensagem));
			
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
