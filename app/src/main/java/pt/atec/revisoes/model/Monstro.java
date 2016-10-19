package pt.atec.revisoes.model;

/**
 * Created by atecdroid on 10/19/16.
 */

public class Monstro {
    private int image;
    private int hp;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Monstro(int image, int hp) {

        this.image = image;
        this.hp = hp;
    }
}
