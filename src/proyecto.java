//Alisson IvaniaZpeda Caceres

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class  proyecto {
    
    public static int reiniciarJuego=-1;
    public static void main (String[]args) {
        
    //JOptionPane.showMessageDialog(null, "¿Estas listo?");

    JFrame ventana=new JFrame("Jueguito");
    Juego jueguito=new Juego();
    ventana.add(jueguito);
    ventana.setSize(1300, 400);
    ventana.setLocation(70,200);
    ventana.setVisible(true);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    while(true){
        if(jueguito.juegoFinalizado){
            reiniciarJuego=JOptionPane.showConfirmDialog(null, "Haz perdido, ¿quieres jugar de nuevo?", "Haz perdido", JOptionPane.YES_NO_OPTION);
            if(reiniciarJuego==0){
                reiniciarValores();
            }else if(reiniciarJuego==1){
                System.exit(0);
            }
        }else{
            jueguito.repaint();
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(Juego.pierdeVida==true){
        JOptionPane.showMessageDialog(null, "Cuidado");
        Juego.pierdeVida=false;
        Juego.vidas--;
        pulpoo.y_inicial=270;
        pulpoo.saltando=false;
        Obstaculos.x_inicial=1300;
        }
    
        }
    }
    
    }
    
    public static void reiniciarValores(){
        
        Juego.juegoFinalizado=false;
        //Obstaculos.x_auxiliar=-4;
        Juego.puntos=0;
        Juego.nivel=1;
        Juego.vidas=3;
        reiniciarJuego=-1;
        Obstaculos.x_inicial=1300;
        //Obstaculos.x_auxiliar=1300;
    }
}
