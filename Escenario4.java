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

public class Escenario4 extends JPanel implements ActionListener, KeyListener {
    private ImageIcon icono;
    private Image fondo;
    private Timer t;
    private Random r;
    private JFrame frame;
    private Personaje mario;
    private Estructura[] plataformas;
    private Escalera[] escaleras;
    private static final int MAX_BARRILES = 30; 
    private Barril[] barriles; 
    private Timer timerBarriles; 
    private int indiceBarrilActual = 0;
    private Musica musica1; // Música del escenario
    private int puntos = 0; // Puntos del jugador

    public Escenario4(JFrame jfp) {
        icono = new ImageIcon("imagenes/fondo.png");
        fondo = icono.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        mario = new Personaje(100, 550, "imagenes/marios1.png");
        this.setSize(1200, 700);
        this.setVisible(true);
        this.frame = jfp;
        plataformas = new Estructura[75];
        escaleras = new Escalera[15];
       
        // Plataformas configuradas para el cuarto escenario
        plataformas[61] = new Estructura(5, 680, "imagenes/plataformade33.png");
        plataformas[0] = new Estructura(65, 680, "imagenes/plataformade33.png");
        plataformas[1] = new Estructura(125, 678, "imagenes/plataformade33.png");
        plataformas[2] = new Estructura(185, 676, "imagenes/plataformade33.png");
        plataformas[3] = new Estructura(245, 674, "imagenes/plataformade33.png");
        plataformas[4] = new Estructura(305, 672, "imagenes/plataformade33.png");
        plataformas[5] = new Estructura(365, 670, "imagenes/plataformade33.png");
        plataformas[6] = new Estructura(425, 668, "imagenes/plataformade33.png");
        plataformas[7] = new Estructura(485, 666, "imagenes/plataformade33.png");
        plataformas[8] = new Estructura(545, 664, "imagenes/plataformade33.png");
        plataformas[9] = new Estructura(605, 662, "imagenes/plataformade33.png");
        plataformas[10] = new Estructura(665, 660, "imagenes/plataformade33.png");
        plataformas[11] = new Estructura(725, 658, "imagenes/plataformade33.png");
        plataformas[12] = new Estructura(785, 656, "imagenes/plataformade33.png");
        plataformas[13] = new Estructura(845, 654, "imagenes/plataformade33.png");
        plataformas[14] = new Estructura(905, 654, "imagenes/plataformade33.png");
        plataformas[15] = new Estructura(965, 654, "imagenes/plataformade33.png");
        plataformas[16] = new Estructura(1025, 654, "imagenes/plataformade33.png");
        plataformas[62] = new Estructura(1085, 654, "imagenes/plataformade33.png");
        plataformas[69] = new Estructura(1145, 654, "imagenes/plataformade33.png");
        
        // Segunda fila de plataformas
        plataformas[63] = new Estructura(1025, 500, "imagenes/plataformade33.png");
        plataformas[64] = new Estructura(965, 500, "imagenes/plataformade33.png");
        plataformas[17] = new Estructura(905, 500, "imagenes/plataformade33.png");
        plataformas[18] = new Estructura(845, 500, "imagenes/plataformade33.png");
        plataformas[19] = new Estructura(785, 500, "imagenes/plataformade33.png");
        plataformas[20] = new Estructura(725, 499, "imagenes/plataformade33.png");
        plataformas[21] = new Estructura(665, 498, "imagenes/plataformade33.png");
        plataformas[22] = new Estructura(605, 497, "imagenes/plataformade33.png");
        plataformas[23] = new Estructura(545, 496, "imagenes/plataformade33.png");
        plataformas[24] = new Estructura(485, 495, "imagenes/plataformade33.png");
        plataformas[25] = new Estructura(425, 494, "imagenes/plataformade33.png");
        plataformas[26] = new Estructura(365, 493 ,"imagenes/plataformade33.png");
        plataformas[27] = new Estructura(305, 492, "imagenes/plataformade33.png");
        plataformas[28] = new Estructura(245, 491, "imagenes/plataformade33.png");
        plataformas[29] = new Estructura(185, 490, "imagenes/plataformade33.png");
        plataformas[30] = new Estructura(125, 489, "imagenes/plataformade33.png");
        plataformas[31] = new Estructura(65, 488, "imagenes/plataformade33.png");
        plataformas[32] = new Estructura(5, 487, "imagenes/plataformade33.png");

        // Tercera fila de plataformas
        plataformas[34] = new Estructura(110, 326, "imagenes/plataformade33.png");
        plataformas[35] = new Estructura(170, 325, "imagenes/plataformade33.png");
        plataformas[36] = new Estructura(230, 324, "imagenes/plataformade33.png");
        plataformas[37] = new Estructura(290, 323, "imagenes/plataformade33.png");
        plataformas[38] = new Estructura(350, 322, "imagenes/plataformade33.png");
        plataformas[39] = new Estructura(410, 321, "imagenes/plataformade33.png");        
        plataformas[40] = new Estructura(470, 320, "imagenes/plataformade33.png");
        plataformas[41] = new Estructura(530, 319, "imagenes/plataformade33.png");
        plataformas[42] = new Estructura(590, 318, "imagenes/plataformade33.png");    
        plataformas[43] = new Estructura(650, 318, "imagenes/plataformade33.png");
        plataformas[44] = new Estructura(710, 318, "imagenes/plataformade33.png");
        plataformas[45] = new Estructura(770, 318, "imagenes/plataformade33.png");
        plataformas[46] = new Estructura(830, 318, "imagenes/plataformade33.png");
        plataformas[47] = new Estructura(890, 318, "imagenes/plataformade33.png");        
        plataformas[48] = new Estructura(950, 318, "imagenes/plataformade33.png");
        plataformas[49] = new Estructura(1010, 318, "imagenes/plataformade33.png");
        plataformas[59] = new Estructura(1070, 318, "imagenes/plataformade33.png");
        plataformas[60] = new Estructura(1090, 318, "imagenes/plataformade33.png");

        // Cuarta fila de plataformas
        plataformas[50] = new Estructura(460, 158, "imagenes/plataformade33.png");
        plataformas[51] = new Estructura(520, 158, "imagenes/plataformade33.png");
        plataformas[52] = new Estructura(580, 158, "imagenes/plataformade33.png");
        plataformas[53] = new Estructura(640, 158, "imagenes/plataformade33.png");
        plataformas[54] = new Estructura(700, 158, "imagenes/plataformade33.png");
       
        plataformas[56] = new Estructura(525, 97, "imagenes/princesa2.png");
        plataformas[57] = new Estructura(1080, 250, "imagenes/bariles.png");
        plataformas[58] = new Estructura(965, 247, "imagenes/Mono.gif");
        plataformas[70] = new Estructura(15, 580, "imagenes/fuego.gif");

        // Vidas de Mario (corazones) - igual que en el primer escenario
        plataformas[71] = new Estructura(20, 20, "imagenes/VidasMario.png");
        plataformas[72] = new Estructura(50, 20, "imagenes/VidasMario.png");
        plataformas[73] = new Estructura(80, 20, "imagenes/VidasMario.png");

        // Escaleras
        escaleras[0] = new Escalera(980, 500, "imagenes/Escalera1.png");
        escaleras[1] = new Escalera(110, 327, "imagenes/Escalera1.png");
        escaleras[2] = new Escalera(460, 167, "imagenes/Escalera1.png");
        escaleras[3] = new Escalera(760, 162, "imagenes/Escalera1.png");
        escaleras[4] = new Escalera(830, 162, "imagenes/Escalera1.png");
        escaleras[5] = new Escalera(760, 10, "imagenes/Escalera1.png");
        escaleras[6] = new Escalera(830, 10, "imagenes/Escalera1.png");
        escaleras[7] = new Escalera(400, 360, "imagenes/Escalera2.png");
        escaleras[9] = new Escalera(630, 500, "imagenes/Escalera1.png");
        escaleras[10] = new Escalera(200, 530, "imagenes/Escalera2.png");

        barriles = new Barril[MAX_BARRILES];
        for (Barril barril : barriles) {
            if (barril != null) {
                barril.cambiarDireccion(false);
                barril.setAtraviesaPlataformas(false);
            }
        }

        // Iniciar la música del juego, igual que en el primer escenario
        musica1 = new Musica("Audios/TemaNiveles.wav", true);

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
        for (int i = 0; i < MAX_BARRILES; i++) {
            int indice = (indiceBarrilActual + i) % MAX_BARRILES;
            if (barriles[indice] == null) {
                barriles[indice] = new Barril(960, 220, "imagenes/barrilE.png");
                barriles[indice].cambiarDireccion(false);
                barriles[indice].setAtraviesaPlataformas(false);
                indiceBarrilActual = (indice + 1) % MAX_BARRILES;
                break;
            }
        }
    }

