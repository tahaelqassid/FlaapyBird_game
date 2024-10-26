import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Image;
import java.util.Random;
import java.awt.Font;
import java.awt.Graphics;

public class Scene extends JPanel {


    // vrbls 
    private ImageIcon iconBackgroumdImg;
    private Image imgBackground;
    public Tuyau tuyauHaut1;
    public Tuyau tuyauBas1;
    public Tuyau tuyauHaut2;
    public Tuyau tuyauBas2;
    public Tuyau tuyauHaut3;
    public Tuyau tuyauBas3;


    public FlaapyBird FlaapyBird;


    private final int BoardWidth=140;
    private final int DISTANCE_tuyau=250;
    private final int ECART_tuyau=120;


    public int xFond=0;
    private int dxtuyau;
    private int xtuyau;

    public boolean finDuJeu;

    private Random hasard;

    private int Score;
    private Font police;




// constructions
    public  Scene() {
        super();
        this.iconBackgroumdImg = new ImageIcon(getClass().getResource("/imgs/flappybirdbg.png"));

        this.imgBackground = this.iconBackgroumdImg.getImage();
        this.xFond=0;

        this.dxtuyau=0;
        this.xtuyau=400;
        this.finDuJeu=false;




        this.tuyauHaut1= new Tuyau(this.xtuyau, -150, "/imgs/tuyauHaut.png");
        this.tuyauBas1 = new Tuyau(this.xtuyau, 250, "/imgs/tuyauBas.png");
        this.tuyauHaut2= new Tuyau(this.xtuyau + this.DISTANCE_tuyau, -150, "/imgs/tuyauHaut.png");
        this.tuyauBas2= new Tuyau(this.xtuyau +  this.DISTANCE_tuyau, 250, "/imgs/tuyauBas.png");
        this.tuyauHaut3= new Tuyau(this.xtuyau + this.DISTANCE_tuyau *2, -150, "/imgs/tuyauHaut.png");
        this.tuyauBas3= new Tuyau(this.xtuyau + this.DISTANCE_tuyau *2, 250, "/imgs/tuyauBas.png");
        this.hasard=new Random();




        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Keys());


        this.FlaapyBird= new FlaapyBird(150, 100, "/imgs/oiseau1.png");

