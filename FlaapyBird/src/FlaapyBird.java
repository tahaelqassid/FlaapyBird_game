import java.awt.Image;

import javax.swing.ImageIcon;

public class FlaapyBird  implements Runnable {


    private int Hauteur;
    private int Largeur;
    private int x;
    private int y;
    private int dy;
    private String strimage;
    private ImageIcon iconbird;
    private Image imgbird;

    private final int PAUSE =10;



    public FlaapyBird (int x,int y,String strimage) {

        this.Hauteur=24;
        this.Largeur=34;
        this.x=x;
        this.y=y;
        this.iconbird=new ImageIcon(getClass().getResource(strimage));
        this.strimage=strimage;
        this.imgbird= this.iconbird.getImage();

        Thread chronoAiles = new Thread(this);
        chronoAiles.start();


        




    }

    public int getHauteur() {
        return Hauteur;
    }

    public int getLargeur() {
        return Largeur;
    }

    public Image getImgbird() {
        return imgbird;
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

    public void birdup(){
        this.dy=50;
       
    }

    private void batDesAiles(int dy) {

        if(dy>10) {
            this.iconbird=new ImageIcon(getClass().getResource("/imgs/oiseau2.png"));
            this.imgbird=this.iconbird.getImage();
            this.y=this.y -3;


        } else if(dy>5){
            this.y=this.y -2;

        } else if(dy>1) {this.y=this.y -1;}
        else if(dy==1) {
            this.iconbird=new ImageIcon(getClass().getResource("/imgs/oiseau1.png"));
            this.imgbird=this.iconbird.getImage();

        }

    }

    public boolean collision (Tuyau tuyau) {
        if(tuyau.getY() < 50){ // détecte un tuyau haut
			if(this.y <= tuyau.getY() + tuyau.getHauteur() && this.x + this.Largeur >= tuyau.getX() && 
					this.x <= tuyau.getX() + tuyau.getLargeur()){return true;}
			else{return false;}
		}else // sinon test avec tuyau bas
			if(this.y + this.Hauteur >= tuyau.getY() && this.x + this.Largeur >= tuyau.getX() && 
			this.x <= tuyau.getX() + tuyau.getLargeur()){return true;}
		     else{return false;}
      
    }

    @Override
    public void run() {

        while(true) {
            this.batDesAiles(dy);
            this.dy--;
           try {Thread.sleep(PAUSE);} catch(InterruptedException e){}
           
        }
    }
    
}
