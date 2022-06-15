package Inputs;

import game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static utilz.Constants.Directions.*;

public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_Q:
                gamePanel.setDirection(LEFT);
                break;
            case KeyEvent.VK_Z:
                gamePanel.setDirection(UP);
                break;
            case KeyEvent.VK_D:
                gamePanel.setDirection(RIGHT);
                break;
            case KeyEvent.VK_S:
                gamePanel.setDirection(DOWN);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_Q:
            case KeyEvent.VK_Z:
            case KeyEvent.VK_D:
            case KeyEvent.VK_S:
                gamePanel.setMoving(false);
                break;
        }
    }
}
