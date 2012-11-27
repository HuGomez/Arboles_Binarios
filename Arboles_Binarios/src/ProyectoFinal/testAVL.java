package ProyectoFinal;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public final class testAVL extends JFrame {
    AVLTree tree = new AVLTree();
    int n=0;
    public testAVL(){
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(800, 400);
        this.setTitle("AVL Tree");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setBackground(Color.white);
        this.setVisible(true);
        this.getData();
    }
    
    public void getData(){
        JLabel men = new JLabel("Digite un número:");
        men.setBounds(150, 7, 200, 30);
        this.add(men);
        final JTextField field = new JTextField();
        field.setBounds(300, 13, 75, 20);
        field.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                field.setText("");
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });
        field.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_ENTER)
                    try {
                    tree.insert(Integer.parseInt(field.getText()));
                    repaint();
                } catch (Exception ex) {
                    Logger.getLogger(testAVL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            public void keyPressed(KeyEvent e) {}

            public void keyReleased(KeyEvent e) {}
        });  
        this.add(field);
        final JButton button  = new JButton("Ingresar");
        button.setBounds(450, 10, 100, 25);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(!field.getText().equals("")){
                    try {
                        tree.insert(Integer.parseInt(field.getText()));
                        repaint();
                    } catch (Exception ex) {
                        Logger.getLogger(testAVL.class.getName()).log(Level.SEVERE, null, ex);
                      }
                }
            }
        });

        this.add(button);
        final JButton but = new JButton("AVL Tree");
        but.setBounds(600, 10, 100, 25);
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tree.root=null;
                repaint();
            }
        });
        this.add(but);       
    }

    int drawTree(Graphics g, Node x, int x0, int x1, int y) {
        if (tree.root==null) return 0;
        int m = (x0 + x1) / 2;
        g.setColor(Color.black);
        g.fillOval(m, y, 50, 40);
        g.setColor(Color.red);
        g.setFont(new Font("Arial",Font.BOLD,20));
        String t = x.getInfo().toString();
        g.drawString(t, m+20, y+30);
        if (x.getLeft() != null) {
            int x2 = drawTree(g,(Node)x.getLeft(),x0,m,y+50);
            g.drawLine(m+25, y+40, x2+25, y+50);
        }
        if (x.getRigth() != null) {
            int x2 = drawTree(g,(Node)x.getRigth(),m,x1,y+50);
            g.drawLine(m+25, y+40, x2+25, y + 50);
        }
        return m;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(tree.root!=null){
            drawTree(g, tree.root, 0, this.getWidth()-25, 100);
        }
    }
}