        this.Score=0;
        this.police= new Font("Ariel",Font.PLAIN,27);





       

        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start();

    }
    //mthds
    private void deplacementFond(Graphics g) {
        if(this.xFond == -this.BoardWidth) {
            this.xFond=0;
        }
        g.drawImage(this.imgBackground,this.xFond,0,null);
        g.drawImage(this.imgBackground,this.xFond+this.BoardWidth,0,null);
        g.drawImage(this.imgBackground,this.xFond+this.BoardWidth * 2,0,null);
        g.drawImage(this.imgBackground,this.xFond+this.BoardWidth * 3,0,null);


    
    }
    private void deplacementTuyau(Graphics g) {
        this.tuyauHaut1.setX(this.tuyauHaut1.getX() - 1);
		this.tuyauBas1.setX(this.tuyauHaut1.getX());
		
		if(this.tuyauHaut1.getX() == -100){
	    	this.tuyauHaut1.setX(this.tuyauHaut3.getX() + this.DISTANCE_tuyau);
	    	this.tuyauHaut1.setY(-100 - 10 * this.hasard.nextInt(18));
	    	this.tuyauBas1.setY(this.tuyauHaut1.getY() + this.tuyauHaut1.getHauteur() + this.ECART_tuyau);
	    }		
		g.drawImage(this.tuyauHaut1.getImgTuyau(), this.tuyauHaut1.getX(), this.tuyauHaut1.getY(), null);
		g.drawImage(this.tuyauBas1.getImgTuyau(), this.tuyauBas1.getX(), this.tuyauBas1.getY(), null);
		
		// tuyau2
		this.tuyauHaut2.setX(this.tuyauHaut2.getX() - 1);
		this.tuyauBas2.setX(this.tuyauHaut2.getX());
		
		if(this.tuyauHaut2.getX() == -100){
			this.tuyauHaut2.setX(this.tuyauHaut1.getX() + this.DISTANCE_tuyau);
			this.tuyauHaut2.setY(-100 - 10 * this.hasard.nextInt(18));
	    	this.tuyauBas2.setY(this.tuyauHaut2.getY() + this.tuyauHaut2.getHauteur() + this.ECART_tuyau);
		}		
		g.drawImage(this.tuyauHaut2.getImgTuyau(), this.tuyauHaut2.getX(), this.tuyauHaut2.getY(), null);
		g.drawImage(this.tuyauBas2.getImgTuyau(), this.tuyauBas2.getX(), this.tuyauBas2.getY(), null);
		
		// tuyau3
		this.tuyauHaut3.setX(this.tuyauHaut3.getX() - 1);
		this.tuyauBas3.setX(this.tuyauHaut3.getX());
		
		if(this.tuyauHaut3.getX() == -100){
			this.tuyauHaut3.setX(this.tuyauHaut2.getX() + this.DISTANCE_tuyau);
			this.tuyauHaut3.setY(-100 - 10 * this.hasard.nextInt(18));
	    	this.tuyauBas3.setY(this.tuyauHaut3.getY() + this.tuyauHaut3.getHauteur() + this.ECART_tuyau);
		}		
		g.drawImage(this.tuyauHaut3.getImgTuyau(), this.tuyauHaut3.getX(), this.tuyauHaut3.getY(), null);
		g.drawImage(this.tuyauBas3.getImgTuyau(), this.tuyauBas3.getX(), this.tuyauBas3.getY(), null);	

	}

    private boolean collisionFlappy(){

        boolean finDuJeu = false;
		// proche tuyau1
		if(this.FlaapyBird.getX() + this.FlaapyBird.getLargeur() > this.tuyauBas1.getX() - 20 && 
				this.FlaapyBird.getX() < this.tuyauBas1.getX() + this.tuyauBas1.getLargeur() + 20){
			finDuJeu = this.FlaapyBird.collision(this.tuyauBas1);
			if(finDuJeu == false){finDuJeu = this.FlaapyBird.collision(this.tuyauHaut1);}
		}else{
			// proche tuyau2
			if(this.FlaapyBird.getX() + this.FlaapyBird.getLargeur() > this.tuyauBas2.getX() - 20 && this.FlaapyBird.getX() < this.tuyauBas2.getX() + this.tuyauBas2.getLargeur() + 20){
				finDuJeu = this.FlaapyBird.collision(this.tuyauBas2);
				if(finDuJeu == false){finDuJeu = this.FlaapyBird.collision(this.tuyauHaut2);}			
		    }else{
				// proche tuyau3
			    if(this.FlaapyBird.getX() + this.FlaapyBird.getLargeur() > this.tuyauBas3.getX() - 20 && this.FlaapyBird.getX() < this.tuyauBas3.getX() + this.tuyauBas3.getLargeur() + 20){
			    	finDuJeu = this.FlaapyBird.collision(this.tuyauBas3);
				    if(finDuJeu == false){finDuJeu = this.FlaapyBird.collision(this.tuyauHaut3);}
			}else{
				// contact avec le plafond ou le sol
				if(this.FlaapyBird.getY() < 0 || this.FlaapyBird.getY() + this.FlaapyBird.getHauteur() > 355){finDuJeu = true;}else{finDuJeu = false;}
		        }
		    }
	    }
		return finDuJeu;

    }

    private void Score () {
        if(this.tuyauBas1.getX() + this.tuyauBas1.getLargeur() == 95 || this.tuyauBas2.getX() + this.tuyauBas2.getLargeur() == 95 || 
		   this.tuyauBas3.getX() + this.tuyauBas3.getLargeur() == 95){
			  this.Score++;
			  Audio.playSound("/audio/sonnerie.wav");
		}

    }





    public void paintComponent(Graphics g) {
        this.deplacementFond(g);
        this.deplacementTuyau(g);
        this.Score();
		g.setFont(police);
		g.drawString("" + Score, 140, 50);
        this.finDuJeu=this.collisionFlappy();
        this.FlaapyBird.setY(this.FlaapyBird.getY()+1);
        g.drawImage(this.FlaapyBird.getImgbird(), this.FlaapyBird.getX(), this.FlaapyBird.getY(), null);
        if(this.finDuJeu == true){
			g.drawString("Fin du jeu\ntahaelqassid", 20, 200);
		    Audio.playSound("/audio/choc.wav");
		}

    }

}