import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class KeyboardObserver extends Thread {
    private Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<KeyEvent>(100);

    static JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("Untitled Snake");
        frame.setTitle("Untitled Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        frame.setUndecorated(false);
        frame.setSize((Room.game.getWidth() * 10) + 17, (Room.game.getHeight() * 10) + 40);
        frame.setLayout(new GridBagLayout());

        frame.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //do nothing
            }
            @Override
            public void focusLost(FocusEvent e) {
                System.exit(0);
            }
        });


        frame.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
                //do nothing
            }

            public void keyReleased(KeyEvent e) {
                //do nothing
            }

            public void keyPressed(KeyEvent e) {
                keyEvents.add(e);
            }
        });
    }


    public boolean hasKeyEvents() {
        return !keyEvents.isEmpty();
    }

    public KeyEvent getEventFromTop() {
        return keyEvents.poll();
    }
}
