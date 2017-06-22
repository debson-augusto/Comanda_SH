/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Model.Produto_Pedido;
import Model.Produto_PedidoDAO;
import Model.Produtos;
import Model.ProdutosDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author batman
 */
public class FormProdutos_Pedido extends javax.swing.JFrame {

    /**
     * Creates new form Produtos_Pedido
     */
    DefaultListModel lstModel;
    boolean apagar = false;
    int iIDComanda = 0;
    FormComanda form;

    String CADASTRO_EFET, ERRO_ADD_PROD, FORM_PRINCIPAL, ERRO_TABLE;

    public FormProdutos_Pedido(int id_com, FormComanda frm, String Idioma, String Pais) throws Exception {
        initComponents();
        Translate(Idioma, Pais);
        lstModel = new DefaultListModel();
        Load();
        iIDComanda = id_com;
        form = frm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProdPedido = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtQuant = new javax.swing.JTextField();
        lblQtde = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProd_Pedidos = new javax.swing.JTable();
        lblListaprodu = new javax.swing.JLabel();
        lblValor1 = new javax.swing.JLabel();
        lblValor2 = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produtos - Pedido");
        setAlwaysOnTop(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblProdPedido.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        lblProdPedido.setForeground(new java.awt.Color(254, 254, 254));
        lblProdPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProdPedido.setText("Produtos para Pedido");
        getContentPane().add(lblProdPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 6, 381, 42));

        lblID.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 250, 250));
        lblID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblID.setText("ID");
        getContentPane().add(lblID, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 54, 89, 36));

        txtID.setEnabled(false);
        txtID.setFocusable(false);
        txtID.setMaximumSize(new java.awt.Dimension(10, 28));
        getContentPane().add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 96, 89, 36));

        txtQuant.setEnabled(false);
        txtQuant.setMaximumSize(new java.awt.Dimension(10, 28));
        txtQuant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQuantKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtQuantKeyPressed(evt);
            }
        });
        getContentPane().add(txtQuant, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 180, 89, 36));

        lblQtde.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblQtde.setForeground(new java.awt.Color(255, 250, 250));
        lblQtde.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQtde.setText("Quant");
        getContentPane().add(lblQtde, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 138, 89, 36));

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Create.png"))); // NOI18N
        btnAdd.setText("Adicionar");
        btnAdd.setEnabled(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 138, 90, 78));

        txtNome.setEnabled(false);
        txtNome.setFocusable(false);
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 96, 288, 36));

        lblNome.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 250, 250));
        lblNome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNome.setText("Nome");
        getContentPane().add(lblNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 54, 276, 36));

        tblProd_Pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "COD", "Nome", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProd_Pedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProd_PedidosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProd_Pedidos);
        if (tblProd_Pedidos.getColumnModel().getColumnCount() > 0) {
            tblProd_Pedidos.getColumnModel().getColumn(0).setMinWidth(50);
            tblProd_Pedidos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblProd_Pedidos.getColumnModel().getColumn(0).setMaxWidth(50);
            tblProd_Pedidos.getColumnModel().getColumn(2).setMinWidth(100);
            tblProd_Pedidos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblProd_Pedidos.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 246, 381, 120));

        lblListaprodu.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        lblListaprodu.setForeground(new java.awt.Color(254, 254, 254));
        lblListaprodu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblListaprodu.setText("Lista de Produtos");
        getContentPane().add(lblListaprodu, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 222, 381, 18));

        lblValor1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblValor1.setForeground(new java.awt.Color(255, 250, 250));
        lblValor1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValor1.setText("Total");
        getContentPane().add(lblValor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 138, 89, 36));

        lblValor2.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        lblValor2.setForeground(new java.awt.Color(255, 250, 250));
        lblValor2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValor2.setText("Valor");
        getContentPane().add(lblValor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 138, 89, 36));

        txtValor.setEnabled(false);
        txtValor.setFocusable(false);
        txtValor.setMaximumSize(new java.awt.Dimension(10, 28));
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 180, 89, 36));

        txtTotal.setEnabled(false);
        txtTotal.setFocusable(false);
        txtTotal.setMaximumSize(new java.awt.Dimension(10, 28));
        getContentPane().add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 180, 89, 36));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/background.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 520, 410));

        setBounds(0, 0, 410, 409);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            Produto_Pedido ProdPed = new Produto_Pedido();
            Produto_PedidoDAO pDAO = new Produto_PedidoDAO();

            ProdPed.setId_Produto(Integer.parseInt(txtID.getText()));
            ProdPed.setId_comanda(iIDComanda);
            ProdPed.setQuantidade(Integer.parseInt(txtQuant.getText()));
            double total = ((Double.parseDouble(txtQuant.getText())) * (Double.parseDouble(txtValor.getText())));
            ProdPed.setValor(total);

            //Inserindo no Banco o Obj
            pDAO.addEntity(ProdPed);
            JOptionPane.showMessageDialog(rootPane, CADASTRO_EFET);

            form.Load();
            form.atualiza();

            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, ERRO_ADD_PROD + "\n" + e.getMessage(),
                    FORM_PRINCIPAL, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblProd_PedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProd_PedidosMouseClicked
        btnAdd.setEnabled(true);
        MoverTable(tblProd_Pedidos.getSelectedRow());
        txtQuant.setText("");
        txtTotal.setText("");
        txtQuant.setEnabled(true);
        txtQuant.isFocusable();

        //JOptionPane.showMessageDialog(rootPane, (int) tblShow.getValueAt(tblShow.getSelectedRow(), 0));
    }//GEN-LAST:event_tblProd_PedidosMouseClicked

    private void txtQuantKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantKeyTyped

        //System.out.println(evt.getKeyChar());
        int xKey = Character.getNumericValue(evt.getKeyChar());
        double qtde = 0;
        double tbValue = ((double) tblProd_Pedidos.getValueAt(tblProd_Pedidos.getSelectedRow(), 2));

        if ((xKey >= 0) && (xKey <= 9)) {
            if (txtQuant.getText().isEmpty()) {
                qtde = Double.valueOf(xKey);
            } else {
                qtde = Double.valueOf(txtQuant.getText() + String.valueOf(xKey));
            }

            txtTotal.setText(String.valueOf(qtde * tbValue));

        } else if (apagar == true) {
            if (txtQuant.getText().length() > 0) {
                int tamanho = txtQuant.getText().length();

                qtde = Double.valueOf(txtQuant.getText().substring(0, (tamanho)));

                txtTotal.setText(String.valueOf(qtde * tbValue));
            } else {
                txtTotal.setText("");
            }
        } else {
            evt.consume();
        }
    }//GEN-LAST:event_txtQuantKeyTyped

    private void txtQuantKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQuantKeyPressed
        apagar = (evt.getKeyCode() == 8);
    }//GEN-LAST:event_txtQuantKeyPressed

    /**
     * @param args the command line arguments
     */
    public void Load() throws SQLException, Exception {

        try {
            ProdutosDAO pDAO = new ProdutosDAO();
            List<Produtos> lstProdutos = pDAO.getAllEntity();
            DefaultTableModel tablemd = (DefaultTableModel) tblProd_Pedidos.getModel();
            tablemd.getDataVector().removeAllElements();
            if (lstProdutos.size() > 0) {
                for (Produtos Produtos : lstProdutos) {
                    tablemd.addRow(new Object[]{Produtos.getId(), Produtos.getNome(), Produtos.getPreco()});
                }
                tblProd_Pedidos.clearSelection();
            }
            tblProd_Pedidos.updateUI();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ERRO_TABLE);
        }
    }

    public void MoverTable(int i) {

        try {
            txtID.setText(String.valueOf(tblProd_Pedidos.getValueAt(i, 0)));
            txtNome.setText(String.valueOf(tblProd_Pedidos.getValueAt(i, 1)));
            txtValor.setText(String.valueOf(tblProd_Pedidos.getValueAt(i, 2)));
        } catch (Exception e) {

        }

    }

    private void Translate(String Idioma, String Pais) {

        Locale Us = new Locale(Idioma, Pais);
        Locale.setDefault(Us);

        ResourceBundle propriedades = ResourceBundle.getBundle("Internacionalização/appstrings");
        //aqui traduzindo elementos da janela principal
        lblProdPedido.setText(propriedades.getString("ProdPedido"));
        lblID.setText(propriedades.getString("ProdPedID"));
        lblNome.setText(propriedades.getString("ProdPedName"));
        lblQtde.setText(propriedades.getString("Quant"));
        lblValor2.setText(propriedades.getString("Valor"));
        lblValor1.setText(propriedades.getString("TotProdPed"));
        lblListaprodu.setText(propriedades.getString("ListaProdPed"));
        btnAdd.setText(propriedades.getString("AddProd"));

        CADASTRO_EFET = propriedades.getString("Prod_add");
        ERRO_ADD_PROD = propriedades.getString("product_error");
        FORM_PRINCIPAL = propriedades.getString("Main_Form");
        ERRO_TABLE = propriedades.getString("Erro_table");

        tblProd_Pedidos.getColumnModel().getColumn(0).setHeaderValue(propriedades.getString("COD"));
        tblProd_Pedidos.getColumnModel().getColumn(1).setHeaderValue(propriedades.getString("Name"));
        tblProd_Pedidos.getColumnModel().getColumn(2).setHeaderValue(propriedades.getString("Price"));
        tblProd_Pedidos.getTableHeader().repaint();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblListaprodu;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblProdPedido;
    private javax.swing.JLabel lblQtde;
    private javax.swing.JLabel lblValor1;
    private javax.swing.JLabel lblValor2;
    private javax.swing.JTable tblProd_Pedidos;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtQuant;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}