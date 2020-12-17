
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
public class Ray {
    private static double pasMax = 100;
    private static double longeurRayMax = 800;
    
    private Lumiere lumiere;
    private double angle;
    private double ux;
    private double uy;
    
    public Ray(Lumiere lumiere,double x,double y,double angle){
        this.lumiere=lumiere;
        this.angle=angle;
        ux=Math.cos(angle);
        uy=Math.sin(angle);
    }
    
    public double[] avancer(ArrayList<Mur> murs,Graphics g){
        double[] tempCoord = {lumiere.getX(),lumiere.getY()};
        double distance;
        double longeurRay = 0;
        do{
            distance = distanceMin(murs,tempCoord[0],tempCoord[1]);
            
            //g.setColor(Color.red);
            //g.drawOval((int)(tempCoord[0]-distance), (int)(tempCoord[1]-distance), (int)(2*distance), (int)(2*distance));
            
            tempCoord[0]+=distance*ux;
            tempCoord[1]+=distance*uy;
            longeurRay+=distance;
        }while(distance >=1 && longeurRay<Ray.longeurRayMax);
        if(longeurRay>Ray.longeurRayMax){
            tempCoord[0]=lumiere.getX()+Ray.longeurRayMax*ux;
            tempCoord[1]=lumiere.getY()+Ray.longeurRayMax*uy;
        }
        return tempCoord; 
    }

    private double distanceMin(ArrayList<Mur> murs, double x, double y) {
        double dmin = Ray.pasMax;//distance du plus proche obstacle
        double d;
        for(Mur mur:murs){
            //if(){//si le rayon passe pas à coté de ce mur
                d=mur.distance(x, y);
            //}
            if(d<dmin && d>0){
                dmin=d;
            }
        }
        return dmin;
    }

    public Lumiere getLumiere() {
        return lumiere;
    }

    public double getUx() {
        return ux;
    }

    public void setUx(double ux) {
        this.ux = ux;
    }

    public double getUy() {
        return uy;
    }

    public void setUy(double uy) {
        this.uy = uy;
    }
    
    
    
}
