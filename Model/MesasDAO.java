package Model;

import Utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author batman
 */
public class MesasDAO {

    protected Connection Conn;
    protected PreparedStatement Sql;

    public MesasDAO() throws SQLException {
        this.Conn = Conexao.getConn();
    }

    public void addEntity(Object obj) throws SQLException {
        String sql = "INSERT INTO Mesa (numero,tipo, status) VALUES (?,?,?)";
        Sql = Conn.prepareStatement(sql);
        Sql.setInt(1, ((Mesas) obj).getNumero());
        Sql.setString(2, ((Mesas) obj).getTipo());
        Sql.setString(3, ((Mesas) obj).getStatus());
        Sql.execute();
        Sql.close();

    }

    public void remove(int numero) throws Exception {

        String sql = "DELETE FROM Mesa WHERE id = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setInt(1, numero);
        Sql.executeUpdate();
        Sql.close();
    }

    public <T> List<T> getAllEntity() throws Exception {
        List<Mesas> listMesas = new ArrayList();
        String sql = "SELECT * FROM Mesa order by numero";
        Sql = Conn.prepareStatement(sql);
        ResultSet rs = Sql.executeQuery();
        while (rs.next()) {
            Mesas obj = new Mesas();
            obj.setId(rs.getInt("id"));
            obj.setNumero(rs.getInt("numero"));
            obj.setTipo(rs.getString("tipo"));
            listMesas.add(obj);
        }
        rs.close();
        Sql.close();
        return (List<T>) listMesas;
    }

    public <T> List<T> getAllEntityVazias(String str) throws Exception {
        List<Mesas> listMesas = new ArrayList();
        String sql = "SELECT * FROM Mesa where status =? order by numero";
        Sql = Conn.prepareStatement(sql);
        Sql.setString(1, str);
        ResultSet rs = Sql.executeQuery();
        while (rs.next()) {
            Mesas obj = new Mesas();
            obj.setId(rs.getInt("id"));
            obj.setNumero(rs.getInt("numero"));
            obj.setTipo(rs.getString("tipo"));
            listMesas.add(obj);
        }
        rs.close();
        Sql.close();
        return (List<T>) listMesas;
    }

    public int GetId(int ios, String str) throws SQLException {
        String sql = "SELECT * FROM Mesa where status = ? order by numero";
        Sql = Conn.prepareStatement(sql);
        Sql.setString(1, str);
        ResultSet rs = Sql.executeQuery();
        for (int i = 1; i < ios; i++) {
            rs.next();
        }
        rs.next();
        int id = rs.getInt("id");
        rs.close();
        Sql.close();
        return id;
    }

    public String Tipo(int numero) throws Exception {
        String sql = "SELECT * FROM Mesa WHERE id = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setInt(1, numero);
        ResultSet rs = Sql.executeQuery();
        rs.next();
        String tipo = rs.getString("tipo");
        rs.close();
        Sql.close();
        return tipo;
    }

    public int Numero(int numero) throws Exception {
        String sql = "SELECT * FROM Mesa WHERE id = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setInt(1, numero);
        ResultSet rs = Sql.executeQuery();
        rs.next();
        int Numero = rs.getInt("numero");
        rs.close();
        Sql.close();
        return Numero;
    }

    public void updateEntity(int entrada, String status) throws SQLException {

        String sql = "UPDATE mesa SET status=? WHERE ID = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setString(1, status);
        Sql.setInt(2, entrada);
        Sql.executeUpdate();
        Sql.close();
    }

}
