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
    private Escalera[] escaleras;

    public Escenario(JFrame jfp) {
        icono = new ImageIcon("imagenes/fondo.png");
        fondo = icono.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        mario = new Personaje(100, 500, "imagenes/marios1.png");
        this.setSize(1200, 700);
        this.setVisible(true);
        this.frame = jfp;
        plataformas = new Estructura[65];
        escaleras = new Escalera[10];
        // estructura inicial
        plataformas[0] = new Estructura(0, 640, "imagenes/Plataformasinicio.png");
        // estructura izquierda
        plataformas[1] = new Estructura(0, 468, "imagenes/plataformade3.png");
        plataformas[2] = new Estructura(64, 468, "imagenes/plataformade3.png");
        plataformas[3] = new Estructura(128, 468, "imagenes/plataformade3.png");
        plataformas[4] = new Estructura(192, 468, "imagenes/plataformade3.png");
        plataformas[5] = new Estructura(256, 468, "imagenes/plataformade3.png");
        plataformas[6] = new Estructura(320, 468, "imagenes/plataformade3.png");
        plataformas[7] = new Estructura(384, 468, "imagenes/plataformade3.png");
        plataformas[8] = new Estructura(448, 468, "imagenes/plataformade3.png");
        plataformas[9] = new Estructura(512, 469, "imagenes/plataformade3.png");
        plataformas[10] = new Estructura(576, 469, "imagenes/plataformade3.png");
        plataformas[11] = new Estructura(640, 469, "imagenes/plataformade3.png");
        plataformas[12] = new Estructura(704, 469, "imagenes/plataformade3.png");
        plataformas[13] = new Estructura(768, 471, "imagenes/plataformade3.png");
        plataformas[14] = new Estructura(832, 471, "imagenes/plataformade3.png");
        plataformas[15] = new Estructura(896, 471, "imagenes/plataformade3.png");
        plataformas[16] = new Estructura(960, 475, "imagenes/plataformade3.png");
        plataformas[17] = new Estructura(1024, 477, "imagenes/plataformade3.png");
        //palata forma derecha
        plataformas[18] = new Estructura( 1119, 309, "imagenes/plataformade3.png");
        plataformas[19] = new Estructura( 1055, 309, "imagenes/plataformade3.png"); // ojo que esta estructura EMPIZA LA DEL MONO O LA FINAL
       plataformas[20] = new Estructura(  991, 309, "imagenes/plataformade3.png");
        plataformas[21] = new Estructura(  927, 309, "imagenes/plataformade3.png");
        plataformas[22] = new Estructura(  863, 309, "imagenes/plataformade3.png");
        plataformas[23] = new Estructura(  799, 309, "imagenes/plataformade3.png");
        plataformas[24] = new Estructura(  735, 309, "imagenes/plataformade3.png");
        plataformas[25] = new Estructura(  671, 309,"imagenes/plataformade3.png");
        plataformas[26] = new Estructura(  607, 310, "imagenes/plataformade3.png");
        plataformas[27] = new Estructura(  543, 310, "imagenes/plataformade3.png");
        plataformas[28] = new Estructura(  479, 311, "imagenes/plataformade3.png");
        plataformas[29] = new Estructura(  415, 311, "imagenes/plataformade3.png");
        plataformas[30] = new Estructura(  351, 311, "imagenes/plataformade3.png");
        plataformas[31] = new Estructura(  287, 312, "imagenes/plataformade3.png");
        plataformas[32] = new Estructura(  223, 312, "imagenes/plataformade3.png");
        plataformas[33] = new Estructura(  159, 313, "imagenes/plataformade3.png");
        plataformas[34] = new Estructura(  95, 314, "imagenes/plataformade3.png");
        // estructura final
        plataformas[35] = new Estructura(    554, 65, "imagenes/plataformade3.png");
        plataformas[36] = new Estructura(    490, 65, "imagenes/plataformade3.png");
        plataformas[37] = new Estructura(    426, 65, "imagenes/plataformade3.png");
        plataformas[38] = new Estructura(    362, 65, "imagenes/plataformade3.png");
         // estructura izquierda final
         plataformas[39] = new Estructura(0, 155, "imagenes/plataformade3.png");
         plataformas[40] = new Estructura(64, 155, "imagenes/plataformade3.png");
         plataformas[41] = new Estructura(128, 155, "imagenes/plataformade3.png");
         plataformas[42] = new Estructura(192, 155, "imagenes/plataformade3.png");
         plataformas[43] = new Estructura(256, 155, "imagenes/plataformade3.png");
         plataformas[44] = new Estructura(320, 155, "imagenes/plataformade3.png");
         plataformas[45] = new Estructura(384, 155, "imagenes/plataformade3.png");
         plataformas[46] = new Estructura(448, 155, "imagenes/plataformade3.png");
         plataformas[47] = new Estructura(512, 155, "imagenes/plataformade3.png");
         plataformas[48] = new Estructura(576, 155, "imagenes/plataformade3.png");
         plataformas[49] = new Estructura(640, 155, "imagenes/plataformade3.png");
         plataformas[50] = new Estructura(704, 155, "imagenes/plataformade3.png");
         plataformas[51] = new Estructura(768, 155, "imagenes/plataformade3.png");
         plataformas[52] = new Estructura(832, 158, "imagenes/plataformade3.png");
         plataformas[53] = new Estructura(896, 161, "imagenes/plataformade3.png");
         plataformas[54] = new Estructura(960, 164, "imagenes/plataformade3.png");
         plataformas[55] = new Estructura(1024, 167, "imagenes/plataformade3.png");
        // princesa
        plataformas[56] = new Estructura(   485, 0, "imagenes/princesa.png");
        // bariles 
        plataformas[57] = new Estructura(   40,  89, "imagenes/bariles.png");
        // mono
        plataformas[58] = new Estructura(   120,  60, "imagenes/Mono.png");

        //escaleras 
        escaleras[0] = new Escalera(  0,  468, "imagenes/Escalera1.png");
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

    // funciones del proyecto
    private void verificarColisionConPrincesa() {
        Estructura princesa = plataformas[56]; // Asumiendo que la princesa está en la posición 56
        if (mario.getRectangle().intersects(princesa.getRectangle())) {
            t.stop();
            frame.dispose();
            frame = new Principal(2);
        }
    }

    public void actionPerformed(ActionEvent e) {
        verificarColisionConPrincesa();
        mario.mover();
        boolean sobreEstructura = false;

        if (!mario.isEscalando()) {
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

                if (mario.getY() >= 640) {
                    mario.setY(640);
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
        }

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
