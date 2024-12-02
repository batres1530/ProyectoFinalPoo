import java.awt.Rectangle;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Figura { 
    protected int x;
    protected int y;
    protected int ancho;
    protected int alto;
    protected int visible;
    protected Image img;
    protected ImageIcon icono;
    protected Rectangle rect;
    protected String imag;

    public Figura(int x, int y, String imag) {  
        this.x = x;
        this.y = y;
        this.imag = imag;
        this.icono = new ImageIcon(imag);
        this.img = icono.getImage();
        this.visible = 1;
        this.ancho = this.icono.getIconWidth();
        this.alto = this.icono.getIconHeight();
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getX() {
        return this.x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
    public int getAncho() {
        return this.ancho;
    }
    
    public void setAlto(int alto) {
        this.alto = alto;
    }
    
    public int getAlto() {
        return this.alto;
    }
    
    public void setImage(Image img) {
        this.img = img;
    }
    
    public Image getImage() {
        return this.img;
    }
    
    public void setIcon(ImageIcon icono) {
        this.icono = icono;
    }
    
    public ImageIcon getIcon() {
        return this.icono;
    }
    
    public void setVisible(int visible) {
        this.visible = visible;
    }
    
    public int getVisible() {
        return this.visible;
    }
    
    public Rectangle getRectangle() {
        return this.rect = new Rectangle(this.x, this.y, this.ancho, this.alto);
    }
    
    public boolean getDetectar(Rectangle r) {
        this.rect = new Rectangle(this.x, this.y, this.ancho, this.alto);
        return this.rect.intersects(r);
    }
    
    public void dibujar(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (getVisible() == 1) {
            g2d.drawImage(this.img, this.x, this.y, null);
        }
    }
}
