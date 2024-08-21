import java.util.ArrayList;
import java.util.Iterator;

public class Leilao {
	private ArrayList<Lote> lotes;
	private int numeroProxLote;

	public Leilao() {
		this.lotes = new ArrayList<>();
		this.numeroProxLote = 1;
	}

	public void adicionaLote(String descricao) {
		this.lotes.add(new Lote(this.numeroProxLote, descricao));
		this.numeroProxLote++;
	}

	public void mostraLotes() {
		Iterator<Lote> it = this.lotes.iterator();
		while (it.hasNext()) {
			Lote lote = it.next();
			System.out.println(lote.getNumero() + ": " + lote.getDescricao());
			Lance melhorLance = lote.getMaiorLance();
			if (melhorLance != null) {
				System.out.println(" Lance: " + melhorLance.getValor());
			} else {
				System.out.println(" (Nenhum Lance)");
			}
		}
	}

	public Lote getLote(int numero) {
		if ((numero >= 1) && (numero < this.numeroProxLote)) {
			Lote loteSelecionado = this.lotes.get(numero - 1);
			if (loteSelecionado.getNumero() != numero) {
				System.out.println("Erro!!");
			}
			return loteSelecionado;
		} else {
			System.out.println("Lote número " + numero + " não existe");
			return null;
		}
	}

	public void close() {
		for (Lote lote : this.lotes) {
			Lance maiorLance = lote.getMaiorLance();
			if (maiorLance != null) {
				System.out.println("Lote " + lote.getNumero() + ": " + lote.getDescricao());
				System.out.println("Vendido para " + maiorLance.getLicitante().getNome() + " por "
						+ maiorLance.getValor() + " reais.");
			} else {
				System.out.println("Lote " + lote.getNumero() + ": " + lote.getDescricao() + " não foi vendido.");
			}
		}
	}

	public ArrayList<Lote> getNaoVendidos() {
		ArrayList<Lote> naoVendidos = new ArrayList<>();
		for (Lote lote : this.lotes) {
			if (lote.getMaiorLance() == null) {
				naoVendidos.add(lote);
			}
		}
		return naoVendidos;
	}

	public Lote removeLote(int numero) {
		if (numero >= 1 && numero < this.numeroProxLote) {
			Lote loteRemovido = this.lotes.remove(numero - 1);
			for (int i = numero - 1; i < lotes.size(); i++) {
				lotes.get(i).atualizarNumero(i + 1);
			}
			this.numeroProxLote--;
			return loteRemovido;
		} else {
			System.out.println("Lote número " + numero + " não existe");
			return null;
		}
	}
}
