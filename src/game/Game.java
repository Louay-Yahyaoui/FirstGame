package game;

import javax.swing.*;

public class Game implements Runnable
{
    private GameWindow gameWindow;
    private GamePanel panel;
    private final int FPS_CAP=120;
    private Thread gameThread;

    public Game()
    {
        panel=new GamePanel();
        gameWindow=new GameWindow(panel);
        panel.requestFocus();
        gameThread=new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double timePerFrame=Math.pow(10,9)/FPS_CAP;
        long lastFrame=System.nanoTime();
        long now;
        int frames=0;
        double lastCheck=0;
        while(true)
        {
            now=System.nanoTime();
            if (now-lastFrame > timePerFrame)
            {
                panel.repaint();
                lastFrame=now;
                frames++;
            }
            if(System.currentTimeMillis()-lastCheck>=1000)
            {
                lastCheck=System.currentTimeMillis();
                if (frames!=0)
                System.out.println("FPS: "+frames);
                frames=0;
            }
        }
    }
}
