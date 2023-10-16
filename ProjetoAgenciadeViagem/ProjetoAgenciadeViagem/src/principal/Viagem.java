package principal;

import java.sql.ResultSet;
import java.util.Date;

public class Viagem {
	
	public Viagem () {
		
	}
	
	private String OrigemDestino;
	public Viagem(String origemDestino, Date dataViagem, int id, String nome) {
		super();
		OrigemDestino = origemDestino;
		DataViagem = dataViagem;
		Id = id;
		Nome = nome;
	}
	
	private Date DataViagem;
	private int Id;
	private String Nome;
	public ResultSet resultado;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getOrigemDestino() {
		return OrigemDestino;
	}
	public void setOrigemDestino(String origemDestino) {
		OrigemDestino = origemDestino;
	}
	public Date getDataViagem() {
		return DataViagem;
	}
	public void setDataViagem(Date dataViagem) {
		DataViagem = dataViagem;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public void criarViagem(Viagem viagem) {
		// TODO Auto-generated method stub
		
	}
		

}
