package game;

import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel
{
    private int xDelta=100;
    private int yDelta=100;
    public GamePanel()
    {
        MouseInputs mouse=new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
    }
    public void changexDelta(int x)
    {
        xDelta+=x;
        repaint();
    }
    public void changeyDelta(int y)
    {
        yDelta+=y;
        repaint();
    }
    public void followMouse(int x,int y)
    {
        xDelta=x;
        yDelta=y;
        repaint();
    }
    public void paintComponent(Graphics G)
    {
        super.paintComponent(G);
        G.setColor(Color.cyan);
        G.fillRect(xDelta,yDelta,100,100);
    }
}
