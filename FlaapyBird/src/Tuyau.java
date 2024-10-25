import java.awt.Image;

import javax.swing.ImageIcon;

public class Tuyau {

    private int hauteur;
    private int largeur;
    private int x;
    private int y;
    private String strimage;
    private ImageIcon icoTuyau;
    private Image imgTuyau;

    public Tuyau(int x,int y,String strimage) {
        this.largeur=50;
        this.hauteur=300;
        this.x=x;
        this.y=y;
        this.strimage=strimage;
        this.icoTuyau= new ImageIcon(getClass().getResource(this.strimage));
        this.imgTuyau= this.icoTuyau.getImage();




    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public Image getImgTuyau() {
        return imgTuyau;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    



    
}


