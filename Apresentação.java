import java.util.ArrayList;

public class Apresentação {
	public void exibirLotes(ArrayList<Lote> lotes) {
		for (Lote lote : lotes) {
			System.out.println(lote.getNumero() + ": " + lote.getDescricao());
			Lance melhorLance = lote.getMaiorLance();
			if (melhorLance != null) {
				System.out.println(" Lance: " + melhorLance.getValor());
			} else {
				System.out.println(" (Nenhum Lance)");
			}
		}
	}
}