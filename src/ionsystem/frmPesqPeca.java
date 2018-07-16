package ionsystem;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmPesqPeca extends javax.swing.JDialog {

    public frmPesqPeca(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(null); 
        
        DAOPeca peca = new DAOPeca();
        ArrayList<Peca> pecas = peca.ListarTodasPecas();
        Object[] coluna = new Object[]{"Código","Descrição","Preço"};
        DefaultTableModel model = new DefaultTableModel(coluna, 0);
        for(Peca a : pecas){
            model.addRow(new Object[]{a.getCod_Peca(),a.getDescricao(),a.getPreco()});
        }
        tblPecas.setModel(model);
        tblPecas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblPecas.getColumnModel().getColumn(0).setPreferredWidth(60);
        tblPecas.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblPecas.getColumnModel().getColumn(2).setPreferredWidth(80);
    }
    
    public Peca getPecaSelecionada(){
        if(tblPecas.getSelectedRow() != -1){
            Peca al = new Peca();
            al.setCod_Peca((int)tblPecas.getValueAt(tblPecas.getSelectedRow(), 0));
            al.setDescricao((String)tblPecas.getValueAt(tblPecas.getSelectedRow(), 1));
            al.setPreco((float)tblPecas.getValueAt(tblPecas.getSelectedRow(), 2));
            return al;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPecas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblPecas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPecas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPecasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPecas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPecasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPecasMouseClicked
        setVisible(false);
    }//GEN-LAST:event_tblPecasMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmPesqPeca dialog = new frmPesqPeca(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPecas;
    // End of variables declaration//GEN-END:variables
}
