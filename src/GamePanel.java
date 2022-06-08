import Inputs.KeyboardInputs;
import Inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel
{
    public GamePanel()
    {
        addKeyListener(new KeyboardInputs());
        addMouseListener(new MouseInputs());
    }
    public void paintComponent(Graphics G)
    {
        super.paintComponent(G);
        G.setColor(Color.cyan);
        G.fillRect(100,100,100,100);
    }
}
