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
    private Timer timerBarriles; // Temporizadores
    private int indiceBarrilActual = 0; // Índice actual para controlar dónde colocar el nuevo barril

    public Escenario(JFrame jfp) {
        icono = new ImageIcon("imagenes/fondo.png");
        fondo = icono.getImage().getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        mario = new Personaje(100, 500, "imagenes/marios1.png");
        this.setSize(1200, 700);
        this.setVisible(true);
        this.frame = jfp;
        plataformas = new Estructura[85];
        escaleras = new Escalera[10];
        plataformas[0] = new Estructura(0, 640, "imagenes/Plataformasinicio.png");
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
        plataformas[18] = new Estructura(1119, 309, "imagenes/plataformade3.png");
        plataformas[19] = new Estructura(1055, 309, "imagenes/plataformade3.png");
        plataformas[20] = new Estructura(991, 309, "imagenes/plataformade3.png");
        plataformas[21] = new Estructura(927, 309, "imagenes/plataformade3.png");
        plataformas[22] = new Estructura(863, 309, "imagenes/plataformade3.png");
        plataformas[23] = new Estructura(799, 309, "imagenes/plataformade3.png");
        plataformas[24] = new Estructura(735, 309, "imagenes/plataformade3.png");
        plataformas[25] = new Estructura(671, 309, "imagenes/plataformade3.png");
        plataformas[26] = new Estructura(607, 310, "imagenes/plataformade3.png");
        plataformas[27] = new Estructura(543, 310, "imagenes/plataformade3.png");
        plataformas[28] = new Estructura(479, 311, "imagenes/plataformade3.png");
        plataformas[29] = new Estructura(415, 311, "imagenes/plataformade3.png");
        plataformas[30] = new Estructura(351, 311, "imagenes/plataformade3.png");
        plataformas[31] = new Estructura(287, 312, "imagenes/plataformade3.png");
        plataformas[32] = new Estructura(223, 312, "imagenes/plataformade3.png");
        plataformas[33] = new Estructura(159, 313, "imagenes/plataformade3.png");
        plataformas[34] = new Estructura(95, 314, "imagenes/plataformade3.png");
        plataformas[35] = new Estructura(554, 65, "imagenes/plataformade3.png");
        plataformas[36] = new Estructura(490, 65, "imagenes/plataformade3.png");
        plataformas[37] = new Estructura(426, 65, "imagenes/plataformade3.png");
        plataformas[38] = new Estructura(362, 65, "imagenes/plataformade3.png");
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
        plataformas[56] = new Estructura(485, 0, "imagenes/princesa.png");
        plataformas[57] = new Estructura(40, 89, "imagenes/bariles.png");
        escaleras[0] = new Escalera(900, 470, "imagenes/Escalera1.png");
        escaleras[1] = new Escalera(200, 310, "imagenes/Escalera1.png");
        escaleras[2] = new Escalera(900, 160, "imagenes/Escalera1.png");
        escaleras[3] = new Escalera(120, 60, "imagenes/Mono.png");

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

        // Inicialización del temporizador para generar barriles
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
                barriles[indice] = new Barril(100, 140, "imagenes/barrilE.png");
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
        
         // Dibuja las balas
        for (Bala bala : mario.getBalas()) {
        bala.dibujar(g2d); // Asumiendo que cada bala tiene un método dibujar
    }

    }

    private void verificarColisionConPrincesa() {
        Estructura princesa = plataformas[56];
        if (mario.getRectangle().intersects(princesa.getRectangle())) {
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
