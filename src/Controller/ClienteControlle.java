package Controller;

import Dao.ClienteDao;
import Model.ContatoModel;
import java.sql.SQLException;
import lib.ControleErros;

/**
 *
 * @author Carlos
 */
public class ClienteControlle {
    
    public void chkForm(String nome, String email, String telefone, String endereco) throws SQLException {
        
        ControleErros ctrlErro = new ControleErros();
        ContatoModel objModel = new ContatoModel();
        
        if("".equals(nome)) {
            ctrlErro.setErro("errorNome");
        } else {
            objModel.setNome(nome.toUpperCase());
        }
        
        if("".equals(email)) {
            ctrlErro.setErro("errorEmail");
        } else {
            objModel.setEmail(email.toUpperCase());
        }
        
        if("".equals(telefone)) {
            ctrlErro.setErro("errorTelefone");
        } else {
            objModel.setTelefone(telefone.toUpperCase());
        }
        
        if("".equals(endereco)) {
            ctrlErro.setErro("errorEndereco");
        } else {
            objModel.setEndereco(endereco.toUpperCase());
        }
        
        ClienteDao objDao = new ClienteDao();
        objDao.salvar(objModel);
    }
    
}
