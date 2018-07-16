package ionsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.PropertyMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class frmPrincipal extends javax.swing.JFrame {

    public frmPrincipal() {
        initComponents();
        
        setLocationRelativeTo(null); //ABRIR CENTRALIZADO
        setExtendedState(MAXIMIZED_BOTH); //ABRIR MAXIMIZADO
    }

        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jmbPrincipal = new javax.swing.JMenuBar();
        jmnCadastros = new javax.swing.JMenu();
        jmnCadCliente = new javax.swing.JMenuItem();
        jmnFuncionario = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmnCadTipoEquip = new javax.swing.JMenuItem();
        jmnCadEquipamento = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jmnCadServico = new javax.swing.JMenuItem();
        jmnCadPeca = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jmnCadSair = new javax.swing.JMenuItem();
        jmnOs = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jmnRelatorios = new javax.swing.JMenu();
        jmnCadastralCliente = new javax.swing.JMenuItem();
        jmnSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ION System - Asistência Técnica");
        setIconImages(null);

        jmnCadastros.setText("Cadastros");

        jmnCadCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jmnCadCliente.setText("Cliente");
        jmnCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnCadClienteActionPerformed(evt);
            }
        });
        jmnCadastros.add(jmnCadCliente);

        jmnFuncionario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        jmnFuncionario.setText("Funcionário");
        jmnFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnFuncionarioActionPerformed(evt);
            }
        });
        jmnCadastros.add(jmnFuncionario);
        jmnCadastros.add(jSeparator1);

        jmnCadTipoEquip.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        jmnCadTipoEquip.setText("Tipo de Equipamento");
        jmnCadTipoEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnCadTipoEquipActionPerformed(evt);
            }
        });
        jmnCadastros.add(jmnCadTipoEquip);

        jmnCadEquipamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        jmnCadEquipamento.setText("Equipamento");
        jmnCadEquipamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnCadEquipamentoActionPerformed(evt);
            }
        });
        jmnCadastros.add(jmnCadEquipamento);
        jmnCadastros.add(jSeparator2);

        jmnCadServico.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jmnCadServico.setText("Serviço");
        jmnCadServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnCadServicoActionPerformed(evt);
            }
        });
        jmnCadastros.add(jmnCadServico);

        jmnCadPeca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        jmnCadPeca.setText("Peça");
        jmnCadPeca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnCadPecaActionPerformed(evt);
            }
        });
        jmnCadastros.add(jmnCadPeca);
        jmnCadastros.add(jSeparator3);

        jmnCadSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jmnCadSair.setText("Sair");
        jmnCadSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnCadSairActionPerformed(evt);
            }
        });
        jmnCadastros.add(jmnCadSair);

        jmbPrincipal.add(jmnCadastros);

        jmnOs.setText("Ordem Serviço");
        jmnOs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmnOsMouseClicked(evt);
            }
        });
        jmbPrincipal.add(jmnOs);

        jMenu1.setText("Imprimir O.S.");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jmbPrincipal.add(jMenu1);

        jmnRelatorios.setText("Relatórios");

        jmnCadastralCliente.setText("Cadastro de Clientes");
        jmnCadastralCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnCadastralClienteActionPerformed(evt);
            }
        });
        jmnRelatorios.add(jmnCadastralCliente);

        jmbPrincipal.add(jmnRelatorios);

        jmnSair.setText("Sair");
        jmnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmnSairMouseClicked(evt);
            }
        });
        jmbPrincipal.add(jmnSair);

        setJMenuBar(jmbPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmnCadEquipamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnCadEquipamentoActionPerformed
        new frmCadEquip(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jmnCadEquipamentoActionPerformed

    private void jmnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmnSairMouseClicked
       System.exit(0);
    }//GEN-LAST:event_jmnSairMouseClicked

    private void jmnCadSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnCadSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmnCadSairActionPerformed

    private void jmnCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnCadClienteActionPerformed
        new frmCadCliente(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jmnCadClienteActionPerformed

    private void jmnFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnFuncionarioActionPerformed
        new frmCadFuncionario(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jmnFuncionarioActionPerformed

    private void jmnCadTipoEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnCadTipoEquipActionPerformed
        new frmCadTipoEquip(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jmnCadTipoEquipActionPerformed

    private void jmnCadServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnCadServicoActionPerformed
        new frmCadServico(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jmnCadServicoActionPerformed

    private void jmnCadPecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnCadPecaActionPerformed
        new frmCadPeca(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jmnCadPecaActionPerformed

    private void jmnOsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmnOsMouseClicked
        new frmCadOs(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jmnOsMouseClicked

    private void jmnCadastralClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnCadastralClienteActionPerformed
        Map parametro = new HashMap();
        String arquivo = "C:\\Users\\Diego Fassion\\Documents\\DIEGO\\ADS UNIMAR\\5º Termo\\Cedran\\NetBeansProjects\\IONSystem\\src\\ionsystem\\rptCliente.jasper";
        JasperPrint jasperprint = null;
         try {
             jasperprint = JasperFillManager.fillReport(arquivo, parametro, conexao.getconexao());
             JasperViewer relatorio = new JasperViewer(jasperprint, false);
             relatorio.setVisible(true);
         } catch (JRException ex) {
             Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jmnCadastralClienteActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new frmImprimirOS(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuBar jmbPrincipal;
    private javax.swing.JMenuItem jmnCadCliente;
    private javax.swing.JMenuItem jmnCadEquipamento;
    private javax.swing.JMenuItem jmnCadPeca;
    private javax.swing.JMenuItem jmnCadSair;
    private javax.swing.JMenuItem jmnCadServico;
    private javax.swing.JMenuItem jmnCadTipoEquip;
    private javax.swing.JMenuItem jmnCadastralCliente;
    private javax.swing.JMenu jmnCadastros;
    private javax.swing.JMenuItem jmnFuncionario;
    private javax.swing.JMenu jmnOs;
    private javax.swing.JMenu jmnRelatorios;
    private javax.swing.JMenu jmnSair;
    // End of variables declaration//GEN-END:variables

}
