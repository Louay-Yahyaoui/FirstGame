package game;

import javax.swing.*;

public class GameWindow {
    private JFrame jframe;
    public GameWindow(GamePanel panel)
    {
        jframe=new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(panel);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setVisible(true);
    }
}
