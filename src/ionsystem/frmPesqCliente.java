package ionsystem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmPesqCliente extends javax.swing.JDialog {

    public frmPesqCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
        DAOCliente cliente = new DAOCliente();
        ArrayList<Cliente> clientes = cliente.ListarTodosClientes();
        Object[] coluna = new Object[]{"Código","Nome","Data de Nascimento","RG","CPF","Telefone","Endereco","CEP","Bairro","Cidade"};
        DefaultTableModel model = new DefaultTableModel(coluna, 0);
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        for(Cliente a : clientes){
            model.addRow(new Object[]{a.getCod_Cliente(),a.getNome(),data.format(a.getData_Nasc().getTime())});
        }
        tblCliente.setModel(model);
        tblCliente.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblCliente.getColumnModel().getColumn(0).setPreferredWidth(60);
        tblCliente.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblCliente.getColumnModel().getColumn(2).setPreferredWidth(100);
        
    }
    
    public Cliente getClienteSelecionado(){
        if(tblCliente.getSelectedRow() != -1){
            Cliente al = new Cliente();
            al.setCod_Cliente((int)tblCliente.getValueAt(tblCliente.getSelectedRow(), 0));
            al.setNome((String)tblCliente.getValueAt(tblCliente.getSelectedRow(), 1));
            SimpleDateFormat data = new SimpleDateFormat("dd/mm/yyyy");
            Calendar cal = Calendar.getInstance();
            try{
                cal.setTime(data.parse((String) tblCliente.getValueAt(tblCliente.getSelectedRow(), 2)));
            }catch (ParseException ex){
                Logger.getLogger(frmPesqCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            al.setData_Nasc(cal);
            al.setRG((String)tblCliente.getValueAt(tblCliente.getSelectedRow(), 3));
            al.setCPF((String)tblCliente.getValueAt(tblCliente.getSelectedRow(), 4));
            al.setTelefone((String)tblCliente.getValueAt(tblCliente.getSelectedRow(), 5));
            
            return al;
        }
        return null;
    }
    
    public Cliente getClienteSelecOS(){
        if(tblCliente.getSelectedRow() != -1){
            Cliente al = new Cliente();
            al.setCod_Cliente((int)tblCliente.getValueAt(tblCliente.getSelectedRow(), 0));
            al.setNome((String)tblCliente.getValueAt(tblCliente.getSelectedRow(), 1));
            return al;
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisando Cliente");
        setPreferredSize(new java.awt.Dimension(400, 300));
        setResizable(false);

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        setVisible(false);
    }//GEN-LAST:event_tblClienteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmPesqCliente dialog = new frmPesqCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tblCliente;
    // End of variables declaration//GEN-END:variables
}
