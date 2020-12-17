/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxime
 */
class Mur {
    private Poteau pot1;
    private Poteau pot2;
    
    private double longeur;
    private double ux;
    private double uy;
    
    public Mur(Poteau pot1, Poteau pot2){
        this.pot1=pot1;
        this.pot2=pot2;
        this.longeur=Math.sqrt((pot1.getX()-pot2.getX())*(pot1.getX()-pot2.getX())+(pot1.getY()-pot2.getY())*(pot1.getY()-pot2.getY()));
        this.ux=(pot2.getX()-pot1.getX())/longeur;
        this.uy=(pot2.getY()-pot1.getY())/longeur;
    }

    public Poteau getPot1() {
        return pot1;
    }

    public Poteau getPot2() {
        return pot2;
    }

    public double getLongeur() {
        return longeur;
    }
    public double distance(double x,double y){
        double d;
        
        double x1 = x-pot1.getX();
        double y1 = y-pot1.getY();
        double x2 = x-pot2.getX();
        double y2 = y-pot2.getY();
        double projection = x1*ux+y1*uy;
        if(projection<0)            d=Math.sqrt(x1*x1+y1*y1);
        else if(projection>longeur) d=Math.sqrt(x2*x2+y2*y2);
        else                        d=Math.abs(x1*uy-y1*ux);
        //System.out.println(d);
        return d;
    }
    
    
    
}
