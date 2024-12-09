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

    // Campos agregados de la lógica del Escenario2
    private static final int MAX_BARRILES = 30; 
    private Barril[] barriles; 
    private int[] posicionesFijasX = {100, 300, 500, 700, 900};
    private Timer timerBarriles; 
    private int indiceBarrilActual = 0;
    private Musica musica1; 
    private Musica musicaNivelGanado;
    private int puntos;

    public Escenario5(JFrame jfp) {
        icono = new ImageIcon("imagenes/fondo.png");
        fondo = icono.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        mario = new Personaje(100, 500, "imagenes/marios1.png");
        this.setSize(1200, 700);
        this.setVisible(true);
        this.frame = jfp;

        // Aumentamos el tamaño del array para incluir más elementos (vidas, princesa, etc.)
        plataformas = new Estructura[90];
        escaleras = new Escalera[16];

        // Plataformas del escenario 5
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

        // Princesa, barriles y mono
        plataformas[56] = new Estructura(650, 115, "imagenes/princesa.png");
        plataformas[57] = new Estructura(490, 115, "imagenes/bariles.png");
        plataformas[58] = new Estructura(550, 85, "imagenes/Mono.png");

        // Vidas (corazones), como en el escenario 2
        plataformas[68] = new Estructura(20, 20, "imagenes/VidasMario.png");
        plataformas[69] = new Estructura(50, 20, "imagenes/VidasMario.png");
        plataformas[70] = new Estructura(80, 20, "imagenes/VidasMario.png");

        // Escaleras
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

        // Barriles
        barriles = new Barril[MAX_BARRILES];
        // Inicializar barriles (inicialmente nulos, se generarán después)
        // Configurar el comportamiento predeterminado de los barriles si existieran
        for (Barril barril : barriles) {
            if (barril != null) {
                barril.cambiarDireccion(true);
                barril.setAtraviesaPlataformas(true);
            }
        }

        // Música
        musica1 = new Musica("Audios/TemaNiveles.wav", true);

        t = new Timer(16, null);
        t.addActionListener(this);
        t.start();
        addKeyListener(this);
        this.setFocusable(true);

        // Timer de barriles
        timerBarriles = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarBarril();
            }
        });
        timerBarriles.start();
    }

    private void generarBarril() {
        for (int i = 0; i < barriles.length; i++) {
            int indice = (indiceBarrilActual + i) % MAX_BARRILES;
            if (barriles[indice] == null) {
                int x = posicionesFijasX[indiceBarrilActual];
                int y = 50; // Posición inicial en Y
                barriles[indice] = new Barril(x, y, "imagenes/barrilE.png");
                barriles[indice].setVisible(true);
                barriles[indice].cambiarDireccion(true);
                barriles[indice].setAtraviesaPlataformas(true);
                indiceBarrilActual = (indiceBarrilActual + 1) % posicionesFijasX.length;
                break;
            }
        }
    }

    private void verificarColisionConPrincesa() {
        Estructura princesa = plataformas[56];
        if (princesa != null && princesa.getVisible() == 1 && mario.getRectangle().intersects(princesa.getRectangle())) {
            musicaNivelGanado = new Musica("Audios/NivelGanado.wav", false);
            musica1.detener();
            t.stop();
            frame.dispose();
            frame = new Principal(6); // Siguiente nivel
        }
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

        for (int i = 0; i < barriles.length; i++) {
            if (barriles[i] != null) {
                barriles[i].mover(plataformas);
                barriles[i].dibujar(g2d);
            }
        }

        mario.dibujar(g2d);

        // Dibujar balas de Mario
        for (Bala bala : mario.getBalas()) {
            if (bala != null && bala.getVisible() == 1) {
                bala.dibujar(g2d); 
            }
        }

        // Mostrar puntaje
        g2d.setColor(Color.WHITE);
        g2d.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        g2d.drawString("Puntos: " + puntos, 120, 40);
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

        boolean estaEscalando = false;
        for (Escalera escalera : escaleras) {
            if (escalera != null && escalera.estaEscalando(mario)) {
                estaEscalando = true;
                break;
            }
        }
        mario.setEscalando(estaEscalando);

        // Colisión de Mario con barriles
        for (Barril barril : barriles) {
            if (barril != null && barril.getVisible() == 1) {
                if (mario.getRectangle().intersects(barril.getRectangle())) {
                    barril.setVisible(false);
                    barril.setX(3000);
                    puntos -= 250; // restar puntos por golpe

                    // Quitar una vida
                    if (plataformas[70] != null && plataformas[70].getVisible() == 1) {
                        plataformas[70].setVisible(0);
                    } else if (plataformas[69] != null && plataformas[69].getVisible() == 1) {
                        plataformas[69].setVisible(0);
                    } else if (plataformas[68] != null && plataformas[68].getVisible() == 1) {
                        plataformas[68].setVisible(0);
                    }

                    // Verificar si no quedan vidas
                    int vidasRestantes = 0;
                    if (plataformas[68] != null && plataformas[68].getVisible() == 1) vidasRestantes++;
                    if (plataformas[69] != null && plataformas[69].getVisible() == 1) vidasRestantes++;
                    if (plataformas[70] != null && plataformas[70].getVisible() == 1) vidasRestantes++;

                    if (vidasRestantes == 0) {
                        musica1.detener();
                        t.stop();
                        frame.dispose();
                        frame = new PantallaPerdedor();
                    }
                }
            }
        }

        // Colisión de bala con barril
        for (Bala bala : mario.getBalas()) {
            if (bala != null && bala.getVisible() == 1) {
                Rectangle rectBala = bala.getRectangle();
                for (Barril barril : barriles) {
                    if (barril != null && barril.getVisible() == 1) {
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