
import java.awt.Color;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
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
public class Fenetre extends JFrame{
    private Panel pan;
    public Fenetre(){
        this.setSize(800, 600);
        this.setTitle("Test Ray Tracing");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        pan = new Panel();
        this.setContentPane(pan);
        
        
        this.setVisible(true);
        pan.go();
    }
    
}
