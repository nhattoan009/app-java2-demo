package ASM366;

import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QLNV_FORM extends javax.swing.JFrame implements Runnable {

//    private int List = 0;
    int qlnhanvien = 1;
    private JFileChooser rc = new JFileChooser();
    QLNV quanly;

    public QLNV_FORM() {
        quanly = new QLNV();
        initComponents();
//        List = 0;
        Thread t1 = new Thread((Runnable) this);
        t1.start();
        lblTime.setEnabled(false);
        setLocationRelativeTo(null);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Date now = new Date();
                SimpleDateFormat formater = new SimpleDateFormat();
                formater.applyPattern("hh:mm:ss aa");
                String time = formater.format(now);
                lblTime.setText(time);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Lỗi");
            }
        }
    }

    void hienthi(NhanVien obj) {
        TxtMaNV.setText(obj.getMaNV());
        TxtHoTen.setText(obj.getHoTen());
        TxtTuoi.setText(String.valueOf(obj.getTuoi()));
        TxtEmail.setText(obj.getEmail());
        TxtLuong.setText(String.valueOf(obj.getLuong()));

    }

    void reset() {
        TxtMaNV.setText("");
        TxtHoTen.setText("");
        TxtTuoi.setText("");
        TxtEmail.setText("");
        TxtLuong.setText("");
        TxtMaNV.requestFocus();
    }

    void themNhnVien() {
        if (kiemtra()) {
            try {
                NhanVien nv = new NhanVien();
                nv.setMaNV(TxtMaNV.getText());
                nv.setHoTen(TxtHoTen.getText());
                nv.setTuoi(Integer.parseInt(TxtTuoi.getText()));
                nv.setEmail(TxtEmail.getText());
                nv.setLuong(Double.parseDouble(TxtLuong.getText()));
                quanly.themMoi(nv);
                JOptionPane.showMessageDialog(this, "Thêm dữ liệu thành công");
                reset();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi");
            }

        }
    }

    public boolean kiemtra() {

        if (TxtMaNV.getText().equals("")) {
            lblErrorManv.setText("Mã nhân viên đang trống");
            TxtMaNV.requestFocus();
            return false;
        } else {
            lblErrorManv.setText("");
        }

        if (TxtHoTen.getText().equals("")) {
            lblErrorHoten.setText("Họ tên đang trống");
            TxtHoTen.requestFocus();
            return false;
        } else {
            lblErrorHoten.setText("");
        }

        if (TxtTuoi.getText().equals("")) {
            lblErrorTuoi.setText("Tuổi đang trống");
            TxtTuoi.requestFocus();
            return false;
        } else {

            int tuoi = Integer.parseInt(TxtTuoi.getText());
            lblErrorTuoi.setText("");
            if (tuoi < 18 || tuoi > 55) {
                lblErrorTuoi.setText("Tuổi phải từ 18 - 55");
                TxtTuoi.requestFocus();
                return false;
            } else {
                lblErrorTuoi.setText("");
            }
        }

        if (TxtEmail.getText().equals("")) {
            lblErrorEmail.setText("Email đang trống");
            TxtEmail.requestFocus();
            return false;
        } else {
//            lblErrorEmail.setText("");
            Pattern pattern = Pattern.compile("^\\w+@[a-zA-Z]+\\.com$"); //[a-zA-Z]+[a-zA-Z0-9]*@{1}[a-zA-Z]+mail.com
            Matcher matcher = pattern.matcher(TxtEmail.getText());
            if (matcher.find()) {
                lblErrorEmail.setText("");
            } else {
                lblErrorEmail.setText("Email không đúng định dạng");
                TxtEmail.requestFocus();
                return false;
            }
        }

        if (TxtLuong.getText().equals("")) {
            lblErrorLuong.setText("Lương đang trống");
            TxtLuong.requestFocus();
            return false;
        } else if (Double.parseDouble(TxtLuong.getText()) < 5000) {
            lblErrorLuong.setText("Lương phải lớn hơn 5000");
            TxtLuong.requestFocus();
            return false;
        } else {
            lblErrorLuong.setText("");
        }
        

        return true;
    }


    public void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tblQLNV.getModel();
        model.setRowCount(0);
        for (int i = 0; i < quanly.danhsach.size(); i++) {
            Object[] row = new Object[]{quanly.danhsach.get(i).getMaNV(), quanly.danhsach.get(i).getHoTen(),
                quanly.danhsach.get(i).getTuoi(), quanly.danhsach.get(i).getEmail(), quanly.danhsach.get(i).getLuong()};
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TxtMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtHoTen = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtTuoi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtLuong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblQLNV = new javax.swing.JTable();
        bntNew = new javax.swing.JButton();
        bntSave = new javax.swing.JButton();
        bntdetele = new javax.swing.JButton();
        bntfind = new javax.swing.JButton();
        bntOpen = new javax.swing.JButton();
        bntExit = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        bntFist = new javax.swing.JButton();
        bntPre = new javax.swing.JButton();
        bntNext = new javax.swing.JButton();
        bntLast = new javax.swing.JButton();
        lblTime = new javax.swing.JButton();
        lblReconrd = new javax.swing.JLabel();
        lblErrorManv = new javax.swing.JLabel();
        lblErrorHoten = new javax.swing.JLabel();
        lblErrorTuoi = new javax.swing.JLabel();
        lblErrorEmail = new javax.swing.JLabel();
        lblErrorLuong = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUAN LY NHAN VIEN");
        jLabel1.setOpaque(true);

        jLabel2.setText("MÃ NHÂN VIÊN");

        jLabel3.setText("HỌ TÊN ");

        jLabel4.setText("TUỔI ");

        jLabel5.setText("EMAIL ");

        jLabel6.setText("LƯƠNG ");

        tblQLNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ NV", "HỌ TÊN NV", "TUÔI NV", "EMAIL NV", "LƯƠNG NV"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblQLNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblQLNV);

        bntNew.setText("NEW");
        bntNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNewActionPerformed(evt);
            }
        });

        bntSave.setText("SAVE");
        bntSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSaveActionPerformed(evt);
            }
        });

        bntdetele.setText("DELETE");
        bntdetele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntdeteleActionPerformed(evt);
            }
        });

        bntfind.setText("FIND");
        bntfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntfindActionPerformed(evt);
            }
        });

        bntOpen.setText("OPEN");
        bntOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntOpenActionPerformed(evt);
            }
        });

        bntExit.setText("EXIT");
        bntExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntExitActionPerformed(evt);
            }
        });

        bntFist.setText("<<");
        bntFist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntFistActionPerformed(evt);
            }
        });

        bntPre.setText("|<");
        bntPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntPreActionPerformed(evt);
            }
        });

        bntNext.setText("|>");
        bntNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntNextActionPerformed(evt);
            }
        });

        bntLast.setText(">>");
        bntLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntLastActionPerformed(evt);
            }
        });

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTime.setForeground(new java.awt.Color(204, 51, 0));
        lblTime.setText("Time");
        lblTime.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblReconrd.setText("Record :");

        lblErrorManv.setForeground(new java.awt.Color(204, 0, 0));

        lblErrorHoten.setForeground(new java.awt.Color(204, 0, 0));

        lblErrorTuoi.setForeground(new java.awt.Color(204, 0, 0));

        lblErrorEmail.setForeground(new java.awt.Color(204, 0, 0));

        lblErrorLuong.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblErrorManv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TxtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                    .addComponent(TxtMaNV)
                                    .addComponent(TxtHoTen)
                                    .addComponent(TxtTuoi)
                                    .addComponent(lblErrorTuoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblErrorLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TxtLuong)
                                    .addComponent(lblErrorEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(lblErrorHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bntNew, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntSave, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntdetele, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntfind, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntExit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(bntPre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bntFist)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bntLast)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bntNext))
                                    .addComponent(lblReconrd, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                        .addGap(54, 54, 54))))
            .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bntNew)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntdetele))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TxtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(lblErrorManv, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TxtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(bntfind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntOpen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bntExit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lblErrorTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErrorLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bntFist)
                            .addComponent(bntPre)
                            .addComponent(bntLast)
                            .addComponent(bntNext))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblReconrd)
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblQLNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLNVMouseClicked

    }//GEN-LAST:event_tblQLNVMouseClicked

    private void bntNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNewActionPerformed
        // TODO add your handling code here:
        //tạo mới dữ liệu
        for (int i = 0;i <= quanly.danhsach.size(); i++) {
            if (TxtMaNV.getText().equals(quanly.danhsach.get(i).getMaNV())) {
                JOptionPane.showMessageDialog(this, "Mã nhân viên trùng");
            }
        }
        
        
        bntNew.setMnemonic(KeyEvent.VK_T);
        themNhnVien();
        fillToTable();
    }//GEN-LAST:event_bntNewActionPerformed

    private void bntSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSaveActionPerformed
        // TODO add your handling code here:
        // lưu dữ liệu
        bntSave.setMnemonic(KeyEvent.VK_S);
        JFileChooser saveDig = new JFileChooser();
        saveDig.showSaveDialog(this);
        quanly.ghiFile(saveDig.getSelectedFile());
    }//GEN-LAST:event_bntSaveActionPerformed

    private void bntdeteleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntdeteleActionPerformed
        // TODO add your handling code here:
        // Xóa
        bntdetele.setMnemonic(KeyEvent.VK_X);
        String xoa = JOptionPane.showInputDialog(this, "Nhập Mã NV cần xóa");
        int x = JOptionPane.showConfirmDialog(this, "Ấn YES để xóa");
        if (x == JOptionPane.YES_OPTION) {
             quanly.xoaById(xoa);
        }
        // int vt= quanly.timKiemById(xoa);
       

        this.fillToTable();
    }//GEN-LAST:event_bntdeteleActionPerformed

    private void bntfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntfindActionPerformed
        // TODO add your handling code here:
        // Tìm
        bntfind.setMnemonic(KeyEvent.VK_Q);
        String vao = JOptionPane.showInputDialog(this, "Nhập ID nhân viên cần tìm");
        int vt = quanly.timKiemById(vao);
        if (vt != -1) {
            TxtMaNV.setText(quanly.danhsach.get(vt).getMaNV());
            TxtHoTen.setText(quanly.danhsach.get(vt).getHoTen());
            TxtTuoi.setText("" + quanly.danhsach.get(vt).getTuoi() + "");
            TxtEmail.setText(quanly.danhsach.get(vt).getEmail());
            TxtLuong.setText("" + quanly.danhsach.get(vt).getLuong() + "");
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên");
        }
    }//GEN-LAST:event_bntfindActionPerformed

    private void bntOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntOpenActionPerformed
        // TODO add your handling code here:
        // Mở
        bntOpen.setMnemonic(KeyEvent.VK_O);
        JFileChooser openDig = new JFileChooser();
        openDig.showOpenDialog(this);
        quanly.docFile(openDig.getSelectedFile());
        if (quanly.getDanhsach().size() != 0) {
//            List = 0;
            TxtMaNV.setText(quanly.danhsach.get(0).getMaNV());
            TxtHoTen.setText(quanly.danhsach.get(0).getHoTen());
            TxtTuoi.setText(String.valueOf(quanly.danhsach.get(0).getTuoi()));
            TxtEmail.setText(quanly.danhsach.get(0).getEmail());
            TxtLuong.setText(String.valueOf(quanly.danhsach.get(0).getLuong()));
            quanly.setVitrihienhanh(ICONIFIED);
            JOptionPane.showMessageDialog(null, "Mở dữ liệu trong file  thành công");
        } else {
            JOptionPane.showMessageDialog(null, "File Trống");
        }
