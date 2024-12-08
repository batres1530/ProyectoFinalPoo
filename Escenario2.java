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

public class Escenario2 extends JPanel implements ActionListener, KeyListener {
    private ImageIcon icono;
    private Image fondo;
    private Timer t;
    private Random r;
    private JFrame frame;
    private Personaje mario;
    private Estructura[] plataformas;
    private Escalera[] escaleras;
    private int[] posicionesFijasX = {100, 300, 500, 700, 900};
    private static final int MAX_BARRILES = 30;
    private Barril[] barriles; 
    private Timer timerBarriles; 
    private int indiceBarrilActual = 0;

    public Escenario2(JFrame jfp) {
        icono = new ImageIcon("imagenes/fondo.png");
        fondo = icono.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        mario = new Personaje(100, 500, "imagenes/marios1.png");
        this.setSize(1200, 700);
        this.setVisible(true);
        this.frame = jfp;
        plataformas = new Estructura[85];
        escaleras = new Escalera[25];
        // plataforma inicio
        plataformas[0] = new Estructura(0, 640, "imagenes/plataformainicio2.png");
        // Plataformas uno
        plataformas[1] = new Estructura(64, 482, "imagenes/plataformade32.png");
        plataformas[2] = new Estructura(128, 482, "imagenes/plataformade32.png");
        plataformas[3] = new Estructura(192, 482, "imagenes/plataformade32.png");
        plataformas[4] = new Estructura(256, 482, "imagenes/plataformade32.png");
        plataformas[5] = new Estructura(320, 482, "imagenes/plataformade32.png");
        plataformas[6] = new Estructura(384, 482, "imagenes/plataformade32.png");
        plataformas[7] = new Estructura(448, 482, "imagenes/plataformade32.png");
        plataformas[8] = new Estructura(512, 482, "imagenes/plataformade32.png");
        plataformas[9] = new Estructura(576, 482, "imagenes/plataformade32.png");
        plataformas[10] = new Estructura(640, 482, "imagenes/plataformade32.png");;
        plataformas[11] = new Estructura(704, 482, "imagenes/plataformade32.png");;
        plataformas[12] = new Estructura(768, 482, "imagenes/plataformade32.png");;
        plataformas[13] = new Estructura(832, 482, "imagenes/plataformade32.png");;
       // plataformas[14] = new Estructura(896, 482, "imagenes/plataformade32.png");;
        plataformas[15] = new Estructura(960, 482, "imagenes/plataformade32.png");
        plataformas[16] = new Estructura(1024, 482, "imagenes/plataformade32.png");
        plataformas[17] = new Estructura(1060, 482, "imagenes/plataformade32.png");
        // segunda plataforma
        plataformas[18] = new Estructura(90, 325, "imagenes/plataformade32.png");
        plataformas[19] = new Estructura(128, 325, "imagenes/plataformade32.png");
        plataformas[20] = new Estructura(192, 325, "imagenes/plataformade32.png");
        plataformas[21] = new Estructura(256, 325, "imagenes/plataformade32.png");
        plataformas[22] = new Estructura(320, 325, "imagenes/plataformade32.png");
        //plataformas[23] = new Estructura(384, 325, "imagenes/plataformade32.png");
        plataformas[24] = new Estructura(448, 325, "imagenes/plataformade32.png");
        plataformas[25] = new Estructura(512, 325, "imagenes/plataformade32.png");
        plataformas[26] = new Estructura(576, 325, "imagenes/plataformade32.png");
        plataformas[27] = new Estructura(640, 325, "imagenes/plataformade32.png");
        plataformas[28] = new Estructura(704, 325, "imagenes/plataformade32.png");
        plataformas[29] = new Estructura(768, 325, "imagenes/plataformade32.png");
        plataformas[30] = new Estructura(832, 325, "imagenes/plataformade32.png");
        //plataformas[31] = new Estructura(896, 325, "imagenes/plataformade32.png");
        plataformas[32] = new Estructura(960, 325, "imagenes/plataformade32.png");
        plataformas[33] = new Estructura(1024, 325, "imagenes/plataformade32.png");
        // Plataformas tres
        plataformas[34] = new Estructura(115, 170, "imagenes/plataformade32.png");
        plataformas[35] = new Estructura(170, 170, "imagenes/plataformade32.png");
        plataformas[36] = new Estructura(225, 170, "imagenes/plataformade32.png");
        plataformas[37] = new Estructura(280, 170, "imagenes/plataformade32.png");
        plataformas[38] = new Estructura(335, 170, "imagenes/plataformade32.png");
        plataformas[39] = new Estructura(390, 170, "imagenes/plataformade32.png");        
        plataformas[40] = new Estructura(445, 170, "imagenes/plataformade32.png");
        plataformas[41] = new Estructura(500, 170, "imagenes/plataformade32.png");
        plataformas[42] = new Estructura(555, 170, "imagenes/plataformade32.png");
        plataformas[43] = new Estructura(610, 170, "imagenes/plataformade32.png");
        plataformas[44] = new Estructura(665, 170, "imagenes/plataformade32.png");
        plataformas[45] = new Estructura(720, 170, "imagenes/plataformade32.png");
        plataformas[46] = new Estructura(775, 170, "imagenes/plataformade32.png");
        plataformas[47] = new Estructura(830, 170, "imagenes/plataformade32.png");
        plataformas[48] = new Estructura(885, 170, "imagenes/plataformade32.png");        
        plataformas[49] = new Estructura(940, 170, "imagenes/plataformade32.png");
        plataformas[50] = new Estructura(990, 170, "imagenes/plataformade32.png");
        // plataforma 5 
      
        plataformas[52] = new Estructura( 305, 5, "imagenes/plataformade32.png");
        plataformas[53] = new Estructura( 360, 5, "imagenes/plataformade32.png");
        plataformas[54] = new Estructura( 415, 5, "imagenes/plataformade32.png");
        plataformas[55] = new Estructura( 470, 5, "imagenes/plataformade32.png");
        plataformas[56] = new Estructura( 525, 5, "imagenes/plataformade32.png");
        plataformas[57] = new Estructura( 580, 5, "imagenes/plataformade32.png");
        plataformas[58] = new Estructura( 635, 5, "imagenes/plataformade32.png");
        plataformas[59] = new Estructura( 690, 5, "imagenes/plataformade32.png");
        plataformas[60] = new Estructura( 745, 5, "imagenes/plataformade32.png");
        plataformas[61] = new Estructura( 800, 5, "imagenes/plataformade32.png");
        
        
        // princesa
        plataformas[65] = new Estructura(700, 108, "imagenes/princesa.png");
        plataformas[66] = new Estructura(450, 103, "imagenes/bariles.png");
        plataformas[67] = new Estructura(550, 75, "imagenes/Mono.png");
        //escaleraderecha
        escaleras[0] = new Escalera(1067, 485, "imagenes/Escalera1.png");
        //escalera centro
        escaleras[2] = new Escalera(600, 485, "imagenes/Escalera1.png");
        // escalera izquierda
        escaleras[4] = new Escalera(60, 485, "imagenes/Escalera1.png");    
        //escalera segunda
        escaleras[6] = new Escalera(125, 325, "imagenes/Escalera1.png");
        // escaler centro 1 
        escaleras[7] = new Escalera(500, 325, "imagenes/Escalera1.png");
        //escalera centro 2
        escaleras[8] = new Escalera(827, 325, "imagenes/Escalera1.png");
        // escalera derecha
        escaleras[9] = new Escalera(1008, 325, "imagenes/Escalera1.png");
        // escalera centro 3
        escaleras[10] = new Escalera(600, 170, "imagenes/Escalera1.png");
        // escalera izquierda
        escaleras[11] = new Escalera(165, 170, "imagenes/Escalera1.png");
        // escalera derecha
        escaleras[12] = new Escalera(980, 170, "imagenes/Escalera1.png");
        // escaleras 4 
        escaleras[13] = new Escalera(350, 42, "imagenes/palos1.png");
        // escaleras 5
        escaleras[14] = new Escalera(780, 42, "imagenes/palos1.png");
        barriles = new Barril[MAX_BARRILES];
        
        for (Barril barril : barriles) {
            if (barril != null) {
                barril.cambiarDireccion(true);
                barril.setAtraviesaPlataformas(true);
            }
        }
        // escaleras[3] = new Escalera(500, 500, "imagenes/Escalera2.png");
        
        t = new Timer(16, null);
        t.addActionListener(this);
        t.start();
        addKeyListener(this);
        this.setFocusable(true);

        timerBarriles = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarBarril();
            }
        });
        timerBarriles.start();
    }

    private void generarBarril() {
        // Busca un espacio disponible en el arreglo de barriles
        for (int i = 0; i < barriles.length; i++) {
            int indice = (indiceBarrilActual + i) % MAX_BARRILES;
            if (barriles[i] == null) {
                int x = posicionesFijasX[indiceBarrilActual];
                int y = 50; // Posición inicial en Y
                barriles[indice] = new Barril(x, y, "imagenes/barrilE.png");
                barriles[indice].setVisible(true);
                barriles[indice].cambiarDireccion(true);
                barriles[indice].setAtraviesaPlataformas(true);
                indiceBarrilActual = (indiceBarrilActual + 1) % posicionesFijasX.length; // Ciclar posiciones fijas
                break;
            }
        }
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
        for(int i = 0; i < barriles.length; i++) {
            if (barriles[i] != null) {
                barriles[i].mover(plataformas);
                barriles[i].dibujar(g2d);
                Rectangle rectBarril = barriles[i].getRectangle();
                g2d.setColor(Color.YELLOW);
                g2d.drawRect(rectBarril.x, rectBarril.y, rectBarril.width, rectBarril.height);
            }
        }

        mario.dibujar(g2d);
        Rectangle rectMario = mario.getRectangle();
        g2d.setColor(Color.BLUE);
        g2d.drawRect(rectMario.x, rectMario.y, rectMario.width, rectMario.height);
    }

    private void verificarColisionConPrincesa() {
        Estructura princesa = plataformas[65];
        if (mario.getRectangle().intersects(princesa.getRectangle())) {
            t.stop();
            frame.dispose();
            frame = new Principal(3);
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

        for (Barril barril : barriles) {
            if (barril != null) {
                barril.mover(plataformas);
                if (mario.getRectangle().intersects(barril.getRectangle())) {
                    barril.setVisible(false);
                    barril.setX(3000);
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
