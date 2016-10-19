package pt.atec.revisoes.model;

/**
 * Created by atecdroid on 10/19/16.
 */

public class Arma {
    private int imagem;
    private String nome;
    private int attack;

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public Arma(int imagem, String nome, int attack) {

        this.imagem = imagem;
        this.nome = nome;
        this.attack = attack;
    }
}
