package principalDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import principal.Conexao;
import principal.Reserva;

public class ReservaDAO {
    private Connection conexao;
    
    ClienteDAO  clienteDAO = new ClienteDAO();
    ViagemDAO   viagemDAO = new  ViagemDAO();
    
    public ReservaDAO() {
        try {
            conexao = Conexao.conectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void criarReserva(Reserva reserva) {
        String sql = "INSERT INTO reserva (valor_passagem, data_embarque,status_reserva,id_cliente) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, reserva.getValorPassagem());
            stmt.setString(2, reserva.getDataEmbarque());
            stmt.setString(3,reserva.getStatusReserva());
            stmt.setInt(4, reserva.getCliente().getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Reserva buscarReserva(int idReserva) {
        Reserva reserva = null;
        String sql = "SELECT * FROM reserva WHERE Id_reserva = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idReserva);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                reserva = new Reserva();
                reserva.setId(resultado.getInt("Id_reserva"));
                reserva.setCliente(clienteDAO.buscarCliente(resultado.getInt("Id_cliente")));
                reserva.setValorPassagem(resultado.getInt("valor_passagem"));
                reserva.setDataEmbarque(resultado.getString("data_embarque"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reserva;
    }


    public void atualizarReserva(Reserva reservaAtualizada) {
        String sql = "UPDATE reserva SET id_cliente = ?, data_embarque = ? WHERE id_reserva = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, reservaAtualizada.getIdCliente());
            stmt.setString(2, reservaAtualizada.getDataEmbarque());
            stmt.setInt(3, reservaAtualizada.getId());
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




