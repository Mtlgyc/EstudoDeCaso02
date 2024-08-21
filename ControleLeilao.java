import java.util.Scanner;
import java.util.ArrayList;

public class ControleLeilao {
	private Leilao leilao;
	private Apresentação apresentacao;
	private Scanner scanner;

	public ControleLeilao() {
		this.leilao = new Leilao();
		this.apresentacao = new Apresentação();
		this.scanner = new Scanner(System.in);
	}

	public void iniciar() {
		int opcao;
		do {
			exibirMenu();
			opcao = scanner.nextInt();
			scanner.nextLine(); // Limpar o buffer
			processarOpcao(opcao);
		} while (opcao != 0);
	}

	private void exibirMenu() {
		System.out.println("Menu:");
		System.out.println("1 - Adicionar lote");
		System.out.println("2 - Mostrar lotes");
		System.out.println("3 - Fechar leilão");
		System.out.println("4 - Mostrar lotes não vendidos");
		System.out.println("5 - Remover lote");
		System.out.println("6 - Dar lance");
		System.out.println("0 - Sair");
		System.out.print("Escolha uma opção: ");
	}

	private void processarOpcao(int opcao) {
		switch (opcao) {
		case 1:
			adicionarLote();
			break;
		case 2:
			mostrarLotes();
			break;
		case 3:
			fecharLeilao();
			break;
		case 4:
			mostrarNaoVendidos();
			break;
		case 5:
			removerLote();
			break;
		case 6:
			darLance();
			break;
		case 0:
			System.out.println("Saindo...");
			break;
		default:
			System.out.println("Opção inválida.");
			break;
		}
	}

	private void adicionarLote() {
		System.out.print("Descrição do lote: ");
		String descricao = scanner.nextLine();
		leilao.adicionaLote(descricao);
		System.out.println("Lote adicionado.");
	}

	private void mostrarLotes() {
		leilao.mostraLotes();
	}

	private void fecharLeilao() {
		leilao.close();
	}

	private void mostrarNaoVendidos() {
		ArrayList<Lote> naoVendidos = leilao.getNaoVendidos();
		if (naoVendidos.isEmpty()) {
			System.out.println("Todos os lotes foram vendidos.");
		} else {
			for (Lote lote : naoVendidos) {
				System.out.println("Lote não vendido: " + lote.getDescricao());
			}
		}
	}

	private void removerLote() {
		System.out.print("Número do lote a ser removido: ");
		int numero = scanner.nextInt();
		scanner.nextLine(); // Limpar o buffer
		Lote loteRemovido = leilao.removeLote(numero);
		if (loteRemovido != null) {
			System.out.println("Lote " + loteRemovido.getNumero() + " removido.");
		}
	}

	private void darLance() {
		System.out.print("Número do lote para o qual deseja dar um lance: ");
		int numeroLote = scanner.nextInt();
		scanner.nextLine(); // Limpar o buffer

		Lote lote = leilao.getLote(numeroLote);
		if (lote != null) {
			System.out.print("Nome do licitante: ");
			String nome = scanner.nextLine();
			System.out.print("Valor do lance: ");
			double valor = scanner.nextDouble();
			scanner.nextLine(); // Limpar o buffer

			Pessoa licitante = new Pessoa(nome);
			lote.lancePara(licitante, valor);
			System.out.println("Lance registrado.");
		} else {
			System.out.println("Lote não encontrado.");
		}
	}
}