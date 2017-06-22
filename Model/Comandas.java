/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.CONSTANTES;
import Utils.Formats;
import java.text.ParseException;
import java.sql.Date;

/**
 *
 * @author batman
 */
public class Comandas {

    int id;
    int id_mesa;
    Date data;
    int id_Garcom;
    double Total;
    double Total_Comissao;
    String status;

    Date inicio;
    Date fim;

    public Comandas() throws ParseException {
        inicio = Formats.FormatDate("01/01/2000");
        fim = Formats.FormatDate("31/12/2099");
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int comanda) {
        if (comanda > 0) {
            this.id_mesa = comanda;
        }
    }

    public int getId_Garcom() {
        return id_Garcom;
    }

    public void setId_Garcom(int Produto) {
        if (Produto > 0) {
            this.id_Garcom = Produto;
        }
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) throws Exception {
        if (total >= 0) {
            this.Total = total;
        } else {
            throw new Exception(CONSTANTES.m_strValor);
        }
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {

        if ((data.after(inicio)) && (data.before(fim))) {
            this.data = data;
        }
    }

    public double getTotal_Comissao() {
        return Total_Comissao;
    }

    public void setTotal_Comissao(double Total_Com) throws Exception {
        if (Total_Com >= 0) {
            this.Total_Comissao = Total_Com;
        } else {
            throw new Exception(CONSTANTES.m_strValor);
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) throws Exception {
        if (!status.isEmpty()) {
            this.status = status.toUpperCase();
        } else {
            throw new Exception(CONSTANTES.m_strDados);
        }

    }

}
