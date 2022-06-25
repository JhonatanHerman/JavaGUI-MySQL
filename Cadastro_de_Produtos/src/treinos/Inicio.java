/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package treinos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.*; //é necessário esse import para a delcaração da jtable

/**
 *
 * @author jhona
 */
public class Inicio extends javax.swing.JFrame {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/produtos";
    String user = "root";
    String password = "21032003";
    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
    }
        
    
    public void Listar(){
       // conexao com o banco de dados:
       DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel(); //declaração da tabela jtable
       tblModel.setRowCount(0); //limpeza da tabela
       
       try{
           //open connection
           Class.forName(driver);
           //Conexao
           Connection con = DriverManager.getConnection(url, user, password);
           //criação do statement
           Statement st = con.createStatement();
           //mysql query
           String sql ="select * from cadastro";
           ResultSet rs = st.executeQuery(sql); 
           
           while(rs.next()){ //os dados serão buscados linha por linha, do 1 cadastro ao ultimo
               //os dados serão adicionados até o final
               String id = String.valueOf(rs.getInt("id")); //conversão int para string
               String Data = rs.getString("data"); //o que está entre aspas é a coluna no banco do mysql
               String Código = rs.getString("codigo_produto");
               String Nome = rs.getString("nome_produto");
               String Modelo = rs.getString("modelo_produto");
               String NumerodeSérie = rs.getString("numero_serie");
               String Adicional = rs.getString("adicional");
               
               String tbData[] = {id, Data, Código, Nome, Modelo, NumerodeSérie, Adicional}; 
               //pega todos os dados e coloca em um array String para ser adicionado na tabela
               
               
               
               tblModel.addRow(tbData); //adiciona na tabela em forma de row
               
            }
           
        //Fecham a conexão
        rs.close();
        st.close();      
        con.close();
        
         
        
       }catch(Exception e){
           System.out.println(e.getMessage());
       }
    } //fim metodo listar
    
    private int cadastrar(String data, String codigo, String nome, String modelo, String numero, String adicional) {
        int resultado=0;
        
        try {
            Class.forName(driver);
            String query = "INSERT INTO `produtos`.`cadastro` (`data`, `codigo_produto`, `nome_produto`, `modelo_produto`, `numero_serie`, `adicional`) VALUES "
                            + "('"+data+"', '"+codigo+"', '"+nome+"' , '"+modelo+"' , '"+numero+"' , '"+adicional+"');";
            try {
                Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                resultado = st.executeUpdate(query);
                st.close();
                con.close();

            } catch (SQLException e) {
                System.out.println(e);
            }

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return resultado;
	}
    
    
    
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelPrincipal = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        BotCadastro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        CodProd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Data = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        NomeProd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Adicional = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        NumSerie = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ModelProd = new javax.swing.JTextField();
        listar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        BotMoviment = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro");
        setMinimumSize(new java.awt.Dimension(960, 720));

        PainelPrincipal.setPreferredSize(new java.awt.Dimension(960, 720));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Código do Produto:");

        BotCadastro.setText("Cadastrar");
        BotCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotCadastroActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Data", "Código ", "Nome", "Modelo", "Numero de Série", "Adicional"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        CodProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodProdActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nome do Produto:");

        Data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Data:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Adicional");

        Adicional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionalActionPerformed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Modelo do Produto:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Número de Série:");

        listar.setText("Listar produtos");
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarActionPerformed(evt);
            }
        });

        PainelPrincipal.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelPrincipal.setLayer(BotCadastro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelPrincipal.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelPrincipal.setLayer(CodProd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelPrincipal.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelPrincipal.setLayer(Data, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelPrincipal.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelPrincipal.setLayer(NomeProd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelPrincipal.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelPrincipal.setLayer(Adicional, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelPrincipal.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelPrincipal.setLayer(NumSerie, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelPrincipal.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelPrincipal.setLayer(ModelProd, javax.swing.JLayeredPane.DEFAULT_LAYER);
        PainelPrincipal.setLayer(listar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout PainelPrincipalLayout = new javax.swing.GroupLayout(PainelPrincipal);
        PainelPrincipal.setLayout(PainelPrincipalLayout);
        PainelPrincipalLayout.setHorizontalGroup(
            PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelPrincipalLayout.createSequentialGroup()
                .addGroup(PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NomeProd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CodProd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Data)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Adicional, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NumSerie)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ModelProd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelPrincipalLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(listar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(BotCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                .addContainerGap())
        );
        PainelPrincipalLayout.setVerticalGroup(
            PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                    .addGroup(PainelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CodProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NomeProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ModelProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NumSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Adicional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotCadastro)
                            .addComponent(listar))))
                .addContainerGap())
        );

        jMenu.setText("Menu");
        jMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuActionPerformed(evt);
            }
        });

        BotMoviment.setText("Movimentação");
        BotMoviment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotMovimentActionPerformed(evt);
            }
        });
        jMenu.add(BotMoviment);

        jMenuBar1.add(jMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotCadastroActionPerformed
        String data = Data.getText();
        String codigo = CodProd.getText();
        String nome = NomeProd.getText();
        String modelo = ModelProd.getText();
        String numero = NumSerie.getText();
        String adicional = Adicional.getText();
        int resultado = cadastrar(data, codigo, nome, modelo, numero, adicional);
        System.out.println("Resultado: "+resultado);
        Listar();
        
    }//GEN-LAST:event_BotCadastroActionPerformed

    private void CodProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CodProdActionPerformed

    private void DataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DataActionPerformed

    private void AdicionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdicionalActionPerformed

    private void jMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jMenuActionPerformed

    private void BotMovimentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotMovimentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotMovimentActionPerformed

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
       Listar(); //chama o método de listagem
    }//GEN-LAST:event_listarActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Adicional;
    private javax.swing.JButton BotCadastro;
    private javax.swing.JMenuItem BotMoviment;
    private javax.swing.JTextField CodProd;
    private javax.swing.JTextField Data;
    private javax.swing.JTextField ModelProd;
    private javax.swing.JTextField NomeProd;
    private javax.swing.JTextField NumSerie;
    private javax.swing.JDesktopPane PainelPrincipal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton listar;
    // End of variables declaration//GEN-END:variables
}
