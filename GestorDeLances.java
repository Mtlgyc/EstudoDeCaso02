public class GestorDeLances {
	private Lance maiorLance;

	public Lance getMaiorLance() {
		return this.maiorLance;
	}

	public void registrarLance(Lance lance) {
		if (this.maiorLance == null || lance.getValor() > this.maiorLance.getValor()) {
			this.maiorLance = lance;
		} else {
			System.out.println("Lance inferior ao maior lance atual.");
		}
	}
}
