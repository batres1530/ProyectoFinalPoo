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

public class intruciones extends JFrame
{
    ImageIcon jugar, jugar2, salir, salir2, intruciones,intruciones2;
    JButton botJugar, botSalir, botIntro;
    JLabel fondoI;
    Musica musica;
    public intruciones()
    {
        getContentPane().setLayout(null);
        salir = new ImageIcon("imagenes/salir.png");
        salir2 = new ImageIcon("imagenes/salir2.png");
        
        //Inicializamos botones
        botSalir = new JButton(salir);
        botSalir.setContentAreaFilled(false); //Quitar relleno
        botSalir.setBorder(null); //Quitar borde
        botSalir.setFocusPainted(false); //Quitar preseleccion de boton
        botSalir.setRolloverIcon(salir2); //Cuando cursor este sobre boton, llama a salir2
        botSalir.setToolTipText("PRESIONE SI DESEA SALIR al inicio del juego");
        
        //COLOCAMOS LOS BOTONES EN LAS COORDENADAS Y TAMAÑOS ESPECÍFICOS
        botSalir.setBounds(780, 550, 250, 125); // X, Y, ANCHO, ALTO
      
        
        //AGREGAR LOS BOTONES AL JFRAME
        getContentPane().add(botSalir);
    
        
        //HABILITAMOS LOS BOTONES
        botSalir.setEnabled(true);
        
        
        //COLOCAMOS EL FONDO POR MEDIO DE LA ETIQUETA (JLABEL)
        fondoI =new JLabel("");
        fondoI.setIcon(new ImageIcon("imagenes/intruciones.png"));
        fondoI.setBounds(0, 0, 1200, 700);
        getContentPane().add(fondoI);
        
        //PONEMOS LA RUTA DE LA MUSICA
        musica = new Musica ("Audios/TemaInicio.wav", false);
        //DAMOS LA ACCION A LOS BOTONES
        botSalir.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                musica.detener();
                dispose(); //Quita visualmente el inicio
                new Inicio();
            }
        });
        
        this.setVisible(true);
        this.setSize(1200,700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}