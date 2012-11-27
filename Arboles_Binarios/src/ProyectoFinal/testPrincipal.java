
package ProyectoFinal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class testPrincipal extends JFrame {
    int n=0;
    SearchBinaryTree tree = new SearchBinaryTree();
    
    public testPrincipal(){
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setTitle("Proyecto Árboles");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.white);
        this.setVisible(true);
        this.getData();
    }

    public  void getData(){
        JButton but = new JButton("Arbol AVL");
        but.setBounds(150, 10, 100, 25);
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
                testAVL t1 = new testAVL();
            }
        });
        this.add(but);
        
        JButton bu = new JButton("Arbol BST");
        bu.setBounds(150, 100, 100, 25);
        bu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                testSBT t1 = new testSBT();
                repaint();
            }
        });
        this.add(bu);

        JButton butt = new JButton("Arbol Rojo-Negro");
        butt.setBounds(135, 190, 130, 25);
        butt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RBPlot().setVisible(true);
                repaint();
            }
        });
        this.add(butt);

        JButton butto = new JButton("Cola MinHeap");
        butto.setBounds(135, 280, 130, 25);
        butto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                testHeap h = new testHeap();
                repaint();
            }
        });
        this.add(butto);
        
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
