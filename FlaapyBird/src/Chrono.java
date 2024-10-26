public class Chrono implements Runnable {
    private final int PAUSE = 5;  // Short pause for rapid updates

    public void run() {
        while (App.scene.finDuJeu == false) {
            App.scene.xFond--;  // Larger decrement for faster movement

            // Wrap the background if needed
            if (App.scene.xFond <= -App.scene.getWidth()) {
                App.scene.xFond = 0;  // Reset position to create an infinite loop
            }

            App.scene.repaint();

            try {
                Thread.sleep(this.PAUSE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
