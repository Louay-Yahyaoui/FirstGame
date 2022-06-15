package game;

import entities.Player;

import javax.swing.*;
import java.awt.*;

public class Game implements Runnable
{
    private GameWindow gameWindow;
    private GamePanel panel;
    private final int FPS_CAP=120;
    private Thread gameThread;
    private final int UPS=200;
    private Player player;

    public Game()
    {
        initClasses();
        panel=new GamePanel(this);
        gameWindow=new GameWindow(panel);
        panel.requestFocus();
        gameThread=new Thread(this);
        gameThread.start();
    }

    private void initClasses() {
        player =new Player(200,200);
    }

    public void update()
    {
        player.update();
    }

    public Player getPlayer() {
        return player;
    }

    public void render(Graphics g)
    {
        player.render(g);
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

    public void FocusLost() {
        player.resetBooleans();
    }
}
