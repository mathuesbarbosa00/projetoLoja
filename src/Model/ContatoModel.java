package Model;

import java.util.Calendar;

/**
 *
 * @author CARLOS AIRES
 */
public class ContatoModel {
    private int id;
    private String nome;
    private String email;
    private String endereco;
    private String dataNascimento;
    
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getEndereco() {
        return this.endereco;
    }
    
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getDataNascimento() {
        return this.dataNascimento;
    }
    
}
