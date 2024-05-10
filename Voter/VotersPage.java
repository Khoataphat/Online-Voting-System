/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Voters;

import Admin.*;
import General.Canditates;
import General.Home;
import General.VotersList;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.time.LocalDate;
import java.util.Vector;

/**
 *
 * @author welcome
 */
public class VotersPage extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;

    String username;
    String pwd;

    public VotersPage(String username, String pwd) {
        initComponents();
        JButton [] btns = {jButton1, jButton2, jButton3, jButton4, jButton5, jButton7, jButton12, jButton13, jButton14, jButton15, jButton16};
        for (JButton btn : btns) {
            btn.setBackground(new Color(21,25,28));
            btn.setUI(new BasicButtonUI());
            btn.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setBackground(new Color(54,81,207));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btn.setBackground(new Color(21,25,28));
                }

            });
        }

        this.username = username;
        this.pwd = pwd;
        upDateDB();
    }

    private VotersPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void upDateDB(){
        String serverName = "MSI\\SQLEXPRESS";
        String databaseName = "Online-Voting";
        String username = "sa";
        String password = "123456789";
        String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true;";
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, "sa", "123456789");
            pst = con.prepareStatement("select * from Election");

            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();

            q = stData.getColumnCount();

            // Define custom column names
            String[] columnNames = {"Election_ID", "Election_Name", "Start_Date", "End_Date", "Winner"};

            DefaultTableModel RecordTable = new DefaultTableModel(columnNames, 0);
            jTable1.setModel(RecordTable);

            while (rs.next()){
                Vector columnData = new Vector();

                for(i = 1;i <= q; i++){
                    columnData.add(rs.getString("Election_ID"));
                    columnData.add(rs.getString("Election_Name"));
                    columnData.add(rs.getString("Start_Date"));
                    columnData.add(rs.getString("End_Date"));
                    columnData.add(rs.getString("Winner"));
                }
                RecordTable.addRow(columnData);
            }

        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
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

        JPanel pnRoot = new JPanel();
        JPanel pnSide = new JPanel();
        JPanel jPanel1 = new JPanel();
        JButton jButton6 = new JButton();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton7 = new JButton();
        JPanel jPanel5 = new JPanel();
        JPanel jPanel6 = new JPanel();
        jButton13 = new JButton();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel();
        JPanel pnCenter = new JPanel();
        JPanel pnCBottom = new JPanel();
        JLabel jLabel1 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JPanel pniCTop = new JPanel();
        JLabel jLabel2 = new JLabel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        JPanel jPanel4 = new JPanel();
        JPanel pniCCenter = new JPanel();
        JButton jButton8 = new JButton();
        jButton12 = new JButton();
        JLabel jLabel8 = new JLabel();
        jButton14 = new JButton();
        jButton15 = new JButton();
        jButton16 = new JButton();
        JButton jButton17 = new JButton();
//
        jTable1 = new JTable();

        JScrollPane jScrollPane1 = new JScrollPane();
