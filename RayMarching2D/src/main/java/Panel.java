
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
public class Panel extends JPanel implements MouseMotionListener{
    private ArrayList<Mur> murs;
    private Lumiere lumiere;
    
    static int NB_RAYS = 50;
    static int NB_MURS = 6;
    
    
    public Panel(){
        murs = new ArrayList();
    }
    
    public void init(){
        
        lumiere = new Lumiere(NB_RAYS);
        for(int k=0 ; k<NB_MURS ; k++){
            murs.add(new Mur(new Poteau(Math.random()*this.getWidth(),Math.random()*this.getHeight()),new Poteau(Math.random()*this.getWidth(),Math.random()*this.getHeight())));
        }
        this.addMouseMotionListener(this);
        this.repaint();
    }
    
    public void go(){
        init();
        
    }
    
    public void paintComponent(Graphics g){
        g.setColor(new Color(10,10,10));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.white);
        dessinerMurs(g);
        g.setColor(Color.yellow);
        dessinerLumiere(g);
    }
    
    
    public void dessinerMurs(Graphics g){
        g.setColor(Color.white);
        for(Mur mur:murs){
            g.drawLine((int)mur.getPot1().getX(), (int)mur.getPot1().getY(), (int)mur.getPot2().getX(), (int)mur.getPot2().getY());
        }
    }
    
    public void dessinerLumiere(Graphics g){
        g.fillOval((int)lumiere.getX()-Lumiere.R, (int)lumiere.getY()-Lumiere.R  , 2*Lumiere.R+1, 2*Lumiere.R+1);
        double[] coordFin;
        for(Ray ray:lumiere.getRays()){
            coordFin = ray.avancer(murs,g);
            g.setColor(new Color(240,240,0));
            g.drawLine((int)lumiere.getX(),(int)lumiere.getY(),(int)coordFin[0],(int)coordFin[1]);
            
            //g.drawLine((int)coordFin[0], (int)coordFin[1], (int)coordFin[0], (int)coordFin[1]);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        lumiere.setX(e.getX());
        lumiere.setY(e.getY());
        this.repaint();
    }
}
