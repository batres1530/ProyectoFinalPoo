import javax.swing.JFrame;

public class Principal extends JFrame {
    Escenario esc;
    Escenario2 esc2;
    Escenario3 esc3;
    Escenario4 esc4;
    Escenario5 esc5;
    Escenario6 esc6;
 
    

    public Principal(int nivel) {
        switch (nivel) {
            case 1:
                esc= new Escenario(this);
                this.add(esc);
                break;

            case 2:
                esc2 = new Escenario2(this);
                this.add(esc2);
                break;

             case 3:
                esc3 = new Escenario3(this);
                this.add(esc3);
                break;   
            case 4:
                esc4 = new Escenario4(this);
                this.add(esc4);
                break;
            case 5:
                esc5 = new Escenario5(this);
                this.add(esc5);
                break;
            case 6:
                esc6 = new Escenario6(this);
                this.add(esc6);
                break;       
           
        }
        this.setSize(1200, 730);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String args[]) {
        new Inicio();
    }
}
