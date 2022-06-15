package game;

import javax.swing.*;

public class Game implements Runnable
{
    private GameWindow gameWindow;
    private GamePanel panel;
    private final int FPS_CAP=120;
    private Thread gameThread;
    private final int UPS=200;

    public Game()
    {
        panel=new GamePanel();
        gameWindow=new GameWindow(panel);
        panel.requestFocus();
        gameThread=new Thread(this);
        gameThread.start();
    }
    public void update()
    {
        panel.updateGame();
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_CAP;
        double timePerUpdate = 1000000000.0 / UPS;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                panel.repaint();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;

            }
        }

    }
}
