public class Veiculo {
	protected String identificador;
	TipoVaga tipo;
	Ticket ticket;

	public String getIdentificador() {
		return identificador;
	}

	public TipoVaga getTipoVaga() {
		return tipo;
	}
	
	public void setTicket(Ticket ticket){
	    this.ticket = ticket;
	}
	
	public Ticket getTicket(){
	    return ticket;
	}
	
	public String getPlaca(){
	    return identificador;
	}
	
	
}