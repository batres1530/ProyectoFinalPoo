public class Barriles extends Figura {
    public Barriles(int x, int y, String ruta) {
        super(x, y, ruta);
    }
    public void mover() {
        this.x -= 1;
    }
    public boolean colision(Personaje personaje) {
        return personaje.getRectangle().intersects(this.getRectangle());
    }
    
}
