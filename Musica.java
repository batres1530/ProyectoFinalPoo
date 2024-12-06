
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Musica{
    Clip clip;    
    String ruta;
    boolean repetir;    
    public Musica(String ruta, boolean repetir){
        this.ruta = ruta;
        this.repetir = repetir;
        try {
            clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta));         
            clip.open(inputStream);
            reproducir(ruta, repetir);
        } 
        catch (Exception e){
            System.err.println(e.getMessage());
        }
    }     
    
    public void reproducir(final String ruta, final boolean repetir){
        new Thread(new Runnable(){
            public void run() {
                try {
                    if(repetir){
                        clip.loop(Clip.LOOP_CONTINUOUSLY);// Repite continuamente
                    }
                    clip.start(); 
                } 
                catch (Exception e){
                    System.err.println(e.getMessage());
                }
            }
        }).start();  
    }
    
    public void iniciar(){
        clip.start();
    }
    public void detener(){
        clip.stop();
        clip.close();
    }
}