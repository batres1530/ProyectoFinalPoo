import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Inicio extends JFrame
{
    ImageIcon jugar, jugar2, salir, salir2, intruciones,intruciones2;
    JButton botJugar, botSalir, botIntro;
    JLabel fondoI;
    Musica musica;
    public Inicio()
    {
        getContentPane().setLayout(null);
        intruciones = new ImageIcon("imagenes/introciones.png");
        intruciones2 = new ImageIcon("imagenes/intruciones2.png");
        jugar = new ImageIcon("imagenes/jugar.png");
        jugar2 = new ImageIcon("imagenes/juga2.png");
        salir = new ImageIcon("imagenes/salir.png");
        salir2 = new ImageIcon("imagenes/salir2.png");
        
        //Inicializamos botones
        botIntro = new JButton(intruciones);
        botIntro.setContentAreaFilled(false); //Quitar relleno
        botIntro.setBorder(null); //Quitar borde
        botIntro.setFocusPainted(false); //Quitar preseleccion de boton
        botIntro.setRolloverIcon(intruciones2); //Cuando cursor este sobre boton, llama a intruciones2
        botIntro.setToolTipText("PRESIONE PARA VER LAS INTRUCCIONES");
        botJugar = new JButton(jugar);
        botJugar.setContentAreaFilled(false); //Quitar relleno
        botJugar.setBorder(null); //Quitar borde
        botJugar.setFocusPainted(false); //Quitar preseleccion de boton
        botJugar.setRolloverIcon(jugar2); //Cuando cursor este sobre boton, llama a jugar2
        botJugar.setToolTipText("PRESIONE PARA JUGAR DONKEY KONG");
        botSalir = new JButton(salir);
        botSalir.setContentAreaFilled(false); //Quitar relleno
        botSalir.setBorder(null); //Quitar borde
        botSalir.setFocusPainted(false); //Quitar preseleccion de boton
        botSalir.setRolloverIcon(salir2); //Cuando cursor este sobre boton, llama a salir2
        botSalir.setToolTipText("PRESIONE SI DESEA SALIR DEL JUEGO");
        
        //COLOCAMOS LOS BOTONES EN LAS COORDENADAS Y TAMAÑOS ESPECÍFICOS
        botJugar.setBounds(310, 400, 250, 125);
        botSalir.setBounds(680, 400, 250, 125); // X, Y, ANCHO, ALTO
        botIntro.setBounds(470, 250, 300, 143);
        
        //AGREGAR LOS BOTONES AL JFRAME
        getContentPane().add(botJugar);
        getContentPane().add(botSalir);
        getContentPane().add(botIntro);
        
        //HABILITAMOS LOS BOTONES
        botJugar.setEnabled(true);
        botSalir.setEnabled(true);
        botIntro.setEnabled(true);
        
        //COLOCAMOS EL FONDO POR MEDIO DE LA ETIQUETA (JLABEL)
        fondoI =new JLabel("");
        fondoI.setIcon(new ImageIcon("imagenes/fondoI.png"));
        fondoI.setBounds(0, 0, 1200, 700);
        getContentPane().add(fondoI);
        
        //PONEMOS LA RUTA DE LA MUSICA
        musica = new Musica ("Audios/TemaInicio.wav", false);
        //DAMOS LA ACCION A LOS BOTONES
        botIntro.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                musica.detener();
                dispose(); //Quita visualmente el inicio
                new intruciones( );
            }
        });

        botJugar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                musica.detener();
                dispose(); //Quita visualmente el inicio
                new iniciodejuego();
            }
        });
        
        botSalir.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                System.exit(0);
            }
        });
        
        this.setVisible(true);
        this.setSize(1200,700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}