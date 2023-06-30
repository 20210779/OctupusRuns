
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;


public class pulpoo{
        
        //objeto de la clase
   Juego jueguito;
   //variables que nos ayudan que el pulpo salta
   static boolean saltando=false;
   boolean sube=false;
   boolean baja=false;
   //variables que delimitan el area del objeto
   //variables que limiten el area del objeto
   
   Area llantaDeLatera,llanteTrasera,Carroceria, tractor;
    //variables de tamaño del personaje     
   int anchoPersonaje=100;
   int altoPersonaje=112;
   //coordenadas iniciales de personaje
   static int x_inicial=560;
   static int y_inicial=270;
   //coordenadas para manipular el personaje
  int x_auxiliar=0;
  int y_auxiliar=0; 
   
   
   public pulpoo(Juego jueguito){
           this.jueguito=jueguito;
    }
   
   public void mover(){
       if(x_inicial+x_auxiliar>0 && x_inicial+x_auxiliar<jueguito.getWidth()-anchoPersonaje){
           x_inicial+=x_auxiliar;
       }
       if(saltando){
           if(y_inicial==270){//si el pulpo esta en el suelo
               sube=true;
               y_auxiliar=-2;
               baja=false;
           }
           if(y_inicial==130){//si el pulpo llego al limite del salto
           baja=true;
           y_auxiliar=2;
           sube=false;
           }
           
           if(sube){
                y_inicial+=y_auxiliar;
           }
           if(baja){
                y_inicial+=y_auxiliar;
                if(y_inicial==270){//si el pulpo llego al suelo al saltar
                    saltando=false;
                }
           }
       }
   }
   
   public void paint(Graphics2D g){
       // si falla, colocar de nuevo auto en vez de pulpo
       ImageIcon pulpo=new ImageIcon(getClass().getResource("/multimedia/musolini.png"));
       g.drawImage(pulpo.getImage(), x_inicial,y_inicial, anchoPersonaje, altoPersonaje, null);
   
   }
   public void keyPressed(KeyEvent e){
       if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    saltando=true;
   }
           
   }
   public Area getBounds(){
       Rectangle form1=new Rectangle(x_inicial,y_inicial, 95,62);
       Carroceria=new Area(form1);
       
       Ellipse2D forma2=new Ellipse2D.Double(x_inicial,y_inicial+28,48,38);
       llanteTrasera=new Area(forma2);
       
        Ellipse2D forma3=new Ellipse2D.Double(x_inicial+73,y_inicial+39,38,38);
        llantaDeLatera=new Area(forma3);
        
        tractor=Carroceria;
        tractor.add(Carroceria);
        tractor.add(llanteTrasera);
        tractor.add(llantaDeLatera);
        
        return tractor;
   }
}

