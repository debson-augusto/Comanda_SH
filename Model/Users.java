/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Utils.CONSTANTES;

/**
 *
 * @author batman
 */
public class Users {

    int Id;
    String Nome;
    String Senha;
    int Cargo;
    String CPF;

    public String getPerfil() {
        if (this.Cargo == 0) {
            return "ADMINISTRADOR";
        } else if (this.Cargo == 1) {
            return "CAIXA";
        } else {
            return "GARÇOM";
        }
    }

    public Users() {
        this.Id = 0;
        this.Nome = "";
        this.Senha = "";
        this.Cargo = 0;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) throws Exception {
        if (Nome.isEmpty()) {
            throw new Exception(CONSTANTES.user_nm);
        }

        this.Nome = Nome.toUpperCase();
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) throws Exception {
        if (Senha.isEmpty()) {
            throw new Exception(CONSTANTES.pass_u);
        }
        this.Senha = Senha;
    }

    public int getCargo() {
        return Cargo;
    }

    public void setCargo(int Cargo) {
        this.Cargo = Cargo;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) throws Exception {
        //CPF = CPF.replaceAll("-", "").replaceAll(".", "");
        if ((CPF.length() < 13) && (CPF.isEmpty())) {
            throw new Exception(CONSTANTES.cpf_invalido);
        }
        this.CPF = CPF;
    }
}
