package ionsystem;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmPesqServico extends javax.swing.JDialog {

    public frmPesqServico(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(null); 
        
        DAOServico servico = new DAOServico();
        ArrayList<Servico> servicos = servico.ListarTodosServicos();
        Object[] coluna = new Object[]{"Código","Descrição","Preço"};
        DefaultTableModel model = new DefaultTableModel(coluna, 0);
        for(Servico a : servicos){
            model.addRow(new Object[]{a.getCodigo(),a.getDescricao(),a.getPreco()});
        }
        tblServico.setModel(model);
        tblServico.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblServico.getColumnModel().getColumn(0).setPreferredWidth(60);
        tblServico.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblServico.getColumnModel().getColumn(2).setPreferredWidth(80);
    }

    public Servico getServicoSelecionado(){
        if(tblServico.getSelectedRow() != -1){
            Servico al = new Servico();
            al.setCodigo((int)tblServico.getValueAt(tblServico.getSelectedRow(), 0));
            al.setDescricao((String)tblServico.getValueAt(tblServico.getSelectedRow(), 1));
            al.setPreco((float)tblServico.getValueAt(tblServico.getSelectedRow(), 2));
            return al;
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblServico = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisando Serviço");
        setResizable(false);

        tblServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblServicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblServico);

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

    private void tblServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblServicoMouseClicked
        setVisible(false);
    }//GEN-LAST:event_tblServicoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmPesqServico dialog = new frmPesqServico(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tblServico;
    // End of variables declaration//GEN-END:variables
}
