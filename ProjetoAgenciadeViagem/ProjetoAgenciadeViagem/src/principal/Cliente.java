package principal;

import java.sql.ResultSet;

public class Cliente {
	
	private int Cpf;
	private String Nacionalidade;
	private String Email;
	private int Telefone;
	private int Id;
	public ResultSet resultado;
	
	private String Nome;
	public Cliente(String nome, int cpf, String nacionalidade, String email, int telefone, int id) {
		super();
		Nome = nome;
		Cpf = cpf;
		Nacionalidade = nacionalidade;
		Email = email;
		Telefone = telefone;
		Id = id;
	}


	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getCpf() {
		return Cpf;
	}

	public void setCpf(int cpf) {
		Cpf = cpf;
	}

	public String getNacionalidade() {
		return Nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		Nacionalidade = nacionalidade;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getTelefone() {
		return Telefone;
	}

	public void setTelefone(int telefone) {
		Telefone = telefone;
	}


	public void add(Cliente Cliente) {
		
		
	}


	public void atualizarCliente(Cliente clienteAtualizar) {
		// TODO Auto-generated method stub
		
	}


}
