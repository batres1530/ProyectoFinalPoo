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

public class Escenario5 extends JPanel implements ActionListener, KeyListener {
    private ImageIcon icono;
    private Image fondo;
    private Timer t;
    private Random r;
    private JFrame frame;
    private Personaje mario;
    private Estructura[] plataformas;
    private Escalera[] escaleras;

    public Escenario5(JFrame jfp) {
        icono = new ImageIcon("imagenes/fondo.png");
        fondo = icono.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        mario = new Personaje(100, 500, "imagenes/marios1.png");
        this.setSize(1200, 700);
        this.setVisible(true);
        this.frame = jfp;
        plataformas = new Estructura[65];
        escaleras = new Escalera[16];
        plataformas[0] = new Estructura(0, 640, "imagenes/plataformainicio5.png");
        plataformas[1] = new Estructura(0, 488, "imagenes/plataformainicio5.png");
        plataformas[2] = new Estructura(0, 332, "imagenes/plataformade35.png");
        plataformas[3] = new Estructura(108, 332, "imagenes/plataformade35.png");
        plataformas[4] = new Estructura(288, 332, "imagenes/plataformade35.png");
        plataformas[5] = new Estructura(396, 332, "imagenes/plataformade35.png");
        plataformas[6] = new Estructura(504, 332, "imagenes/plataformade35.png");
        plataformas[7] = new Estructura(612, 332, "imagenes/plataformade35.png");
        plataformas[8] = new Estructura(720, 332, "imagenes/plataformade35.png");
        plataformas[9] = new Estructura(765, 332, "imagenes/plataformade35.png");
        plataformas[10] = new Estructura(945, 332, "imagenes/plataformade35.png");
        plataformas[11] = new Estructura(1053, 332, "imagenes/plataformade35.png");
        plataformas[12] = new Estructura(1161, 332, "imagenes/plataformade35.png");
        plataformas[13] = new Estructura(0, 180, "imagenes/plataformainicio5.png");
        plataformas[14] = new Estructura(300, 17, "imagenes/plataformade35.png");
        plataformas[15] = new Estructura(408, 17, "imagenes/plataformade35.png");
        plataformas[16] = new Estructura(516, 17, "imagenes/plataformade35.png");
        plataformas[17] = new Estructura(624, 17, "imagenes/plataformade35.png");
        plataformas[18] = new Estructura(732, 17, "imagenes/plataformade35.png");


       
        
        plataformas[56] = new Estructura(650, 115, "imagenes/princesa.png");
        plataformas[57] = new Estructura(490, 115, "imagenes/bariles.png");
        plataformas[58] = new Estructura(550, 85, "imagenes/Mono.png");

        // escaleras
        escaleras[0] = new Escalera(10, 490, "imagenes/Escalera1.png");
        escaleras[1] = new Escalera(350, 490, "imagenes/Escalera1.png");
        escaleras[2] = new Escalera(750, 490, "imagenes/Escalera1.png");
        escaleras[3] = new Escalera(1100, 490, "imagenes/Escalera1.png");
        escaleras[4] = new Escalera(810, 332, "imagenes/Escalera1.png");
        escaleras[5] = new Escalera(290, 332, "imagenes/Escalera1.png");
        escaleras[6] = new Escalera(100, 180, "imagenes/Escalera1.png");
        escaleras[7] = new Escalera(400, 180, "imagenes/Escalera1.png");
        escaleras[8] = new Escalera(700, 180, "imagenes/Escalera1.png");
        escaleras[9] = new Escalera(1000, 180, "imagenes/Escalera1.png");
        escaleras[10] = new Escalera(790, 54, "imagenes/palos1.png");
        escaleras[11] = new Escalera(340, 54, "imagenes/palos1.png");



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
                g2d.setColor(Color.RED);
                g2d.drawRect(rectPlataforma.x, rectPlataforma.y, rectPlataforma.width, rectPlataforma.height);
            }
        }
        for (int i = 0; i < escaleras.length; i++){
            if (escaleras[i] != null) {
                escaleras[i].dibujar(g2d);
                Rectangle rectEscalera = escaleras[i].getRectangle();
                g2d.setColor(Color.GREEN);
                g2d.drawRect(rectEscalera.x, rectEscalera.y, rectEscalera.width, rectEscalera.height);
            }
        }

        mario.dibujar(g2d);
        Rectangle rectMario = mario.getRectangle();
        g2d.setColor(Color.BLUE);
        g2d.drawRect(rectMario.x, rectMario.y, rectMario.width, rectMario.height);
    }

    private void verificarColisionConPrincesa() {
        Estructura princesa = plataformas[56];
        if (mario.getRectangle().intersects(princesa.getRectangle())) {
            t.stop();
            frame.dispose();
            frame = new Principal(6);
        }
    }

    public void actionPerformed(ActionEvent e) {
        verificarColisionConPrincesa();
        mario.mover();
        
        boolean sobreEstructura = false;
    
        // Manejar colisiones solo si Mario no está escalando
        if (!mario.isEscalando()) {
            for (Estructura estructura : plataformas) {
                if (estructura != null && mario.getFeetRectangle().intersects(estructura.getRectangle())) {
                    // Detectar si Mario está cayendo hacia una plataforma
                    if (mario.getVelocidadY() > 0 && (mario.getY() + mario.getAlto()) >= estructura.getY()) {
                        mario.setY(estructura.getY() - mario.getAlto());
                        mario.setVelocidadY(0);
                        mario.setSaltando(false);
                        sobreEstructura = true;
                        mario.guardarUltimaPosicionY(mario.getY()); // Guardar la última posición válida
                        break;
                    }
                }
            }
    
            // Si no está sobre una plataforma, aplicar gravedad
            if (!sobreEstructura) {
                mario.setVelocidadY(mario.getVelocidadY() + 1);
                mario.setY(mario.getY() + mario.getVelocidadY());
    
                if (mario.getY() >= 640) { // Limitar la posición al suelo
                    mario.setY(640);
                    mario.setVelocidadY(0);
                    mario.setSaltando(false);
                }
            }
    
            // Manejar colisión con plataformas mientras Mario sube (opcional, si deseas evitar algo al saltar hacia arriba)
            for (Estructura estructura : plataformas) {
                if (estructura != null && mario.getRectangle().intersects(estructura.getRectangle())) {
                    if (mario.getVelocidadY() < 0 && mario.getY() <= estructura.getY() + 50) {
                        mario.setY(estructura.getY() + 50);
                        mario.setVelocidadY(0);
                        break;
                    }
                }
            }
        }
    
        // Manejar escaleras
        for (Escalera escalera : escaleras) {
            if (escalera != null && escalera.estaEscalando(mario)) {
                mario.setEscalando(true);
                break;
            } else {
                mario.setEscalando(false);
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