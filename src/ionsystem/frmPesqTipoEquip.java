package ionsystem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmPesqTipoEquip extends javax.swing.JDialog {

    public frmPesqTipoEquip(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(null); 
        
        DAOTipoEquip tipoequip = new DAOTipoEquip();
        ArrayList<TipoEquip> tiposequip = tipoequip.ListarTodosTiposEquip();
        Object[] coluna = new Object[]{"Código","Descrição"};
        DefaultTableModel model = new DefaultTableModel(coluna, 0);
        //SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        for(TipoEquip a : tiposequip){
            model.addRow(new Object[]{a.getCodigo(),a.getDescricao()});
        }
        jtbTipoEquip.setModel(model);
        jtbTipoEquip.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jtbTipoEquip.getColumnModel().getColumn(0).setPreferredWidth(60);
        jtbTipoEquip.getColumnModel().getColumn(1).setPreferredWidth(300);
    }
    
    public TipoEquip getTipoSelecionado(){
        if(jtbTipoEquip.getSelectedRow() != -1){
            TipoEquip al = new TipoEquip();
            al.setCodigo((int)jtbTipoEquip.getValueAt(jtbTipoEquip.getSelectedRow(), 0));
            al.setDescricao((String)jtbTipoEquip.getValueAt(jtbTipoEquip.getSelectedRow(), 1));
            return al;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTipoEquip = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jtbTipoEquip.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbTipoEquip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbTipoEquipMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbTipoEquip);

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

    private void jtbTipoEquipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTipoEquipMouseClicked
        setVisible(false);
    }//GEN-LAST:event_jtbTipoEquipMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmPesqTipoEquip dialog = new frmPesqTipoEquip(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable jtbTipoEquip;
    // End of variables declaration//GEN-END:variables
}
