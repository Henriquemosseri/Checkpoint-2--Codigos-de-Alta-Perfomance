package aplicaco;

import java.util.Scanner;
import entidades.Mensagem;
import fila.FilaMensagens;

public class AtendimentoMensagem {

	// Henrique Mosseri RM:552240
	//Cintia Cristina
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FilaMensagens filaReclamacao = new FilaMensagens();
		FilaMensagens filaSugestao = new FilaMensagens();
		FilaMensagens filaResolucao = new FilaMensagens();
		inicializacao(filaReclamacao, filaSugestao, filaResolucao);
		int opcao, motivo = 0;
		String nome = null, email = null, mensagem = null;

		do {
			System.out.println(" 1 - Recebimento de mensagem");
			System.out.println(" 2 - Atendimento mensagem");
			System.out.println(" 3 - Recebimento e encaminhamento para resolução");
			System.out.println(" 0 - Encerrar atendimento");
			opcao = sc.nextInt();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite o seu nome (opcional)");
				sc.nextLine();
				nome = sc.nextLine();

				System.out.println("Digite seu email ou telefone (obrigatório)");
				email = sc.nextLine();

				if (email.isBlank()) {
					System.out.println("Opção invalida, vamos te redirecionar ao menu principal\n");
					break;
				}

				System.out.println("Digite o motivo do seu contato: ");
				System.out.println("1- para reclamação");
				System.out.println("2- para sugestão");
				motivo = sc.nextInt();
				if(motivo!=1 && motivo!=2) {
					System.out.println("valor invalido, te redirecionamos para o menu principal");
					break;
				}
				
				System.out.println("Por fim, digite sua mensagem");
				sc.nextLine();
				mensagem = sc.nextLine();

				if (mensagem.isBlank()) {
					System.out.println("Opção invalida, vamos te redirecionar ao menu principal");
					break;
				}
				if (motivo == 1) {
					filaReclamacao.enqueue(new Mensagem(nome, email, motivo, mensagem));
					System.out.println("Mensagem Recebida!");
				}

				else if (motivo == 2) {
					filaSugestao.enqueue(new Mensagem(nome, email, motivo, mensagem));
					System.out.println("Mensagem recebida!");
				}

				break;
				
			case 2:
				System.out.println("Qual fila você gostaria de atender?: ");
				System.out.println("1. Fila Reclamação");
				System.out.println("2. Fila Sugestão\n");
				int filaEscolhida = sc.nextInt();

				if (filaEscolhida == 1) {

					if (filaReclamacao.isEmpty()) {
						System.out.println("Não há reclamações para atender!\n");
						break;

					} else
						System.out.println("A mensagem recebida foi a seguinte: "+filaReclamacao.dequeue().getMensagem()+"\n");
				}

				else if (filaEscolhida == 2) {

					if (filaSugestao.isEmpty()) {
						System.out.println("Não há sugestões para atender!");
						break;
						
					} else
						System.out.println("A mensagem recebida foi a seguinte: "+filaSugestao.dequeue().getMensagem()+"\n");
				} else {
					System.out.println("Opção invalida, vamos te redirecionar ao menu principal");
					break;
				}
				
				System.out.println("A mensagem do cliente pode ser prontamente respondida? ");
				System.out.println("1. Sim");
				System.out.println("2. Não");
				int resposta = sc.nextInt();

				if (resposta == 1)
					System.out.println("Enviada resposta para cliente: sua solicitação já foi resolvida. Obrigado!!!");

				else {
					filaResolucao.enqueue(new Mensagem(nome, email, motivo, mensagem));
					System.out.println(
							"Enviada resposta ao cliente: Encaminharemos sua mensagem e logo receberá um retorno!");
				}
				break;

			case 3:
				if (filaResolucao.isEmpty()) {
					System.out.println("Não há resoluções para atender!");

				} else {
					filaResolucao.dequeue();
					System.out.println(
							"Enviada resposta para cliente: sua solicitação já foi resolvida pelo setor responsável. Obrigado!!!\n");
				}

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

	public static void inicializacao(FilaMensagens filaReclamacao, FilaMensagens filaSugestao,
			FilaMensagens filaResolucao) {
		filaReclamacao.init();
		filaSugestao.init();
		filaResolucao.init();
	}
}
