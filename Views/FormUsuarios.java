package Views;

import Model.Users;
import Model.UsersDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author batman
 */
public class FormUsuarios extends javax.swing.JInternalFrame {

    /**
     * Creates new form FormUser
     */
    private boolean m_showGrid = true;
    private String ERRO;
    private UsersDAO m_UserC;
    private Users m_objUser = null;
    private boolean m_AlterUser = false;

    public String INFORMAR_OCUPACAO, USUARIO_INSERIDO_SUCESS, BTN_NOVO, BTN_SALVAR, ERRO_CADASTRAR;
    public String USUARIO_DUPLICADO, FORMULARIO_PRINCIPAL, WANT_DELETE;

    public void Traduz(String Idioma, String Pais) {
        Locale Us = new Locale(Idioma, Pais);
        Locale.setDefault(Us);

        ResourceBundle propriedades = ResourceBundle.getBundle("Internacionalização/appstrings");
        BTN_NOVO = propriedades.getString("NewCad").toUpperCase();
        BTN_SALVAR = propriedades.getString("SaveCad").toUpperCase();
        lblCad.setText(propriedades.getString("MDIUsers").toUpperCase());
        lblNome.setText(propriedades.getString("ProdPedName"));
        lblCPF.setText(propriedades.getString("CPF").toUpperCase());
        lblSenh.setText(propriedades.getString("Password"));
        btnEditar.setText(propriedades.getString("EditCad"));
        btnExcluir.setText(propriedades.getString("ExProd"));
        btnCancelar.setText(propriedades.getString("CancelCad"));
        lblList.setText(propriedades.getString("User_list"));
        btnADM.setText(propriedades.getString("adm"));
        btnCAIXA.setText(propriedades.getString("cashier"));
        btnGARCOM.setText(propriedades.getString("jGarCom"));
 
        INFORMAR_OCUPACAO = propriedades.getString("Cargo");
        USUARIO_INSERIDO_SUCESS = propriedades.getString("SUCESS_USER");
        ERRO_CADASTRAR = propriedades.getString("product_error");
        USUARIO_DUPLICADO = propriedades.getString("duplicate_user");
        FORMULARIO_PRINCIPAL = propriedades.getString("Main_Form");
        WANT_DELETE = propriedades.getString("Want_Delete");
        
        
        tbUsers.getColumnModel().getColumn(0).setHeaderValue(propriedades.getString("COD"));
        tbUsers.getColumnModel().getColumn(1).setHeaderValue(propriedades.getString("Name"));
        tbUsers.getColumnModel().getColumn(2).setHeaderValue(propriedades.getString("CPF"));
        tbUsers.getColumnModel().getColumn(3).setHeaderValue(propriedades.getString("perfil"));
        tbUsers.getTableHeader().repaint();
    }

    public FormUsuarios(String Idioma, String Pais) {
        initComponents();
        Traduz(Idioma, Pais);
        loadTable();
    }

    private void defaultLayout(boolean dl) {
        btnCancelar.setEnabled(!dl);
        txtUser.setText("");
        txtPass.setText("");
        txtCPF.setText("");
        txtUser.setEnabled(!dl);
        txtPass.setEnabled(!dl);
        txtCPF.setEnabled(!dl);
        btnExcluir.setEnabled(false);
        btnEditar.setEnabled(false);
        if (dl) {
            loadTable();
            btnNovo.setText(BTN_NOVO);
        } else {
            btnNovo.setText(BTN_SALVAR);
        }
    }

    private void loadTable() {
        if (m_showGrid) {
            try {
                m_UserC = new UsersDAO();
                List<Users> lstUsers = m_UserC.getAllEntitys();
                DefaultTableModel tablemd = (DefaultTableModel) tbUsers.getModel();
                tablemd.getDataVector().removeAllElements();
                if (lstUsers.size() > 0) {
                    for (Users user : lstUsers) {
                        tablemd.addRow(new Object[]{user.getId(), user.getNome(), user.getCPF(), user.getPerfil()});
                    }
                    tbUsers.clearSelection();
                }
                tbUsers.updateUI();
            } catch (Exception ex) {

            }
        }

    }

