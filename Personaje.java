import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class Personaje extends Figura {
    private int avanceX;
    private int velocidadY;
    private boolean saltando;
    private final int gravedad = 1;
    private final int alturaSalto = -20;
    private final int suelo = 640;

    public Personaje(int x, int y, String imag) {
        super(x, y, imag);
        this.avanceX = 0;
        this.velocidadY = 0;
        this.saltando = false;
    }

    public void mover() {
        this.x += this.avanceX;

        if (this.x > 1100) this.x = 1100;
        if (this.x < 15) this.x = 15;

        if (saltando) {
            this.y += this.velocidadY;
            this.velocidadY += gravedad;

            if (this.y >= suelo) {
                this.y = suelo;
                this.saltando = false;
                this.velocidadY = 0;
            }
        }
    }

    public void keyPressed(KeyEvent ev) {
        int tecla = ev.getKeyCode();

        if (tecla == KeyEvent.VK_RIGHT) {
            this.avanceX = 5;
            cambiarImagen("imagenes/marios1.png");
        }

        if (tecla == KeyEvent.VK_LEFT) {
            this.avanceX = -5;
            cambiarImagen("imagenes/marios2.png");
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

    private void cambiarImagen(String ruta) {
        this.icono = new ImageIcon(ruta);
        this.img = icono.getImage();
    }

    public Rectangle getRectangle() {
        return new Rectangle(this.x + 20, this.y + 10 , this.img.getWidth(null)- 40, this.img.getHeight (null)-30 );
    }

    public Rectangle getFeetRectangle() {
        int feetHeight = 1;
        return new Rectangle(this.x, this.y + this.img.getHeight(null) - feetHeight, this.img.getWidth(null), feetHeight);
    }

    public int getVelocidadY() {
        return velocidadY;
    }

    public void setVelocidadY(int velocidadY) {
        this.velocidadY = velocidadY;
    }

    public int getAlto() {
        return this.img.getHeight(null);
    }

    public boolean isSaltando() {
        return saltando;
    }

    public void setSaltando(boolean saltando) {
        this.saltando = saltando;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
