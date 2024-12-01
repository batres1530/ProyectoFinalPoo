import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import java.util.Random;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Escenario extends JPanel implements ActionListener, KeyListener {
    private ImageIcon icono;
    private Image fondo;
    private Timer t;
    private Random r;
    private JFrame frame;
    private Personaje mario;
    private Estructura[] plataformas;

    public Escenario(JFrame jfp) {
        icono = new ImageIcon("imagenes/Fondo.png");
        fondo = icono.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        mario = new Personaje(100, 500, "imagenes/mario1.png");
        this.setSize(1200, 700);
        this.setVisible(true);
        this.frame = jfp;
        plataformas = new Estructura[100];
        plataformas[0] = new Estructura(0, 640, "imagenes/plataforma.png");
        plataformas[1] = new Estructura(500, 640, "imagenes/plataforma.png");
        plataformas[2] = new Estructura(1000, 640, "imagenes/plataforma.png");
        plataformas[3] = new Estructura(0, 500, "imagenes/plataformaXL.png");
        t = new Timer(16, null);
        t.addActionListener(this);
        t.start();
        addKeyListener(this);
        this.setFocusable(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), null);
        for (int i = 0; i < plataformas.length; i++) {
            if (plataformas[i] != null) {
                plataformas[i].dibujar(g2d);
                Rectangle rectPlataforma = plataformas[i].getRectangle();
                // g2d.setColor(Color.RED);
                // g2d.drawRect(rectPlataforma.x, rectPlataforma.y, rectPlataforma.width, rectPlataforma.height);
            }
        }
        mario.dibujar(g2d);
        Rectangle rectMario = mario.getRectangle();
        g2d.setColor(Color.BLUE);
        g2d.drawRect(rectMario.x, rectMario.y, rectMario.width, rectMario.height);
    }

    public void actionPerformed(ActionEvent e) {
        mario.mover();
        boolean sobreEstructura = false;

        for (Estructura estructura : plataformas) {
            if (estructura != null && mario.getFeetRectangle().intersects(estructura.getRectangle())) {
                if (mario.getVelocidadY() > 0 && (mario.getY() + mario.getAlto()) >= estructura.getY()) {
                    mario.setY(estructura.getY() - mario.getAlto());
                    mario.setVelocidadY(0);
                    mario.setSaltando(false);
                    sobreEstructura = true;
                    break;
                }
            }
        }

        if (!sobreEstructura) {
            mario.setVelocidadY(mario.getVelocidadY() + 1);
            mario.setY(mario.getY() + mario.getVelocidadY());

            if (mario.getY() >= 550) {
                mario.setY(550);
                mario.setVelocidadY(0);
                mario.setSaltando(false);
            }
        }

        for (Estructura estructura : plataformas) {
            if (estructura != null && mario.getRectangle().intersects(estructura.getRectangle())) {
                if (mario.getVelocidadY() < 0 && mario.getY() <= estructura.getY() + 50) {
                    mario.setY(estructura.getY() + 50);
                    mario.setVelocidadY(0);
                    break;
                }
            }
        }

        repaint();
    }

    public void keyPressed(KeyEvent e) {
        this.mario.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        this.mario.keyReleased(e);
    }

    public void keyTyped(KeyEvent e) {
    }
}
