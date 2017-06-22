/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author batman
 */
public class Formats {

    public static String format(String str) {
        MaskFormatter jTregistro = null;
        try {
            jTregistro = new MaskFormatter("##.###.###-##");
            jTregistro.setOverwriteMode(true);
            jTregistro.setValidCharacters(str);
        } catch (Exception pe) {
            System.out.println(pe.getMessage());
        }
        DefaultFormatterFactory factory = new DefaultFormatterFactory(jTregistro, jTregistro);
        return factory.toString();
    }

    public static java.sql.Date FormatDate(String str) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date data = new java.sql.Date(sdf.parse(str).getTime());
        return data;
    }

    public static java.sql.Date DataAtualSqlDate() {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        java.util.Date dataUtil = new java.util.Date();
        try {
            dataUtil = df.parse(c.getTime().toString());
        } catch (ParseException ex) {

        }
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

        return dataSql;
    }

    public static java.sql.Date StringToDate(String str) {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        java.util.Date dataUtil = new java.util.Date();
        try {
            dataUtil = df.parse(str);
        } catch (ParseException ex) {
            
        }
        java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

        return dataSql;
    }
}
