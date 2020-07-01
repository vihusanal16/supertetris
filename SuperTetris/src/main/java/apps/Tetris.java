package apps;

import listeners.TetrisListeners;
import pieces.Peca;
import pieces.PecaI;
import pieces.PecaJ;
import pieces.PecaL;
import pieces.PecaO;
import pieces.PecaS;
import pieces.PecaT;
import pieces.PecaZ;

/**
 *
 * @author vitoralencar
 */

public class Tetris extends javax.swing.JFrame implements TetrisListeners{

    /**
     * Creates new form Tetris
     */
    public Tetris() {
        initComponents();
        
        tetrisBoard.requestFocus();
        tetrisBoard.addListener(this);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tetrisBoard = new apps.TetrisBoard();
        paneDados = new javax.swing.JPanel();
        lblPontos = new javax.swing.JLabel();
        lblProximasPecas = new javax.swing.JLabel();
        txtPontos = new javax.swing.JTextField();
        paneNext1 = new javax.swing.JPanel();
        paneNext2 = new javax.swing.JPanel();
        paneNext3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout tetrisBoardLayout = new javax.swing.GroupLayout(tetrisBoard);
        tetrisBoard.setLayout(tetrisBoardLayout);
        tetrisBoardLayout.setHorizontalGroup(
            tetrisBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
        );
        tetrisBoardLayout.setVerticalGroup(
            tetrisBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        paneDados.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblPontos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPontos.setText("Pontos");
        lblPontos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblProximasPecas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProximasPecas.setText("Próximas Peças");
        lblProximasPecas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtPontos.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        txtPontos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPontos.setText("1");
        txtPontos.setToolTipText("");

        paneNext1.setLayout(new java.awt.BorderLayout());

        paneNext2.setLayout(new java.awt.BorderLayout());

        paneNext3.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout paneDadosLayout = new javax.swing.GroupLayout(paneDados);
        paneDados.setLayout(paneDadosLayout);
        paneDadosLayout.setHorizontalGroup(
            paneDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDadosLayout.createSequentialGroup()
                .addGroup(paneDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneDadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(paneDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblPontos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblProximasPecas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPontos, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
                    .addGroup(paneDadosLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(paneDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(paneNext1, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                            .addComponent(paneNext2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(paneNext3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneDadosLayout.setVerticalGroup(
            paneDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneDadosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(paneNext3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(paneNext2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(paneNext1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(lblProximasPecas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txtPontos, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPontos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(tetrisBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(paneDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(paneDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tetrisBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tetris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tetris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tetris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tetris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tetris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblPontos;
    private javax.swing.JLabel lblProximasPecas;
    private javax.swing.JPanel paneDados;
    private javax.swing.JPanel paneNext1;
    private javax.swing.JPanel paneNext2;
    private javax.swing.JPanel paneNext3;
    private apps.TetrisBoard tetrisBoard;
    private javax.swing.JTextField txtPontos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onNewPiece(TetrisBoard board) {
        txtPontos.setText(board.getNumPieces() + "");
        paneNext1.removeAll();
        
        paneNext1.add(new Peca(board.piece2));
        paneNext1.revalidate();
        paneNext1.repaint();     
        
        paneNext2.removeAll();
        paneNext2.add(new Peca(board.piece3));
        paneNext2.revalidate();
        paneNext2.repaint();
        
        paneNext3.removeAll();
        paneNext3.add(new Peca(board.piece4));
        paneNext3.revalidate();
        paneNext3.repaint();
        
    }

}