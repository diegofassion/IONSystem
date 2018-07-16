package ionsystem;

import java.awt.FlowLayout;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class frmCadCliente extends javax.swing.JDialog {
    private ButtonGroup grpSex;
    private boolean press_edit;

    public frmCadCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null); 
        
        ButtonGroup grpSex = new ButtonGroup();  
  
        grpSex.add(jrbMasc);  
        grpSex.add(jrbFem);  
                
        pnlSexo.setLayout(new FlowLayout());
        pnlSexo.add(jrbMasc);
        pnlSexo.add(jrbFem);
        
        jrbMasc.setSelected(true);
        
        HabilitarBotoes();
        DesabilitarCampos();
    }
    
    private void LimparCampos(){
        txtCodigo.setText("");
        txtNome.setText("");
        txtDataNasc.setValue(null);
        txtRG.setText("");
        txtCPF.setText("");
        txtTelefone.setText("");
        txtEndereco.setText("");
        txtCEP.setText("");
        txtBairro.setText("");
        txtCidade.setText("");
        cbbEstado.setSelectedIndex(0);
    }
    
    private void HabilitarBotoes(){
        btnClienteInserir.setEnabled(true);
        btnClienteEditar.setEnabled(false);
        btnClienteExcluir.setEnabled(false);
        btnClientePesquisar.setEnabled(true);
        btnClienteDesfazer.setEnabled(false);
        btnClienteSalvar.setEnabled(false);
        btnClienteSair.setEnabled(true);
    }
    
    public void DesabilitarBotoes(){
        btnClienteInserir.setEnabled(false);
        btnClienteEditar.setEnabled(false);
        btnClienteExcluir.setEnabled(false);
        btnClientePesquisar.setEnabled(false);
        btnClienteDesfazer.setEnabled(true);
        btnClienteSalvar.setEnabled(true);
        btnClienteSair.setEnabled(false);
    }
        
    private void HabilitarCampos(){
        txtCodigo.setEnabled(true);
        txtNome.setEnabled(true);
        jrbMasc.setEnabled(true);
        jrbFem.setEnabled(true);
        txtDataNasc.setEnabled(true);
        txtRG.setEnabled(true);
        txtCPF.setEnabled(true);
        txtTelefone.setEnabled(true);
        txtEndereco.setEnabled(true);
        txtCEP.setEnabled(true);
        txtBairro.setEnabled(true);
        txtCidade.setEnabled(true);
        cbbEstado.setEnabled(true);
    }
    
    private void DesabilitarCampos(){
        txtCodigo.setEnabled(false);
        txtNome.setEnabled(false);
        jrbMasc.setEnabled(false);
        jrbFem.setEnabled(false);
        txtDataNasc.setEnabled(false);
        txtRG.setEnabled(false);
        txtCPF.setEnabled(false);
        txtTelefone.setEnabled(false);
        txtEndereco.setEnabled(false);
        txtCEP.setEnabled(false);
        txtBairro.setEnabled(false);
        txtCidade.setEnabled(false);
        cbbEstado.setEnabled(false);
    }
    
    private Cliente getDados(){
        Cliente a = new Cliente();
        a.setCod_Cliente(Integer.parseInt(txtCodigo.getText()));
        a.setNome(txtNome.getText());
        
        if (jrbMasc.isSelected()){
            a.setSexo("Masculino");
        }else{
            a.setSexo("Feminino");
        }
        
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        try {
            data.parse(txtDataNasc.getText());
        
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(frmCadCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            a.setData_Nasc(data.getCalendar());
        
        a.setRG(txtRG.getText());
        a.setCPF(txtCPF.getText());
        a.setTelefone(txtTelefone.getText());
        a.setEndereco(txtEndereco.getText());
        a.setCEP(txtCEP.getText());
        a.setBairro(txtBairro.getText());
        a.setCidade(txtCidade.getText());
        a.setEstado(cbbEstado.getSelectedItem().toString());
        return a;
    }
    
    private void setDados(Cliente a){
        txtCodigo.setText(String.valueOf(a.getCod_Cliente()));
        txtNome.setText(a.getNome());
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        data.setCalendar(a.getData_Nasc());
        txtDataNasc.setText(data.format(a.getData_Nasc().getTime()));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCadCliente1 = new javax.swing.JPanel();
        btnClienteExcluir = new javax.swing.JButton();
        btnClienteInserir = new javax.swing.JButton();
        btnClienteEditar = new javax.swing.JButton();
        btnClientePesquisar = new javax.swing.JButton();
        btnClienteSair = new javax.swing.JButton();
        jspCliente2 = new javax.swing.JSeparator();
        jspCliente1 = new javax.swing.JSeparator();
        btnClienteSalvar = new javax.swing.JButton();
        btnClienteDesfazer = new javax.swing.JButton();
        pnlCadCliente2 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        pnlSexo = new javax.swing.JPanel();
        jrbMasc = new javax.swing.JRadioButton();
        jrbFem = new javax.swing.JRadioButton();
        lblDataNasc = new javax.swing.JLabel();
        txtDataNasc = new javax.swing.JFormattedTextField();
        lblRG = new javax.swing.JLabel();
        txtRG = new javax.swing.JFormattedTextField();
        lblCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblCEP = new javax.swing.JLabel();
        txtCEP = new javax.swing.JFormattedTextField();
        lblBairro = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        lblCidade = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        lblCidade1 = new javax.swing.JLabel();
        cbbEstado = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cliente");
        setIconImage(null);
        setResizable(false);

        pnlCadCliente1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnClienteExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Excluir.png"))); // NOI18N
        btnClienteExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnClienteExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClienteExcluir.setOpaque(false);
        btnClienteExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteExcluirActionPerformed(evt);
            }
        });

        btnClienteInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Inserir.png"))); // NOI18N
        btnClienteInserir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnClienteInserir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClienteInserir.setOpaque(false);
        btnClienteInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteInserirActionPerformed(evt);
            }
        });

        btnClienteEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Editar.png"))); // NOI18N
        btnClienteEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnClienteEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClienteEditar.setOpaque(false);
        btnClienteEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteEditarActionPerformed(evt);
            }
        });

        btnClientePesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Pesquisar.png"))); // NOI18N
        btnClientePesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnClientePesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClientePesquisar.setOpaque(false);
        btnClientePesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientePesquisarActionPerformed(evt);
            }
        });

        btnClienteSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Sair.png"))); // NOI18N
        btnClienteSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnClienteSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClienteSair.setOpaque(false);
        btnClienteSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteSairActionPerformed(evt);
            }
        });

        jspCliente2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jspCliente1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnClienteSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar.png"))); // NOI18N
        btnClienteSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnClienteSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClienteSalvar.setOpaque(false);
        btnClienteSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteSalvarActionPerformed(evt);
            }
        });

        btnClienteDesfazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Desfazer.png"))); // NOI18N
        btnClienteDesfazer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnClienteDesfazer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClienteDesfazer.setOpaque(false);
        btnClienteDesfazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteDesfazerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCadCliente1Layout = new javax.swing.GroupLayout(pnlCadCliente1);
        pnlCadCliente1.setLayout(pnlCadCliente1Layout);
        pnlCadCliente1Layout.setHorizontalGroup(
            pnlCadCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadCliente1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnClienteInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClienteExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClienteSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClienteDesfazer, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jspCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClientePesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jspCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClienteSair, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnlCadCliente1Layout.setVerticalGroup(
            pnlCadCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadCliente1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCadCliente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jspCliente2)
                    .addComponent(btnClientePesquisar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnClienteExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClienteSair, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jspCliente1)
                    .addComponent(btnClienteSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClienteDesfazer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClienteEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnClienteInserir, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlCadCliente2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCodigo.setText("Código:");

        txtCodigo.setToolTipText("");

        lblNome.setText("Nome:");

        txtNome.setToolTipText("");

        pnlSexo.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));

        jrbMasc.setText("Masculino");

        jrbFem.setText("Feminino");

        javax.swing.GroupLayout pnlSexoLayout = new javax.swing.GroupLayout(pnlSexo);
        pnlSexo.setLayout(pnlSexoLayout);
        pnlSexoLayout.setHorizontalGroup(
            pnlSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSexoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jrbMasc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbFem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSexoLayout.setVerticalGroup(
            pnlSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSexoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlSexoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbMasc)
                    .addComponent(jrbFem))
                .addContainerGap())
        );

        lblDataNasc.setText("Data Nasc:");

        try {
            txtDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblRG.setText("RG:");

        try {
            txtRG.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblCPF.setText("CPF:");

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblTelefone.setText("Telefone:");

        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblEndereco.setText("Endereço:");

        txtEndereco.setToolTipText("");

        lblCEP.setText("CEP:");

        try {
            txtCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lblBairro.setText("Bairro:");

        txtBairro.setToolTipText("");

        lblCidade.setText("Cidade:");

        txtCidade.setToolTipText("");

        lblCidade1.setText("Estado:");

        cbbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" }));

        javax.swing.GroupLayout pnlCadCliente2Layout = new javax.swing.GroupLayout(pnlCadCliente2);
        pnlCadCliente2.setLayout(pnlCadCliente2Layout);
        pnlCadCliente2Layout.setHorizontalGroup(
            pnlCadCliente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadCliente2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlCadCliente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCadCliente2Layout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCadCliente2Layout.createSequentialGroup()
                        .addComponent(pnlSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDataNasc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblRG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCPF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCadCliente2Layout.createSequentialGroup()
                        .addGroup(pnlCadCliente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCadCliente2Layout.createSequentialGroup()
                                .addComponent(lblBairro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCadCliente2Layout.createSequentialGroup()
                                .addComponent(lblEndereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCEP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCadCliente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCadCliente2Layout.createSequentialGroup()
                                .addComponent(lblCidade1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCadCliente2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(lblTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCadCliente2Layout.setVerticalGroup(
            pnlCadCliente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadCliente2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlCadCliente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlCadCliente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCadCliente2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(pnlCadCliente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCPF)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRG)
                            .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDataNasc)))
                    .addGroup(pnlCadCliente2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(pnlCadCliente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCEP)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(pnlCadCliente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBairro)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCidade)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCidade1)
                    .addComponent(cbbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCadCliente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCadCliente2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlCadCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCadCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClienteSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteSairActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnClienteSairActionPerformed

    private void btnClienteSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteSalvarActionPerformed
        DAOCliente qry = new DAOCliente();
        if (press_edit == false){ //SALVA
            if(txtCodigo.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Código é obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtCodigo.requestFocus();
            }else if(txtNome.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Nome é obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtNome.requestFocus();
            }else if(txtDataNasc.getText().equals("  /  /    ")){
                JOptionPane.showMessageDialog(null, "A data é um campo obrigatório!", "Aviso", JOptionPane.WARNING_MESSAGE);
                txtDataNasc.requestFocus();
            }else{
                qry.salvar(this.getDados());
                JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso!!!");
                this.LimparCampos();
                HabilitarBotoes();
                DesabilitarCampos();
            }
        }else{  //EDITA
            qry.editar(this.getDados(), txtCodigo.getText());
            JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!!!");
            press_edit = false;
            this.LimparCampos();
            HabilitarBotoes();
            DesabilitarCampos();
        }
    }//GEN-LAST:event_btnClienteSalvarActionPerformed
    
    
    private void btnClienteInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteInserirActionPerformed
        HabilitarCampos();
        DesabilitarBotoes();
        txtCodigo.requestFocus();
    }//GEN-LAST:event_btnClienteInserirActionPerformed

    private void btnClienteDesfazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteDesfazerActionPerformed
        LimparCampos();
        DesabilitarCampos();
        HabilitarBotoes();
        press_edit = false;
    }//GEN-LAST:event_btnClienteDesfazerActionPerformed

    private void btnClientePesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientePesquisarActionPerformed
        frmPesqCliente pesqCliente = new frmPesqCliente(null, rootPaneCheckingEnabled);
        pesqCliente.setVisible(true);
        Cliente cli = pesqCliente.getClienteSelecionado();
        if(cli != null){
            setDados(cli);
        }
        if(txtCodigo.getText().trim().isEmpty()){
            HabilitarBotoes();
        }else{
            btnClienteInserir.setEnabled(false);
            btnClienteEditar.setEnabled(true);
            btnClienteExcluir.setEnabled(true);
        }
    }//GEN-LAST:event_btnClientePesquisarActionPerformed

    private void btnClienteEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteEditarActionPerformed
        press_edit = true;
        DesabilitarBotoes();
        HabilitarCampos();
        txtCodigo.requestFocus(true);
    }//GEN-LAST:event_btnClienteEditarActionPerformed

    private void btnClienteExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteExcluirActionPerformed
        DAOCliente qry = new DAOCliente();
        qry.excluir(txtCodigo.getText());
        this.LimparCampos();
        HabilitarBotoes();
        JOptionPane.showMessageDialog(null, "Cliente Excluído com Sucesso!!!");
    }//GEN-LAST:event_btnClienteExcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmCadCliente dialog = new frmCadCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnClienteDesfazer;
    private javax.swing.JButton btnClienteEditar;
    private javax.swing.JButton btnClienteExcluir;
    private javax.swing.JButton btnClienteInserir;
    private javax.swing.JButton btnClientePesquisar;
    private javax.swing.JButton btnClienteSair;
    private javax.swing.JButton btnClienteSalvar;
    private javax.swing.JComboBox<String> cbbEstado;
    private javax.swing.JRadioButton jrbFem;
    private javax.swing.JRadioButton jrbMasc;
    private javax.swing.JSeparator jspCliente1;
    private javax.swing.JSeparator jspCliente2;
    private javax.swing.JLabel lblBairro;
    private javax.swing.JLabel lblCEP;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblCidade1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDataNasc;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblRG;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JPanel pnlCadCliente1;
    private javax.swing.JPanel pnlCadCliente2;
    private javax.swing.JPanel pnlSexo;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JFormattedTextField txtDataNasc;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtRG;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
