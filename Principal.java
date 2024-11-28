import javax.swing.JFrame;

public class Principal extends JFrame {
    Escenario esc; 
    public Principal() {
        esc = new Escenario();
        this.add(esc);
        this.setSize(1200, 700);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Principal();
    }
}
