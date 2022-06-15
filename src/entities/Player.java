package entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.PlayerConstants.*;

public class Player extends Entity{
    private BufferedImage[][] animations;
    private int AniSpeed=15,AniTick=0,AniIndex=0;
    private int playerAction=IDLE;
    private int playDir=-1;
    private boolean up =false;
    private boolean down =false;
    private boolean right =false;
    private boolean left=false;
    private boolean moving;
    private float playerSpeed=1;

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    private boolean attacking;

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    private boolean Left=false;
    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }
    public void update()
    {
        updatePos();
        updateAnimationTick();
        setAnimation();
    }
    public void setDirection(int direction)
    {
        this.playDir=direction;

    }
    public void render(Graphics g)
    {
        g.drawImage(animations[playerAction][AniIndex],(int) x,(int) y,256,160,null);
    }
    public void loadAnimations()
    {
        InputStream is=getClass().getResourceAsStream("/res/spriteatlas.png");
        try {
            BufferedImage img = ImageIO.read(is);
            animations =new BufferedImage[9][6];
            for (int j=0;j<animations.length;j++)
                for (int i = 0; i<animations[j].length; i++)
                    animations[j][i]=img.getSubimage(i*64,j*40,64,40);
        }
        catch (IOException e)
        {}
        finally
        {
            try{is.close();}
            catch (Exception e){}
        }
    }
    public void setAnimation()
    {
        if (attacking)
            playerAction=ATTACK_1;
        else if(moving)
            playerAction=RUNNING;
        else
            playerAction=IDLE;
    }
    private void updatePos() {
        moving=false;
        if(left && !right)
        {
            x-=playerSpeed;
            moving=true;
        }


        else if (!left && right)
        {
            x+=playerSpeed;
            moving=true;
        }

        if(up && !down)
        {
            y -= playerSpeed;
            moving=true;
        } else if (!up && down) {
            y += playerSpeed;
            moving=true;
        }


    }
    private void updateAnimationTick()
    {
        int startAni=playerAction;
        AniTick++;
        if(AniTick>=AniSpeed)
        {
            AniIndex++;
            AniTick=0;
            if(AniIndex>= GetSpriteAmount(playerAction))
            {   AniIndex=0;
                attacking=false;
            }
        }
        if(startAni!=playerAction)
        {
            AniTick=0;
            AniIndex=0;
        }
    }

    public void resetBooleans() {
        left=false;
        up=false;
        down=false;
        right=false;
        moving=false;
    }
}
