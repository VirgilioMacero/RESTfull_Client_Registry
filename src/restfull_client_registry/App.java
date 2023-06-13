/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package restfull_client_registry;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import org.json.simple.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Virgilio
 */
public class App extends javax.swing.JFrame {

    public ListUser ListaUsuarios = new ListUser();

    public String DefaultImage = "C:\\Users\\Virgilio\\Documents\\Proyectos Universidad UJAP\\RESTfull_Client_Registry\\src\\restfull_client_registry\\Images\\DefaultUserLogo.jpg";

    public String NewImage;

    public App() throws IOException, ParseException {

        super("CRUD With Java on Windows");

        initComponents();

        BtnDelete.setEnabled(false);

        try {

            ListaUsuarios.loadUsers();

            ListaUsuarios.getUsuarios().forEach(user -> LoadTable(user));

        } catch (ParseException e) {

            System.err.println(e);
        }

        scaleImage(DefaultImage);

        scaleButtons();

    }

    public void LoadTable(User usuario) {

        DefaultTableModel model = (DefaultTableModel) LstSelectUser.getModel();

        Vector row = new Vector();
        row.add(usuario.getName());
        row.add(usuario.getLastName());
        row.add(usuario.getCedula());

        model.addRow(row);

    }

    public void clearTable() {

        DefaultTableModel model = (DefaultTableModel) LstSelectUser.getModel();
        model.setRowCount(0);

    }

    public void scaleButtons() throws IOException {

        Image SaveImage = new ImageIcon("C:\\Users\\Virgilio\\Documents\\Proyectos Universidad UJAP\\RESTfull_Client_Registry\\src\\restfull_client_registry\\Images\\BtnSave.png").getImage();

        Image EditImage = new ImageIcon("C:\\Users\\Virgilio\\Documents\\Proyectos Universidad UJAP\\RESTfull_Client_Registry\\src\\restfull_client_registry\\Images\\EditIcon.png").getImage();

        Image DeleteImage = new ImageIcon("C:\\Users\\Virgilio\\Documents\\Proyectos Universidad UJAP\\RESTfull_Client_Registry\\src\\restfull_client_registry\\Images\\Delete.png").getImage();

        ImageIcon DeleteIcon = new ImageIcon(DeleteImage.getScaledInstance(BtnDelete.getWidth(), BtnDelete.getHeight(), Image.SCALE_SMOOTH));

        ImageIcon EditIcon = new ImageIcon(EditImage.getScaledInstance(BtnEdit.getWidth(), BtnEdit.getHeight(), Image.SCALE_SMOOTH));

        ImageIcon SaveIcon = new ImageIcon(SaveImage.getScaledInstance(BtnSave.getWidth(), BtnSave.getHeight(), Image.SCALE_SMOOTH));

        BtnDelete.setIcon(DeleteIcon);
        BtnEdit.setIcon(EditIcon);
        BtnSave.setIcon(SaveIcon);

    }

    public void scaleImage(String Img) throws IOException {

        LineBorder Line = new LineBorder(Color.BLACK, 2, true);

        LblPerfilImage.setBorder(Line);

        BufferedImage image = ImageIO.read(new File(Img));

        Image ImageResized = image.getScaledInstance(LblPerfilImage.getWidth(), LblPerfilImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ResizedIcon = new ImageIcon(ImageResized);
        LblPerfilImage.setIcon(ResizedIcon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LblPerfilImage = new javax.swing.JLabel();
        BtnSelectPicture = new com.k33ptoo.components.KButton();
        TxtName = new jcmouse.materialdesign.TextInput();
        TxtLastName = new jcmouse.materialdesign.TextInput();
        TxtCedula = new jcmouse.materialdesign.TextInput();
        DTPFechaNacimiento = new com.github.lgooddatepicker.components.DatePicker();
        TxtPhone = new jcmouse.materialdesign.TextInput();
        jLabel1 = new javax.swing.JLabel();
        TxtMail = new jcmouse.materialdesign.TextInput();
        BtnSave = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        LstSelectUser = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        LblPerfilImage.setAlignmentX(0.5F);
        LblPerfilImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        BtnSelectPicture.setText("Seleccionar");
        BtnSelectPicture.setkBackGroundColor(new java.awt.Color(51, 153, 255));
        BtnSelectPicture.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        BtnSelectPicture.setkHoverStartColor(new java.awt.Color(51, 153, 255));
        BtnSelectPicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSelectPictureActionPerformed(evt);
            }
        });

        TxtName.setColorPrimary(new java.awt.Color(255, 255, 255));
        TxtName.setHint("Nombre");
        TxtName.setMaxLength(50);

        TxtLastName.setColorPrimary(new java.awt.Color(255, 255, 255));
        TxtLastName.setHint("Apellido");
        TxtLastName.setMaxLength(50);

        TxtCedula.setColorPrimary(new java.awt.Color(255, 255, 255));
        TxtCedula.setHint("Cedula");
        TxtCedula.setMaxLength(8);

        TxtPhone.setColorPrimary(new java.awt.Color(255, 255, 255));
        TxtPhone.setHint("Telefono");
        TxtPhone.setMaxLength(12);

