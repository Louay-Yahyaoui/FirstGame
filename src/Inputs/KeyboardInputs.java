package Inputs;

import game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        switch (e.getKeyCode()) {
            case KeyEvent.VK_Q -> gamePanel.getGame().getPlayer().setLeft(true);
            case KeyEvent.VK_Z -> gamePanel.getGame().getPlayer().setUp(true);
            case KeyEvent.VK_D -> gamePanel.getGame().getPlayer().setRight(true);
            case KeyEvent.VK_S -> gamePanel.getGame().getPlayer().setDown(true);
        }
        }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_Q -> gamePanel.getGame().getPlayer().setLeft(false);
            case KeyEvent.VK_Z -> gamePanel.getGame().getPlayer().setUp(false);
            case KeyEvent.VK_D -> gamePanel.getGame().getPlayer().setRight(false);
            case KeyEvent.VK_S -> gamePanel.getGame().getPlayer().setDown(false);
        }
    }
}
