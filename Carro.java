public class Carro extends Veiculo {
	TipoVaga tipo = TipoVaga.CARRO;

	public Carro(String identificador) {
		this.identificador = identificador;
	}

	@Override
	public TipoVaga getTipoVaga() {
		return tipo;
	}
}