        jLabel1.setText("Fecha de Nacimiento");
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));

        TxtMail.setColorPrimary(new java.awt.Color(255, 255, 255));
        TxtMail.setHint("Correo");
        TxtMail.setMaxLength(50);

        BtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSaveActionPerformed(evt);
            }
        });

        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });

        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnSelectPicture, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LblPerfilImage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtLastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtCedula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtPhone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DTPFechaNacimiento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtMail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(60, 60, 60))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(LblPerfilImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnSelectPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DTPFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TxtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        LstSelectUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Cedula"
            }
        ));
        LstSelectUser.setVerifyInputWhenFocusTarget(false);
        LstSelectUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LstSelectUserMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(LstSelectUser);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSelectPictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSelectPictureActionPerformed

        JFileChooser FileChooser = new JFileChooser();
        FileChooser.showOpenDialog(this);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("IMAGES ONLY", "jpg", "png", "jpeg");
        FileChooser.setFileFilter(filter);
        FileChooser.addChoosableFileFilter(filter);

        File Picture = FileChooser.getSelectedFile();

        try {

            if (filter.accept(Picture)) {
                NewImage = Picture.getAbsolutePath();
                scaleImage(Picture.getAbsolutePath());

            } else {

                JOptionPane.showMessageDialog(this, "Solo Puede Ingresar fotos por este medio");

            }

        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_BtnSelectPictureActionPerformed

    private void LstSelectUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LstSelectUserMouseClicked

        System.out.println(LstSelectUser.getSelectedRow());

        int fila = LstSelectUser.getSelectedRow();

        ListaUsuarios.getUsuarios().forEach(user -> {
            try {
                Buscar(user, fila);
            } catch (IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        });


    }//GEN-LAST:event_LstSelectUserMouseClicked

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed

        ListaUsuarios.getUsuarios().forEach(user -> {
            try {
                Eliminar(user);

            } catch (IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        try {
            ListaUsuarios.loadUsers();
        } catch (IOException | ParseException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        clearTable();
        try {
            CleanControls();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        ListaUsuarios.getUsuarios().forEach(user -> LoadTable(user));


    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        try {
            CleanControls();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnEditActionPerformed

    private void BtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSaveActionPerformed

        try {
            save();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ListaUsuarios.loadUsers();
        } catch (IOException | ParseException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        clearTable();
        ListaUsuarios.getUsuarios().forEach(user -> LoadTable(user));

    }//GEN-LAST:event_BtnSaveActionPerformed

    public void save() throws MalformedURLException, IOException {

        String name = TxtName.getText();
        String cedula = TxtCedula.getText();
        String lastName = TxtLastName.getText();
        String Tlf = TxtPhone.getText();
        String mail = TxtMail.getText();
        LocalDate Fecha = DTPFechaNacimiento.getDate();

        if (!name.equals("") && !cedula.equals("") && !lastName.equals("") && NewImage != null && !Tlf.equals("") && !mail.equals("") && Fecha != null) {

            if ((Fecha.compareTo(LocalDate.now())) < 0) {

                User Temp = new User(WIDTH, name, lastName, cedula, Fecha.toString(), NewImage, Tlf, mail);

                ListaUsuarios.saveUser(Temp);

                System.out.println("Saved User");

                CleanControls();

            } else {

                JOptionPane.showMessageDialog(rootPane, "Debe ingresar una fecha menor a el dia de hoy");

            }

        } else {

            JOptionPane.showMessageDialog(rootPane, "Falto alguna casilla Rellenar Info");

        }

    }

    public void Eliminar(User Usuario) throws IOException, ParseException {

        if (Integer.parseInt(TxtCedula.getText()) == Usuario.getCedula()) {

            ListaUsuarios.deleteUser(Usuario);

        }

    }

    public void Buscar(User usuario, int fila) throws IOException {

        if ((int) LstSelectUser.getValueAt(fila, 2) == usuario.getCedula()) {

            TxtCedula.setText("" + usuario.getCedula());
            TxtName.setText(usuario.getName());
            TxtLastName.setText(usuario.getLastName());
            TxtPhone.setText(usuario.getPhone());
            try {
                scaleImage(usuario.getDirectory());
                NewImage = usuario.getDirectory();
            } catch (Exception e) {

                scaleImage(DefaultImage);
                NewImage = null;

            }

            TxtMail.setText(usuario.getMail());
            try {
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
                LocalDateTime dateTime1 = LocalDateTime.parse(usuario.getFechaNacimiento(), format);
                DTPFechaNacimiento.setDate(dateTime1.toLocalDate());
            } catch (Exception e) {

                System.err.println(e);

            }

            BtnDelete.setEnabled(true);

        }

    }

    public void CleanControls() throws IOException {

        TxtCedula.setText("");
        TxtLastName.setText("");
        TxtMail.setText("");
        TxtName.setText("");
        TxtPhone.setText("");
        DTPFechaNacimiento.setText("");
        NewImage = null;
        scaleImage(DefaultImage);
        TxtName.grabFocus();
        BtnDelete.setEnabled(false);

    }

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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    try {
                        new App().setVisible(true);
                    } catch (ParseException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnSave;
    private com.k33ptoo.components.KButton BtnSelectPicture;
    private com.github.lgooddatepicker.components.DatePicker DTPFechaNacimiento;
    private javax.swing.JLabel LblPerfilImage;
    private javax.swing.JTable LstSelectUser;
    private jcmouse.materialdesign.TextInput TxtCedula;
    private jcmouse.materialdesign.TextInput TxtLastName;
    private jcmouse.materialdesign.TextInput TxtMail;
    private jcmouse.materialdesign.TextInput TxtName;
    private jcmouse.materialdesign.TextInput TxtPhone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
