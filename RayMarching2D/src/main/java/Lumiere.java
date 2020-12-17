/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
public class Lumiere {
    public static int R=5;
    
    private double x;
    private double y;
    private Ray[] rays;
    
    public Lumiere(int nRay){
        x=0;
        y=0;
        rays=new Ray[nRay];
        for(int k=0;k<nRay;k++){
            rays[k]=new Ray(this,x,y,2*Math.PI*k/nRay);
        }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Ray[] getRays() {
        return rays;
    }

    public void setRays(Ray[] rays) {
        this.rays = rays;
    }
    
    
    
}
