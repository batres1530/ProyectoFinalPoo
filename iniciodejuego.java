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

public class iniciodejuego extends JFrame
{
    ImageIcon jugar, jugar2;
    JButton botJugar;
    JLabel fondoI;
    Musica musica;
    public iniciodejuego()
    {
        getContentPane().setLayout(null);
      
        jugar = new ImageIcon("imagenes/jugar.png");
        jugar2 = new ImageIcon("imagenes/juga2.png");
        
        //Inicializamos botones
       
        botJugar = new JButton(jugar);
        botJugar.setContentAreaFilled(false); //Quitar relleno
        botJugar.setBorder(null); //Quitar borde
        botJugar.setFocusPainted(false); //Quitar preseleccion de boton
        botJugar.setRolloverIcon(jugar2); //Cuando cursor este sobre boton, llama a jugar2
        botJugar.setToolTipText("PRESIONE PARA JUGAR DONKEY KONG");
       
        
        //COLOCAMOS LOS BOTONES EN LAS COORDENADAS Y TAMAÑOS ESPECÍFICOS
        botJugar.setBounds(840, 550, 250, 125);
    
        
        //AGREGAR LOS BOTONES AL JFRAME
        getContentPane().add(botJugar);
       
        
        //HABILITAMOS LOS BOTONES
        botJugar.setEnabled(true);
       
        
        //COLOCAMOS EL FONDO POR MEDIO DE LA ETIQUETA (JLABEL)
        fondoI =new JLabel("");
        fondoI.setIcon(new ImageIcon("imagenes/iniciodejugo.gif"));
        fondoI.setBounds(0, 0, 1200, 700);
        getContentPane().add(fondoI);
        
        //PONEMOS LA RUTA DE LA MUSICA
        musica = new Musica ("Audios/TemaInicio.wav", false);
        //DAMOS LA ACCION A LOS BOTONES
       
        botJugar.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ev)
            {
                musica.detener();
                dispose(); //Quita visualmente el inicio
                new Principal(1);
            }
        });
        
        this.setVisible(true);
        this.setSize(1200,700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}