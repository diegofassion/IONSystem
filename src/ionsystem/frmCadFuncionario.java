package ionsystem;

import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public class frmCadFuncionario extends javax.swing.JDialog {
    private boolean press_edit;
    
    public frmCadFuncionario(java.awt.Frame parent, boolean modal) {
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
        txtCodigoFunc.setText("");
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
        btnFuncInserir.setEnabled(true);
        btnFuncEditar.setEnabled(false);
        btnFuncExcluir.setEnabled(false);
        btnFuncPesquisar.setEnabled(true);
        btnFuncDesfazer.setEnabled(false);
        btnFuncSalvar.setEnabled(false);
        btnFuncSair.setEnabled(true);
    }
    
    public void DesabilitarBotoes(){
        btnFuncInserir.setEnabled(false);
        btnFuncEditar.setEnabled(false);
        btnFuncExcluir.setEnabled(false);
        btnFuncPesquisar.setEnabled(false);
        btnFuncDesfazer.setEnabled(true);
        btnFuncSalvar.setEnabled(true);
        btnFuncSair.setEnabled(false);
    }
        
    private void HabilitarCampos(){
        txtCodigoFunc.setEnabled(true);
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
        txtCodigoFunc.setEnabled(false);
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
    
    private Funcionario getDados(){
        Funcionario a = new Funcionario();
        a.setCod_Funcionario(Integer.parseInt(txtCodigoFunc.getText()));
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
            java.util.logging.Logger.getLogger(frmCadFuncionario.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private void setDados(Funcionario a){
        txtCodigoFunc.setText(String.valueOf(a.getCod_Funcionario()));
        txtNome.setText(a.getNome());
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        data.setCalendar(a.getData_Nasc());
        txtDataNasc.setText(data.format(a.getData_Nasc().getTime()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCadFunc1 = new javax.swing.JPanel();
        btnFuncExcluir = new javax.swing.JButton();
        btnFuncInserir = new javax.swing.JButton();
        btnFuncEditar = new javax.swing.JButton();
        btnFuncPesquisar = new javax.swing.JButton();
        btnFuncSair = new javax.swing.JButton();
        jspCliente2 = new javax.swing.JSeparator();
        jspCliente1 = new javax.swing.JSeparator();
        btnFuncSalvar = new javax.swing.JButton();
        btnFuncDesfazer = new javax.swing.JButton();
        pnlCadFunc2 = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        txtCodigoFunc = new javax.swing.JTextField();
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
        setTitle("Cadastro de Funcionário");
        setResizable(false);

        pnlCadFunc1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnFuncExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Excluir.png"))); // NOI18N
        btnFuncExcluir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFuncExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFuncExcluir.setOpaque(false);
        btnFuncExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncExcluirActionPerformed(evt);
            }
        });

        btnFuncInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Inserir.png"))); // NOI18N
        btnFuncInserir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFuncInserir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFuncInserir.setOpaque(false);
        btnFuncInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncInserirActionPerformed(evt);
            }
        });

        btnFuncEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Editar.png"))); // NOI18N
        btnFuncEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFuncEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFuncEditar.setOpaque(false);
        btnFuncEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncEditarActionPerformed(evt);
            }
        });

        btnFuncPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Pesquisar.png"))); // NOI18N
        btnFuncPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFuncPesquisar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFuncPesquisar.setOpaque(false);
        btnFuncPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncPesquisarActionPerformed(evt);
            }
        });

        btnFuncSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Sair.png"))); // NOI18N
        btnFuncSair.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFuncSair.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFuncSair.setOpaque(false);
        btnFuncSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncSairActionPerformed(evt);
            }
        });

        jspCliente2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jspCliente1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btnFuncSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar.png"))); // NOI18N
        btnFuncSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFuncSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFuncSalvar.setOpaque(false);
        btnFuncSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncSalvarActionPerformed(evt);
            }
        });

        btnFuncDesfazer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Desfazer.png"))); // NOI18N
        btnFuncDesfazer.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnFuncDesfazer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnFuncDesfazer.setOpaque(false);
        btnFuncDesfazer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncDesfazerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCadFunc1Layout = new javax.swing.GroupLayout(pnlCadFunc1);
        pnlCadFunc1.setLayout(pnlCadFunc1Layout);
        pnlCadFunc1Layout.setHorizontalGroup(
            pnlCadFunc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadFunc1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFuncInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFuncEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFuncExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFuncSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnFuncDesfazer, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jspCliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFuncPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jspCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFuncSair, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        pnlCadFunc1Layout.setVerticalGroup(
            pnlCadFunc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCadFunc1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCadFunc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jspCliente2)
                    .addComponent(btnFuncPesquisar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnFuncExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFuncSair, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jspCliente1)
                    .addComponent(btnFuncSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFuncDesfazer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFuncEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnFuncInserir, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlCadFunc2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCodigo.setText("Código:");

        txtCodigoFunc.setToolTipText("");

        lblNome.setText("Nome:");

        txtNome.setToolTipText("");

        pnlSexo.setBorder(javax.swing.BorderFactory.createTitledBorder("Sexo"));

        jrbMasc.setText("Masculino");

        jrbFem.setText("Feminino");
        jrbFem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbFemActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout pnlCadFunc2Layout = new javax.swing.GroupLayout(pnlCadFunc2);
        pnlCadFunc2.setLayout(pnlCadFunc2Layout);
        pnlCadFunc2Layout.setHorizontalGroup(
            pnlCadFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadFunc2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlCadFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCadFunc2Layout.createSequentialGroup()
                        .addComponent(lblCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(lblNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCadFunc2Layout.createSequentialGroup()
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
                    .addGroup(pnlCadFunc2Layout.createSequentialGroup()
                        .addGroup(pnlCadFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCadFunc2Layout.createSequentialGroup()
                                .addComponent(lblBairro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCadFunc2Layout.createSequentialGroup()
                                .addComponent(lblEndereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCEP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCadFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCadFunc2Layout.createSequentialGroup()
                                .addComponent(lblCidade1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCadFunc2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(lblTelefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCadFunc2Layout.setVerticalGroup(
            pnlCadFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadFunc2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlCadFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlCadFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCadFunc2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(pnlCadFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCPF)
                            .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRG)
                            .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDataNasc)))
                    .addGroup(pnlCadFunc2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(pnlCadFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCEP)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(pnlCadFunc2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
            .addComponent(pnlCadFunc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlCadFunc2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlCadFunc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCadFunc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFuncSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncSairActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnFuncSairActionPerformed

    private void jrbFemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbFemActionPerformed

    }//GEN-LAST:event_jrbFemActionPerformed

    private void btnFuncSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncSalvarActionPerformed
        DAOFuncionario qry = new DAOFuncionario();
        if (press_edit == false){ //SALVA
            if(txtCodigoFunc.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Código é obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtCodigoFunc.requestFocus();
            }else if(txtNome.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "Nome é obrigatório!!!","Aviso",JOptionPane.WHEN_IN_FOCUSED_WINDOW);
                txtNome.requestFocus();
            }else if(txtDataNasc.getText().equals("  /  /    ")){
                JOptionPane.showMessageDialog(null, "A data é um campo obrigatório!", "Aviso", JOptionPane.WARNING_MESSAGE);
                txtDataNasc.requestFocus();
            }else{
                qry.salvar(this.getDados());
                JOptionPane.showMessageDialog(null, "Funcionário inserido com sucesso!!!");
                this.LimparCampos();
                HabilitarBotoes();
                DesabilitarCampos();
            }
        }else{   //EDITA
            qry.editar(this.getDados(), txtCodigoFunc.getText());
            JOptionPane.showMessageDialog(null, "Funcionário editado com sucesso!!!");
            press_edit = false;
            this.LimparCampos();
            HabilitarBotoes();
            DesabilitarCampos();
        }
    }//GEN-LAST:event_btnFuncSalvarActionPerformed

    private void btnFuncInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncInserirActionPerformed
        HabilitarCampos();
        DesabilitarBotoes();
        txtCodigoFunc.requestFocus();
    }//GEN-LAST:event_btnFuncInserirActionPerformed

    private void btnFuncDesfazerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncDesfazerActionPerformed
        LimparCampos();
        DesabilitarCampos();
        HabilitarBotoes();
        press_edit = false;
    }//GEN-LAST:event_btnFuncDesfazerActionPerformed

    private void btnFuncPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncPesquisarActionPerformed
        frmPesqFuncionario pesqFuncionario = new frmPesqFuncionario(null, rootPaneCheckingEnabled);
        pesqFuncionario.setVisible(true);
        Funcionario func = pesqFuncionario.getFuncionarioSelecionado();
        if(func != null){
            setDados(func);
        }
        if(txtCodigoFunc.getText().trim().isEmpty()){
            HabilitarBotoes();
        }else{
            btnFuncInserir.setEnabled(false);
            btnFuncEditar.setEnabled(true);
            btnFuncExcluir.setEnabled(true);
        }
    }//GEN-LAST:event_btnFuncPesquisarActionPerformed

    private void btnFuncEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncEditarActionPerformed
        press_edit = true;
        DesabilitarBotoes();
        HabilitarCampos();
        txtCodigoFunc.requestFocus(true);
    }//GEN-LAST:event_btnFuncEditarActionPerformed

    private void btnFuncExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncExcluirActionPerformed
        DAOFuncionario qry = new DAOFuncionario();
        qry.excluir(txtCodigoFunc.getText());
        this.LimparCampos();
        HabilitarBotoes();
        JOptionPane.showMessageDialog(null, "Funcionario Excluído com Sucesso!!!");
    }//GEN-LAST:event_btnFuncExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(frmCadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCadFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmCadFuncionario dialog = new frmCadFuncionario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnFuncDesfazer;
    private javax.swing.JButton btnFuncEditar;
    private javax.swing.JButton btnFuncExcluir;
    private javax.swing.JButton btnFuncInserir;
    private javax.swing.JButton btnFuncPesquisar;
    private javax.swing.JButton btnFuncSair;
    private javax.swing.JButton btnFuncSalvar;
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
    private javax.swing.JPanel pnlCadFunc1;
    private javax.swing.JPanel pnlCadFunc2;
    private javax.swing.JPanel pnlSexo;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCEP;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCodigoFunc;
    private javax.swing.JFormattedTextField txtDataNasc;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JFormattedTextField txtRG;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
