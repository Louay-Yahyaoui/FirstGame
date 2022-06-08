import Inputs.KeyboardInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel
{
    public GamePanel()
    {
        addKeyListener(new KeyboardInputs());
    }
    public void paintComponent(Graphics G)
    {
        super.paintComponent(G);
        G.setColor(Color.cyan);
        G.fillRect(100,100,100,100);
    }
}
