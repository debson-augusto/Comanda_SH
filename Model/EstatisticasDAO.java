package Model;

import Utils.Conexao;
import Utils.Formats;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author batman
 */
public class EstatisticasDAO {

    protected Connection Conn;
    protected PreparedStatement Sql;
    Date dataAtual;
    Calendar cale = Calendar.getInstance();

    public EstatisticasDAO() throws SQLException {
        this.Conn = Conexao.getConn();
        dataAtual = Formats.DataAtualSqlDate();
    }

    public <T> List<T> LoadTableMesas(Date dat) throws SQLException {
        List<Estatisticas> listEstatisticas = new ArrayList();
        String sql = "select c.id, c.id_mesa, m.tipo, u.nome from comanda c join mesa m on c.id_mesa = m.id join users u on c.id_garcom = u.id where c.data = ? and c.status = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setDate(1, dat);
        Sql.setString(2, "ABERTA");
        ResultSet rs = Sql.executeQuery();
        while (rs.next()) {
            Estatisticas obj = new Estatisticas();
            obj.setComanda(rs.getInt("id"));
            obj.setMesa(rs.getInt("id_mesa"));
            obj.setTipo(rs.getString("tipo"));
            obj.setGarcom(rs.getString("nome"));
            listEstatisticas.add(obj);
        }

        rs.close();
        Sql.close();
        return (List<T>) listEstatisticas;
    }

    public <T> List<T> LoadTablePedidos() throws SQLException {
        List<Estatisticas> listEstatisticas = new ArrayList();
        String sql = "Select c.data, c.id, c.id_mesa, c.total, c.status, g.nome from comanda c join users g on c.id_garcom = g.id where c.data = ? order by id;";
        Sql = Conn.prepareStatement(sql);
        Sql.setDate(1, dataAtual);
        ResultSet rs = Sql.executeQuery();
        while (rs.next()) {
            Estatisticas obj = new Estatisticas();
            obj.setData(rs.getDate("data"));
            obj.setComanda(rs.getInt("id"));
            obj.setMesa(rs.getInt("id_mesa"));
            obj.setValor(rs.getDouble("total"));
            obj.setStatus(rs.getString("status"));
            obj.setGarcom(rs.getString("nome"));
            listEstatisticas.add(obj);
        }

        rs.close();
        Sql.close();
        return (List<T>) listEstatisticas;
    }

    public <T> List<T> LoadComissoes(Date dat) throws SQLException {
        List<Estatisticas> listEstatisticas = new ArrayList();
        String sql = "select c.data, g.nome, count(c.total) as soma, sum(c.total) as total_vendas, sum(c.total_comissao) as total_comissao from comanda c join users g on c.id_garcom = g.id where c.data = ? and c.status = ? group by c.data, g.nome";
        Sql = Conn.prepareStatement(sql);
        Sql.setDate(1, dat);
        Sql.setString(2, "ENCERRADA");
        ResultSet rs = Sql.executeQuery();
        while (rs.next()) {
            Estatisticas obj = new Estatisticas();
            obj.setData(rs.getDate("data"));
            obj.setGarcom(rs.getString("nome"));
            obj.setQte_vendas(rs.getInt("soma"));
            obj.setSoma_vendas(rs.getDouble("total_vendas"));
            obj.setSoma_comissoes(rs.getDouble("total_comissao"));
            listEstatisticas.add(obj);
        }

        rs.close();
        Sql.close();
        return (List<T>) listEstatisticas;
    }
}
