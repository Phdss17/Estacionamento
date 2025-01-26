import java.time.LocalDateTime;
import java.time.Duration;

public class Ticket {
	private String identificador;
	private boolean pago;
	private Double valorpago;
	LocalDateTime entrada;

	public Ticket(Veiculo veiculo) {
		this.identificador = veiculo.identificador;
		this.pago = false;
		setHoraEntrada();
	}

	public double getValorPago() {
		return valorpago;
	}

	public boolean isPago() {
		return pago;
	}
	
	public void setHoraEntrada(){
	    entrada = LocalDateTime.now();
	}

	public LocalDateTime getHoraEntrada() {
		return entrada;
	}

	public void setValorPago(Veiculo veiculo, LocalDateTime horaDeSaida) {
		Duration duracao = Duration.between(entrada, horaDeSaida);
        long diferenca = duracao.toMinutes();
		
		if(veiculo instanceof Carro) {
			valorpago = diferenca*0.10;
			if(valorpago<5.0) {
				valorpago=5.0;
			}
		} else if(veiculo instanceof Moto) {
			valorpago = diferenca*0.05;
			if(valorpago<3.0) {
				valorpago=3.0;
			}
		} else if(veiculo instanceof Bike){
            valorpago = 3.0;
		}
	}
	
	public void setPago(boolean pago){
	    this.pago = pago;
	}
}
