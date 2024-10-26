
import javax.swing.JFrame;
import javax.swing.JPanel;
public class App {

    public static JFrame window;
    public static Scene scene;
    public static void main(String[] args)  {



        window = new JFrame("Flaapybird");
        scene = new Scene();



        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(375,400);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setAlwaysOnTop(true);

        window.setContentPane(scene);
        window.setVisible(true);

    }
}


