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
    private float xDelta=100;
    private float yDelta=100;
    private float xDir=1,yDir=1;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int AniSpeed=15,AniTick=0,AniIndex=0;
    private int playerAction=IDLE;
    private int playDir=-1;
    private boolean moving=false;
    public GamePanel()
    {
        setFocusable(true);
        MouseInputs mouse=new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouse);
        addMouseMotionListener(mouse);
        setPanelSize();
        importImage();
        loadAnimations();
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setDirection(int direction)
    {
        this.playDir=direction;
        moving=true;
    }
    public void followMouse(int x,int y)
    {
        xDelta=x;
        yDelta=y;

    }
    private void updateAnimationTick()
    {
        AniTick++;
        if(AniTick>=AniSpeed)
        {
            AniIndex++;
            AniTick=0;
            if(AniIndex>= GetSpriteAmount(playerAction))
                AniIndex=0;
        }
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage(animations[playerAction][AniIndex],(int) xDelta,(int) yDelta,256,160,null);
    }
    public void importImage()
    {
        InputStream is=getClass().getResourceAsStream("/res/spriteatlas.png");
        try {
            img = ImageIO.read(is);
        }
        catch (IOException e)
        {}
        finally
        {
            try{is.close();}
            catch (Exception e){}
        }
    }
    public void loopyloop() {

        if ((xDelta >= 700) || (xDelta < 0)) {
            xDir *= -1;
        }


        if ((yDelta >= 500) || (yDelta < 0)) {
            yDir *= -1;
        }
        xDelta += xDir;
        yDelta += yDir;
    }
    private void setPanelSize()
    {
        Dimension size=new Dimension(800,600);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }
    private void loadAnimations()
    {
        animations =new BufferedImage[9][6];
        for (int j=0;j<animations.length;j++)
            for (int i = 0; i<animations[j].length; i++)
                animations[j][i]=img.getSubimage(i*64,j*40,64,40);
    }
    public void setAnimation()
    {
        if (moving)
            playerAction=RUNNING;
        else
            playerAction=IDLE;
    }
    private void updatePos() {
        if (moving) {
            switch (playDir) {
                case LEFT -> xDelta -= 5;
                case UP -> yDelta -= 5;
                case RIGHT -> xDelta += 5;
                case DOWN -> yDelta += 5;
            }
        }
    }

    public void updateGame()
    {
        updateAnimationTick();
        setAnimation();
        updatePos();
    }
}

