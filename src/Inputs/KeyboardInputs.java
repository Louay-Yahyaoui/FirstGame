package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_A:
                System.out.println("aha an a");
                break;
            case KeyEvent.VK_B:
                System.out.println("oh a B how Bold of you");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
