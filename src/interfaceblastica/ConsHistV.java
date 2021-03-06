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
 * @author Afran
 */
public class ConsHistV extends javax.swing.JInternalFrame {
    final String banco = "jdbc:mysql://localhost/dbpowerguido";
    final String usuario = "root";
    final String senha = "";
    String user;
    Connection conexao;
    PreparedStatement sql;
    ResultSet resultado;
    public ConsHistV() throws SQLException {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbV = new javax.swing.JTable();
        cbCampo = new javax.swing.JComboBox<>();
        tfCons = new javax.swing.JTextField();
        btCons = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 245, 245));
        setClosable(true);
        setVisible(false);

        tbV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "COD", "Funcionário", "Cod F.", "Valor", "Data"
            }
        ));
        tbV.setGridColor(new java.awt.Color(230, 230, 230));
        jScrollPane1.setViewportView(tbV);
        if (tbV.getColumnModel().getColumnCount() > 0) {
            tbV.getColumnModel().getColumn(0).setPreferredWidth(45);
            tbV.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbV.getColumnModel().getColumn(2).setPreferredWidth(55);
            tbV.getColumnModel().getColumn(3).setPreferredWidth(60);
            tbV.getColumnModel().getColumn(4).setPreferredWidth(90);
        }

        cbCampo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Código F.", "Funcionário", "Data" }));

        btCons.setText("Consultar");
        btCons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Stay Classy SLDT", 1, 48)); // NOI18N
        jLabel1.setText("Histórico de Vendas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfCons)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCons)))
                        .addContainerGap())
                    .addComponent(jLabel1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCons))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsActionPerformed
        try {
            String campo = cbCampo.getSelectedItem().toString();
            DefaultTableModel model = (DefaultTableModel) tbV.getModel();
            switch(campo){
                case "Funcionário":
                sql = conexao.prepareStatement("select * from usuario as a,venda as b where a.cod = b.cod_user and a.nome like '%"+tfCons.getText()+"%' order by b.cod");
                resultado = sql.executeQuery();
                model.setNumRows(0);
                while(resultado.next()){
                    model.addRow(new Object[]{resultado.getInt("b.cod"),resultado.getString("a.nome"),resultado.getInt("a.cod"),resultado.getDouble("b.preco"),resultado.getString("b.data")});
                }break;
                case "Código":
                sql = conexao.prepareStatement("select * from usuario as a,venda as b where a.cod = b.cod_user and b.cod = "+tfCons.getText()+" order by b.cod");
                resultado = sql.executeQuery();
                model.setNumRows(0);
                while(resultado.next()){
                    model.addRow(new Object[]{resultado.getInt("b.cod"),resultado.getString("a.nome"),resultado.getInt("a.cod"),resultado.getDouble("b.preco"),resultado.getString("b.data")});
                }break;
                case "Código F.":
                sql = conexao.prepareStatement("select * from usuario as a,venda as b where a.cod = b.cod_user and a.cod = "+tfCons.getText()+" order by b.cod");
                resultado = sql.executeQuery();
                model.setNumRows(0);
                while(resultado.next()){
                    model.addRow(new Object[]{resultado.getInt("b.cod"),resultado.getString("a.nome"),resultado.getInt("a.cod"),resultado.getDouble("b.preco"),resultado.getString("b.data")});
                }break;
                case "Data":
                sql = conexao.prepareStatement("select * from usuario as a,venda as b where a.cod = b.cod_user and b.data like '%"+tfCons.getText()+"%' order by b.cod");
                resultado = sql.executeQuery();
                model.setNumRows(0);
                while(resultado.next()){
                    model.addRow(new Object[]{resultado.getInt("b.cod"),resultado.getString("a.nome"),resultado.getInt("a.cod"),resultado.getDouble("b.preco"),resultado.getString("b.data")});
                }break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsHistV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btConsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCons;
    private javax.swing.JComboBox<String> cbCampo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbV;
    private javax.swing.JTextField tfCons;
    // End of variables declaration//GEN-END:variables
}
