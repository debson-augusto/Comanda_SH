
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
public class Produto_PedidoDAO {

    protected Connection Conn;
    protected PreparedStatement Sql;
    ProdutosDAO pDAO = new ProdutosDAO();
    int Quantidade;
    double Valor;

    public Produto_PedidoDAO() throws SQLException {
        this.Conn = Conexao.getConn();
        Quantidade = 0;
        Valor = 0;
    }

    public void addEntity(Produto_Pedido obj) throws SQLException {
        boolean inserir = verifica(obj.getId_Produto(), obj.getId_comanda());
        if (inserir == false) {
            String sql = "INSERT INTO Produto_pedido (id_comanda,id_produto, quantidade, valor) VALUES (?,?,?,?)";
            Sql = Conn.prepareStatement(sql);
            Sql.setInt(1, (obj.getId_comanda()));
            Sql.setInt(2, (obj.getId_Produto()));
            Sql.setInt(3, (obj.getQuantidade()));
            Sql.setDouble(4, obj.getValor());
            Sql.execute();
            Sql.close();
        } else {
            String sql = "UPDATE Produto_pedido SET quantidade = ?, valor =? WHERE id_produto = ? and id_comanda = ?";
            Sql = Conn.prepareStatement(sql);
            Sql.setInt(1, (Quantidade + obj.getQuantidade()));
            Sql.setDouble(2, (Valor + obj.getValor()));
            Sql.setInt(3, (obj.getId_Produto()));
            Sql.setInt(4, (obj.getId_comanda()));
            Sql.executeUpdate();
            Sql.close();
        }

    }

    public boolean verifica(int i, int ii) throws SQLException {
        String sql = "SELECT * FROM Produto_pedido WHERE id_produto = ? and id_comanda = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setInt(1, i);
        Sql.setInt(2, ii);
        ResultSet rs = Sql.executeQuery();
        if (rs.next()) {
            Quantidade = rs.getInt("quantidade");
            Valor = rs.getDouble("valor");
            return true;
        } else {
            return false;
        }
    }

    public void remove(int id, int id_comanda) throws Exception {
        String sql = "DELETE FROM Produto_pedido WHERE id = ? and id_comanda = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setInt(1, id);
        Sql.setInt(2, id_comanda);
        Sql.executeUpdate();
        Sql.close();
    }

    public <T> List<T> getAllEntity(int id_Comanda) throws Exception {
        ComandasDAO cDAO = new ComandasDAO();
        List<Produto_Pedido> listProdutoPed = new ArrayList();
        String sql = "select pp.*, p.nome from Produto_pedido pp Join Produtos p on PP.id_produto = p.id where id_comanda = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setInt(1, id_Comanda);
        ResultSet rs = Sql.executeQuery();

        while (rs.next()) {
            Produto_Pedido obj = new Produto_Pedido();
            obj.setId(rs.getInt("id"));
            obj.setId_comanda(rs.getInt("id_comanda"));
            obj.setId_Produto(rs.getInt("id_produto"));
            obj.setQuantidade(rs.getInt("quantidade"));
            obj.setValor(rs.getDouble("valor"));
            Valor += (rs.getDouble("valor"));
            obj.setNome(rs.getString("nome"));
            listProdutoPed.add(obj);
        }

        rs.close();
        Sql.close();
        cDAO.ValorTotal(Valor, id_Comanda);
        return (List<T>) listProdutoPed;
    }

}
