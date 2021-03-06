/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceblastica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dicente
 */
public class ConsUser extends javax.swing.JInternalFrame {
    final String banco = "jdbc:mysql://localhost/dbpowerguido";
    final String usuario = "root";
    final String senha = "";
    String user;
    Connection conexao;
    PreparedStatement sql;
    ResultSet resultado;
    public ConsUser() throws SQLException {
        this.conexao = DriverManager.getConnection(banco,usuario,senha);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfUser = new javax.swing.JTextField();
        btConsultar = new javax.swing.JButton();
        cbCampo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbUser = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);

        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        cbCampo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Login", "Email", "CPF", "C?digo" }));
        cbCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCampoActionPerformed(evt);
            }
        });

        tbUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod", "Nome", "Login", "Email", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbUser);
        if (tbUser.getColumnModel().getColumnCount() > 0) {
            tbUser.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbUser.getColumnModel().getColumn(1).setPreferredWidth(350);
            tbUser.getColumnModel().getColumn(2).setPreferredWidth(150);
            tbUser.getColumnModel().getColumn(3).setPreferredWidth(250);
            tbUser.getColumnModel().getColumn(4).setPreferredWidth(150);
        }

        jLabel1.setFont(new java.awt.Font("Stay Classy SLDT", 1, 48)); // NOI18N
        jLabel1.setText("Funcion?rio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(tfUser)
                        .addGap(8, 8, 8)
                        .addComponent(btConsultar)))
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(235, 235, 235))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConsultar)
                    .addComponent(cbCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        try {
            String campo = cbCampo.getSelectedItem().toString();
            DefaultTableModel model = (DefaultTableModel) tbUser.getModel();
            switch(campo){
                case "Nome":
                    sql = conexao.prepareStatement("select * from usuario where nome like '%"+tfUser.getText()+"%' order by nome");
                    resultado = sql.executeQuery();
                    model.setNumRows(0);
                    while(resultado.next()){
                        model.addRow(new Object[]{resultado.getInt("cod"),resultado.getString("nome"),resultado.getString("login"),resultado.getString("email"),resultado.getString("cpf")});
                    }
                    break;
                case "C?digo":
                    sql = conexao.prepareStatement("select * from usuario where cod="+Integer.parseInt(tfUser.getText()));
                    resultado = sql.executeQuery();
                    model.setNumRows(0);
                    while(resultado.next()){
                        model.addRow(new Object[]{resultado.getInt("cod"),resultado.getString("nome"),resultado.getString("login"),resultado.getString("email"),resultado.getString("cpf")});
                    }
                    break;
                case "Login":
                    sql = conexao.prepareStatement("select * from usuario where login like '%"+tfUser.getText()+"%' order by login");
                    resultado = sql.executeQuery();
                    model.setNumRows(0);
                    while(resultado.next()){
                        model.addRow(new Object[]{resultado.getInt("cod"),resultado.getString("nome"),resultado.getString("login"),resultado.getString("email"),resultado.getString("cpf")});
                    }
                    break;
                case "Email":
                    sql = conexao.prepareStatement("select * from usuario where email like '%"+tfUser.getText()+"%'");
                    resultado = sql.executeQuery();
                    model.setNumRows(0);
                    while(resultado.next()){
                        model.addRow(new Object[]{resultado.getInt("cod"),resultado.getString("nome"),resultado.getString("login"),resultado.getString("email"),resultado.getString("cpf")});
                    }
                    break;
                case "CPF":
                    sql = conexao.prepareStatement("select * from usuario where cpf like '%"+tfUser.getText()+"%'");
                    resultado = sql.executeQuery();
                    model.setNumRows(0);
                    while(resultado.next()){
                        model.addRow(new Object[]{resultado.getInt("cod"),resultado.getString("nome"),resultado.getString("login"),resultado.getString("email"),resultado.getString("cpf")});
                    }
                    break;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btConsultarActionPerformed

    private void cbCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCampoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConsultar;
    private javax.swing.JComboBox<String> cbCampo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbUser;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}
