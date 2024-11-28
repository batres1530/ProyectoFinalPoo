import javax.swing.JFrame;

public class Principal extends JFrame {
    Escenario esc;
    Escenario2 esc2;

    public Principal(int nivel) {
        switch (nivel) {
            case 1:
                esc = new Escenario(this);
                this.add(esc);
                break;

            case 2:
                esc2 = new Escenario2(this);
                this.add(esc2);
                break;
        }
        this.setSize(1200, 700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String args[]) {
        Principal p = new Principal(1);
    }
}
