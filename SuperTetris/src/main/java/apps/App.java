package apps;

import gameDatas.Player;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import listeners.TetrisListeners;

/**
 *
 * @author vitoralencar
 */
public class App extends javax.swing.JFrame {

    /**
     * Creates new form App
     */
    public App() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpaneApp = new javax.swing.JPanel();
        jpaneInterior = new javax.swing.JPanel();
        btnPlay = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        btnHighScore = new javax.swing.JButton();
        jpaneBotton = new javax.swing.JPanel();
        btnAbout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblNome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SuperTetris 2020");
        setAutoRequestFocus(false);
        setResizable(false);

        jpaneApp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jpaneApp.setLayout(null);

        jpaneInterior.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jpaneInterior.setLayout(new java.awt.GridLayout(3, 1, 10, 10));

        btnPlay.setText("Play");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        jpaneInterior.add(btnPlay);

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jpaneInterior.add(btnLogin);

        btnHighScore.setText("HighScore");
        btnHighScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHighScoreActionPerformed(evt);
            }
        });
        jpaneInterior.add(btnHighScore);

        jpaneApp.add(jpaneInterior);
        jpaneInterior.setBounds(100, 50, 190, 160);

        jpaneBotton.setLayout(new java.awt.GridLayout(1, 2, 200, 10));

        btnAbout.setText("About");
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });
        jpaneBotton.add(btnAbout);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jpaneBotton.add(btnExit);

        jpaneApp.add(jpaneBotton);
        jpaneBotton.setBounds(10, 230, 360, 29);

        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNome.setToolTipText("");
        jpaneApp.add(lblNome);
        lblNome.setBounds(100, 10, 190, 0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpaneApp, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpaneApp, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        // TODO add your handling code here:
        
        //Criando um novo jogo
        Tetris play = new Tetris();
        play.setVisible(true);
        
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        
        
        
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Tetris", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            try{
                FileWriter arq = new FileWriter("dados");
                PrintWriter gravarArq = new PrintWriter(arq);
                gravarArq.println("");
                gravarArq.close();

            }
            catch(IOException e){
                System.out.println("Erro ao gravar");
            }
            System.exit(0);
        }
        
        
       
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
        // TODO add your handling code here:
        
        Sobre about = new Sobre();      
        about.setVisible(true);
        
    }//GEN-LAST:event_btnAboutActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        
        if(!login){
            
            Login newLogin = new Login();
            newLogin.setVisible(true);                
            login = true;

            lblNome.setText("Bem vindo " + newLogin.nomes + "!");
            
        } else {
            JOptionPane.showMessageDialog(null, "Login já realizado!");
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnHighScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHighScoreActionPerformed
        try {
            // TODO add your handling code here:

            String highscore = read();
            JOptionPane.showMessageDialog(null, "Player : " + "Pontos" + "\n" + highscore);
            
            
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo");
        }
        
    }//GEN-LAST:event_btnHighScoreActionPerformed

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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }
    

    boolean login = false;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbout;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHighScore;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnPlay;
    private javax.swing.JPanel jpaneApp;
    private javax.swing.JPanel jpaneBotton;
    private javax.swing.JPanel jpaneInterior;
    private javax.swing.JLabel lblNome;
    // End of variables declaration//GEN-END:variables

    public static String read() throws FileNotFoundException, IOException{
        
        String caminho = "highscore";
        String conteudo = "";
            
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            
            String linha = "";
                     
            try {
                linha = lerArq.readLine();
                while(linha != null){
                    conteudo += linha + "\n";
                    linha = lerArq.readLine();
                }
                arq.close();
                return conteudo;
            }
            catch(IOException e){
                System.out.println("Erro. Não foi possível ler o arquivo. " + e);
                return "";
            }
            
        }
        catch (FileNotFoundException e) {
            System.out.println("Erro. Não foi possível encontrar o arquivo! " + e.toString());
            return "";
        }            
    }

    public void ordenaHighScore(){
        
    }

}
