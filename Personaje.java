import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Personaje extends Figura {
    
    private int avanceX;
    private int velocidadY;
    private boolean saltando;
    private final int gravedad = 1;
    private final int alturaSalto = -15;
    private final int suelo = 500;

    public Personaje(int x, int y, String imag) {
        super(x, y, "imagenes/mario1.png");
        this.avanceX = 0;
        this.velocidadY = 0;
        this.saltando = false;
    }

    public void mover() {
        this.x += this.avanceX;

        if (this.x == 1100) {
            this.x += -5;
        }

        if (this.x == 15) {
            this.x += 5;
        }

        if (saltando) {
            this.y += velocidadY;
            velocidadY += gravedad;

            if (this.y >= suelo) {
                this.y = suelo;
                saltando = false;
                velocidadY = 0;
            }
        }
    }

    public void keyPressed(KeyEvent ev) {
        int tecla = ev.getKeyCode();
        
        if (tecla == KeyEvent.VK_RIGHT && this.x < 1100) {
            this.avanceX = +5;
            this.icono = new ImageIcon("Imagenes/mario2.png");
            this.img = icono.getImage();
        }
        
        if (tecla == KeyEvent.VK_LEFT && this.x > 15) {
            this.avanceX = -5;
            this.icono = new ImageIcon("Imagenes/mario1.png");
            this.img = icono.getImage();
        }

        if (tecla == KeyEvent.VK_SPACE && !saltando) {
            this.saltando = true;
            this.velocidadY = alturaSalto;
        }
    }

    public void keyReleased(KeyEvent ev) {
        int tecla = ev.getKeyCode();
        if (tecla == KeyEvent.VK_RIGHT || tecla == KeyEvent.VK_LEFT) {
            this.avanceX = 0;
        }
    }

    public void dibujar(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(this.img, this.x, this.y, null);
    }
}
