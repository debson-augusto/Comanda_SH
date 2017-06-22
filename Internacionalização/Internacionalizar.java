/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Internacionalização;

import Utils.CONSTANTES;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author batman
 */
public class Internacionalizar {

    public void Translate(String Idioma, String Pais) {
        Locale Us = new Locale(Idioma, Pais);
        Locale.setDefault(Us);

        ResourceBundle propriedades = ResourceBundle.getBundle("Internacionalização/appstrings");
        
        CONSTANTES.user_nm = propriedades.getString("USERNAME"); //"Nome do usuario deve ser preenchido!";
        CONSTANTES.pass_u = propriedades.getString("PASS_ENTERED");//"Senha do usuario deve ser preenhida";
        CONSTANTES.cpf_invalido = propriedades.getString("nin_invalid");//"CPF invalido";
        CONSTANTES.m_strValor = propriedades.getString("VALID_VALUE");//"Informar um Valor Válido";
        CONSTANTES.m_strDados = propriedades.getString("INVALID_INFO");//"Dados Inválidos";
        CONSTANTES.m_strNome = propriedades.getString("UsuarioValido");//"Informar um Nome Válido";
        CONSTANTES.m_strCPF = propriedades.getString("valid_NIN");//"Informar um CPF Válido";
        CONSTANTES.m_strNum = propriedades.getString("valid_number");//"Informar um Número Válido";
        CONSTANTES.m_strTipo = propriedades.getString("Choose_Type");//"Favor escolher um tipo";
        CONSTANTES.m_strQte = propriedades.getString("Inform_quant");//"Informe uma Quantidade!";
        CONSTANTES.m_strSenh = propriedades.getString("SenhaValida");//"Informar uma Senha Válida";
        CONSTANTES.m_strTGar = propriedades.getString("jCadGar");//"Cadastro de Garçons";
        CONSTANTES.m_strStatus = propriedades.getString("Valid_status");//"Informar um Status Válido";
        CONSTANTES.m_strProd = propriedades.getString("Valid_item");

    }

}
