/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistema;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author JESUS EMMANUEL
 */
public class Login extends javax.swing.JFrame {
    private int contadorCaracterUsuario = 0;
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        //JOptionPane.showMessageDialog(null, "Bienvenido");
        this.cargarDatosBD();
    }
    private void cargarDatosBD(){
        
        
        try {
            String user = "root";
            String url = "jdbc:mysql://localhost:3306/";
            String password = "root";
            String bd = "requerimientos";
            String conector = "com.mysql.cj.jdbc.Driver";
            Class.forName(conector);
            Connection conexion = DriverManager.getConnection(url+bd,user,password);
            System.out.println("onexion exitosa");
            
            String query = "SELECT * FROM tipo_usuarios ";
            Statement sql = conexion.createStatement();
            ResultSet respuesta = sql.executeQuery(query);
            
            while(respuesta.next()){
                this.comboTipo.addItem(respuesta.getString(2));
            }
            conexion.close();
            
        } catch(ClassNotFoundException | SQLException message){
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, message);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        comboTipo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        btnAcceso = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Usuario :");

        jLabel2.setText("Rol :");

        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        jLabel3.setText("Password");

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });

        btnAcceso.setText("Acceso");
        btnAcceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccesoActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar");

        jLabel4.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtPassword))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUsuario)
                                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAcceso)
                        .addGap(46, 46, 46)
                        .addComponent(btnCerrar)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcceso)
                    .addComponent(btnCerrar))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        int caracterAscii = (int) evt.getKeyChar();
        if(caracterAscii == 8 && this.contadorCaracterUsuario > 0){
            this.contadorCaracterUsuario--;
        }   //numero
        if((caracterAscii > 47 && caracterAscii < 58)
                //letras minusaculas
            || (caracterAscii > 96 && caracterAscii < 123) 
                //guion bajo
            || (caracterAscii == 95)
                //letras mayusculas
            || (caracterAscii > 64 && caracterAscii < 91)){
            this.contadorCaracterUsuario++;
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        int caracterAscii = (int) evt.getKeyChar();
        if((caracterAscii > 47 && caracterAscii < 58)
                //letras minusaculas
            || (caracterAscii > 96 && caracterAscii < 123) 
                //letras mayusculas
            || (caracterAscii > 64 && caracterAscii < 91))
        {
            
        }else{
            evt.consume();
        }
        
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void btnAccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccesoActionPerformed
        try {
            String usuario, pass, tipo;
            usuario = this.txtUsuario.getText();
            pass = this.txtPassword.getText();
            tipo = this.comboTipo.getSelectedItem().toString();
            String user = "root";
            String url = "jdbc:mysql://localhost:3306/";
            String password = "root";
            String bd = "requerimientos";
            String conector = "com.mysql.cj.jdbc.Driver";
            Class.forName(conector);
            Connection conexion = DriverManager.getConnection(url+bd,user,password);
            System.out.println("conexion exitosa");
            
            String query = "SELECT * FROM usuarios where usuario = '" + usuario + "' and " +
                            "contrasena ='" + pass + "'";
            Statement sql = conexion.createStatement();
            ResultSet respuesta = sql.executeQuery(query);
            if(respuesta.next()){
                //JOptionPane.showMessageDialog(null, "El usuario se encuentra en la base de datos");
                String rol_usuario = "";
                String usuario_logeado = respuesta.getString(3);
                int tipo_usuario = respuesta.getInt(2);
                query = "SELECT nombre FROM tipo_usuarios WHERE id=" + tipo_usuario;
                respuesta = sql.executeQuery(query);
                while(respuesta.next()){
                    JOptionPane.showMessageDialog(null,respuesta.getString(1));
                    rol_usuario = respuesta.getString(1);
                }
                MDIPrincipal pr = new MDIPrincipal();
                if(rol_usuario.equals("Administrador")){
                    pr.mnuAAgregar.setEnabled(true);
                    pr.mnuActUsuarios.setEnabled(true);
                    pr.mnuEliUsuarios.setEnabled(true);
                }else{
                    pr.mnuAAgregar.setEnabled(false);
                    pr.mnuActUsuarios.setEnabled(false);
                    pr.mnuEliUsuarios.setEnabled(false);
                }
                pr.mnuEUsuario.setText(usuario_logeado);
                pr.setVisible(true);
                this.hide();
            }else{
                JOptionPane.showMessageDialog(null, "El usuario no se encontro en la base de datos");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnAccesoActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceso;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JComboBox<String> comboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
