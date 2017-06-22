
package Model;

import Utils.CONSTANTES;

/**
 *
 * @author batman
 */
public class Produtos {

    int id;
    String Nome;
    double Preco;

    public Produtos() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String name) throws Exception {
        if (name.isEmpty()) {
            throw new Exception(CONSTANTES.m_strNome);
        } else {
            this.Nome = name;
        }
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double preco) throws Exception {
        if (preco >= 0) {
            this.Preco = preco;
        } else {
            throw new Exception(CONSTANTES.m_strValor);
        }
    }

}
