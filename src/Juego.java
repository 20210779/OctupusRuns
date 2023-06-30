
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;


public class Juego extends JPanel{
    URL direccionSonidoSalto, direccionSonidoChoque,AIdireccion;
    AudioClip sonidoChoque, sonidoSalto,AI;
    
        //sonido del juego
        //objetos de las clases auto, obstaculo y fondo
        pulpoo pulpo=new pulpoo(this);
        Obstaculos obstaculo=new Obstaculos(this);
        fondo Fondo=new fondo(this);
        
        //variables del juego
        
        public static boolean juegoFinalizado=false;
        public static boolean pierdeVida=false;
        public static int vidas=3;
        public static int puntos=0;
        public static int nivel=1;

        public Juego(){
            try {
        
        //Ruta de musica
        String filePath = "src/multimedia/mario.wav";
        
        //Cargar musica
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath));
        Clip clip = AudioSystem.getClip();
        
        //Para poder reproducirlo
        clip.open(audioInputStream);
        clip.start();
        
    } catch (Exception e) {
        e.printStackTrace();
    }
            direccionSonidoChoque=getClass().getResource("/multimedia/choque.wav");
            sonidoChoque=Applet.newAudioClip(direccionSonidoChoque);
            
            direccionSonidoSalto=getClass().getResource("/multimedia/salto.wav");
            sonidoSalto=Applet.newAudioClip(direccionSonidoSalto);
            
            AIdireccion=getClass().getResource("/multimedia/yoasobi.wav");
            AI=Applet.newAudioClip(AIdireccion);
            
            
            
            addKeyListener(new KeyListener(){
                @Override
                public void keyTyped(KeyEvent e) {
                    
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    //el salto se activa con space
                    if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    sonidoSalto.play();
                    
                    AI.play();
                    pulpo.keyPressed(e);   
                     //AI.play();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }
            
            
            });
            setFocusable(true);
        }   
        
        public void mover(){
            obstaculo.mover();
            pulpo.mover();
            Fondo.mover();
        }
       
        
    @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            dibujar(g2);
            dibujarPuntaje(g2);
        }
        
        public void dibujar(Graphics2D g){
            Fondo.paint(g);
            pulpo.paint(g);
            obstaculo.paint(g);
            mover();
        }


        public void dibujarPuntaje(Graphics2D g){

            ImageIcon Corazon1=new ImageIcon(getClass().getResource("/multimedia/Heart1.png"));
            ImageIcon Corazon2=new ImageIcon(getClass().getResource("/multimedia/Heart1.png"));
            ImageIcon Corazon3=new ImageIcon(getClass().getResource("/multimedia/Heart1.png"));
            ImageIcon Corazon4=new ImageIcon(getClass().getResource("/multimedia/Heart1.png"));
            if(vidas==3)
            {
                g.drawImage(Corazon1.getImage(), 15,15, 44, 44, null);
                g.drawImage(Corazon2.getImage(), 65,15, 44, 44, null);
                g.drawImage(Corazon3.getImage(), 115,15, 44, 44, null);
                g.drawImage(Corazon4.getImage(), 165,15, 44, 44, null);
            }
            else if(vidas==2){
                g.drawImage(Corazon1.getImage(), 15,15, 44, 44, null);
                g.drawImage(Corazon2.getImage(), 65,15, 44, 44, null);
                g.drawImage(Corazon3.getImage(), 115,15, 44, 44, null);
                /*int widthH=40;
                int newH=(widthH*vidas);*/
            }
            else if(vidas==1)
            {
                g.drawImage(Corazon1.getImage(), 15,15, 44, 44, null);
                g.drawImage(Corazon2.getImage(), 65,15, 44, 44, null);
            }
            else{
                g.drawImage(Corazon1.getImage(), 15,15, 44, 44, null);
            }


            Graphics2D g1=g,g2=g;
            Font score=new Font("Arial", Font.BOLD,28);
            g.setFont(score);
            g.setColor(Color.BLACK);
            g1.drawString("Puntaje: "+puntos,1100,30);
            //g1.drawString("Vidas: "+vidas,20,30);

            g1.drawString("Nivel: "+nivel,570,30);

            if(juegoFinalizado) {
                g2.setColor(Color.red);
                g2.drawString("¡¡Game Over!!", ((float) getBounds().getCenterX() / 2) + 230, 70);
            }
        }
        
        public void finJuego(){
            juegoFinalizado=true;
            sonidoChoque.play();
        }
        
        public void pierdeVidas(){
            sonidoChoque.play();
            pierdeVida=true;
        }

    void pierdeVida() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    
