import javax.swing.*;

public class Game extends JFrame
{
    private GameWindow gameWindow;
    private GamePanel panel;
    public Game()
    {
        panel=new GamePanel();
        gameWindow=new GameWindow(panel);
        panel.requestFocus();

    }
}
