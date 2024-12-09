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
    private static final int MAX_BARRILES = 30; // Número máximo de barriles
    private Barril[] barriles; // Arreglo de barriles
    private Timer timerBarriles; // Temporizador de barriles
    private int indiceBarrilActual = 0; 
    private Musica musica1; // Música del juego
    private Musica musicaNivelGanado;
    private int puntos;

    public Escenario(JFrame jfp) {
        icono = new ImageIcon("imagenes/fondo.png");
        fondo = icono.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        mario = new Personaje(100, 500, "imagenes/marios1.png");
        this.setSize(1200, 700);
        this.setVisible(true);
        this.frame = jfp;

        plataformas = new Estructura[85];
        escaleras = new Escalera[15];

        // Plataformas (versión del primer código, mantenemos esta configuración)
        plataformas[0] = new Estructura(0, 655, "imagenes/Plataformasinicio.png");
        plataformas[1] = new Estructura(0, 479, "imagenes/plataformade3.png");
        plataformas[2] = new Estructura(64, 479, "imagenes/plataformade3.png");
        plataformas[3] = new Estructura(128, 479, "imagenes/plataformade3.png");
        plataformas[4] = new Estructura(192, 479, "imagenes/plataformade3.png");
        plataformas[5] = new Estructura(256, 479, "imagenes/plataformade3.png");
        plataformas[6] = new Estructura(320, 479, "imagenes/plataformade3.png");
        plataformas[7] = new Estructura(384, 479, "imagenes/plataformade3.png");
        plataformas[8] = new Estructura(448, 479, "imagenes/plataformade3.png");
        plataformas[9] = new Estructura(512, 480, "imagenes/plataformade3.png");
        plataformas[10] = new Estructura(576, 480, "imagenes/plataformade3.png");
        plataformas[11] = new Estructura(640, 480, "imagenes/plataformade3.png");
        plataformas[12] = new Estructura(704, 480, "imagenes/plataformade3.png");
        plataformas[13] = new Estructura(768, 481, "imagenes/plataformade3.png");
        plataformas[14] = new Estructura(832, 482, "imagenes/plataformade3.png");
        plataformas[15] = new Estructura(896, 483, "imagenes/plataformade3.png");
        plataformas[16] = new Estructura(960, 484, "imagenes/plataformade3.png");
        plataformas[17] = new Estructura(1024, 485, "imagenes/plataformade3.png");
        // segunda plataforma
        plataformas[18] = new Estructura(1119, 312, "imagenes/plataformade3.png");
        plataformas[19] = new Estructura(1055, 312, "imagenes/plataformade3.png");
        plataformas[20] = new Estructura(991, 312, "imagenes/plataformade3.png");
        plataformas[21] = new Estructura(927, 312, "imagenes/plataformade3.png");
        plataformas[22] = new Estructura(863, 312, "imagenes/plataformade3.png");
        plataformas[23] = new Estructura(799, 312, "imagenes/plataformade3.png");
        plataformas[24] = new Estructura(735, 312, "imagenes/plataformade3.png");
        plataformas[25] = new Estructura(671, 312, "imagenes/plataformade3.png");
        plataformas[26] = new Estructura(607, 313, "imagenes/plataformade3.png");
        plataformas[27] = new Estructura(543, 313, "imagenes/plataformade3.png");
        plataformas[28] = new Estructura(479, 314, "imagenes/plataformade3.png");
        plataformas[29] = new Estructura(415, 314, "imagenes/plataformade3.png");
        plataformas[30] = new Estructura(351, 314, "imagenes/plataformade3.png");
        plataformas[31] = new Estructura(287, 315, "imagenes/plataformade3.png");
        plataformas[32] = new Estructura(223, 315, "imagenes/plataformade3.png");
        plataformas[33] = new Estructura(159, 316, "imagenes/plataformade3.png");
        plataformas[34] = new Estructura(95, 317, "imagenes/plataformade3.png");
        // tercera princesa
        plataformas[35] = new Estructura(554, 65, "imagenes/plataformade3.png");
        plataformas[36] = new Estructura(490, 65, "imagenes/plataformade3.png");
        plataformas[37] = new Estructura(426, 65, "imagenes/plataformade3.png");
        plataformas[38] = new Estructura(362, 65, "imagenes/plataformade3.png");
        // mono
        plataformas[39] = new Estructura(0, 160, "imagenes/plataformade3.png");
        plataformas[40] = new Estructura(64, 160, "imagenes/plataformade3.png");
        plataformas[41] = new Estructura(128, 160, "imagenes/plataformade3.png");
        plataformas[42] = new Estructura(192, 160, "imagenes/plataformade3.png");
        plataformas[43] = new Estructura(256, 160, "imagenes/plataformade3.png");
        plataformas[44] = new Estructura(320, 160, "imagenes/plataformade3.png");
        plataformas[45] = new Estructura(384, 160, "imagenes/plataformade3.png");
        plataformas[46] = new Estructura(448, 160, "imagenes/plataformade3.png");
        plataformas[47] = new Estructura(512, 160, "imagenes/plataformade3.png");
        plataformas[48] = new Estructura(576, 160, "imagenes/plataformade3.png");
        plataformas[49] = new Estructura(640, 160, "imagenes/plataformade3.png");
        plataformas[50] = new Estructura(704, 160, "imagenes/plataformade3.png");
        plataformas[51] = new Estructura(768, 160, "imagenes/plataformade3.png");
        plataformas[52] = new Estructura(832, 161, "imagenes/plataformade3.png");
        plataformas[53] = new Estructura(896, 162, "imagenes/plataformade3.png");
        plataformas[54] = new Estructura(960, 163, "imagenes/plataformade3.png");
        plataformas[55] = new Estructura(1024, 164, "imagenes/plataformade3.png");
        plataformas[56] = new Estructura(485, 0, "imagenes/princesa.png");
        plataformas[57] = new Estructura(40, 89, "imagenes/bariles.png");
        plataformas[58] = new Estructura(0, 555, "imagenes/fuego.gif");
        
        // Agregamos las vidas del personaje (corazones) del segundo código
        plataformas[59] = new Estructura(20, 20, "imagenes/VidasMario.png");
        plataformas[60] = new Estructura(50, 20, "imagenes/VidasMario.png");
        plataformas[61] = new Estructura(80, 20, "imagenes/VidasMario.png");

        // escaleras (mantener las del primer código)
        escaleras[0] = new Escalera(894, 485, "imagenes/Escalera1.png");
        escaleras[9] = new Escalera(894, 632, "imagenes/Escalera2.png");
        escaleras[1] = new Escalera(223, 315, "imagenes/Escalera1.png");
        escaleras[10] = new Escalera(223, 460, "imagenes/Escalera2.png");
        escaleras[2] = new Escalera(900, 160, "imagenes/Escalera1.png");
        escaleras[3] = new Escalera(115, 85, "imagenes/Mono.gif");
        escaleras[4] = new Escalera(298, 7, "imagenes/Escalera1.png");
        escaleras[5] = new Escalera(243, 7, "imagenes/Escalera1.png");
        escaleras[6] = new Escalera(553, 90, "imagenes/Escalera3.png"); 
        escaleras[7] = new Escalera(553, 125, "imagenes/Escalera3.png"); 
        escaleras[8] = new Escalera(553, 67, "imagenes/Escalera2.png"); 

        barriles = new Barril[MAX_BARRILES];
        for (Barril barril : barriles) {
            if (barril != null) {
                barril.cambiarDireccion(false);
                barril.setAtraviesaPlataformas(false);
            }
        }

        // Iniciar la música del juego (del segundo código)
        musica1 = new Musica("Audios/TemaNiveles.wav", true);

        t = new Timer(16, null);
        t.addActionListener(this);
        t.start();
        addKeyListener(this);
        this.setFocusable(true);

        // Inicialización del temporizador para generar barriles
        timerBarriles = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarBarril();
            }
        });
        timerBarriles.start();
    }

    private void generarBarril() {
        for (int i = 0; i < MAX_BARRILES; i++) {
            int indice = (indiceBarrilActual + i) % MAX_BARRILES; 
            if (barriles[indice] == null) {
                barriles[indice] = new Barril(100, 140, "imagenes/barrilE.png");
                barriles[indice].cambiarDireccion(false);
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
        
        // Dibuja las balas
        for (Bala bala : mario.getBalas()) {
            bala.dibujar(g2d); 
        }
        g2d.setColor(Color.WHITE);
        g2d.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        g2d.drawString("Puntos: " + puntos, 120, 40);

    }

    private void verificarColisionConPrincesa() {
        Estructura princesa = plataformas[56];
        if (mario.getRectangle().intersects(princesa.getRectangle())) {
            // Detener la música antes de avanzar de nivel
            musicaNivelGanado = new Musica ("Audios/NivelGanado.wav", false);
            musica1.detener();
            t.stop();
            frame.dispose();
            frame = new Principal(2);
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
    
            // Manejar colisión con plataformas mientras Mario sube
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

        for (Barril barril : barriles) {
            if (barril != null) {
                barril.mover(plataformas);
                if (mario.getRectangle().intersects(barril.getRectangle())) {
                    barril.setVisible(false);
                    barril.setX(3000);
                    // Restar vidas al colisionar con un barril, de derecha a izquierda
                    if (plataformas[61] != null && plataformas[61].getVisible() == 1) {
                        plataformas[61].setVisible(0);
                    } else if (plataformas[60] != null && plataformas[60].getVisible() == 1) {
                        plataformas[60].setVisible(0);
                    } else if (plataformas[59] != null && plataformas[59].getVisible() == 1) {
                        plataformas[59].setVisible(0);
                    }
                    puntos -= 250;
                }
            }
        }

        // Colisión bala-barril
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
                            bala.setX(2000);
                            puntos+= 200;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < barriles.length; i++) {
            Rectangle rectFuego = plataformas[58].getRectangle();
            Barril barril = barriles[i];
            if (barril != null) {
                Rectangle rectBarril = barril.getRectangle();
                if (rectBarril.intersects(rectFuego)) {
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
