import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Barril extends Figura {
    private int velocidadX;
    private int velocidadY;
    private boolean visible;
    private boolean atraviesaPlataformas;
    private final double gravedad = 1;

    public Barril(int x, int y, String imag) {
        super(x, y, imag);
        this.velocidadX = 5;
        this.velocidadY = 0;
        this.visible = true;
        this.atraviesaPlataformas = false;
    }

    public void mover(Estructura[] plataformas) {
        if (visible) {
            this.x += this.velocidadX;
            if (!atraviesaPlataformas) {
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
            } else {
               
                this.y += this.velocidadY;
            }

            if (this.x > 1200 || this.x < 0) {
                this.velocidadX = -this.velocidadX;
            }
        }
    }

    public void moverIzquierda(Estructura[] plataformas) {
        if (visible) {
            this.x -= this.velocidadX; // velocidadX es negativo, por lo que se mueve hacia la izquierda
    
            if (!atraviesaPlataformas) {
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
            } else {
                this.y += this.velocidadY;
            }
    
            // Reiniciar posición si el barril sale del lado izquierdo
            if (this.x > 1200 || this.x < 0) {
                this.velocidadX = -this.velocidadX;
            }
        }
    }

    public void cambiarDireccion(boolean haciaAbajo) {
        if (haciaAbajo) {
            this.velocidadX = 0;
            this.velocidadY = 5 ;
        } else {
            this.velocidadX = 5;
            this.velocidadY = 0;
        }
    }

    public void setAtraviesaPlataformas(boolean atraviesa) {
        this.atraviesaPlataformas = atraviesa;
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
