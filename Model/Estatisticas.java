
package Model;

import java.sql.Date;

/**
 *
 * @author batman
 */
public class Estatisticas {
    
    int comanda;
    int mesa;
    String tipo;
    String Garcom;
    double Valor;
    Date data;
    int qte_vendas;
    double soma_vendas;
    double soma_comissoes;

    public int getQte_vendas() {
        return qte_vendas;
    }

    public void setQte_vendas(int qte_vendas) {
        this.qte_vendas = qte_vendas;
    }

    public double getSoma_vendas() {
        return soma_vendas;
    }

    public void setSoma_vendas(double soma_vendas) {
        this.soma_vendas = soma_vendas;
    }

    public double getSoma_comissoes() {
        return soma_comissoes;
    }

    public void setSoma_comissoes(double soma_comissoes) {
        this.soma_comissoes = soma_comissoes;
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status.toUpperCase();
    }
    String status;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    

    public String getGarcom() {
        return Garcom;
    }

    public void setGarcom(String Garcom) {
        this.Garcom = Garcom.toUpperCase();
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public Estatisticas() {
    }

    public int getComanda() {
        return comanda;
    }

    public void setComanda(int comanda) {
        this.comanda = comanda;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
}
