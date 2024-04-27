package aplicacao;

import java.util.Scanner;
import entidades.Mensagem;
import fila.FilaMensagens;

public class AtendimentoMensagem {

	/*
	Henrique Mosseri RM:552240
	Guilherme Bussolan Loureiro RM:552455
	Caio Sales Dias RM: 552286
	Elizandra de Oliveira Rodrigues RM:552288
	Cintia Cristina Braga Angelo RM: 552253 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FilaMensagens filaReclamacao = new FilaMensagens();
		FilaMensagens filaSugestao = new FilaMensagens();
		FilaMensagens filaResolucao = new FilaMensagens();
		inicializacao(filaReclamacao, filaSugestao, filaResolucao);
		int opcao;

		do {
			opcao=menu(sc);
		
			switch (opcao) {
			case 1:
				recebimentoMensagem(sc, filaReclamacao, filaSugestao);
				break;

			case 2:
				atendimentoMensagem(sc, filaResolucao, filaReclamacao, filaSugestao);
				break;

			case 3:
				recebimentoEncaminhamento(filaResolucao);
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

	private static int menu(Scanner sc) {
		System.out.println(" 1 - Recebimento de mensagem");
		System.out.println(" 2 - Atendimento mensagem");
		System.out.println(" 3 - Recebimento e encaminhamento para resolução");
		System.out.println(" 0 - Encerrar atendimento");
		int opcao = sc.nextInt();

		return opcao;
	}

	private static void recebimentoEncaminhamento(FilaMensagens filaResolucao) {
		if (filaResolucao.isEmpty()) {
			System.out.println("Não há resoluções para atender!");
			return;
		}

		filaResolucao.dequeue();
		System.out.println(
				"Enviada resposta para cliente: sua solicitação já foi resolvida pelo setor responsável. Obrigado!!!\n");

	}

	private static void atendimentoMensagem(Scanner sc, FilaMensagens filaResolucao, FilaMensagens filaReclamacao,
			FilaMensagens filaSugestao) {
		System.out.println("Qual fila você gostaria de atender?: ");
		System.out.println("1. Fila Reclamação");
		System.out.println("2. Fila Sugestão\n");
		int filaEscolhida = sc.nextInt();

		if (filaEscolhida == 1) {

			if (filaReclamacao.isEmpty()) {
				System.out.println("Não há reclamações para atender!\n");
				return;

			}

		}

		else if (filaEscolhida == 2) {

			if (filaSugestao.isEmpty()) {
				System.out.println("Não há sugestões para atender!");
				return;

			}

		} else {
			System.out.println("Opção invalida, vamos te redirecionar ao menu principal");
			return;
		}

		System.out.println("A mensagem do cliente pode ser prontamente respondida? ");
		System.out.println("1. Sim");
		System.out.println("2. Não");
		int resposta = sc.nextInt();

		if (resposta == 1)
			System.out.println("Enviada resposta para cliente: sua solicitação já foi resolvida. Obrigado!!!");

		else {
			if(filaResolucao.isFull()) {
				System.out.println("A fila de resolução está cheia!! não será possível realizar a adição nela");
				return;
			}
			if (filaEscolhida == 1) {
				filaResolucao.enqueue(filaReclamacao.dequeue());
				System.out.println(
						"Enviada resposta ao cliente: Encaminharemos sua mensagem e logo receberá um retorno!");
				return;
			}
			filaResolucao.enqueue(filaSugestao.dequeue());
			System.out.println("Enviada resposta ao cliente: Encaminharemos sua mensagem e logo receberá um retorno!");
		}

	}

	private static void recebimentoMensagem(Scanner sc, FilaMensagens filaReclamacao, FilaMensagens filaSugestao) {
		String nome = null, email = null, mensagem = null;
		int motivo = 0;

		System.out.println("Digite o seu nome (opcional)");
		sc.nextLine();
		nome = sc.nextLine();

		System.out.println("Digite seu email ou telefone (obrigatório)");
		email = sc.nextLine();

		if (email.isBlank()) {
			System.out.println("Opção invalida, vamos te redirecionar ao menu principal\n");
			return;
		}

		System.out.println("Digite o motivo do seu contato: ");
		System.out.println("1- para reclamação");
		System.out.println("2- para sugestão");
		motivo = sc.nextInt();
		if (motivo != 1 && motivo != 2) {
			System.out.println("valor invalido, te redirecionamos para o menu principal");
			return;
		}
		if(motivo==1 && filaReclamacao.isFull()) {
			System.out.println("A fila está cheia!! Não aceitamos mais mensagens no momento.");
		return;
		}else if (motivo==2 && filaSugestao.isFull()){
			System.out.println("A fila está cheia!! Não aceitamos mais mensagens no momento.");
			return;
		}
		System.out.println("Por fim, digite sua mensagem");
		sc.nextLine();
		mensagem = sc.nextLine();

		if (mensagem.isBlank()) {
			System.out.println("Opção invalida, vamos te redirecionar ao menu principal");
			return;
		}
		if (motivo == 1) {
			filaReclamacao.enqueue(new Mensagem(nome, email, motivo, mensagem));
			System.out.println("Mensagem Recebida!");
		}

		else if (motivo == 2) {
			filaSugestao.enqueue(new Mensagem(nome, email, motivo, mensagem));
			System.out.println("Mensagem recebida!");
		}

	}

	public static void inicializacao(FilaMensagens filaReclamacao, FilaMensagens filaSugestao,
			FilaMensagens filaResolucao) {
		filaReclamacao.init();
		filaSugestao.init();
		filaResolucao.init();
	}
}
