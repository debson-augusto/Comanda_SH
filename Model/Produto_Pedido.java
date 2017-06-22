
package Model;

import Utils.CONSTANTES;

/**
 *
 * @author batman
 */
public class Produto_Pedido {

    int id;
    int id_comanda;
    int id_Produto;
    int quantidade;
    double Valor;
    String nome;

    public Produto_Pedido() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getId_comanda() {
        return id_comanda;
    }

    public void setId_comanda(int comanda) {
        if (comanda > 0) {
            this.id_comanda = comanda;
        }
    }

    public int getId_Produto() {
        return id_Produto;
    }

    public void setId_Produto(int Produto) {
        if (Produto > 0) {
            this.id_Produto = Produto;
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quant) throws java.lang.Exception {
        if (quant > 0) {
            this.quantidade = quant;
        } else {
            throw new Exception(CONSTANTES.m_strQte);
        }
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double preco) throws Exception {
        if (preco >= 0) {
            this.Valor = preco;
        } else {
            throw new Exception(CONSTANTES.m_strValor);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (!nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new Exception(CONSTANTES.m_strNome);
        }
    }
}