    public void actualizar() {
        mario.mover(); 
        mario.moverBalas();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(fondo, 0, 0, this.getWidth(), this.getHeight(), null);

        for (int i = 0; i < plataformas.length; i++) {
            if (plataformas[i] != null && plataformas[i].getVisible() == 1) {
                plataformas[i].dibujar(g2d);
            }
        }
        for (int i = 0; i < escaleras.length; i++){
            if (escaleras[i] != null) {
                escaleras[i].dibujar(g2d);
            }
        }

        for (int i = 0; i < barriles.length; i++){
            if (barriles[i] != null) {
                barriles[i].dibujar(g2d);
            }
        }

        mario.dibujar(g2d);

        for (Bala bala : mario.getBalas()) {
            if (bala != null && bala.getVisible() == 1) {
                bala.dibujar(g2d); 
            }
        }

        // Mostrar puntos, igual que en el primer escenario
        g2d.setColor(Color.WHITE);
        g2d.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        g2d.drawString("Puntos: " + puntos, 120, 40);
    }

    private void verificarColisionConPrincesa() {
        Estructura princesa = plataformas[56];
        if (princesa != null && princesa.getVisible() == 1 && mario.getRectangle().intersects(princesa.getRectangle())) {
            // Cuando se llega a la princesa, se detiene la música y se avanza
            musica1.detener();
            t.stop();
            frame.dispose();
            frame = new Principal(5);
        }
    }

