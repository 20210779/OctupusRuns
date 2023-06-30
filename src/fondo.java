
import java.awt.Graphics2D;
import javax.swing.ImageIcon;


public class fondo {
    //objeto de clase juego
     Juego jueguito;
     //variables del tamañao del fondo
     int anchoFondo=1300;
     int altoFondo=400;
     //coordenadas iniciales para mover el fondo
     int x1=1300;
     int y1=0;
     //coordenadas auxiliares que mueven otro fondo
     int x2=0;
     int y2=0;
    public fondo(Juego juiguito){
    this.jueguito=jueguito;
    }
    
    public void mover(){
        x1-=1;
        x2-=1;
        if(x1==0 && x1==1300){
            x1=1300;
            x2=0;
        }
    }
    
    
    public void paint(Graphics2D g){
    ImageIcon ImagenFondo=new ImageIcon(getClass().getResource("/multimedia/fondo.png"));
        g.drawImage(ImagenFondo.getImage(), x1, y1, anchoFondo, altoFondo, null);
        g.drawImage(ImagenFondo.getImage(), x2, y2, anchoFondo, altoFondo, null);

    }
}