    private void AlterUser(Users usr) throws SQLException {
        m_UserC = new UsersDAO();
        m_UserC.updateEntity(usr);
    }

    private void InserirUsuario() throws Exception {
        m_UserC = new UsersDAO();
        m_objUser = new Users();
        if ((verificar()) && (!UsuarioDuplicado())) {
            m_objUser.setNome(txtUser.getText());
            m_objUser.setSenha(String.valueOf(txtPass.getPassword()));
            m_objUser.setCPF(txtCPF.getText());
            m_objUser.setCargo(Cargo());
            m_UserC.addEntity(m_objUser);

            defaultLayout(true);
            loadTable();

            JOptionPane.showMessageDialog(this, USUARIO_INSERIDO_SUCESS);
        } else {
            JOptionPane.showMessageDialog(this, ERRO);
        }

    }

    public boolean verificar() {
        if ((btnADM.isSelected()) || (btnCAIXA.isSelected()) || (btnGARCOM.isSelected())) {
            return true;
        } else {
            ERRO = INFORMAR_OCUPACAO;
            return false;
        }

    }

    private boolean UsuarioDuplicado() throws Exception {
        m_UserC = new UsersDAO();
        if (m_UserC.DuplicatedEntity(txtUser.getText())) {
            ERRO = USUARIO_DUPLICADO;
            return true;
        } else {
            return false;
        }
    }

    private int Cargo() {
        if (btnADM.isSelected()) {
            return 0;
        } else if (btnCAIXA.isSelected()) {
            return 1;
        } else {
            return 2;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblCad = new javax.swing.JLabel();
        lblList = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsers = new javax.swing.JTable();
        lblNome = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lblSenh = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        lblCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        btnADM = new javax.swing.JCheckBox();
        btnCAIXA = new javax.swing.JCheckBox();
        btnGARCOM = new javax.swing.JCheckBox();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCad.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        lblCad.setForeground(new java.awt.Color(254, 242, 242));
        lblCad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCad.setText("USUARIOS");
        getContentPane().add(lblCad, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 26));

        lblList.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        lblList.setForeground(new java.awt.Color(254, 242, 242));
        lblList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblList.setText("Lista de Usuários");
        getContentPane().add(lblList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 551, -1));

        tbUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "COD", "NOME", "CPF", "PERFIL"
            }
        ));
        tbUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsers);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 316, 560, 130));

        lblNome.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblNome.setForeground(new java.awt.Color(254, 254, 254));
        lblNome.setText("Nome");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 82, -1));

        txtUser.setEnabled(false);
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 439, -1));

        lblSenh.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblSenh.setForeground(new java.awt.Color(254, 254, 254));
        lblSenh.setText("Senha");
        getContentPane().add(lblSenh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 82, 30));

        txtPass.setAutoscrolls(false);
        txtPass.setEnabled(false);
        getContentPane().add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 160, -1));

        lblCPF.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblCPF.setForeground(new java.awt.Color(254, 254, 254));
        lblCPF.setText("CPF");
        getContentPane().add(lblCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 59, -1));

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.setEnabled(false);
        getContentPane().add(txtCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 193, -1));

        buttonGroup1.add(btnADM);
        btnADM.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnADM.setForeground(new java.awt.Color(254, 254, 254));
        btnADM.setText("Administrador");
        btnADM.setEnabled(false);
        getContentPane().add(btnADM, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        buttonGroup1.add(btnCAIXA);
        btnCAIXA.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnCAIXA.setForeground(new java.awt.Color(254, 254, 254));
        btnCAIXA.setText("Caixa");
        btnCAIXA.setEnabled(false);
        getContentPane().add(btnCAIXA, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        buttonGroup1.add(btnGARCOM);
        btnGARCOM.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        btnGARCOM.setForeground(new java.awt.Color(254, 254, 254));
        btnGARCOM.setText("Garçom");
        btnGARCOM.setEnabled(false);
        getContentPane().add(btnGARCOM, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Add-user-icon.png"))); // NOI18N
        btnNovo.setText("NOVO");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 122, 76));

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Pencil.png"))); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 122, 76));

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Delete-user-icon.png"))); // NOI18N
        btnExcluir.setText("EXCLUIR");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 122, 76));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Cancel-icon.png"))); // NOI18N
        btnCancelar.setText("CANCELAR");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, -1, 76));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/background.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-11, -152, 690, 660));

        setBounds(0, 0, 567, 486);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        if (btnNovo.getText().equals(BTN_NOVO)) {
            defaultLayout(false);
            btnADM.setEnabled(true);
            btnCAIXA.setEnabled(true);
            btnGARCOM.setEnabled(true);
            txtUser.requestFocus();
        } else if (btnNovo.getText().equals(BTN_SALVAR)) {
            if (m_AlterUser) {
                try {
                    m_objUser.setNome(txtUser.getText());
                    m_objUser.setCPF(txtCPF.getText());
                    m_objUser.setSenha(String.valueOf(txtPass.getPassword()));
                    m_objUser.setCargo(Cargo());
                    AlterUser(m_objUser);
                    loadTable();
                    defaultLayout(true);
                    m_AlterUser = false;
                } catch (Exception ex) {
                    Logger.getLogger(FormUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                try {
                    InserirUsuario();
                    loadTable();
                    defaultLayout(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ERRO_CADASTRAR + "\n" + ex.getMessage(),
                            FORMULARIO_PRINCIPAL, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            m_AlterUser = true;
            defaultLayout(false);
            txtUser.setText(m_objUser.getNome());
            txtPass.setText(m_objUser.getSenha());
            txtCPF.setText(m_objUser.getCPF());
            switch (m_objUser.getCargo()) {
                case 0:
                    btnADM.setSelected(true);
                    break;
                case 1:
                    btnCAIXA.setSelected(true);
                    break;
                default:
                    btnGARCOM.setSelected(true);
                    break;
            }
            btnCancelar.setEnabled(true);
            btnNovo.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(FormUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void tbUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsersMouseClicked
        // TODO add your handling code here:
        try {
            m_objUser = m_UserC.getEntityById((int) tbUsers.getValueAt(tbUsers.getSelectedRow(), 0));
            if (m_objUser != null) {
                defaultLayout(false);
                txtUser.setText(m_objUser.getNome());
                txtPass.setText(m_objUser.getSenha());
                txtCPF.setText(m_objUser.getCPF());
                btnNovo.setEnabled(false);

                switch (m_objUser.getCargo()) {
                    case 0:
                        btnADM.setSelected(true);
                        break;
                    case 1:
                        btnCAIXA.setSelected(true);
                        break;
                    default:
                        btnGARCOM.setSelected(true);
                        break;
                }
                txtUser.selectAll();
                txtUser.requestFocus();
                btnEditar.setEnabled(true);
                btnExcluir.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tbUsersMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int i = JOptionPane.showConfirmDialog(rootPane, WANT_DELETE);
        if (i == 0) {
            try {
                m_UserC = new UsersDAO();
                m_UserC.removeEntity(m_objUser);
                loadTable();
                defaultLayout(true);
                btnNovo.setEnabled(true);
            } catch (SQLException ex) {
                Logger.getLogger(FormUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        loadTable();
        defaultLayout(true);
        btnNovo.setEnabled(true);
        btnADM.setSelected(false);
        btnCAIXA.setSelected(false);
        btnGARCOM.setSelected(false);

    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox btnADM;
    private javax.swing.JCheckBox btnCAIXA;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JCheckBox btnGARCOM;
    private javax.swing.JButton btnNovo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCad;
    private javax.swing.JLabel lblList;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenh;
    private javax.swing.JTable tbUsers;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
