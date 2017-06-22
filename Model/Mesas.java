
package Model;

import Utils.CONSTANTES;

/**
 *
 * @author batman
 */
public class Mesas {

    int id;
    int numero;
    String tipo;
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) throws Exception {
        if(!status.isEmpty()){
        this.status = status.toUpperCase();
        } else {
            throw new Exception(CONSTANTES.m_strStatus);
        }
    }

    public Mesas() {
    }

    public void setId(int id) {
        this.id = id;
    }

        public int getId() {
        return id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) throws Exception {
        if (numero <= 0) {
            throw new Exception(CONSTANTES.m_strNum);
        } else {
            this.numero = numero;
        }

    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) throws Exception {
        if (!tipo.isEmpty()) {
            this.tipo = tipo.toUpperCase();
        } else {
            throw new Exception(CONSTANTES.m_strTipo);
        }
    }

    public String toString() {
        return id + " - " + numero + " - " + tipo;
    }

}
