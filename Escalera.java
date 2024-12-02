public class Escalera extends Figura {
    public Escalera (int x, int y, String ruta){
        super(x, y, ruta);
    }
    public boolean estaEscalando(Personaje personaje){
        return personaje.getRectangle().intersects(this.getRectangle());
    }
}
