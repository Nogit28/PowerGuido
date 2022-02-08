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
public class CadC extends javax.swing.JInternalFrame {
    final String banco = "jdbc:mysql://localhost/dbpowerguido";
    final String usuario = "root";
    final String senha = "";
    String nomeP;
    Connection conexao;
    PreparedStatement sql;
    ResultSet resultado,res2,res3;
    Integer codU,codC,qtd=0,codF;
    Double totalC = 0.0;
    String nomeU;
    
    public CadC() throws SQLException {
        conexao = DriverManager.getConnection(banco,usuario,senha);
        initComponents();
    }
    
    public CadC(Integer codU) throws SQLException {
        conexao = DriverManager.getConnection(banco,usuario,senha);
        this.codU = codU;
        sql = conexao.prepareStatement("select * from usuario where cod="+codU);
        resultado = sql.executeQuery();
        if(resultado!=null && resultado.next()){
            nomeU = resultado.getString("nome");
        }
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
        jTable1 = new javax.swing.JTable();
        lbFunc = new javax.swing.JLabel();
        lbProd = new javax.swing.JLabel();
        lbQtd = new javax.swing.JLabel();
        lbNomeF = new javax.swing.JLabel();
        btAdc = new javax.swing.JButton();
        tfProd = new javax.swing.JTextField();
        tfQtd = new javax.swing.JTextField();
        lbTotal = new javax.swing.JLabel();
        lbTotalP = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        tfData = new javax.swing.JTextField();
        lbCarrinho = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCompra = new javax.swing.JTable();
        btConcluir = new javax.swing.JButton();
        lbInv = new javax.swing.JLabel();
        lbDt = new javax.swing.JLabel();
        lbForn = new javax.swing.JLabel();
        tfForn = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(250, 250, 250));
        setClosable(true);

        lbFunc.setText("Funcion�rio:");

        lbProd.setText("Produto:");

        lbQtd.setText("Qtd:");

        lbNomeF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbNomeF.setText(" ");
        lbNomeF.setText(nomeU);

