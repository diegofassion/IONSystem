package ionsystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmPesqEquip extends javax.swing.JDialog {

    public frmPesqEquip(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null); 
        
        DAOCliente cliente = new DAOCliente();
        ArrayList<Cliente> clientes = cliente.ListarTodosClientes();
        
        DAOEquipamento equip = new DAOEquipamento();
        ArrayList<Equipamento> equips = equip.ListarTodosEquipamentos();
        Object[] coluna = new Object[]{"Código","Cliente","Marca","Modelo"};
        DefaultTableModel model = new DefaultTableModel(coluna, 0);
        for(Equipamento a : equips){
            String nome=null;
            for(Cliente c : clientes){
                if(a.getCod_Cliente() == c.getCod_Cliente()){
                    nome = c.getNome();
                }
            }
            model.addRow(new Object[]{a.getCod_Equip(),nome,a.getMarca(),a.getModelo()});
            
        }
        tblPesqEquip.setModel(model);
        tblPesqEquip.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblPesqEquip.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblPesqEquip.getColumnModel().getColumn(1).setPreferredWidth(120);
        tblPesqEquip.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblPesqEquip.getColumnModel().getColumn(3).setPreferredWidth(100);
    }
    
    public Equipamento getEquipamentoSelecionado(){
        if(tblPesqEquip.getSelectedRow() != -1){
            Equipamento al = new Equipamento();
            al.setCod_Equip((int)tblPesqEquip.getValueAt(tblPesqEquip.getSelectedRow(), 0));
            al.setCod_Cliente((int)tblPesqEquip.getValueAt(tblPesqEquip.getSelectedRow(), 1));
            al.setMarca((String)tblPesqEquip.getValueAt(tblPesqEquip.getSelectedRow(), 2));
            al.setModelo((String)tblPesqEquip.getValueAt(tblPesqEquip.getSelectedRow(), 3));
            al.setSerie((String)tblPesqEquip.getValueAt(tblPesqEquip.getSelectedRow(), 4));
            al.setTipoEquip((int)tblPesqEquip.getValueAt(tblPesqEquip.getSelectedRow(), 5));
            al.setDescricao((String)tblPesqEquip.getValueAt(tblPesqEquip.getSelectedRow(), 6));
            al.setObs((String)tblPesqEquip.getValueAt(tblPesqEquip.getSelectedRow(), 7));
            return al;
        }
        return null;
    }
    
    public Equipamento getEquipSelecOS(){
        if(tblPesqEquip.getSelectedRow() != -1){
            Equipamento al = new Equipamento();
            al.setCod_Equip((int)tblPesqEquip.getValueAt(tblPesqEquip.getSelectedRow(), 0));
            al.setMarca((String)tblPesqEquip.getValueAt(tblPesqEquip.getSelectedRow(), 2));
            al.setModelo((String)tblPesqEquip.getValueAt(tblPesqEquip.getSelectedRow(), 3));
            return al;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPesqEquip = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tblPesqEquip.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPesqEquip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPesqEquipMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPesqEquip);

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

    private void tblPesqEquipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPesqEquipMouseClicked
        setVisible(false);
    }//GEN-LAST:event_tblPesqEquipMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmPesqEquip dialog = new frmPesqEquip(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tblPesqEquip;
    // End of variables declaration//GEN-END:variables
}
