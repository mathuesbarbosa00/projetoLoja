package Dao;

import Banco.Banco;
import Model.ContatoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author CARLOS AIRES
 */
public class ClienteDao {
    
    public void salvar(ContatoModel objModel) throws SQLException {
        
        //ContatoModel objModel = new ContatoModel();
        
        String nome, email, telefone, endereco;
        
        nome = objModel.getNome();
        email = objModel.getEmail();
        telefone = objModel.getTelefone();
        endereco = objModel.getEndereco();
        
        Connection con = new Banco().getConnection();

        String sql = "INSERT INTO tb_clientes (TXT_NOME, TXT_EMAIL, TXT_TELEFONE, TXT_ENDERECO) VALUES (?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setString(1, nome);
        stmt.setString(2, email);
        stmt.setString(3, telefone);
        stmt.setString(4, endereco);
        
        stmt.execute();
        stmt.close();
        
        JOptionPane.showMessageDialog(null,"Cadastro efetuado com sucesso!!!!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void atualizar(ContatoModel objModel) throws SQLException {}
    
    public void deletar(ContatoModel objModel) throws SQLException {
        
        int id = objModel.getId();
        
        Connection con = new Banco().getConnection();
        
        String sql = "UPDATE tb_clientes SET FLG_STATUS = 'D' WHERE ID = (?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        stmt.execute();
        stmt.close();
        
        JOptionPane.showMessageDialog(null,"Dado deletado com sucesso!!!!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void listar(ContatoModel objModel) throws SQLException {
        
        int id = objModel.getId();
        
        Connection con = new Banco().getConnection();
        
        String sql = "SELECT * FROM tb_clientes WHERE ID = (?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        stmt.execute();
        stmt.close();
        
    }
}
