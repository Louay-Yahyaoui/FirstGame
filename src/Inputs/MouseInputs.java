package Inputs;

import game.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener {
    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    GamePanel gamePanel ;
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Hey you, you're finally awake");
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Mouse dragging");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        gamePanel.followMouse(e.getX(),e.getY());
    }
}
