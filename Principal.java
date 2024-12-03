import javax.swing.JFrame;

public class Principal extends JFrame {
    Escenario esc;
    Escenario2 esc2;

    public Principal(int nivel) {
        switch (nivel) {
            case 1:
                esc2 = new Escenario2(this);
                this.add(esc2);
                break;

            case 2:
                esc = new Escenario(this);
                this.add(esc);
                break;
        }
        this.setSize(1200, 730);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String args[]) {
        Principal p = new Principal(1);
    }
}
