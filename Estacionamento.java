import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
	int vagasCarro;
	int vagasMotoBike;
	List<Veiculo> veiculoEstacionado;

	public Estacionamento(int vagasCarro, int vagasMotoBike) {
		this.vagasCarro = vagasCarro;
		this.vagasMotoBike = vagasMotoBike;
		this.veiculoEstacionado = new ArrayList<>(vagasCarro+vagasMotoBike);
	}

	public boolean registrarEntrada(Veiculo veiculo) {
		for(int i=0; i < veiculoEstacionado.size(); i++) {
			Veiculo aux = veiculoEstacionado.get(i);
			if(aux.getIdentificador().equals(veiculo.identificador)) {
				return false;
			}
		}

		if(vagasDisponiveisPara(veiculo.getTipoVaga()) > 0) {
			veiculoEstacionado.add(veiculo);
			switch(veiculo.getTipoVaga()) {
			case CARRO:
				vagasCarro--;
				break;
			case MOTO_E_BIKE:
				vagasMotoBike--;
				break;
			}
			veiculo.setTicket(new Ticket(veiculo));
			return true;
		}
		System.out.println("O veiculo nao pode ser registrado devido a falta de vagas");
		return false;
	}

	public boolean registrarSaida(String identificador, LocalDateTime horaDeSaida) {
		for (int i = 0; i < veiculoEstacionado.size(); i++) {
			Veiculo aux = veiculoEstacionado.get(i);
			if(aux.getIdentificador().equals(identificador)) {
				veiculoEstacionado.get(i).getTicket().setValorPago(veiculoEstacionado.get(i), horaDeSaida);
				veiculoEstacionado.get(i).getTicket().setPago(true);
				if(veiculoEstacionado.get(i) instanceof Carro) {
					vagasCarro++;
				} else {
					vagasMotoBike++;
				}
				veiculoEstacionado.remove(i);
				return true;
			}
		}

		return false;
	}

	public Ticket getTicketBy(String identificador) {
		for (Veiculo veiculo : veiculoEstacionado) {
			if (veiculo.getIdentificador().equals(identificador)) {
				return veiculo.getTicket();
			}
		}

		return null;
	}

	public Veiculo[] listarVeiculosEstacionados() {
		Veiculo[] veiculos = new Veiculo[veiculoEstacionado.size()];
		for(int i=0; i < veiculoEstacionado.size(); i++) {
			veiculos[i] = veiculoEstacionado.get(i);
		}

		for (Veiculo veiculo : veiculos) {
			if (veiculo != null) {
				System.out.println(veiculo.getPlaca());
				if(veiculo instanceof Carro) {
					System.out.println("Carro");
				} else if(veiculo instanceof Moto) {
					System.out.println("Moto");
				} else {
					System.out.println("Bike");
				}
				System.out.println(veiculo.getTicket().getHoraEntrada());
				if(veiculo.getTicket().isPago()==true) {
					System.out.println("Ticket foi pago");
				} else {
					System.out.println("Ticket nC#o pago");
				}

			}
		}
		return veiculos;
	}

	public int vagasDisponiveisPara(TipoVaga tipo) {
		switch(tipo) {
		case CARRO:
			return vagasCarro;
		case MOTO_E_BIKE:
			return vagasMotoBike;
		}

		return 0;
	}
}
