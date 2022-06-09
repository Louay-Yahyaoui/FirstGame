package game;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel
{
    private float xDelta=100;
    private float yDelta=100;
    private float xDir=1,yDir=1;
    private Color color;
    private Random random;

    public GamePanel()
    {
        MouseInputs mouse=new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        random=new Random();
    }
    public void changexDelta(int x)
    {
        xDelta+=x;
    }
    public void changeyDelta(int y)
    {
        yDelta+=y;
    }
    public void followMouse(int x,int y)
    {
        xDelta=x;
        yDelta=y;

    }
    public void paintComponent(Graphics G)
    {
        super.paintComponent(G);
        G.setColor(color);
        loopyloop();
        G.fillRect((int)xDelta,(int)yDelta,100,100);


    }
    public void loopyloop() {

        if ((xDelta >= 300) || (xDelta < 0)) {
            xDir *= -1;
            color = randomColor();
        }


        if ((yDelta >= 300) || (yDelta < 0)) {
            yDir *= -1;
            color = randomColor();
        }
        xDelta += xDir;
        yDelta += yDir;
    }

    public Color randomColor() {
        int r=random.nextInt(256);
        int g=random.nextInt(256);
        int b=random.nextInt(256);
        return new Color(r,g,b);
    }
}