    public void actionPerformed(ActionEvent e) {
        verificarColisionConPrincesa();
        mario.mover();
        mario.moverBalas();
        boolean sobreEstructura = false;

        if (!mario.isEscalando()) {
            for (Estructura estructura : plataformas) {
                if (estructura != null && estructura.getVisible() == 1 && mario.getFeetRectangle().intersects(estructura.getRectangle())) {
                    if (mario.getVelocidadY() > 0 && (mario.getY() + mario.getAlto()) >= estructura.getY()) {
                        mario.setY(estructura.getY() - mario.getAlto());
                        mario.setVelocidadY(0);
                        mario.setSaltando(false);
                        sobreEstructura = true;
                        mario.guardarUltimaPosicionY(mario.getY());
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
                if (estructura != null && estructura.getVisible() == 1 && mario.getRectangle().intersects(estructura.getRectangle())) {
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

        // Colisión con barriles - igual que en el primer escenario
        for (Barril barril : barriles) {
            if (barril != null) {
                barril.moverIzquierda(plataformas);
                if (mario.getRectangle().intersects(barril.getRectangle())) {
                    // Mario golpeado por un barril
                    barril.setVisible(false);
                    barril.setX(3000);
                    puntos -= 250; // restar puntos

                    // Quitar una vida de derecha a izquierda, igual que en escenario 1
                    if (plataformas[73] != null && plataformas[73].getVisible() == 1) {
                        plataformas[73].setVisible(0);
                    } else if (plataformas[72] != null && plataformas[72].getVisible() == 1) {
                        plataformas[72].setVisible(0);
                    } else if (plataformas[71] != null && plataformas[71].getVisible() == 1) {
                        plataformas[71].setVisible(0);
                    }

                    // Verificar si no quedan vidas
                    int vidasRestantes = 0;
                    if (plataformas[71] != null && plataformas[71].getVisible() == 1) vidasRestantes++;
                    if (plataformas[72] != null && plataformas[72].getVisible() == 1) vidasRestantes++;
                    if (plataformas[73] != null && plataformas[73].getVisible() == 1) vidasRestantes++;

                    if (vidasRestantes == 0) {
                        musica1.detener();
                        t.stop();
                        frame.dispose();
                        frame = new PantallaPerdedor();
                    }
                }
            }
        }

        // Colisión bala-barril - igual que en el primer escenario
        for (Bala bala : mario.getBalas()) {
            if (bala != null && bala.getVisible() == 1) {
                Rectangle rectBala = bala.getRectangle();
                for (Barril barril : barriles) {
                    if (barril != null) {
                        Rectangle rectBarril = barril.getRectangle();
                        if (rectBala.intersects(rectBarril)) {
                            barril.setVisible(false);
                            barril.setX(3000);
                            bala.setVisible(0);
                            bala.setX(3000);
                            puntos += 200; // sumar puntos por destruir el barril
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