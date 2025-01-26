public class Bike extends Veiculo {
	TipoVaga tipo = TipoVaga.MOTO_E_BIKE;

	public Bike(String identificador) {
		this.identificador = identificador;
	}

	@Override
	public TipoVaga getTipoVaga() {
		return tipo;
	}
}