        btAdc.setText("Adicionar");
        btAdc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdcActionPerformed(evt);
            }
        });

        lbTotal.setText("Total: R$");

        lbTotalP.setText("0.00");

        lbData.setText("Data:");

        tfData.setText("dd/mm/aaaa");

        lbCarrinho.setText("Carrinho:");

        tbCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Pre�o", "Qtd", "Fornecedor"
            }
        ));
        jScrollPane2.setViewportView(tbCompra);
        if (tbCompra.getColumnModel().getColumnCount() > 0) {
            tbCompra.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbCompra.getColumnModel().getColumn(1).setPreferredWidth(35);
            tbCompra.getColumnModel().getColumn(2).setPreferredWidth(30);
            tbCompra.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        btConcluir.setText("Concluir");
        btConcluir.setEnabled(false);
        btConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConcluirActionPerformed(evt);
            }
        });

        lbInv.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbInv.setForeground(new java.awt.Color(255, 100, 100));
        lbInv.setText(" ");

        lbDt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbDt.setForeground(new java.awt.Color(255, 100, 100));
        lbDt.setText(" ");

        lbForn.setText("CNPJ do F.:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbQtd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbProd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfProd, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbInv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btConcluir)
                            .addComponent(btAdc)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTotalP))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbDt))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFunc)
                            .addComponent(lbForn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNomeF)
                            .addComponent(tfForn))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbCarrinho)
                        .addGap(0, 310, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {tfForn, tfProd, tfQtd});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbFunc)
                        .addComponent(lbNomeF))
                    .addComponent(lbCarrinho, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbForn)
                            .addComponent(tfForn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbProd)
                            .addComponent(tfProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbQtd)
                            .addComponent(tfQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAdc)
                            .addComponent(lbInv))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTotal)
                            .addComponent(lbTotalP)
                            .addComponent(lbDt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbData)
                            .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btConcluir)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAdcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdcActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) tbCompra.getModel();
            sql = conexao.prepareStatement("select max(cod) from compra");
            resultado = sql.executeQuery();
            resultado.next();
            codC = 1+resultado.getInt("max(cod)");
            sql = conexao.prepareStatement("select * from fornecedor where cnpj='"+tfForn.getText()+"'");
            res3 = sql.executeQuery();
            if(res3!=null && res3.next()){
                codF = res3.getInt("cod");
                lbInv.setText(" ");
                sql = conexao.prepareStatement("select * from produto where nome='"+tfProd.getText()+"'");
                resultado = sql.executeQuery();
                if(resultado!=null && resultado.next()){
                    if(!tfQtd.getText().equals("")){
                        qtd = Integer.parseInt(tfQtd.getText());
                        if(qtd<=0){
                            lbInv.setText("Quantidade Inv�lida!");
                        }else{
                            sql = conexao.prepareStatement("update produto set qtd=qtd+? where nome='"+tfProd.getText()+"'");
                            sql.setInt(1,qtd);
                            sql.executeUpdate();
                            sql = conexao.prepareStatement("insert into produto_compra(cod_compra,cod_prod,qt,cod_forn) values(?,?,?,?)");
                            sql.setInt(1,codC);
                            sql.setInt(2,resultado.getInt("cod"));
                            sql.setInt(3,qtd);
                            sql.setInt(4,codF);
                            sql.executeUpdate();
                            lbInv.setText(" ");
                            tfForn.setText(null);
                            tfProd.setText(null);
                            tfQtd.setText(null);
                            totalC = totalC + (resultado.getDouble("preco")*qtd);
                            lbTotalP.setText(String.valueOf(totalC));
                            btConcluir.setEnabled(true);
                            sql = conexao.prepareStatement("select a.nome,a.preco,b.qt,c.nome from produto as a,produto_compra as b,fornecedor as c where a.cod = b.cod_prod and c.cod = b.cod_forn and cod_compra="+codC);
                            res2 = sql.executeQuery();
                            model.setNumRows(0);
                            while(res2.next()){
                                model.addRow(new Object[]{res2.getString("a.nome"),res2.getDouble("a.preco"),res2.getInt("b.qt"),res2.getString("c.nome")});
                            }
                        }
                    }else{
                        lbInv.setText("Quantidade Inv�lida!");
                    }
                }else{
                    lbInv.setText("Produto Inv�lido!");
                }
            }else{
                lbInv.setText("Fornecedor Inv�lido!");
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(CadC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAdcActionPerformed

    private void btConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConcluirActionPerformed
        try {
            if(tfData.getText().equals("dd/mm/aaaa")){
                lbDt.setText("Insira a data!");
            }else{
                sql = conexao.prepareStatement("insert into compra(data,preco,cod_user) values(?,?,?)");
                sql.setString(1,tfData.getText());
                sql.setDouble(2,totalC);
                sql.setInt(3,codU);
                sql.executeUpdate();
                DefaultTableModel model = (DefaultTableModel) tbCompra.getModel();
                model.setNumRows(0);
                btConcluir.setEnabled(false);
                lbTotalP.setText("0.00");
                lbDt.setText(" ");
                tfData.setText("dd/mm/aaaa");
                totalC = 0.0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btConcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdc;
    private javax.swing.JButton btConcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbCarrinho;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbDt;
    private javax.swing.JLabel lbForn;
    private javax.swing.JLabel lbFunc;
    private javax.swing.JLabel lbInv;
    private javax.swing.JLabel lbNomeF;
    private javax.swing.JLabel lbProd;
    private javax.swing.JLabel lbQtd;
    private javax.swing.JLabel lbTotal;
    private javax.swing.JLabel lbTotalP;
    private javax.swing.JTable tbCompra;
    private javax.swing.JTextField tfData;
    private javax.swing.JTextField tfForn;
    private javax.swing.JTextField tfProd;
    private javax.swing.JTextField tfQtd;
    // End of variables declaration//GEN-END:variables
}
