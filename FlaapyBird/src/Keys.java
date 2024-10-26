import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


public class Keys implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
      
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_SPACE) {
            App.scene.FlaapyBird.birdup();

        }
       
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
        
    }



    
}
