package ionsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class frmImprimirOS extends javax.swing.JDialog {

    public frmImprimirOS(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(null); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNomeOS = new javax.swing.JLabel();
        txtNumeroOS = new javax.swing.JTextField();
        btnAbrirOS = new javax.swing.JButton();
        btnCancelarOS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Digite o número da OS");
        setResizable(false);

        lblNomeOS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNomeOS.setText("Número da O.S. para Imprimir:");

        txtNumeroOS.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btnAbrirOS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAbrirOS.setText("Abrir");
        btnAbrirOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirOSActionPerformed(evt);
            }
        });

        btnCancelarOS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelarOS.setText("Cancelar");
        btnCancelarOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarOSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNumeroOS)
                        .addComponent(lblNomeOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAbrirOS, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarOS, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeOS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNumeroOS, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrirOS, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarOS, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarOSActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelarOSActionPerformed

    private void btnAbrirOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirOSActionPerformed
        Map parametro = new HashMap();
        String arquivo = "C:\\Users\\Diego Fassion\\Documents\\DIEGO\\ADS UNIMAR\\5º Termo\\Cedran\\NetBeansProjects\\IONSystem\\src\\ionsystem\\rptOS.jasper";
        JasperPrint jasperprint = null;
         try {
             parametro.put("Cod_OS", txtNumeroOS.getText());
             jasperprint = JasperFillManager.fillReport(arquivo, parametro, conexao.getconexao());
             JasperViewer relatorio = new JasperViewer(jasperprint, false);
             this.setVisible(false);
             relatorio.setVisible(true);
         } catch (JRException ex) {
             Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_btnAbrirOSActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmImprimirOS dialog = new frmImprimirOS(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirOS;
    private javax.swing.JButton btnCancelarOS;
    private javax.swing.JLabel lblNomeOS;
    private javax.swing.JTextField txtNumeroOS;
    // End of variables declaration//GEN-END:variables
}
