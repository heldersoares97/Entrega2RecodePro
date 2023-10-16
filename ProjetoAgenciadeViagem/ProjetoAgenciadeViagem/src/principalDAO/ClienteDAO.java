package principalDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import principal.Conexao;
import principal.Cliente;

public class ClienteDAO {
	
	
    private Connection conexao;
    
    public ClienteDAO(){

        try {
            conexao = Conexao.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, cpf, nacionalidade, email, telefone) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getCpf());
            stmt.setString(3, cliente.getNacionalidade());
            stmt.setString(4, cliente.getEmail());
            stmt.setInt(5, cliente.getTelefone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente buscarCliente(int id) {
        Cliente Cliente = null;
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                Cliente = new Cliente();
                Cliente.setId(resultado.getInt("Id_cliente"));
                Cliente.setNome(resultado.getString("Nome"));
                Cliente.setNacionalidade(resultado.getString("Nacionalidade")); // Corrigido para atribuir a nacionalidade a cliente
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Cliente;
    }


    public List<Cliente> listarCliente() {
        List<Cliente> Clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Cliente Cliente = new Cliente();
                Cliente.setId(resultado.getInt("id_cliente"));
                Cliente.setNome(resultado.getString("nome"));
                Cliente.setNacionalidade(resultado.getString("nacionalidade")); 
                Cliente.setEmail(resultado.getString("email"));
                Cliente.setTelefone(resultado.getInt("telefone"));
                Clientes.add(Cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Clientes;
    }


    public void atualizarCliente(Cliente Cliente) {
        String sql = "UPDATE cliente SET nome = ?, nacionalidade = ?, email = ?, telefone = ? WHERE id_cliente = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, Cliente.getNome());
            stmt.setString(2, Cliente.getNacionalidade());
            stmt.setString(3, Cliente.getEmail()); // Adicione o email
            stmt.setInt(4, Cliente.getTelefone()); // Adicione o telefone
            stmt.setInt(5, Cliente.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirCliente(int id) {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



