
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
public class ProdutosDAO {

    protected Connection Conn;
    protected PreparedStatement Sql;

    public ProdutosDAO() throws SQLException {
        this.Conn = Conexao.getConn();
    }

    public void addEntity(Produtos obj) throws SQLException {
        String sql = "INSERT INTO Produtos (nome,preco) VALUES (?,?)";
        Sql = Conn.prepareStatement(sql);
        Sql.setString(1, (obj.getNome()));
        Sql.setDouble(2, (obj.getPreco()));
        Sql.execute();
        Sql.close();

    }

    public void updateEntity(int entrada, String nome, double preco) throws SQLException {
        String sql = "UPDATE Produtos SET nome=?, preco=? WHERE ID = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setString(1, nome);
        Sql.setDouble(2, preco);
        Sql.setInt(3, entrada);
        Sql.executeUpdate();
        Sql.close();
    }

    public void remove(int numero) throws Exception {
        String sql = "DELETE FROM Produtos WHERE id = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setInt(1, numero);
        Sql.executeUpdate();
        Sql.close();
    }
    
    public double preco(int i) throws SQLException{
        String sql = "SELECT * FROM Produtos WHERE id = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setInt(1, i);
        ResultSet rs = Sql.executeQuery();       
        return rs.getDouble("preco");
    }   

    public <T> List<T> getAllEntity() throws Exception {
        List<Produtos> listProdutos = new ArrayList();
        String sql = "SELECT * FROM Produtos order by nome";
        Sql = Conn.prepareStatement(sql);
        ResultSet rs = Sql.executeQuery();
        while (rs.next()) {
            Produtos obj = new Produtos();
            obj.setId(rs.getInt("id"));
            obj.setNome(rs.getString("nome"));
            obj.setPreco(rs.getDouble("preco"));
            listProdutos.add(obj);
        }
        rs.close();
        Sql.close();
        return (List<T>) listProdutos;
    }

}
