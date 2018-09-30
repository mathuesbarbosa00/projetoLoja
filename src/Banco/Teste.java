/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Model.ContatoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author CARLOS AIRES
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        ContatoModel objModel = new ContatoModel();
        
        objModel.setNome("Pedro");
        String novoNome = objModel.getNome();
        
        Connection con = new Banco().getConnection();

        String sql = "INSERT INTO clientes (TXT_NOME, TXT_EMAIL, TXT_ENDERECO, DAT_DATA_NASCIMENTO) VALUES (?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setString(1, novoNome);
        stmt.setString(2, "Rua das ruas");
        stmt.setString(3, "carlos.aires@cpitegus.com.br");
        stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        
        stmt.execute();
        
        stmt.close();
        
        System.out.println("Dados gravados com sucesso!");
        
        con.close();
    }
    
}
