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
        
        String nome, email, endereco, dataNascimento;
        
        nome = objModel.getNome();
        email = objModel.getEmail();
        endereco = objModel.getEndereco();
        dataNascimento = objModel.getDataNascimento();

        Connection con = new Banco().getConnection();

        String sql = "INSERT INTO clientes (TXT_NOME, TXT_EMAIL, TXT_ENDERECO, DAT_DATA_NASCIMENTO) VALUES (?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setString(1, nome);
        stmt.setString(2, email);
        stmt.setString(3, endereco);
        stmt.setString(4, dataNascimento);
        //stmt.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
        
        stmt.execute();
        stmt.close();
        
        JOptionPane.showMessageDialog(null,"Cadastro efetuado com sucesso!!!!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void atualizar(ContatoModel objModel) throws SQLException {}
    
    public void deletar(ContatoModel objModel) throws SQLException {
        
        int id = objModel.getId();
        
        Connection con = new Banco().getConnection();
        
        String sql = "UPDATE clientes SET FLG_STATUS = 'D' WHERE ID = (?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        stmt.execute();
        stmt.close();
        
        JOptionPane.showMessageDialog(null,"Dado deletado com sucesso!!!!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void listar(ContatoModel objModel) throws SQLException {
        
        int id = objModel.getId();
        
        Connection con = new Banco().getConnection();
        
        String sql = "SELECT * FROM cliente WHERE ID = (?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        stmt.execute();
        stmt.close();
        
    }
}
