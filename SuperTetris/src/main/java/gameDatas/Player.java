package gameDatas;

import java.io.Serializable;

/**
 *************************
 *                       *
 * @author Vitor Alencar * 
 *************************
 */
public class Player implements Serializable{

    String nome;
    String login;
    String senha;
    int pontos;
    
    public Player(String nome, String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }
    
    public Player(){
        this("noName", "noName_user", "");
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return this.login;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getPontos() {
        return this.pontos;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return this.senha;
    }

}
