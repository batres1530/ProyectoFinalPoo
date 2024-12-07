import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class Personaje extends Figura {
    private int avanceX;
    private int velocidadY;
    private boolean saltando;
    private boolean escalando;
    private final int gravedad = 1;
    private final int alturaSalto = -20; // hay que poner el salto con otra tecla y  con otra imagen 
    private final int suelo = 640;
    private int ultimaPosicionY;
    private Bala[] balas; // Arreglo de balas
    private int contadorBalas; // Contador de balas
    private final int maxBalas = 10; // aqui hay que poner las balas de mario yo digo que unas 10
    private int direccion; // 1 para derecha, -1 para izquierda


    public Personaje(int x, int y, String imag) {
        super(x, y, imag);
        this.avanceX = 0;
        this.velocidadY = 0;
        this.saltando = false;
        this.escalando = false;
        this.ultimaPosicionY = y;
        this.balas = new Bala[maxBalas];
        this.contadorBalas = 0;

        for (int i = 0; i < maxBalas; i++) {
            balas[i] = new Bala(-1000, -1000); // Posición inicial fuera de pantalla
            balas[i].setEstadoBala1(false);
        }
    }
    public void disparar() {
        if (contadorBalas < maxBalas) {
            Bala bala = balas[contadorBalas];
            bala.setX(this.x + this.ancho / 2 - 20); // Posición inicial de la bala
            bala.setY(this.y + this.alto / 2- 15);
            bala.setDireccion(this.direccion);
            bala.estadoBala1 = true; // Activa la bala
        contadorBalas++;
        } else {
            contadorBalas = 0; // Reinicia el contador si se supera el límite
        }
    }
    public void moverBalas() {
        for (Bala bala : balas) {
            if (bala.estadoBala1) {
                bala.mover(); // Mueve la bala jjjjjjjjjj
            }
        }
    }
    // metodo getblalas
    public Bala[] getBalas() {
        return this.balas;
    }
    

    public void mover() {
        this.x += this.avanceX;

        if (this.x > 1100) this.x = 1100;
        if (this.x < 15) this.x = 15;

        if (escalando) {
            this.y += this.velocidadY;
            // Si baja más allá de la última posición permitida, restablece la posición
            if (this.y > ultimaPosicionY) {
                this.y = ultimaPosicionY;
                this.velocidadY = 0; // Detener el movimiento vertical
            }
        } else if (saltando) {
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
            this.direccion = 1;
        }

        if (tecla == KeyEvent.VK_LEFT) {
            this.avanceX = -5;
            cambiarImagen("imagenes/marios2.png");
            this.direccion = -1;
        }
        // aqui salta
        // if (tecla == KeyEvent.VK_SPACE && !saltando && !escalando) {
        //     this.saltando = true;
        //     this.velocidadY = alturaSalto;
        // }
        
        // disparo de balas
        if (tecla == KeyEvent.VK_SPACE) {
            disparar(); // Dispara una bala cuando se presiona ESPACIO
        }

        if (tecla == KeyEvent.VK_UP && escalando) {
            this.velocidadY = -5;
            cambiarImagen("imagenes/marioEspalda2.png");
        }

        if (tecla == KeyEvent.VK_DOWN && escalando) {
            this.velocidadY = 5;
            cambiarImagen("imagenes/marioEspalda2.png"); // aqui son los controles de mario
        }
    }

    public void keyReleased(KeyEvent ev) {
        int tecla = ev.getKeyCode();
        if (tecla == KeyEvent.VK_RIGHT || tecla == KeyEvent.VK_LEFT) {
            this.avanceX = 0;
        }

        if (tecla == KeyEvent.VK_UP || tecla == KeyEvent.VK_DOWN) {
            this.velocidadY = 0;
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

    public boolean isEscalando() {
        return escalando;
    }

    public void setEscalando(boolean escalando) {
        this.escalando = escalando;
    }

    public void guardarUltimaPosicionY(int y) {
        this.ultimaPosicionY = y;
    }

    public int getUltimaPosicionY() {
        return ultimaPosicionY;
    }
}
