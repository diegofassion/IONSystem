package ionsystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmPesqFuncionario extends javax.swing.JDialog {

    public frmPesqFuncionario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(null);
        
        
        DAOFuncionario funcionario = new DAOFuncionario();
        ArrayList<Funcionario> funcionarios = funcionario.ListarTodosFuncionarios();
        Object[] coluna = new Object[]{"Código","Nome","Data de Nascimento"};
        DefaultTableModel model = new DefaultTableModel(coluna, 0);
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        for(Funcionario a : funcionarios){
            model.addRow(new Object[]{a.getCod_Funcionario(),a.getNome(),data.format(a.getData_Nasc().getTime())});
        }
        tblPesqFunc.setModel(model);
        tblPesqFunc.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblPesqFunc.getColumnModel().getColumn(0).setPreferredWidth(60);
        tblPesqFunc.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblPesqFunc.getColumnModel().getColumn(2).setPreferredWidth(100);
    }
    
    public Funcionario getFuncionarioSelecionado(){
        if(tblPesqFunc.getSelectedRow() != -1){
            Funcionario al = new Funcionario();
            al.setCod_Funcionario((int)tblPesqFunc.getValueAt(tblPesqFunc.getSelectedRow(), 0));
            al.setNome((String)tblPesqFunc.getValueAt(tblPesqFunc.getSelectedRow(), 1));
            SimpleDateFormat data = new SimpleDateFormat("dd/mm/yyyy");
            Calendar cal = Calendar.getInstance();
            try{
                cal.setTime(data.parse((String) tblPesqFunc.getValueAt(tblPesqFunc.getSelectedRow(), 2)));
            }catch (ParseException ex){
                Logger.getLogger(frmPesqFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
            al.setData_Nasc(cal);
            return al;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPesqFunc = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisando Funcionário");
        setResizable(false);

        tblPesqFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPesqFunc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPesqFuncMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPesqFunc);

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

    private void tblPesqFuncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPesqFuncMouseClicked
        setVisible(false);
    }//GEN-LAST:event_tblPesqFuncMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmPesqFuncionario dialog = new frmPesqFuncionario(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tblPesqFunc;
    // End of variables declaration//GEN-END:variables
}
