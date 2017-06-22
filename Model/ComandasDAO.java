/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author batman
 */
public class ComandasDAO {

    protected Connection Conn;
    protected PreparedStatement Sql;
    int Quantidade;
    double valor;
    int idComanda;

    public ComandasDAO() throws SQLException {
        this.Conn = Conexao.getConn();
        valor = 0;
    }

    public int addEntity(Comandas obj) throws SQLException {
        String sql = "INSERT INTO comanda (id_mesa,id_garcom, data, status) VALUES (?,?,?,?)";
        Sql = Conn.prepareStatement(sql);

        //adding properties for execute before
        Sql.setInt(1, (obj.getId_mesa()));
        Sql.setInt(2, (obj.getId_Garcom()));
        Sql.setDate(3, (obj.getData()));
        Sql.setString(4, "ABERTA");

        //executing sql
        Sql.execute();
        Sql.close();

        String sql_II = "Select * from comanda order by id desc limit 1";
        Sql = Conn.prepareStatement(sql_II);
        ResultSet rs = Sql.executeQuery();
        rs.next();
        int id = rs.getInt("id");
        Sql.close();
        return id;
    }

    public void ValorTotal(double valor_Produtos, int id_comanda) throws SQLException {
        valor = valor_Produtos;
        Update(id_comanda);
    }

    public void Update(int id_comanda) throws SQLException {

        String sql = "UPDATE comanda SET total = ?, total_comissao = ? WHERE id = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setDouble(1, valor);
        Sql.setDouble(2, (valor * 0.1));
        Sql.setInt(3, id_comanda);
        Sql.executeUpdate();
        Sql.close();
    }

    public void remove(int numero) throws Exception {

        String sql = "DELETE FROM Produto_pedido WHERE id = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setInt(1, numero);
        Sql.executeUpdate();
        Sql.close();
    }

    public Comandas getComanda(int id) throws Exception {
        String sql = "SELECT * FROM comanda Where id = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setInt(1, id);
        ResultSet rs = Sql.executeQuery();
        Comandas obj = new Comandas();
        if (rs.next()) {
            obj.setId(rs.getInt("id"));
            obj.setData(rs.getDate("data"));
            obj.setId_mesa(rs.getInt("id_mesa"));
            obj.setId_Garcom(rs.getInt("id_garcom"));
            obj.setTotal(rs.getDouble("total"));
            obj.setTotal_Comissao(rs.getDouble("total_comissao"));
            obj.setStatus(rs.getString("status"));
        }

        rs.close();
        Sql.close();
        return obj;
    }

    public void Status(int id_comanda, String str) throws SQLException {

        String sql = "UPDATE comanda SET status = ? WHERE id = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setString(1, str);
        Sql.setInt(2, id_comanda);
        Sql.executeUpdate();
        Sql.close();
    }

}
