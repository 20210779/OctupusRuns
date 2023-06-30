
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;

public class Obstaculos {
    
    //objeto de clase juego
    Juego jueguito;
    //variables que delimitan el area de obstaculo
    Area cabeza, cuerpo, tiburonn;
    //variables del tamaño del personaje
    int anchoObstaculo=73;
    int altoObstaculo=69;
    //coordenadas iniciales donde se ubica el objeto
    static int x_inicial=1300;
   static int y_inicial=270;
   //coordenadas para manipular el onjeto
   static int x_auxiliar=-4;
    
    
    public Obstaculos(Juego jueguito){
    this.jueguito=jueguito;
    }
    
    public void mover(){
        if(x_inicial<=-100){
            jueguito.puntos++;
            x_inicial=1300;
            if(jueguito.puntos== 3 | jueguito.puntos== 6 | jueguito.puntos== 9 | jueguito.puntos== 12){
                x_auxiliar+=-2;
                jueguito.nivel++;
            }
        }else{
            if(colision()){
                if(jueguito.vidas==0){
                    jueguito.finJuego();
                }else{
                    //LLamaste otro metodo que no era al llamar el mensaje de que perdiste
                    //Creo que ya esta 
                  jueguito.pierdeVidas();  
                }
            }else{
                x_inicial+=x_auxiliar;
            }
            
        }
    }
    
    public void paint(Graphics2D g){
        ImageIcon animal=new ImageIcon(getClass().getResource("/multimedia/tiburon.png"));
        g.drawImage(animal.getImage(), x_inicial, y_inicial, anchoObstaculo, altoObstaculo, null);
    
    }
    
    public Area getBounds(){
       
       Ellipse2D forma1=new Ellipse2D.Double(x_inicial,y_inicial,20,40);
       Rectangle form2=new Rectangle(x_inicial+12,y_inicial+16,50,53);
       cabeza=new Area(forma1);
       cuerpo=new Area(form2);
        
        tiburonn=cabeza;
        tiburonn.add(cabeza);
        tiburonn.add(cuerpo);
        
        return tiburonn;
    }
    public boolean colision(){
        Area areaA=new Area(jueguito.pulpo.getBounds());
        areaA.intersect(getBounds());
        
        return !areaA.isEmpty();
    }
}
