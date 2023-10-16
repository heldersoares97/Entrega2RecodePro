package principal;
import java.sql.ResultSet;

import principal.Reserva;


public class Reserva {
	
    private int id;
    public Reserva(int id, int valorPassagem, String dataEmbarque, String statusReserva, int idCliente,
			int idViagem) {
		super();
		this.id = id;
		this.valorPassagem = valorPassagem;
		this.dataEmbarque = dataEmbarque;
		this.statusReserva = statusReserva;
		this.idCliente = idCliente;
		this.idViagem = idViagem;
	}

	public Reserva() {
	
	}
	private Cliente cliente;
	private Viagem viagem;
	private int valorPassagem;
    private String dataEmbarque;
    private String statusReserva;
    private int idCliente;
    private int idViagem;
	public ResultSet resultado;
    
    
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValorPassagem() {
        return valorPassagem;
    }

    public void setValorPassagem(int valorPassagem2) {
        this.valorPassagem = valorPassagem2;
    }

    public String getDataEmbarque() {
        return dataEmbarque;
    }

    public void setDataEmbarque(String dataEmbarque) {
        this.dataEmbarque = dataEmbarque;
    }

    public String getStatusReserva() {
        return statusReserva;
    }

    public void setStatusReserva(String statusReserva) {
        this.statusReserva = statusReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(int idViagem) {
        this.idViagem = idViagem;
    }

	public void add(Reserva reserva1) {
		
		
	}

	public Viagem getViagem() {
		return viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}

