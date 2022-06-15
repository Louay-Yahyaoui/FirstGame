package game;

import Inputs.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;

public class GamePanel extends JPanel
{
    private Game game;

    public Game getGame() {
        return game;
    }

    public GamePanel(Game game)
    {
        setFocusable(true);
        MouseInputs mouse=new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        setPanelSize();
        this.game=game;
    }




    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        game.render(g);
    }


    private void setPanelSize()
    {
        Dimension size=new Dimension(800,600);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void updateGame()
    {}

}

