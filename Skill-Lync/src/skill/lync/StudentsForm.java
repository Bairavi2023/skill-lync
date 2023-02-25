/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package skill.lync;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;


/**
 *
 * @author Bairavi
 */
public class StudentsForm extends javax.swing.JFrame {

    /**
     * Creates new form StudentsForm
     */
    public StudentsForm() {
        initComponents();
   //     MySqlConnection();
         fillTable();
        resizeImageI();
    }
    public void resizeImageI(){
        ImageIcon icon=new ImageIcon("C:\\Users\\Barkavi\\Downloads\\college Logo2.jpg");
        Image img=icon.getImage();
        Image img1=img.getScaledInstance(jLabel_logo.getWidth(), jLabel_logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon=new ImageIcon(img1);
        jLabel_logo.setIcon(scaledIcon);
    }
    String photopath=null;
    public ImageIcon resizeImageI(String photopath,byte[] photo){
        ImageIcon myPhoto=null;
        if (photopath!=null) {
            myPhoto=new ImageIcon(photopath);
        }else{
            myPhoto=new ImageIcon(photo);
        }
            Image img=myPhoto.getImage();
            Image img1=img.getScaledInstance(label_photo.getWidth(), label_photo.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ph=new ImageIcon(img1); 
            return ph;
    }
    public Connection MySqlConnection(){
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","root");
          //  JOptionPane.showMessageDialog(null, "Mysql DB Connection Successful");
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Mysql DB Connection Failed");
            return null;
        }
    }
     public ArrayList<StudentBean> retrieveData(){
        ArrayList<StudentBean> al=null;
                al=new ArrayList<StudentBean>();
       
        try {
            Connection conn=MySqlConnection();
            String qry="select * from students";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            StudentBean student;
            while (rs.next()) {
                student =new StudentBean(rs.getInt(1),rs.getString("name"),Float.parseFloat(rs.getString(3)),rs.getString(4),rs.getBytes("photo"));                
                al.add(student);
              }
           
        } catch (Exception e) {
            System.out.println(e);
        }
       return al; 
    }
      public void fillTable(){
        ArrayList<StudentBean> al=retrieveData();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.setRowCount(0); // Empty/clear the table
        Object[] row=new Object[4];
        for (int i = 0; i < al.size(); i++) {
            row[0]=al.get(i).getId();
            row[1]=al.get(i).getName();
            row[2]=al.get(i).getFees();
            row[3]=al.get(i).getDob();
            model.addRow(row);
        }
        //model.setRowCount(0);
    }
       public void showItemToFields(int index){
        jTextField_id.setText(Integer.toString(retrieveData().get(index).getId()));
        jTextField_name.setText(retrieveData().get(index).getName());
        jTextField_fees.setText(Float.toString(retrieveData().get(index).getFees()));
        
        try{
            java.util.Date dob=null;
            dob=new SimpleDateFormat("dd-MM-yyyy").parse((String)retrieveData().get(index).getDob());
            jDateChooser1_dob.setDate(dob);
        }catch(ParseException e){
            //Logger.getLogger(Student_Window.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Error in showItemToFields method...");
        }
        label_photo.setIcon(resizeImageI(null, retrieveData().get(index).getPhoto()));
    }
   
   
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField_id = new javax.swing.JTextField();
        jTextField_name = new javax.swing.JTextField();
        jTextField_fees = new javax.swing.JTextField();
        jDateChooser1_dob = new com.toedter.calendar.JDateChooser();
        label_photo = new javax.swing.JLabel();
        jButton_new = new javax.swing.JButton();
        jButton_save = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField_search = new javax.swing.JTextField();
        jButton_photo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel_logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Skill-Lync Full Stack Web Development");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Chennai,Tamil nadu,India");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Student Information");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Student_id:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Student Name:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Fees:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Date of Birth:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Photo:");

        jTextField_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nameActionPerformed(evt);
            }
        });

        jDateChooser1_dob.setDateFormatString("dd-MM-yyyy");

        label_photo.setBackground(new java.awt.Color(255, 255, 255));
        label_photo.setOpaque(true);

        jButton_new.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton_new.setForeground(new java.awt.Color(0, 0, 102));
        jButton_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/check.png"))); // NOI18N
        jButton_new.setText("New");
        jButton_new.setBorderPainted(false);
        jButton_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_newActionPerformed(evt);
            }
        });

        jButton_save.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton_save.setForeground(new java.awt.Color(0, 0, 102));
        jButton_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_add.png"))); // NOI18N
        jButton_save.setText("Insert/Save");
        jButton_save.setBorderPainted(false);
        jButton_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_saveActionPerformed(evt);
            }
        });

        jButton_update.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton_update.setForeground(new java.awt.Color(0, 0, 102));
        jButton_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sync.png"))); // NOI18N
        jButton_update.setText("Update");
        jButton_update.setBorderPainted(false);
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });

        jButton_delete.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton_delete.setForeground(new java.awt.Color(0, 0, 102));
        jButton_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/erase.png"))); // NOI18N
        jButton_delete.setText("Delete");
        jButton_delete.setBorderPainted(false);
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Search Student By Name");

        jTextField_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_searchKeyReleased(evt);
            }
        });

        jButton_photo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton_photo.setForeground(new java.awt.Color(0, 0, 102));
        jButton_photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/folder_red.png"))); // NOI18N
        jButton_photo.setText("Select Photo");
        jButton_photo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_photoActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Student Name", "Fees", "Date of Birth"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/college Logo2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1_dob, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(label_photo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_id)
                    .addComponent(jTextField_name)
                    .addComponent(jTextField_fees))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton_new, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_update, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                        .addComponent(jButton_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton_save, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(128, 128, 128)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jTextField_search, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addComponent(jLabel_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_new, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField_name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButton_save, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton_update, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_fees, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(31, 31, 31)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1_dob, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_search, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_newActionPerformed
        jTextField_id.setText("");
        jTextField_search.setText("");
        jTextField_name.setText("");
        jTextField_fees.setText("");
    }//GEN-LAST:event_jButton_newActionPerformed

    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        if((jTextField_id.getText()!=null || jTextField_name!=null
                || jTextField_fees!=null || jDateChooser1_dob!=null)
                &&photopath!=null){
               //jTextField3_fees.getText().toString()
               try {
                Connection con=MySqlConnection();
                PreparedStatement ps=con.prepareStatement("insert into students"
                        + "(id,name,fees,dob,photo) values (?,?,?,?,?)");
                ps.setInt(1,Integer.parseInt(jTextField_id.getText().toString()));
                //System.out.println("id is "+jTextField1_id.getText().toString());
                ps.setString(2,jTextField_name.getText().toString());
                //System.out.println("name is "+jTextField2_name.getText().toString());
                ps.setFloat(3, Float.parseFloat(jTextField_fees.getText().toString()));
                //System.out.println("Fees is "+jTextField3_fees.getText().toString());
                   SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                   String dob1=sdf.format(jDateChooser1_dob.getDate());
                   ps.setString(4,dob1);
                   //System.out.println("DOB is "+jDateChooser1_dob.getDate());
                   InputStream is=new FileInputStream(new File(photopath));
                   ps.setBlob(5, is);
                   int i=ps.executeUpdate();
                   fillTable();
                   //System.out.println("i is "+i);
                   if(i>=1){
                   JOptionPane.showMessageDialog(null, i+"Student Inserted Succussfully...");
                   jTextField_id.setText("");
                   jTextField_name.setText("");
                   jTextField_fees.setText("");
                   label_photo.setText("");
                   }
                   else
                   JOptionPane.showMessageDialog(null, i+"Student insertion failed...");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Student insertion failed "+e);
            }
        }else{
                JOptionPane.showMessageDialog(null, "All Fields are compulsory ");
        }
    }//GEN-LAST:event_jButton_saveActionPerformed

    private void jButton_photoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_photoActionPerformed
        JFileChooser chooser=new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter fnef=new FileNameExtensionFilter("*.images", "jpg","png");
        chooser.addChoosableFileFilter(fnef);
        int ans=chooser.showSaveDialog(null);
        if (ans==JFileChooser.APPROVE_OPTION) {
           File selectedPhoto=chooser.getSelectedFile();
           String path=selectedPhoto.getAbsolutePath();
           label_photo.setIcon(resizeImageI(path, null));
          this.photopath=path;
        }else{
            System.out.println("Photo Not Selected ....");
        }
    }//GEN-LAST:event_jButton_photoActionPerformed

    private void jTextField_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_nameActionPerformed

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        if (jTextField_id.getText()!=null || jTextField_name!=null
                || jTextField_fees!=null || jDateChooser1_dob!=null){
            String qry=null;
            PreparedStatement ps=null;
            Connection con=MySqlConnection();
            
            //if photopath is null
            if (photopath==null) {
                try {
                    qry="update students set name=?, fees=?,dob=? where id=?";
                    ps=con.prepareStatement(qry);
                    ps.setString(1,jTextField_name.getText().toString());
                    ps.setFloat(2,Float.parseFloat(jTextField_fees.getText().toString()));
                    SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                    String sdate=sdf.format(jDateChooser1_dob.getDate());
                    ps.setString(3,sdate);
                    ps.setInt(4,Integer.parseInt(jTextField_id.getText().toString()));
                    
                    int res=ps.executeUpdate();                   
                    if(res>=1)
                        JOptionPane.showMessageDialog(null, res+" Record successfully Updated..");
                    else
                        JOptionPane.showMessageDialog(null, res+" Record Updation Failed...");
                } catch (Exception e) {                    
                    JOptionPane.showMessageDialog(null, e);
                }
            }else{ //if with photo update
                try{
                InputStream is=new FileInputStream(new File(photopath));
                
                qry="update students set name=?,fees=?,dob=?,photo=? where id=?";
                ps=con.prepareStatement(qry);
                ps.setString(1,jTextField_name.getText().toString());
                ps.setFloat(2,Float.parseFloat(jTextField_fees.getText().toString()));
                SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
                String sdate=sdf.format(jDateChooser1_dob.getDate());
                ps.setString(3,sdate);
                ps.setBlob(4, is);
                ps.setInt(5,Integer.parseInt(jTextField_id.getText().toString()));
                
                int i=ps.executeUpdate();                   
                if(i>=1)
                        JOptionPane.showMessageDialog(null, i+" Record successfully Updated..");
                    else
                        JOptionPane.showMessageDialog(null, i+" Record Updation Failed...");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            fillTable();
        }else{
              JOptionPane.showMessageDialog(null, "All fields are compulsory/Invalid Inputs...");
        }
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
         if(jTextField_id.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter the student_id");
        }else{
            try{
                String sql="delete from students where id=?";
                Connection con=MySqlConnection();
                PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
                ps.setInt(1,Integer.parseInt(jTextField_id.getText().toString()));
                int res=ps.executeUpdate();
                fillTable();
                if(res>=1){
                    JOptionPane.showMessageDialog(null, "Student Deleted Sucessfully");
                }
                else
                JOptionPane.showMessageDialog(null, "Student Deletion failed");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       int ind=jTable1.getSelectedRow();
            showItemToFields(ind);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_searchKeyReleased
       ArrayList<StudentBean> al=null;
                al=new ArrayList<StudentBean>();
       String val=jTextField_search.getText().toString();
        try {
            Connection conn=MySqlConnection();
            //String qry="select * from student where (name like '%"+val+"%' or id like %"+Integer.parseInt(val)+"%)";
            String qry="select * from students where name like '%"+val+"%'";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(qry);
            StudentBean student;
            while (rs.next()) {
                student =new StudentBean(rs.getInt(1),rs.getString("name"),Float.parseFloat(rs.getString(3)),rs.getString(4),rs.getBytes("photo"));                
                al.add(student);
              }
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        model.setRowCount(0); // Empty/clear the table
        Object[] row=new Object[4];
        for (int i = 0; i < al.size(); i++) {
            row[0]=al.get(i).getId();
            row[1]=al.get(i).getName();
            row[2]=al.get(i).getFees();
            row[3]=al.get(i).getDob();
            model.addRow(row);
        }
           
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jTextField_searchKeyReleased

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
            java.util.logging.Logger.getLogger(StudentsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentsForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_new;
    private javax.swing.JButton jButton_photo;
    private javax.swing.JButton jButton_save;
    private javax.swing.JButton jButton_update;
    private com.toedter.calendar.JDateChooser jDateChooser1_dob;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_logo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_fees;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JTextField jTextField_search;
    private javax.swing.JLabel label_photo;
    // End of variables declaration//GEN-END:variables
}