//        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pnRoot.setLayout(new BorderLayout());

        pnSide.setBackground(new Color(21, 25, 28));
        pnSide.setPreferredSize(new Dimension(250, 0));

        jPanel1.setBackground(new Color(21, 25, 28));
        jPanel1.setPreferredSize(new Dimension(270, 150));
        jPanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 40));

        jButton6.setBackground(new Color(0, 0, 0));
        jButton6.setForeground(new Color(255, 255, 255));
        jButton6.setText("VOTE IS OUR RIGHT");
        jButton6.setPreferredSize(new Dimension(200, 40));
        jPanel1.add(jButton6);

        pnSide.add(jPanel1);

        jButton1.setForeground(new Color(0, 255, 204));
        jButton1.setIcon(new ImageIcon("C:\\icons hub\\icons8-home-25.png")); // NOI18N
        jButton1.setText(" HOME");
        jButton1.setPreferredSize(new Dimension(200, 40));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(this::jButton1ActionPerformed);
        pnSide.add(jButton1);

        jButton2.setForeground(new Color(0, 255, 204));
        jButton2.setIcon(new ImageIcon("C:\\icons hub\\icons8-elections-25.png")); // NOI18N
        jButton2.setText("VOTERS");
        jButton2.setPreferredSize(new Dimension(200, 40));
        jButton2.addActionListener(this::jButton2ActionPerformed);
        pnSide.add(jButton2);

        jButton3.setForeground(new Color(0, 255, 204));
        jButton3.setIcon(new ImageIcon("C:\\icons hub\\icons8-people-25.png")); // NOI18N
        jButton3.setText("ADMINISTRATOR");
        jButton3.setPreferredSize(new Dimension(200, 40));
        jButton3.addActionListener(this::jButton3ActionPerformed);
        pnSide.add(jButton3);

        jButton4.setForeground(new Color(0, 255, 204));
        jButton4.setIcon(new ImageIcon("C:\\icons hub\\icons8-leader-25.png")); // NOI18N
        jButton4.setText("CANDIDATES");
        jButton4.setPreferredSize(new Dimension(200, 40));
        jButton4.addActionListener(this::jButton4ActionPerformed);
        pnSide.add(jButton4);

        jButton5.setForeground(new Color(0, 255, 204));
        jButton5.setIcon(new ImageIcon("C:\\icons hub\\icons8-list-25.png")); // NOI18N
        jButton5.setText("VOTER LIST");
        jButton5.setPreferredSize(new Dimension(200, 40));
        jButton5.addActionListener(this::jButton5ActionPerformed);
        pnSide.add(jButton5);

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        pnSide.add(jPanel5);

        jPanel6.setBackground(new Color(34, 40, 44));
        jPanel6.setMinimumSize(new Dimension(200, 280));
        jPanel6.setPreferredSize(new Dimension(200, 280));

        jButton13.setText("ISSUES ");
        jButton13.addActionListener(this::jButton13ActionPerformed);

        jLabel5.setForeground(new Color(255, 255, 102));
        jLabel5.setText("SEE THE ISSUES");

        jLabel6.setForeground(new Color(255, 255, 102));
        jLabel6.setText("AND SORT OUT");

        jLabel7.setForeground(new Color(255, 255, 102));
        jLabel7.setText("THE ISSUES");

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(jButton13, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel7))))
                                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jButton13, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addContainerGap(31, Short.MAX_VALUE))
        );

        pnSide.add(jPanel6);

        pnRoot.add(pnSide, BorderLayout.WEST);

        pnCenter.setBackground(new Color(34, 40, 44));
        pnCenter.setLayout(new BorderLayout());

        pnCBottom.setBackground(new Color(30, 40, 44));
        pnCBottom.setPreferredSize(new Dimension(734, 100));

        jLabel1.setForeground(new Color(0, 204, 204));
        jLabel1.setText("INTERNATIONAL UNIVERSITY");

        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setText("Group 6");

        jLabel4.setForeground(new Color(0, 204, 204));
        jLabel4.setText("Copyright © 2021 PSG");

        GroupLayout pnCBottomLayout = new GroupLayout(pnCBottom);
        pnCBottom.setLayout(pnCBottomLayout);
        pnCBottomLayout.setHorizontalGroup(
                pnCBottomLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnCBottomLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel1)
                                .addGap(105, 105, 105)
                                .addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 2094, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(176, 176, 176))
        );
        pnCBottomLayout.setVerticalGroup(
                pnCBottomLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pnCBottomLayout.createSequentialGroup()
                                .addContainerGap(37, Short.MAX_VALUE)
                                .addGroup(pnCBottomLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                .addGap(23, 23, 23))
        );

        pnCenter.add(pnCBottom, BorderLayout.SOUTH);

        pniCTop.setBackground(new Color(34, 40, 44));
        pniCTop.setPreferredSize(new Dimension(0, 150));

        jLabel2.setFont(new Font("Adobe Caslon Pro", Font.BOLD, 48)); // NOI18N
        jLabel2.setForeground(new Color(0, 204, 204));
        jLabel2.setText("Voters Page");

        jPanel2.setBackground(new Color(255, 204, 204));

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 415, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 38, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new Color(153, 255, 204));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 313, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new Color(255, 255, 102));

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 175, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 39, Short.MAX_VALUE)
        );

        GroupLayout pniCTopLayout = new GroupLayout(pniCTop);
        pniCTop.setLayout(pniCTopLayout);
        pniCTopLayout.setHorizontalGroup(
                pniCTopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pniCTopLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(pniCTopLayout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 1943, Short.MAX_VALUE)
                                .addGroup(pniCTopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel4, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel3, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        );
        pniCTopLayout.setVerticalGroup(
                pniCTopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, pniCTopLayout.createSequentialGroup()
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pniCTopLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(pniCTopLayout.createSequentialGroup()
                                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(72, 72, 72))
                                        .addGroup(pniCTopLayout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pnCenter.add(pniCTop, BorderLayout.NORTH);

        pniCCenter.setBackground(new Color(30, 40, 44));

        jButton8.setForeground(new Color(240, 240, 240));
        jButton8.setIcon(new ImageIcon("C:\\IMAGE HUB\\politics-election-voting-cartoon_1284-23116.jpg")); // NOI18N
        jButton8.addActionListener(this::jButton8ActionPerformed);

        jButton12.setFont(new Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jButton12.setForeground(new Color(0, 255, 204));
        jButton12.setText("Vote");
        jButton12.setPreferredSize(new Dimension(200, 40));
        jButton12.addActionListener(this::jButton12ActionPerformed);

        jLabel8.setFont(new Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 36)); // NOI18N
        jLabel8.setForeground(new Color(0, 255, 102));
        jLabel8.setText("Admins");

        jButton14.setFont(new Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jButton14.setForeground(new Color(0, 255, 204));
        jButton14.setText("Election Status");
        jButton14.setPreferredSize(new Dimension(200, 40));
        jButton14.addActionListener(this::jButton14ActionPerformed);

        jButton15.setFont(new Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jButton15.setForeground(new Color(0, 255, 204));
        jButton15.setText("Election Results");
        jButton15.setPreferredSize(new Dimension(200, 40));
        jButton15.addActionListener(this::jButton15ActionPerformed);

        jButton16.setFont(new Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jButton16.setForeground(new Color(0, 255, 204));
        jButton16.setText("Manage Voters");
        jButton16.setPreferredSize(new Dimension(200, 40));
        jButton16.addActionListener(this::jButton16ActionPerformed);

        jButton17.setBackground(new Color(255, 102, 102));
        jButton17.setFont(new Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jButton17.setText("Logout");
        jButton17.setPreferredSize(new Dimension(200, 40));
        jButton17.addActionListener(this::jButton17ActionPerformed);
//
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {
                        "Election_ID", "Election_Name", "Start_Date", "End_Date", "Winner"
                }
        ));
        jTable1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
//
        GroupLayout pniCCenterLayout = new GroupLayout(pniCCenter);
        pniCCenter.setLayout(pniCCenterLayout);
        pniCCenterLayout.setHorizontalGroup(
                pniCCenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pniCCenterLayout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                //
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 626, GroupLayout.PREFERRED_SIZE)
                                //
                                .addGap(116, 116, 116)
                                .addGroup(pniCCenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(pniCCenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jButton12, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                                .addComponent(jButton14, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addComponent(jButton15, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addComponent(jButton17, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addComponent(jButton16, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(1934, Short.MAX_VALUE))
        );
        pniCCenterLayout.setVerticalGroup(
                pniCCenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(pniCCenterLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(pniCCenterLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(pniCCenterLayout.createSequentialGroup()
                                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(110, Short.MAX_VALUE))
        );

        pnCenter.add(pniCCenter, BorderLayout.CENTER);

        pnRoot.add(pnCenter, BorderLayout.CENTER);

        getContentPane().add(pnRoot, BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(MouseEvent evt) {
        // TODO add your handling code here:

    }

    private void jTable1AncestorAdded(AncestorEvent evt) {

    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int movetohome = JOptionPane.showConfirmDialog(null, "Do You Want to Go to VoterList Page",
                "Warning", JOptionPane.YES_NO_OPTION);
        if(movetohome == JOptionPane.YES_NO_OPTION){
            VotersList h = new VotersList();
            h.show();

            dispose();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int movetohome = JOptionPane.showConfirmDialog(null, "Do You Want to Go to Home Page",
                "Warning", JOptionPane.YES_NO_OPTION);
        if(movetohome == JOptionPane.YES_NO_OPTION){
            Home h = new Home();
            h.show();

            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int movetohome = JOptionPane.showConfirmDialog(null, "Do You Want Go to Voters Login Page",
                "Warning", JOptionPane.YES_NO_OPTION);
        if(movetohome == JOptionPane.YES_NO_OPTION){
            VotersLogin v = new VotersLogin();
            v.show();

            dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private boolean isWithinElectionPeriod() {
        String serverName = "MSI\\SQLEXPRESS";
        String databaseName = "Online-Voting";
        String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true;";
        try {
            String query = "SELECT Start_Date, End_Date FROM Election";
            PreparedStatement pst = con.prepareStatement(query);
            rs = pst.executeQuery();

            if (rs.next()) {
                LocalDate startDate = rs.getDate("Start_Date").toLocalDate();
                LocalDate endDate = rs.getDate("End_Date").toLocalDate();
                LocalDate currentDate = LocalDate.now();

                return (currentDate.isEqual(startDate) || currentDate.isAfter(startDate))
                        && (currentDate.isEqual(endDate) || currentDate.isBefore(endDate));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String serverName = "MSI\\SQLEXPRESS";
        String databaseName = "Online-Voting";
        String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true;";
        try {
            con = DriverManager.getConnection(url, "sa", "123456789");
            // Fix SQL query to prevent SQL injection vulnerability
            String query = "SELECT candidates.Email FROM candidates, voterslist WHERE Candidate_ID = VoterID AND Username = ? AND Password = ?";
            PreparedStatement pst = con.prepareStatement(query);

            // Set the username and password values from existing variables
            pst.setString(1, username);
            pst.setString(2, pwd);

            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Candidate cannot vote");
            } else {
                if (isWithinElectionPeriod()) {
                    query = "SELECT * FROM votersvoting WHERE Username = ? ";
                    pst = con.prepareStatement(query);

                    // Set the username value from existing variable
                    pst.setString(1, username);

                    rs = pst.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "You Have Contributed Your Vote Already");
                    } else {
                        VotersVotingProcess v = new VotersVotingProcess(username, pwd);
                        v.show();
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Voting is not allowed at the moment.");
                }
            }

            JOptionPane.showMessageDialog(this, "Login Failed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        ElectionStatus e = new ElectionStatus();
        e.show();

        dispose();
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        ElectionResults e = new ElectionResults();
        e.show();

        dispose();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        ManageVoters m = new ManageVoters();
        m.show();

        dispose();
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Admin Panel",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            AdminLogin a = new AdminLogin();
            a.show();

            dispose();
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int movetohome = JOptionPane.showConfirmDialog(null, "Do You Want to LogOut",
                "Warning", JOptionPane.YES_NO_OPTION);
        if(movetohome == JOptionPane.YES_NO_OPTION){
            AdminLogin h = new AdminLogin();
            h.show();

            dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int movetohome = JOptionPane.showConfirmDialog(null, "Do You Want to Go to Canditates Page",
                "Warning", JOptionPane.YES_NO_OPTION);
        if(movetohome == JOptionPane.YES_NO_OPTION){
            Canditates h = new Canditates();
            h.show();

            dispose();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(VotersVotingProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VotersVotingProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VotersVotingProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VotersVotingProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VotersPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jButton1;
    private JButton jButton12;
    private JButton jButton13;
    private JButton jButton14;
    private JButton jButton15;
    private JButton jButton16;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton7;
    //
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}