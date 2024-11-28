import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.util.Random;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;

public class Escenario2 extends JPanel implements ActionListener, KeyListener {
    private ImageIcon icono;
    private Image fondo;
    private Timer t;
    private Random r;
    private JFrame frame;

    public Escenario2(JFrame jfp) {
        icono = new ImageIcon("imagenes/fondo2.jpg");
        fondo = icono.getImage();

        this.setSize(1200, 700);
        this.setVisible(true);
        this.frame = jfp;
        t = new Timer(5, null);
        t.addActionListener(this);
        t.start();
        addKeyListener(this);
        this.setFocusable(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(fondo, 0, 0, null);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {

    }
}
