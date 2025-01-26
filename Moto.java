public class Moto extends Veiculo {
	TipoVaga tipo = TipoVaga.MOTO_E_BIKE;

	public Moto(String identificador) {
		this.identificador = identificador;
	}

	@Override
	public TipoVaga getTipoVaga() {
		return tipo;
	}
}