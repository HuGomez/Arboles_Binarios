package ProyectoFinal;

import ProyectoFinal.RBTree.Nodo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class RBPlot extends javax.swing.JFrame {
    RBTree<Integer, Integer> mytree = new RBTree<Integer, Integer>();
       
    public RBPlot() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userInt = new javax.swing.JPanel();
        disp1 = new javax.swing.JLabel();
        numberText = new javax.swing.JTextField();
        insertBtn = new javax.swing.JButton();
        plotInt = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        disp1.setText("Ingrese un número:");

        insertBtn.setText("Insertar");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userIntLayout = new javax.swing.GroupLayout(userInt);
        userInt.setLayout(userIntLayout);
        userIntLayout.setHorizontalGroup(
            userIntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userIntLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(disp1)
                .addGap(18, 18, 18)
                .addComponent(numberText, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(insertBtn)
                .addContainerGap(436, Short.MAX_VALUE))
        );
        userIntLayout.setVerticalGroup(
            userIntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userIntLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(userIntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(disp1)
                    .addComponent(insertBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout plotIntLayout = new javax.swing.GroupLayout(plotInt);
        plotInt.setLayout(plotIntLayout);
        plotIntLayout.setHorizontalGroup(
            plotIntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 749, Short.MAX_VALUE)
        );
        plotIntLayout.setVerticalGroup(
            plotIntLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userInt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(plotInt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(userInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(plotInt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int drawTree(Graphics g, Nodo<Integer,Integer> x, int x0, int x1, int y) {
        if (x == mytree.nil) return 0;
        int m = (x0 + x1) / 2;
        Color n = (x.color == RBTree.RED) ? Color.red : Color.black;
        g.setColor(n);
        g.fillOval(m, y, 50, 40);
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.BOLD,20));
        String t = x.key.toString();
        g.drawString(t, m+20, y+30);
        g.setColor(Color.BLACK);
        if (x.left != mytree.nil) {
            int x2 = drawTree(g,x.left,x0,m,y+50);
            g.drawLine(m+25, y+40, x2+25, y+50);
        }
        if (x.right != mytree.nil) {
            int x2 = drawTree(g,x.right,m,x1,y+50);
            g.drawLine(m+25, y+40, x2+25, y + 50);
        }
        return m;
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        mydraw(g);
    }
    
    void mydraw(Graphics g) {
        //Graphics g = plotInt.getGraphics();
        g.clearRect(0, 80, plotInt.getHeight(), plotInt.getWidth());
        if (mytree.root != mytree.nil)
            drawTree(g, mytree.root, 0, plotInt.getWidth()-25, 100);
    }
    
    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        int x = Integer.parseInt(numberText.getText());
        mytree.insert(x, x);
        this.repaint();
    }//GEN-LAST:event_insertBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new RBPlot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel disp1;
    private javax.swing.JButton insertBtn;
    private javax.swing.JTextField numberText;
    private javax.swing.JPanel plotInt;
    private javax.swing.JPanel userInt;
    // End of variables declaration//GEN-END:variables
}
