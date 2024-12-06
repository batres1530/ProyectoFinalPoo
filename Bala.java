import java.awt.Graphics;
import java.awt.Graphics2D;
public class Bala extends Figura {
    private int direccion; // 1 para derecha -1 para izquierda
    public boolean estadoBala1; // Para controlar si la bala está activa

    // Constructor
    public Bala(int x, int y) {
        super(x, y, "imagenes/bala.png"); // Aquí va la imagen de la bala
        this.direccion = 1; // Por defecto, la bala se moverá hacia la derecha
        this.estadoBala1 = false; 
    }

    // Método para mover la bala
    public void mover() {
        this.x += 10 * direccion; // Se mueve en la dirección establecida
        if (this.x > 1200 || this.x < 0) { // Si sale del límite de la pantalla
            this.estadoBala1 = false; // Desactiva la bala
        }
    }

    // Método para establecer la dirección
    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    // Método para dibujar la bala (si está activa)
    public void dibujar(Graphics g) {
        if (estadoBala1) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(this.img, this.x, this.y, null);
        }
    }
}

