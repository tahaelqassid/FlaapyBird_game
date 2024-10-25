import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Image;
import java.util.Random;
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


    private final int BoardWidth=140;
    private final int DISTANCE_tuyau=250;
    private final int ECART_tuyau=120;


    public int xFond=0;
    private int dxtuyau;
    private int xtuyau;

    private Random hasard;








// constructions
    public  Scene() {
        super();
        this.iconBackgroumdImg = new ImageIcon(getClass().getResource("/imgs/bandeFondEcran.png"));

        this.imgBackground = this.iconBackgroumdImg.getImage();
        this.xFond=0;

        this.dxtuyau=0;
        this.xtuyau=100;



        this.tuyauHaut1= new Tuyau(this.xtuyau, -150, "/imgs/tuyauHaut.png");
        this.tuyauBas1 = new Tuyau(this.xtuyau, 250, "/imgs/tuyauBas.png");
        this.tuyauHaut2= new Tuyau(this.xtuyau + this.DISTANCE_tuyau, -150, "/imgs/tuyauHaut.png");
        this.tuyauBas2= new Tuyau(this.xtuyau +  this.DISTANCE_tuyau, 250, "/imgs/tuyauBas.png");
        this.tuyauHaut3= new Tuyau(this.xtuyau + this.DISTANCE_tuyau *2, -150, "/imgs/tuyauHaut.png");
        this.tuyauBas3= new Tuyau(this.xtuyau + this.DISTANCE_tuyau *2, 250, "/imgs/tuyauBas.png");
        this.hasard=new Random();




       

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




    public void paintComponent(Graphics g) {
        this.deplacementFond(g);
        this.deplacementTuyau(g);
        

    }

}