//        labeltong.setText(""+quanly.danhsach.size()+"");
        this.fillToTable();
    }//GEN-LAST:event_bntOpenActionPerformed

    private void bntExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntExitActionPerformed
        int x = JOptionPane.showConfirmDialog(this, "Ấn YES để thoát");
        if (x == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_bntExitActionPerformed

    private void bntFistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntFistActionPerformed

        hienthi(quanly.first());
        qlnhanvien = 1;
        lblReconrd.setText("" + 1 + "");
    }//GEN-LAST:event_bntFistActionPerformed

    private void bntPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntPreActionPerformed

        lblReconrd.setText("" + (quanly.getVitrihienhanh() + 1) + "");
        hienthi(quanly.previous());

    }//GEN-LAST:event_bntPreActionPerformed

    private void bntNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntNextActionPerformed

        qlnhanvien = qlnhanvien >= quanly.danhsach.size() - 1 ? quanly.danhsach.size() : ++qlnhanvien;
        hienthi(quanly.next());
        lblReconrd.setText("" + qlnhanvien + "");
    }//GEN-LAST:event_bntNextActionPerformed

    private void bntLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntLastActionPerformed

        hienthi(quanly.last());
        lblReconrd.setText("" + quanly.danhsach.size() + "");
        
            JOptionPane.showMessageDialog(this, "Bạn đang ỏ cuối");
    
    }//GEN-LAST:event_bntLastActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLNV_FORM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtHoTen;
    private javax.swing.JTextField TxtLuong;
    private javax.swing.JTextField TxtMaNV;
    private javax.swing.JTextField TxtTuoi;
    private javax.swing.JButton bntExit;
    private javax.swing.JButton bntFist;
    private javax.swing.JButton bntLast;
    private javax.swing.JButton bntNew;
    private javax.swing.JButton bntNext;
    private javax.swing.JButton bntOpen;
    private javax.swing.JButton bntPre;
    private javax.swing.JButton bntSave;
    private javax.swing.JButton bntdetele;
    private javax.swing.JButton bntfind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblErrorEmail;
    private javax.swing.JLabel lblErrorHoten;
    private javax.swing.JLabel lblErrorLuong;
    private javax.swing.JLabel lblErrorManv;
    private javax.swing.JLabel lblErrorTuoi;
    private javax.swing.JLabel lblReconrd;
    private javax.swing.JButton lblTime;
    private javax.swing.JTable tblQLNV;
    // End of variables declaration//GEN-END:variables
}
