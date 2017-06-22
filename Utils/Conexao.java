/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author batman
 */
public class Conexao {

    private static Connection m_Conn;

    public static Connection getConn() throws SQLException {
        if (m_Conn == null) {
            String strdb = "jdbc:postgresql://localhost:5432/NetBeans";
            String strUser = "jesus";
            String strPass = "12345678";
            m_Conn = DriverManager.getConnection(strdb, strUser, strPass);

            return m_Conn;
        } else {
            return m_Conn;
        }

    }

}
