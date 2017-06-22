/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.Conexao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author batman
 */
public class UsersDAO {

    protected java.sql.Connection Conn;
    protected java.sql.PreparedStatement Sql;

    public UsersDAO() throws SQLException {
        this.Conn = Conexao.getConn();
    }

    private void preencherObj(Users obj, ResultSet rs) throws SQLException, Exception {
        obj.setId(rs.getInt("id"));
        obj.setNome(rs.getString("nome"));
        obj.setCPF(rs.getString("cpf"));
        obj.setSenha(rs.getString("senha"));
        obj.setCargo(rs.getInt("cargo"));
    }

    public void addEntity(Users obj) throws SQLException {
        String sql = "INSERT INTO USERS (NOME, SENHA, CARGO, CPF) VALUES (?,?,?,?)";
        Sql = Conn.prepareStatement(sql);
        Sql.setString(1, ((Users) obj).getNome());
        Sql.setString(2, ((Users) obj).getSenha());
        Sql.setInt(3, ((Users) obj).getCargo());
        Sql.setString(4, ((Users) obj).getCPF());
        Sql.execute();
        Sql.close();
    }

    public void removeEntity(Object obj) throws SQLException {
        String sql = "DELETE FROM USERS WHERE ID=?";
        Sql = Conn.prepareStatement(sql);
        Sql.setInt(1, ((Users) obj).getId());
        Sql.execute();
        Sql.close();
    }

    public Users updateEntity(Users obj) throws SQLException {
        String sql = "UPDATE USERS SET NOME=?,SENHA=?,CPF=? WHERE ID=?";
        Sql = Conn.prepareStatement(sql);
        Sql.setString(1, ((Users) obj).getNome());
        Sql.setString(2, ((Users) obj).getSenha());
        Sql.setString(3, ((Users) obj).getCPF());
        Sql.setInt(4, ((Users) obj).getId());
        Sql.executeUpdate();
        Sql.close();
        return obj;
    }

    public Users getEntityById(int id) throws SQLException, Exception {
        Users obj = null;
        String sql = "SELECT * FROM USERS WHERE ID=?";
        Sql = Conn.prepareStatement(sql);
        Sql.setInt(1, id);

        ResultSet rs = Sql.executeQuery();

        if (rs.next()) {
            obj = new Users();
            preencherObj(obj, rs);
        }
        rs.close();
        return obj;

    }

    public <T> List<T> getAllEntitys() throws SQLException, Exception {
        List<Users> listUser = new ArrayList();
        String sql = "SELECT * FROM USERS";
        Sql = Conn.prepareStatement(sql);
        ResultSet rs = Sql.executeQuery();

        while (rs.next()) {
            Users obj = new Users();
            preencherObj(obj, rs);
            listUser.add(obj);
        }
        rs.close();
        Sql.close();
        return (List<T>) listUser;

    }

    public <T> List<T> getAllGarcons(int i) throws SQLException, Exception {
        List<Users> listUser = new ArrayList();
        String sql = "SELECT * FROM USERS where cargo = ? order by nome";
        Sql = Conn.prepareStatement(sql);
        Sql.setInt(1, i);
        ResultSet rs = Sql.executeQuery();

        while (rs.next()) {
            Users obj = new Users();
            preencherObj(obj, rs);
            listUser.add(obj);
        }
        rs.close();
        Sql.close();
        return (List<T>) listUser;

    }

    public int GetId(int ios, int dois) throws SQLException {
        String sql = "SELECT * FROM USERS where cargo = ? order by nome";
        Sql = Conn.prepareStatement(sql);
        Sql.setInt(1, dois);
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

    public String GetNome(int id) throws SQLException {
        String sql = "SELECT * FROM USERS where id = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setInt(1, id);
        ResultSet rs = Sql.executeQuery();
        rs.next();
        String nome = rs.getString("nome");
        rs.close();
        Sql.close();
        return nome;
    }

    public Object SearchEntity(String name) throws SQLException, Exception {
        String sql = "SELECT * FROM USERS WHERE NOME = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setString(1, name.toUpperCase());
        ResultSet rs = Sql.executeQuery();
        Users obj = null;

        if (rs.next()) {
            obj = new Users();
            preencherObj(obj, rs);
        }
        return obj;
    }

    public boolean isEmptyEntity() throws SQLException {
        String sql = "SELECT * FROM USERS";
        Sql = Conn.prepareStatement(sql);
        ResultSet rs = Sql.executeQuery();
        return rs.next();
    }

    public boolean DuplicatedEntity(String name) throws SQLException {
        String sql = "SELECT * FROM users WHERE NOME = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setString(1, name.toUpperCase());
        return Sql.executeQuery().next();

    }

    public Users Login(String i) throws SQLException, Exception {
        Users obj = new Users();
        String sql = "SELECT * FROM users where nome = ?";
        Sql = Conn.prepareStatement(sql);
        Sql.setString(1, i);
        ResultSet rs = Sql.executeQuery();
        while (rs.next()) {
            obj.setId(rs.getInt("id"));
            obj.setNome(rs.getString("nome"));
            obj.setSenha(rs.getString("senha"));
            obj.setCargo(rs.getInt("cargo"));
        }
        rs.close();
        Sql.close();
        return obj;
    }

}
