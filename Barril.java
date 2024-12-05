import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Barril extends Figura {
    private int velocidadX;
    private int velocidadY;
    private boolean visible;
    private final int gravedad = 1;

    public Barril(int x, int y, String imag) {
        super(x, y, imag);
        this.velocidadX = 5;
        this.velocidadY = 0;
        this.visible = true;
    }

    public void mover(Estructura[] plataformas) {
        if (visible) {
            this.x += this.velocidadX;

            boolean sobrePlataforma = false;
            for (Estructura plataforma : plataformas) {
                if (plataforma != null && this.getRectangle().intersects(plataforma.getRectangle())) {
                    if (this.velocidadY > 0 && (this.y + this.img.getHeight(null)) >= plataforma.getY()) {
                        this.y = plataforma.getY() - this.img.getHeight(null);
                        this.velocidadY = 0;
                        sobrePlataforma = true;
                        break;
                    }
                }
            }

            if (!sobrePlataforma) {
                this.velocidadY += gravedad;
                this.y += this.velocidadY;
            }

            if (this.x > 1200 || this.x < 0) {
                this.velocidadX = -this.velocidadX;
            }
        }
    }

    public void dibujar(Graphics g) {
        if (visible) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(this.img, this.x, this.y, null);
        }
    }

    public Rectangle getRectangle() {
        return new Rectangle(this.x, this.y, this.img.getWidth(null), this.img.getHeight(null));
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
