package Dao;

import Banco.Banco;
import Model.ProdutoModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author CARLOS AIRES
 */
public class ProdutoDao {
    
    public void salvar(ProdutoModel objModel) throws SQLException {
        Connection con = new Banco().getConnection();
        
        String sql = "INSERT INTO tb_produtos (TXT_NOME_PROD, TXT_TIPO, TXT_GENERO, TXT_TAMANHO, TXT_COR, TXT_MARCA, QTD_ESTQ, QTD_MIN_ESTQ) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        
        String nomeProd = objModel.getNomeProd();
        String tipo = objModel.getTipo();
        String genero = objModel.getGenero();
        String tamanho = objModel.getTamanho();
        String cor = objModel.getCor();
        String marca = objModel.getMarca();
        int qtdEstq = objModel.getQtdEstq();
        int qtdMinEstq = objModel.getQtdMin();
        
        stmt.setString(1, nomeProd);
        stmt.setString(2, tipo);
        stmt.setString(3, genero);
        stmt.setString(4, tamanho);
        stmt.setString(5, cor);        
        stmt.setString(6, marca);
        stmt.setInt(7, qtdEstq);
        stmt.setInt(8, qtdMinEstq);
        
        
        stmt.execute();
        stmt.close();
        
        JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso!!!!","Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }
}
