/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Voters;

import Admin.VotersPage;
import General.*;
import Admin.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author welcome
 */
public class VotersVotingProcess extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q, i, id, deleteItem;

    String Voter_ID;
    String Election_ID;


    public VotersVotingProcess(String Voter_ID, String Election_ID) {
        initComponents();
        JButton [] btns = {jButton1, jButton2, jButton3, jButton4, jButton5, jButton7};
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


        this.Voter_ID =Voter_ID;
        this.Election_ID = Election_ID;

    }

    private VotersVotingProcess() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        JPanel jPanel5 = new JPanel();
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
        JButton jButton15 = new JButton();
        JPanel pniCCenter = new JPanel();
        JLabel jLabel8 = new JLabel();
        JScrollPane jScrollPane1 = new JScrollPane();
        jTable1 = new javax.swing.JTable();
        JButton jButton8 = new JButton();
        JButton jButton9 = new JButton();
        JButton jButton10 = new JButton();
        JButton jButton11 = new JButton();
        JButton jButton12 = new JButton();
        JButton jButton14 = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnRoot.setLayout(new java.awt.BorderLayout());

        pnSide.setBackground(new java.awt.Color(21, 25, 28));
        pnSide.setPreferredSize(new java.awt.Dimension(250, 0));

        jPanel1.setBackground(new java.awt.Color(21, 25, 28));
        jPanel1.setPreferredSize(new java.awt.Dimension(270, 150));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 40));

        jButton6.setBackground(new java.awt.Color(0, 0, 0));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("VOTE IS OUR RIGHT");
        jButton6.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel1.add(jButton6);

        pnSide.add(jPanel1);

        jButton1.setForeground(new java.awt.Color(0, 255, 204));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\icons hub\\icons8-home-25.png")); // NOI18N
        jButton1.setText(" HOME");
        jButton1.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(this::jButton1ActionPerformed);
        pnSide.add(jButton1);

        jButton2.setForeground(new java.awt.Color(0, 255, 204));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\icons hub\\icons8-elections-25.png")); // NOI18N
        jButton2.setText("VOTERS");
        jButton2.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton2.addActionListener(this::jButton2ActionPerformed);
        pnSide.add(jButton2);

        jButton3.setForeground(new java.awt.Color(0, 255, 204));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\icons hub\\icons8-people-25.png")); // NOI18N
        jButton3.setText("ADMINISTRATOR");
        jButton3.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton3.addActionListener(this::jButton3ActionPerformed);
        pnSide.add(jButton3);

        jButton4.setForeground(new java.awt.Color(0, 255, 204));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\icons hub\\icons8-leader-25.png")); // NOI18N
        jButton4.setText("CANDIDATES");
        jButton4.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton4.addActionListener(this::jButton4ActionPerformed);
        pnSide.add(jButton4);

        jButton5.setForeground(new java.awt.Color(0, 255, 204));
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\icons hub\\icons8-list-25.png")); // NOI18N
        jButton5.setText("VOTER LIST");
        jButton5.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton5.addActionListener(this::jButton5ActionPerformed);
        pnSide.add(jButton5);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 250, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        pnSide.add(jPanel5);

        pnRoot.add(pnSide, java.awt.BorderLayout.WEST);

        pnCenter.setBackground(new java.awt.Color(34, 40, 44));
        pnCenter.setLayout(new java.awt.BorderLayout());

        pnCBottom.setBackground(new java.awt.Color(30, 40, 44));
        pnCBottom.setPreferredSize(new java.awt.Dimension(734, 100));

        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("INTERNATIONAL UNIVERSITY");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Group 6 - PDM");

        jLabel4.setForeground(new java.awt.Color(0, 204, 204));
        jLabel4.setText("Copyright © 2021 PSG");

        javax.swing.GroupLayout pnCBottomLayout = new javax.swing.GroupLayout(pnCBottom);
        pnCBottom.setLayout(pnCBottomLayout);
        pnCBottomLayout.setHorizontalGroup(
                pnCBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnCBottomLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel1)
                                .addGap(105, 105, 105)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1282, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(176, 176, 176))
        );
        pnCBottomLayout.setVerticalGroup(
                pnCBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnCBottomLayout.createSequentialGroup()
                                .addContainerGap(37, Short.MAX_VALUE)
                                .addGroup(pnCBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                .addGap(23, 23, 23))
        );

        pnCenter.add(pnCBottom, java.awt.BorderLayout.SOUTH);

        pniCTop.setBackground(new java.awt.Color(34, 40, 44));
        pniCTop.setPreferredSize(new java.awt.Dimension(0, 150));

        jLabel2.setFont(new java.awt.Font("Adobe Caslon Pro", Font.BOLD, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setText("Cast Your Vote");

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 415, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 38, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 313, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 39, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 102));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 175, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 39, Short.MAX_VALUE)
        );

        jButton15.setIcon(new javax.swing.ImageIcon("C:\\icons hub\\icons8-back-25.png")); // NOI18N
        jButton15.setText("Back");
        jButton15.addActionListener(this::jButton15ActionPerformed);

        javax.swing.GroupLayout pniCTopLayout = new javax.swing.GroupLayout(pniCTop);
        pniCTop.setLayout(pniCTopLayout);
        pniCTopLayout.setHorizontalGroup(
                pniCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pniCTopLayout.createSequentialGroup()
                                .addContainerGap(1728, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pniCTopLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(102, 102, 102)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pniCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        pniCTopLayout.setVerticalGroup(
                pniCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pniCTopLayout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pniCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pniCTopLayout.createSequentialGroup()
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(72, 72, 72))
                                        .addGroup(pniCTopLayout.createSequentialGroup()
                                                .addGroup(pniCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pnCenter.add(pniCTop, java.awt.BorderLayout.NORTH);

        pniCCenter.setBackground(new java.awt.Color(30, 40, 44));

        jLabel8.setFont(new java.awt.Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 255, 102));
        jLabel8.setText("Click The No Button To Cast Your Vote");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}
                },
                new String [] {
                        "Candidate_No","Candidate_ID", "Full_name", "Gender", "Age", "Email"
                }
        ));
        jTable1.setEnabled(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton8.setIcon(new javax.swing.ImageIcon("Image and Icon\\num1.png")); // NOI18N
        jButton8.addActionListener(this::jButton8ActionPerformed);

        jButton9.setIcon(new javax.swing.ImageIcon("Image and Icon\\num2.png")); // NOI18N
        jButton9.addActionListener(this::jButton9ActionPerformed);

        jButton10.setIcon(new javax.swing.ImageIcon("Image and Icon\\num3.png")); // NOI18N
        jButton10.addActionListener(this::jButton10ActionPerformed);

        jButton11.setIcon(new javax.swing.ImageIcon("Image and Icon\\num4.png")); // NOI18N
        jButton11.addActionListener(this::jButton11ActionPerformed);

        jButton12.setIcon(new javax.swing.ImageIcon("Image and Icon\\num5.png")); // NOI18N
        jButton12.addActionListener(this::jButton12ActionPerformed);

        jButton14.setIcon(new javax.swing.ImageIcon("Image and Icon\\")); // NOI18N
        jButton14.setText("Refresh");
        jButton14.addActionListener(this::jButton14ActionPerformed);

        javax.swing.GroupLayout pniCCenterLayout = new javax.swing.GroupLayout(pniCCenter);
        pniCCenter.setLayout(pniCCenterLayout);
        pniCCenterLayout.setHorizontalGroup(
                pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pniCCenterLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(pniCCenterLayout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 821, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(74, 74, 74)
                                                .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                                                .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pniCCenterLayout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(1167, Short.MAX_VALUE))
        );
        pniCCenterLayout.setVerticalGroup(
                pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pniCCenterLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pniCCenterLayout.createSequentialGroup()
                                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(34, 34, 34)
                                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(55, Short.MAX_VALUE))
        );

        pnCenter.add(pniCCenter, java.awt.BorderLayout.CENTER);

        pnRoot.add(pnCenter, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnRoot, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
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
        int movetohome = JOptionPane.showConfirmDialog(null, "Do You Want to LogOut",
                "Warning", JOptionPane.YES_NO_OPTION);
        if(movetohome == JOptionPane.YES_NO_OPTION){
            VotersLogin h = new VotersLogin();
            h.show();

            dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int movetohome = JOptionPane.showConfirmDialog(null, "Do You Want to Go to Admins Login Page",
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
            Candidates h = new Candidates();
            h.show();

            dispose();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        String serverName = "LAPTOP-O6MDECFV\\SQLEXPRESS";
        String databaseName = "Online-Voting";
        String username = "sa";
        String password = "123456789";
        String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true;";
        try{

            con = DriverManager.getConnection(url, username, password);
            pst = con.prepareStatement("select distinct c.* from Candidate c, votes v where c.Candidate_ID = v.Candidate_ID AND v.Election_ID =?");
            pst.setString(1, Election_ID);
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();

            q = stData.getColumnCount();

            // Define custom column names
            String[] columnNames = {"Candidate_ID","Candidate_No", "Full_name", "Gender", "Age", "Email"};

            DefaultTableModel RecordTable = new DefaultTableModel(columnNames, 0);
            jTable1.setModel(RecordTable);

            while (rs.next()){
                Vector columnData = new Vector();

                for(i = 1;i <= q; i++){
                    columnData.add(rs.getString("Candidate_ID"));
                    columnData.add(rs.getString("Candidate_No"));
                    columnData.add(rs.getString("Full_name"));
                    columnData.add(rs.getString("Gender"));
                    columnData.add(rs.getString("Age"));
                    columnData.add(rs.getString("Email"));

                }
                RecordTable.addRow(columnData);
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        // int vote = 1;
        String serverName = "LAPTOP-O6MDECFV\\SQLEXPRESS";
        String databaseName = "Online-Voting";
        String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true;";
        try{
            con = DriverManager.getConnection(url, "sa", "123456789");
            System.out.println("Connected To MySql Database!");
            pst = con.prepareStatement("SELECT Distinct c.Candidate_ID From Candidate c, votes vs WHERE c.Candidate_ID = vs.Candidate_ID AND vs.Election_ID = ?  AND Candidate_No = 1");
            pst.setString(1, Election_ID);
            rs = pst.executeQuery();

            if (rs.next()) {
                String Candidate_ID = rs.getString("Candidate_ID");

                pst = con.prepareStatement("insert into votes values(?,?,?);");

                pst.setString(1, Candidate_ID);
                pst.setString(2, Voter_ID);
                pst.setString(3, Election_ID);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Your Vote Is Casted");

                VotersPage h = new VotersPage(Voter_ID);
                h.show();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No candidate found for the given criteria.");
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        // int vote = 2;
        String serverName = "LAPTOP-O6MDECFV\\SQLEXPRESS";
        String databaseName = "Online-Voting";
        String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true;";
        try{
            con = DriverManager.getConnection(url, "sa", "123456789");
            System.out.println("Connected To MySql Database!");
            pst = con.prepareStatement("SELECT Distinct c.Candidate_ID From Candidate c, votes vs WHERE c.Candidate_ID = vs.Candidate_ID AND vs.Election_ID = ?  AND Candidate_No = 2");
            pst.setString(1, Election_ID);
            rs = pst.executeQuery();

            if (rs.next()) {
                String Candidate_ID = rs.getString("Candidate_ID");

                pst = con.prepareStatement("insert into votes values(?,?,?);");

                pst.setString(1, Candidate_ID);
                pst.setString(2, Voter_ID);
                pst.setString(3, Election_ID);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Your Vote Is Casted");

                VotersPage h = new VotersPage(Voter_ID);
                h.show();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No candidate found for the given criteria.");
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        // int vote = 3;
        String serverName = "LAPTOP-O6MDECFV\\SQLEXPRESS";
        String databaseName = "Online-Voting";
        String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true;";
        try{
            con = DriverManager.getConnection(url, "sa", "123456789");
            System.out.println("Connected To MySql Database!");
            pst = con.prepareStatement("SELECT Distinct c.Candidate_ID From Candidate c, votes vs WHERE c.Candidate_ID = vs.Candidate_ID AND vs.Election_ID = ?  AND Candidate_No = 3");
            pst.setString(1, Election_ID);
            rs = pst.executeQuery();

            if (rs.next()) {
                String Candidate_ID = rs.getString("Candidate_ID");

                pst = con.prepareStatement("insert into votes values(?,?,?);");

                pst.setString(1, Candidate_ID);
                pst.setString(2, Voter_ID);
                pst.setString(3, Election_ID);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Your Vote Is Casted");

                VotersPage h = new VotersPage(Voter_ID);
                h.show();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No candidate found for the given criteria.");
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        // int vote = 4;
        String serverName = "LAPTOP-O6MDECFV\\SQLEXPRESS";
        String databaseName = "Online-Voting";
        String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true;";
        try{
            con = DriverManager.getConnection(url, "sa", "123456789");
            System.out.println("Connected To MySql Database!");
            pst = con.prepareStatement("SELECT Distinct c.Candidate_ID From Candidate c, votes vs WHERE c.Candidate_ID = vs.Candidate_ID AND vs.Election_ID = ?  AND Candidate_No = 4");
            pst.setString(1, Election_ID);
            rs = pst.executeQuery();

            if (rs.next()) {
                String Candidate_ID = rs.getString("Candidate_ID");

                pst = con.prepareStatement("insert into votes values(?,?,?);");

                pst.setString(1, Candidate_ID);
                pst.setString(2, Voter_ID);
                pst.setString(3, Election_ID);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Your Vote Is Casted");

                VotersPage h = new VotersPage(Voter_ID);
                h.show();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No candidate found for the given criteria.");
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        // int vote = 5;
        String serverName = "LAPTOP-O6MDECFV\\SQLEXPRESS";
        String databaseName = "Online-Voting";
        String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true;";
        try{
            con = DriverManager.getConnection(url, "sa", "123456789");
            System.out.println("Connected To MySql Database!");
            pst = con.prepareStatement("SELECT Distinct c.Candidate_ID From Candidate c, votes vs WHERE c.Candidate_ID = vs.Candidate_ID AND vs.Election_ID = ?  AND Candidate_No = 5");
            pst.setString(1, Election_ID);
            rs = pst.executeQuery();

            if (rs.next()) {
                String Candidate_ID = rs.getString("Candidate_ID");

                pst = con.prepareStatement("insert into votes values(?,?,?);");

                pst.setString(1, Candidate_ID);
                pst.setString(2, Voter_ID);
                pst.setString(3, Election_ID);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Your Vote Is Casted");

                VotersPage h = new VotersPage(Voter_ID);
                h.show();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No candidate found for the given criteria.");
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        int movetohome = JOptionPane.showConfirmDialog(null, "Do You Want to LogOut",
                "Warning", JOptionPane.YES_NO_OPTION);
        if(movetohome == JOptionPane.YES_NO_OPTION){
            VotersPage h = new VotersPage(Election_ID);
            h.show();

            dispose();
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://d...content-available-to-author-only...e.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VotersVotingProcess.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VotersVotingProcess().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
