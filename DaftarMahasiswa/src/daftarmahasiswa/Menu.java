/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daftarmahasiswa;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Menu extends javax.swing.JFrame {

    private DefaultTableModel dtm;
    private Boolean isUpdate = false;
    private int selectedID = -1;
    private ArrayList<Mahasiswa> listMhs;
    private String[] genderOptions = {"Laki-laki", "Perempuan"};

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        listMhs = new ArrayList<>();
        //Dummy
        listMhs.add(new Mahasiswa("2001", "Kim", "A", "Ilmu Komputer", "Laki-laki"));
        listMhs.add(new Mahasiswa("2002", "Jisoo", "B", "BIologi", "Perempuan"));
        listMhs.add(new Mahasiswa("2003", "Sunoo", "A", "Matematika", "Laki-laki"));
        // Set Table
        Table.setModel(setTable());
        // Hide Delete button
        btnDelete.setVisible(false);
    }

    public final DefaultTableModel setTable() {
        Object[] column = {"NIM", "Nama", "Nilai", "Prodi", "Gender"};
        DefaultTableModel dataTabel = new DefaultTableModel(null, column);
        
        for (int i = 0; i < listMhs.size(); i++) {
            Object[] row = new Object[5];
            row[0] = listMhs.get(i).getNim();
            row[1] = listMhs.get(i).getNama();
            row[2] = listMhs.get(i).getNilai();
            row[3] = listMhs.get(i).getProdi();
            comboBoxGender.setSelectedItem(listMhs.get(i).getGender());
            row[4] = comboBoxGender.getSelectedItem().toString();
            

            dataTabel.addRow(row);
        }

        return dataTabel;
    }

    public void insertData() {
        
        // Get Data
        String nim = textFieldNim.getText();
        String nama = textFieldNama.getText();
        String nilai = textFieldNilai.getText();
        String prodi = textFieldProdi.getText();
        String gender = comboBoxGender.getSelectedItem().toString();

        
        if(nim.equals("") || nama.equals("") || nilai.equals("") || prodi.equals("") || gender.equals("")){
            // jika inputan data tidak lengkap
            
            //menampilkan validasi
            System.out.println("Insert Failed!");
            JOptionPane.showMessageDialog(null, "Data tidak lengkap!");
            
        }else{
            // jika data input lengkap
            listMhs.add(new Mahasiswa(nim, nama, nilai, prodi, gender));
            
            //Update Table
            Table.setModel(setTable());

            //menampilkan pesan
            System.out.println("Insert Success!");
            JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
            
            resetForm(); //memanggil funsi resetForm untuk menghapus data pada tabel inputan
            
        }

    }

    public void updateData() {
        // Get Data
        String nim = textFieldNim.getText();
        String nama = textFieldNama.getText();
        String nilai = textFieldNilai.getText();
        String prodi = textFieldProdi.getText();
        String gender = comboBoxGender.getSelectedItem().toString();

        //jika user tidak melakukan perubahan apapun
        if(listMhs.get(selectedID).getNim().equals(nim) 
            && listMhs.get(selectedID).getNama().equals(nama) 
            && listMhs.get(selectedID).getNilai().equals(nilai)
            && listMhs.get(selectedID).getProdi().equals(prodi)
            && listMhs.get(selectedID).getGender().equals(gender)){
            
            //menampilkan validasi
            System.out.println("Update Failed!");
            JOptionPane.showMessageDialog(null, "Tidak ada data yang dirubah!");
            
        }else{
            
            // update data dengan menggunakan metode setter
            listMhs.get(selectedID).setNim(nim);
            listMhs.get(selectedID).setNama(nama);
            listMhs.get(selectedID).setNilai(nilai);
            listMhs.get(selectedID).setProdi(prodi);
            listMhs.get(selectedID).setGender(gender);

            // update table
            Table.setModel(setTable());

             //menampilkan pesan
            System.out.println("Update Success!");
            JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
            
        }

        resetForm(); //memanggil funsi resetForm untuk menghapus data pada tabel inputan
    }

    public void deleteData() {
        int option = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus Data", JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.YES_OPTION) {
            // delete row yang dipilih di table
            listMhs.remove(selectedID);
            
            // update table
            Table.setModel(setTable());
            
             //menampilkan pesan
            System.out.println("Delete Success!");
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            
            resetForm(); //memanggil funsi resetForm untuk menghapus data pada tabel inputan
        }
    }
        
    
    public void resetForm(){
        
        // clear text field / menghapus data pada label inputan
        textFieldNim.setText("");
        textFieldNama.setText("");
        textFieldNilai.setText("");
        textFieldProdi.setText("");
        comboBoxGender.getSelectedItem().toString();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPertama = new javax.swing.JPanel();
        Label = new javax.swing.JLabel();
        btnAdd_Update = new javax.swing.JButton();
        textFieldNim = new javax.swing.JTextField();
        txtNim = new javax.swing.JLabel();
        txtNama = new javax.swing.JLabel();
        textFieldNama = new javax.swing.JTextField();
        txtNilai = new javax.swing.JLabel();
        textFieldNilai = new javax.swing.JTextField();
        txtGender = new javax.swing.JLabel();
        comboBoxGender = new javax.swing.JComboBox<>(genderOptions);
        ScrollPane = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnresetForm = new javax.swing.JButton();
        textFieldProdi = new javax.swing.JTextField();
        txtProdi = new javax.swing.JLabel();
        ;

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Label.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        Label.setText("Daftar Mahasiswa");

        btnAdd_Update.setFont(new java.awt.Font("HP Simplified Jpan", 0, 13)); // NOI18N
        btnAdd_Update.setText("Add");
        btnAdd_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd_UpdateActionPerformed(evt);
            }
        });

        textFieldNim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNimActionPerformed(evt);
            }
        });

        txtNim.setFont(new java.awt.Font("HP Simplified Jpan", 0, 13)); // NOI18N
        txtNim.setText("NIM");

        txtNama.setFont(new java.awt.Font("HP Simplified Jpan", 0, 13)); // NOI18N
        txtNama.setText("Nama");

        textFieldNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNamaActionPerformed(evt);
            }
        });

        txtNilai.setFont(new java.awt.Font("HP Simplified Jpan", 0, 13)); // NOI18N
        txtNilai.setText("Nilai");

        textFieldNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNilaiActionPerformed(evt);
            }
        });

        txtGender.setFont(new java.awt.Font("HP Simplified Jpan", 0, 13)); // NOI18N
        txtGender.setText("Gender");

        comboBoxGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String selectedGender = (String) comboBoxGender.getSelectedItem();
                // handling code here
            }
        });

        Table.setAutoCreateRowSorter(true);
        Table.setFont(new java.awt.Font("HP Simplified Jpan", 0, 12)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        Table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Table.setUpdateSelectionOnSort(false);
        Table.setVerifyInputWhenFocusTarget(false);
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        ScrollPane.setViewportView(Table);

        btnDelete.setFont(new java.awt.Font("HP Simplified Jpan", 0, 13)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnresetForm.setFont(new java.awt.Font("HP Simplified Jpan", 0, 13)); // NOI18N
        btnresetForm.setText("Reset");
        btnresetForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetFormActionPerformed(evt);
            }
        });

        textFieldProdi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldProdiActionPerformed(evt);
            }
        });

        txtProdi.setFont(new java.awt.Font("HP Simplified Jpan", 0, 13)); // NOI18N
        txtProdi.setText("Prodi");

        javax.swing.GroupLayout PanelPertamaLayout = new javax.swing.GroupLayout(PanelPertama);
        PanelPertama.setLayout(PanelPertamaLayout);
        PanelPertamaLayout.setHorizontalGroup(
            PanelPertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPertamaLayout.createSequentialGroup()
                .addGroup(PanelPertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPertamaLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(PanelPertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelPertamaLayout.createSequentialGroup()
                                .addGroup(PanelPertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(PanelPertamaLayout.createSequentialGroup()
                                        .addComponent(txtProdi)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textFieldProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelPertamaLayout.createSequentialGroup()
                                        .addComponent(txtGender)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelPertamaLayout.createSequentialGroup()
                                        .addComponent(txtNama)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelPertamaLayout.createSequentialGroup()
                                        .addComponent(txtNim)
                                        .addGap(55, 55, 55)
                                        .addComponent(textFieldNim, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelPertamaLayout.createSequentialGroup()
                                        .addComponent(txtNilai)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(textFieldNilai, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(PanelPertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAdd_Update)
                                    .addComponent(btnDelete)
                                    .addComponent(btnresetForm)))))
                    .addGroup(PanelPertamaLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(Label)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        PanelPertamaLayout.setVerticalGroup(
            PanelPertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPertamaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(Label)
                .addGap(18, 18, 18)
                .addGroup(PanelPertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNim)
                    .addComponent(btnAdd_Update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNama)
                    .addComponent(btnresetForm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldNilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNilai)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProdi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPertamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGender))
                .addGap(26, 26, 26)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelPertama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelPertama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldNimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNimActionPerformed

    private void textFieldNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNamaActionPerformed

    private void textFieldNilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNilaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNilaiActionPerformed

    private void btnAdd_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd_UpdateActionPerformed
        // TODO add your handling code here:
        if (isUpdate == false)
            insertData();
        else {
            updateData();
            btnAdd_Update.setText("Add");
            btnDelete.setVisible(false);
            this.isUpdate = false;
        }
    }//GEN-LAST:event_btnAdd_UpdateActionPerformed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
        this.isUpdate = true;

        //Get Selected Data
        int row = Table.getSelectedRow();
        String selectedNim = (Table.getModel().getValueAt(row, 0).toString());
        String selectedNama = (Table.getModel().getValueAt(row, 1).toString());
        String selectedNilai = (Table.getModel().getValueAt(row, 2).toString());
        String selectedProdi = (Table.getModel().getValueAt(row, 3).toString());
        String selectedGender = (String) comboBoxGender.getSelectedItem();


        for (int i = 0; i < listMhs.size(); i++) {
            if (selectedNim.equals(listMhs.get(i).getNim())) {
                selectedID = i;
                break;
            }
        }

        //System.out.println(selectedID);
        textFieldNim.setText(selectedNim);
        textFieldNama.setText(selectedNama);
        textFieldNilai.setText(selectedNilai);
        textFieldProdi.setText(selectedProdi);
        comboBoxGender.setSelectedItem(selectedGender);

        btnAdd_Update.setText("Update");
        btnDelete.setVisible(true);
    }//GEN-LAST:event_TableMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (isUpdate == true) {
            deleteData();
            btnAdd_Update.setText("Add");
            btnDelete.setVisible(false);
            this.isUpdate = false;
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnresetFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetFormActionPerformed
        // TODO add your handling code here:
        resetForm();
        btnAdd_Update.setText("Add");
        btnDelete.setVisible(false);
        this.isUpdate = false;
        
    }//GEN-LAST:event_btnresetFormActionPerformed

    private void textFieldProdiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldProdiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldProdiActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label;
    private javax.swing.JPanel PanelPertama;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTable Table;
    private javax.swing.JButton btnAdd_Update;
    private javax.swing.JButton btnresetForm;
    private javax.swing.JButton btnDelete;
    private javax.swing.JTextField textFieldNama;
    private javax.swing.JTextField textFieldNilai;
    private javax.swing.JTextField textFieldNim;
    private javax.swing.JTextField textFieldProdi;
    private javax.swing.JComboBox<String> comboBoxGender;
    private javax.swing.JLabel txtNama;
    private javax.swing.JLabel txtNilai;
    private javax.swing.JLabel txtNim;
    private javax.swing.JLabel txtProdi;
    private javax.swing.JLabel txtGender;
    // End of variables declaration//GEN-END:variables
}
