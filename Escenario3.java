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

public class Escenario3 extends JPanel implements ActionListener, KeyListener {
    private ImageIcon icono;
    private Image fondo;
    private Timer t;
    private Random r;
    private JFrame frame;
    private Personaje mario;
    private Estructura[] plataformas;
    private Escalera[] escaleras;
    private static final int MAX_BARRILES = 30; // Número máximo de barriles
    private Barril[] barriles; // Arreglo de barriles
    private Timer timerBarriles; // Temporizadores
    private int indiceBarrilActual = 0; 

    public Escenario3(JFrame jfp) {
        icono = new ImageIcon("imagenes/fondo.png");
        fondo = icono.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        mario = new Personaje(100, 500, "imagenes/marios1.png");
        this.setSize(1200, 700);
        this.setVisible(true);
        this.frame = jfp;
        plataformas = new Estructura[75];
        escaleras = new Escalera[15];
       plataformas[61] = new Estructura(5, 680, "imagenes/plataformade34.png");
        plataformas[0] = new Estructura(65, 680, "imagenes/plataformade34.png");
        plataformas[1] = new Estructura(125, 678, "imagenes/plataformade34.png");
        plataformas[2] = new Estructura(185, 676, "imagenes/plataformade34.png");
        plataformas[3] = new Estructura(245, 674, "imagenes/plataformade34.png");
        plataformas[4] = new Estructura(305, 672, "imagenes/plataformade34.png");
        plataformas[5] = new Estructura(365, 670, "imagenes/plataformade34.png");
        plataformas[6] = new Estructura(425, 668, "imagenes/plataformade34.png");
        plataformas[7] = new Estructura(485, 666, "imagenes/plataformade34.png");
        plataformas[8] = new Estructura(545, 664, "imagenes/plataformade34.png");
        plataformas[9] = new Estructura(605, 662, "imagenes/plataformade34.png");
        plataformas[10] = new Estructura(665, 660, "imagenes/plataformade34.png");
        plataformas[11] = new Estructura(725, 658, "imagenes/plataformade34.png");
        plataformas[12] = new Estructura(785, 656, "imagenes/plataformade34.png");
        plataformas[13] = new Estructura(845, 654, "imagenes/plataformade34.png");
        plataformas[14] = new Estructura(905, 654, "imagenes/plataformade34.png");
        plataformas[15] = new Estructura(965, 654, "imagenes/plataformade34.png");
        plataformas[16] = new Estructura(1025, 654, "imagenes/plataformade34.png");
        plataformas[62] = new Estructura(1085, 654, "imagenes/plataformade34.png");
        // Plataformas dsos
        plataformas[63] = new Estructura(1025, 500, "imagenes/plataformade34.png");
        plataformas[64] = new Estructura(965, 500, "imagenes/plataformade34.png");
        plataformas[17] = new Estructura(905, 500, "imagenes/plataformade34.png");
        plataformas[18] = new Estructura(845, 500, "imagenes/plataformade34.png");
        plataformas[19] = new Estructura(785, 500, "imagenes/plataformade34.png");
        plataformas[20] = new Estructura(725, 499, "imagenes/plataformade34.png");
        plataformas[21] = new Estructura(665, 498, "imagenes/plataformade34.png");
        plataformas[22] = new Estructura(605, 497, "imagenes/plataformade34.png");
        plataformas[23] = new Estructura(545, 496, "imagenes/plataformade34.png");
        plataformas[24] = new Estructura(485, 495, "imagenes/plataformade34.png");
        plataformas[25] = new Estructura(425, 494, "imagenes/plataformade34.png");
        plataformas[26] = new Estructura(365, 493 ,"imagenes/plataformade34.png");
        plataformas[27] = new Estructura(305, 492, "imagenes/plataformade34.png");
        plataformas[28] = new Estructura(245, 491, "imagenes/plataformade34.png");
        plataformas[29] = new Estructura(185, 490, "imagenes/plataformade34.png");
        plataformas[30] = new Estructura(125, 489, "imagenes/plataformade34.png");
        plataformas[31] = new Estructura(65, 488, "imagenes/plataformade34.png");
        plataformas[32] = new Estructura(5, 487, "imagenes/plataformade34.png");

        // plataforma tres
        plataformas[34] = new Estructura(110, 326, "imagenes/plataformade34.png");
        plataformas[35] = new Estructura(170, 325, "imagenes/plataformade34.png");
        plataformas[36] = new Estructura(230, 324, "imagenes/plataformade34.png");
        plataformas[37] = new Estructura(290, 323, "imagenes/plataformade34.png");
        plataformas[38] = new Estructura(350, 322, "imagenes/plataformade34.png");
        plataformas[39] = new Estructura(410, 321, "imagenes/plataformade34.png");        
        plataformas[40] = new Estructura(470, 320, "imagenes/plataformade34.png");
        plataformas[41] = new Estructura(530, 319, "imagenes/plataformade34.png");
        plataformas[42] = new Estructura(590, 318, "imagenes/plataformade34.png");    
        plataformas[43] = new Estructura(650, 318, "imagenes/plataformade34.png");
        plataformas[44] = new Estructura(710, 318, "imagenes/plataformade34.png");
        plataformas[45] = new Estructura(770, 318, "imagenes/plataformade34.png");
        plataformas[46] = new Estructura(830, 318, "imagenes/plataformade34.png");
        plataformas[47] = new Estructura(890, 318, "imagenes/plataformade34.png");        
        plataformas[48] = new Estructura(950, 318, "imagenes/plataformade34.png");
        plataformas[49] = new Estructura(1010, 318, "imagenes/plataformade34.png");
        plataformas[59] = new Estructura( 1070, 318, "imagenes/plataformade34.png");
        plataformas[60] = new Estructura( 1090, 318, "imagenes/plataformade34.png");
        // plataforma 4
        plataformas[50] = new Estructura( 460, 158, "imagenes/plataformade34.png");
        plataformas[51] = new Estructura( 520, 158, "imagenes/plataformade34.png");
        plataformas[52] = new Estructura( 580, 158, "imagenes/plataformade34.png");
        plataformas[53] = new Estructura( 640, 158, "imagenes/plataformade34.png");
        plataformas[54] = new Estructura( 700, 158, "imagenes/plataformade34.png");
       
        plataformas[56] = new Estructura( 485, 97, "imagenes/princesa2.png");
        plataformas[57] = new Estructura(1080, 250, "imagenes/bariles.png");
        plataformas[58] = new Estructura(995, 220, "imagenes/Mono.png");
        // escaleras
        escaleras[0] = new Escalera(980, 500, "imagenes/Escalera1.png"); // escalera derecha del primero
        escaleras[1] = new Escalera(110, 327, "imagenes/Escalera1.png"); // escalaera  izquierda segunda se le va a cambiar la imagen  
        escaleras[2] = new Escalera(460, 167, "imagenes/Escalera1.png"); // escalera princesa
        escaleras[3] = new Escalera(760, 162, "imagenes/Escalera1.png"); // escalera del mono
        escaleras[4] = new Escalera(830, 162, "imagenes/Escalera1.png"); // escalera del mono
        escaleras[5] = new Escalera(760, 10, "imagenes/Escalera1.png");// escalera del mono
        escaleras[6] = new Escalera(830, 10, "imagenes/Escalera1.png");// escalera del mono
        escaleras[7] = new Escalera(400, 360, "imagenes/Escalera2.png"); // no se si van a cambiar las imagenes
        escaleras[9] = new Escalera(630, 500, "imagenes/Escalera1.png");
        escaleras[10] = new Escalera(200, 530, "imagenes/Escalera2.png");

        barriles = new Barril[MAX_BARRILES];
        for (Barril barril : barriles) {
            if (barril != null) {
                barril.cambiarDireccion(false);
                barril.setAtraviesaPlataformas(false);
            }
        }

        t = new Timer(16, null);
        t.addActionListener(this);
        t.start();
        addKeyListener(this);
        this.setFocusable(true);

        timerBarriles = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarBarril();
            }
        });
        timerBarriles.start();
    }

    private void generarBarril() {
        // Busca un espacio disponible en el arreglo de barriles
        for (int i = 0; i < MAX_BARRILES; i++) {
            int indice = (indiceBarrilActual + i) % MAX_BARRILES; // Búsqueda circular
            if (barriles[indice] == null) {
                // Genera un nuevo barril en la posición deseada
                barriles[indice] = new Barril(960, 220, "imagenes/barrilE.png");
                barriles[indice].cambiarDireccion(false); //cambiar a true en los niveles que caen
                barriles[indice].setAtraviesaPlataformas(false);
                indiceBarrilActual = (indice + 1) % MAX_BARRILES;
                break;
            }
        }
    }

    public void actualizar() {
        mario.mover(); // Mueve a Mario
        mario.moverBalas(); // Mueve las balas disparadas
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

        for (int i = 0; i < barriles.length; i++){
            if (barriles[i] != null) {
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
    
        for (Bala bala : mario.getBalas()) {
            bala.dibujar(g2d); // Asumiendo que cada bala tiene un método dibujar
        }

    }

        

    private void verificarColisionConPrincesa() {
        Estructura princesa = plataformas[56];
        if (mario.getRectangle().intersects(princesa.getRectangle())) {
            t.stop();
            frame.dispose();
            frame = new Principal(4);
        }
    }

    public void actionPerformed(ActionEvent e) {
        verificarColisionConPrincesa();
        mario.mover();
        mario.moverBalas();
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
                barril.moverIzquierda(plataformas);
                if (mario.getRectangle().intersects(barril.getRectangle())) {
                    barril.setVisible(false);
                    barril.setX(3000);
                }
            }
        }

        for (Bala bala : mario.getBalas()) {
            if (bala != null) { 
                Rectangle rectBala = bala.getRectangle();
                
                for (Barril barril : barriles) {
                    if (barril != null) {
                        Rectangle rectBarril = barril.getRectangle();
                        if (rectBala.intersects(rectBarril)) {
                          
                            barril.setVisible(false);
                            barril.setX(3000);
                            bala.setVisible(0);
                            bala.setX(3000);
                            break;
                        }
                    }
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

