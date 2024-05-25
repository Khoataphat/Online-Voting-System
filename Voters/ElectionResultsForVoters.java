/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Voters;

import Admin.VotersPage;
import General.*;
import Admin.*;
import Voters.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author welcome
 */
public class ElectionResultsForVoters extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private static String  Voter_ID;
    private static String Election_ID;
    public ElectionResultsForVoters(String Election_ID, String Voter_ID) {
        initComponents();
        ElectionResultsForVoters.Election_ID = Election_ID;
        ElectionResultsForVoters.Voter_ID = Voter_ID;
        upDateDB();
        JButton [] btns = {jButton1, jButton2, jButton3, jButton4, jButton5, jButton7, jButton13};
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
    }


    public int noCand(){
        String serverName = "MSI\\SQLEXPRESS";
        String databaseName = "Online-Voting";
        String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true;";

        try{
            con = DriverManager.getConnection(url, "sa", "123456789");
            pst = con.prepareStatement("SELECT count(DISTINCT(Candidate_ID)) AS Total FROM votes vs WHERE Election_ID =?");
            pst.setString(1, Election_ID);

            rs = pst.executeQuery();
            if(rs.next()){
                String noofcandidates = rs.getString("Total");
                jLabel12.setText(noofcandidates);

            }

            else{
                return 0;
            }

        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }


    public int novoters(){
        String serverName = "MSI\\SQLEXPRESS";
        String databaseName = "Online-Voting";
        String username = "sa";
        String password = "123456789";
        String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true;";

        try{
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            pst = con.prepareStatement("SELECT COUNT(v.Voter_ID) AS Voter_Count FROM votes v WHERE v.Election_ID = ? AND v.Voter_ID IS NOT NULL ");
            pst.setString(1, Election_ID);
            rs = pst.executeQuery();


            if(rs.next()){
                String noofvoters = rs.getString("Voter_Count");
                jLabel10.setText(noofvoters);
            }

            else{
                return 0;
            }

        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return 0;
    }

    public void upDateDB(){
        String serverName = "MSI\\SQLEXPRESS";
        String databaseName = "Online-Voting";
        String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true;";

        jPanel7.setBackground(new java.awt.Color(255, 141, 202, 255));
        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);

        jPanel8.setBackground(new java.awt.Color(152, 170, 248));
        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);

        jPanel9.setBackground(new java.awt.Color(16, 246, 121));
        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);

        jPanel10.setBackground(new java.awt.Color(208, 84, 255));
        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);

        jPanel11.setBackground(new java.awt.Color(253, 143, 79));
        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);

        try{
            con = DriverManager.getConnection(url, "sa", "123456789");
            pst = con.prepareStatement("with total_votes_base_candidate as (\n" +
                    "select Candidate_ID, Election_ID, COUNT(Voter_ID) 'total based on candidate'\n" +
                    "from votes\n" +
                    "where Candidate_ID is not null and \n" +
                    "Election_ID is not null and Voter_ID is not null\n" +
                    "group by Candidate_ID, Election_ID\n" +
                    "),\n" +
                    "total_based_on_election as (\n" +
                    "select Election_ID, count(Voter_ID)  'total based on Voter'\n" +
                    "from votes \n" +
                    "where Election_ID is not null\n" +
                    "group by Election_ID \n" +
                    ")\n" +
                    "select Candidate.Candidate_ID, Candidate.Candidate_No, Candidate.Full_name, total_based_on_election.Election_ID, \n" +
                    "                                                    Cast(([total based on candidate]*100.0 / [total based on Voter]) as decimal(18,2))  PERCENTAGE\n" +
                    "from total_based_on_election, total_votes_base_candidate, Candidate\n" +
                    "where total_based_on_election.Election_ID = total_votes_base_candidate.Election_ID\n" +
                    "and Candidate.Candidate_ID = [total_votes_base_candidate].Candidate_ID\n" +
                    "and Candidate_No = 1\n" +
                    "and total_based_on_election.Election_ID = ?");
            pst.setString(1, Election_ID);
            rs = pst.executeQuery();
            if(rs.next()){
                lb01.setText(rs.getString("Full_name"));

                jPanel7Layout.setHorizontalGroup(
                        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 0, Short.MAX_VALUE)
                );
                jPanel7Layout.setVerticalGroup(
                        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 4 * rs.getInt("PERCENTAGE"), Short.MAX_VALUE)
                );
            }
            else{
                lb01.setText("No Candidate");
            }

        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        try{
            con = DriverManager.getConnection(url, "sa", "123456789");
            pst = con.prepareStatement("with total_votes_base_candidate as (\n" +
                    "select Candidate_ID, Election_ID, COUNT(Voter_ID) 'total based on candidate'\n" +
                    "from votes\n" +
                    "where Candidate_ID is not null and \n" +
                    "Election_ID is not null and Voter_ID is not null\n" +
                    "group by Candidate_ID, Election_ID\n" +
                    "),\n" +
                    "total_based_on_election as (\n" +
                    "select Election_ID, count(Voter_ID)  'total based on Voter'\n" +
                    "from votes \n" +
                    "where Election_ID is not null\n" +
                    "group by Election_ID \n" +
                    ")\n" +
                    "select Candidate.Candidate_ID, Candidate.Candidate_No, Candidate.Full_name, total_based_on_election.Election_ID, \n" +
                    "                                                    Cast(([total based on candidate]*100.0 / [total based on Voter]) as decimal(18,2))  PERCENTAGE\n" +
                    "from total_based_on_election, total_votes_base_candidate, Candidate\n" +
                    "where total_based_on_election.Election_ID = total_votes_base_candidate.Election_ID\n" +
                    "and Candidate.Candidate_ID = [total_votes_base_candidate].Candidate_ID\n" +
                    "and Candidate_No = 2\n" +
                    "and total_based_on_election.Election_ID = ?");
            pst.setString(1, Election_ID);
            rs = pst.executeQuery();
            if(rs.next()){
                lb02.setText(rs.getString("Full_name"));

                jPanel8Layout.setHorizontalGroup(
                        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 0, Short.MAX_VALUE)
                );
                jPanel8Layout.setVerticalGroup(
                        jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 4 * rs.getInt("PERCENTAGE"), Short.MAX_VALUE)
                );
            }
            else{
                lb02.setText("No Candidate");
            }

        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        try{
            con = DriverManager.getConnection(url, "sa", "123456789");
            pst = con.prepareStatement("with total_votes_base_candidate as (\n" +
                    "select Candidate_ID, Election_ID, COUNT(Voter_ID) 'total based on candidate'\n" +
                    "from votes\n" +
                    "where Candidate_ID is not null and \n" +
                    "Election_ID is not null and Voter_ID is not null\n" +
                    "group by Candidate_ID, Election_ID\n" +
                    "),\n" +
                    "total_based_on_election as (\n" +
                    "select Election_ID, count(Voter_ID)  'total based on Voter'\n" +
                    "from votes \n" +
                    "where Election_ID is not null\n" +
                    "group by Election_ID \n" +
                    ")\n" +
                    "select Candidate.Candidate_ID, Candidate.Candidate_No, Candidate.Full_name, total_based_on_election.Election_ID, \n" +
                    "                                                   Cast(([total based on candidate]*100.0 / [total based on Voter]) as decimal(18,2)) PERCENTAGE\n" +
                    "from total_based_on_election, total_votes_base_candidate, Candidate\n" +
                    "where total_based_on_election.Election_ID = total_votes_base_candidate.Election_ID\n" +
                    "and Candidate.Candidate_ID = [total_votes_base_candidate].Candidate_ID\n" +
                    "and Candidate_No = 3\n" +
                    "and total_based_on_election.Election_ID = ?");
            pst.setString(1, Election_ID);
            rs = pst.executeQuery();
            if(rs.next()){
                lb03.setText(rs.getString("Full_name"));

                jPanel9Layout.setHorizontalGroup(
                        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 0, Short.MAX_VALUE)
                );
                jPanel9Layout.setVerticalGroup(
                        jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 4 * rs.getInt("PERCENTAGE"), Short.MAX_VALUE)
                );
            }
            else{
                lb03.setText("No Candidate");
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        try{
            con = DriverManager.getConnection(url, "sa", "123456789");
            pst = con.prepareStatement("with total_votes_base_candidate as (\n" +
                    "select Candidate_ID, Election_ID, COUNT(Voter_ID) 'total based on candidate'\n" +
                    "from votes\n" +
                    "where Candidate_ID is not null and \n" +
                    "Election_ID is not null and Voter_ID is not null\n" +
                    "group by Candidate_ID, Election_ID\n" +
                    "),\n" +
                    "total_based_on_election as (\n" +
                    "select Election_ID, count(Voter_ID)  'total based on Voter'\n" +
                    "from votes \n" +
                    "where Election_ID is not null\n" +
                    "group by Election_ID \n" +
                    ")\n" +
                    "select Candidate.Candidate_ID, Candidate.Candidate_No, Candidate.Full_name, total_based_on_election.Election_ID, \n" +
                    "                                                Cast(([total based on candidate]*100.0 / [total based on Voter]) as decimal(18,2))   PERCENTAGE\n" +
                    "from total_based_on_election, total_votes_base_candidate, Candidate\n" +
                    "where total_based_on_election.Election_ID = total_votes_base_candidate.Election_ID\n" +
                    "and Candidate.Candidate_ID = [total_votes_base_candidate].Candidate_ID\n" +
                    "and Candidate_No = 4\n" +
                    "and total_based_on_election.Election_ID = ?");
            pst.setString(1, Election_ID);
            rs = pst.executeQuery();
            if(rs.next()){
                lb04.setText(rs.getString("Full_name"));

                jPanel10Layout.setHorizontalGroup(
                        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 0, Short.MAX_VALUE)
                );
                jPanel10Layout.setVerticalGroup(
                        jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 4 * rs.getInt("PERCENTAGE"), Short.MAX_VALUE)
                );
            }
            else{
                lb04.setText("No Candidate");
            }

        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        try{
            con = DriverManager.getConnection(url, "sa", "123456789");
            pst = con.prepareStatement("with total_votes_base_candidate as (\n" +
                    "select Candidate_ID, Election_ID, COUNT(Voter_ID) 'total based on candidate'\n" +
                    "from votes\n" +
                    "where Candidate_ID is not null and \n" +
                    "Election_ID is not null and Voter_ID is not null\n" +
                    "group by Candidate_ID, Election_ID\n" +
                    "),\n" +
                    "total_based_on_election as (\n" +
                    "select Election_ID, count(Voter_ID)  'total based on Voter'\n" +
                    "from votes \n" +
                    "where Election_ID is not null\n" +
                    "group by Election_ID \n" +
                    ")\n" +
                    "select Candidate.Candidate_ID, Candidate.Candidate_No, Candidate.Full_name, total_based_on_election.Election_ID, \n" +
                    "                                                    Cast(([total based on candidate]*100.0 / [total based on Voter]) as decimal(18,2))  PERCENTAGE\n" +
                    "from total_based_on_election, total_votes_base_candidate, Candidate\n" +
                    "where total_based_on_election.Election_ID = total_votes_base_candidate.Election_ID\n" +
                    "and Candidate.Candidate_ID = [total_votes_base_candidate].Candidate_ID\n" +
                    "and Candidate_No = 5\n" +
                    "and total_based_on_election.Election_ID = ?");
            pst.setString(1, Election_ID);
            rs = pst.executeQuery();
            if(rs.next()){
                lb05.setText(rs.getString("Full_name"));

                jPanel11Layout.setHorizontalGroup(
                        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 0, Short.MAX_VALUE)
                );
                jPanel11Layout.setVerticalGroup(
                        jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGap(0, 4 * rs.getInt("PERCENTAGE"), Short.MAX_VALUE)
                );
            }
            else{
                lb05.setText("No Candidate");
            }
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        noCand();
        novoters();

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
        JPanel jPanel6 = new JPanel();
        jButton13 = new javax.swing.JButton();
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
        JButton jButton9 = new JButton();
        JButton jButton8 = new JButton();
        JPanel pniCCenter = new JPanel();
        JLabel jLabel8 = new JLabel();
        JButton jButton17 = new JButton();
        JLabel jLabel9 = new JLabel();
        jLabel10 = new javax.swing.JLabel();
        JLabel jLabel11 = new JLabel();
        jLabel12 = new javax.swing.JLabel();
        JLabel jLabel13 = new JLabel();
        jPanel7 = new javax.swing.JPanel();
        lb03 = new javax.swing.JLabel();
        lb02 = new javax.swing.JLabel();
        lb04 = new javax.swing.JLabel();
        lb01 = new javax.swing.JLabel();
        lb05 = new javax.swing.JLabel();

        jLabel15 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

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
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\icons hub\\icons8-home-25.png"));
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
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\icons hub\\icons8-elections-25.png"));
        jButton2.setText("VOTERS");
        jButton2.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton2.addActionListener(this::jButton2ActionPerformed);
        pnSide.add(jButton2);

        jButton3.setForeground(new java.awt.Color(0, 255, 204));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\icons hub\\icons8-people-25.png"));
        jButton3.setText("ADMINISTRATOR");
        jButton3.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton3.addActionListener(this::jButton3ActionPerformed);
        pnSide.add(jButton3);

        jButton4.setForeground(new java.awt.Color(0, 255, 204));
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\icons hub\\icons8-leader-25.png"));
        jButton4.setText("CANDIDATES");
        jButton4.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton4.addActionListener(this::jButton4ActionPerformed);
        pnSide.add(jButton4);

        jButton5.setForeground(new java.awt.Color(0, 255, 204));
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\icons hub\\icons8-list-25.png"));
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

        jPanel6.setBackground(new java.awt.Color(34, 40, 44));
        jPanel6.setMinimumSize(new java.awt.Dimension(200, 280));
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 280));

        pnRoot.add(pnSide, java.awt.BorderLayout.WEST);

        pnCenter.setBackground(new java.awt.Color(34, 40, 44));
        pnCenter.setLayout(new java.awt.BorderLayout());

        pnCBottom.setBackground(new java.awt.Color(30, 40, 44));
        pnCBottom.setPreferredSize(new java.awt.Dimension(734, 100));

        jLabel1.setForeground(new java.awt.Color(0, 204, 204));
        jLabel1.setText("INTERNATIONAL UNIVERSITY");

        jLabel3.setForeground(new java.awt.Color(0, 204, 204));
        jLabel3.setText("Group 5");

        jLabel4.setForeground(new java.awt.Color(0, 204, 204));
        jLabel4.setText("Copyright © 2021 PSG");

        javax.swing.GroupLayout pnCBottomLayout = new javax.swing.GroupLayout(pnCBottom);
        pnCBottom.setLayout(pnCBottomLayout);
        pnCBottomLayout.setHorizontalGroup(
                pnCBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnCBottomLayout.createSequentialGroup()
                                .addGap(80, 80, 120)
                                .addComponent(jLabel1)
                                .addGap(105, 105, 150)
                                .addComponent(jLabel4)
                                .addGap(105, 105, 150)
                                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2819, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(80, 80, 100))
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

        jLabel2.setFont(new java.awt.Font("Adobe Caslon Pro", Font.BOLD, 48));
        jLabel2.setForeground(new java.awt.Color(0, 204, 204));
        jLabel2.setText("Election Results");

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

        jPanel3.setBackground(new java.awt.Color(0, 255, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 313, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 41, Short.MAX_VALUE)
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

        jButton9.setIcon(new javax.swing.ImageIcon("C:\\icons hub\\icons8-back-25.png"));
        jButton9.setText("Back");
        jButton9.addActionListener(this::jButton9ActionPerformed);

        jButton8.setIcon(new javax.swing.ImageIcon("C:\\icons hub\\icons8-refresh-32.png"));
        jButton8.setText("Click");
        jButton8.addActionListener(this::jButton8ActionPerformed);

        javax.swing.GroupLayout pniCTopLayout = new javax.swing.GroupLayout(pniCTop);
        pniCTop.setLayout(pniCTopLayout);
        pniCTopLayout.setHorizontalGroup(
                pniCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pniCTopLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pniCTopLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jButton9)
                                .addGap(105, 105, 105)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2747, Short.MAX_VALUE)
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
                                                .addGroup(pniCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                                                )
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(72, 72, 72))
                                        .addGroup(pniCTopLayout.createSequentialGroup()
                                                .addGroup(pniCTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jButton8)
                                                        .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pnCenter.add(pniCTop, java.awt.BorderLayout.NORTH);

        pniCCenter.setBackground(new java.awt.Color(30, 40, 44));

        jLabel8.setFont(new java.awt.Font("Adobe Caslon Pro Bold", Font.BOLD | Font.ITALIC, 36));
        jLabel8.setForeground(new java.awt.Color(0, 255, 102));
        jLabel8.setText("Admins");

        jButton17.setBackground(new java.awt.Color(232, 10, 10));
        jButton17.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18));
        jButton17.setText("Logout");
        jButton17.setPreferredSize(new java.awt.Dimension(200, 40));
        jButton17.addActionListener(this::jButton17ActionPerformed);

        jLabel9.setFont(new java.awt.Font("Adobe Caslon Pro", Font.ITALIC, 14));
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setText("No of People Contributed Upto ");

        jLabel10.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14));
        jLabel10.setForeground(new java.awt.Color(0, 255, 0));

        jLabel12.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 14));
        jLabel12.setForeground(new java.awt.Color(0, 255, 0));

        jLabel11.setFont(new java.awt.Font("Adobe Caslon Pro", Font.ITALIC, 14));
        jLabel11.setForeground(new java.awt.Color(255, 255, 0));
        jLabel11.setText("No of Canditates Partcipating");

        jLabel13.setFont(new java.awt.Font("Adobe Caslon Pro", Font.ITALIC, 14));
        jLabel13.setForeground(new java.awt.Color(255, 255, 0));
        jLabel13.setText("this time");

        jPanel7.setBackground(new java.awt.Color(0, 255, 204));


        lb03.setForeground(new java.awt.Color(0, 255, 204));
        lb03.setText("03");

        lb02.setForeground(new java.awt.Color(0, 255, 204));
        lb02.setText("02");

        lb04.setForeground(new java.awt.Color(0, 255, 204));
        lb04.setText("04");

        lb01.setForeground(new java.awt.Color(0, 255, 204));
        lb01.setText("01");

        lb05.setForeground(new java.awt.Color(0, 255, 204));
        lb05.setText("05");

        jLabel14.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 23));
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 23));
        jLabel15.setForeground(new java.awt.Color(248, 255, 0));

        jLabel19.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 23));
        jLabel19.setForeground(new java.awt.Color(248, 255, 0));

        jLabel20.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 30));
        jLabel20.setForeground(new java.awt.Color(102, 255, 102));

        jLabel22.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 30));
        jLabel22.setForeground(new java.awt.Color(102, 133, 255));

        jLabel16.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 23));
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 23));
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20));
        jLabel18.setForeground(new java.awt.Color(255, 255, 0));


        javax.swing.GroupLayout pniCCenterLayout = new javax.swing.GroupLayout(pniCCenter);
        pniCCenter.setLayout(pniCCenterLayout);
        pniCCenterLayout.setHorizontalGroup(
                pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pniCCenterLayout.createSequentialGroup()
                                .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pniCCenterLayout.createSequentialGroup()
                                                .addGroup(pniCCenterLayout.createSequentialGroup()
                                                        .addGap(74, 74, 74)
                                                        .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(lb01, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                                                .addComponent(jPanel7,javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGap(47, 47, 47)
                                                        .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(lb02, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGap(44, 44, 44)
                                                        .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(lb03, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGap(45, 45, 45)
                                                        .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(lb04, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                                                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGap(47, 47, 47)
                                                        .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,false)
                                                                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(lb05, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)))
                                                .addGap(50,50,50)
                                                .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(pniCCenterLayout.createSequentialGroup()
                                                                .addComponent(jLabel13)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(jLabel9)
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(pniCCenterLayout.createSequentialGroup()
                                                                .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))

                                        .addGroup(pniCCenterLayout.createSequentialGroup()
                                                .addGap(95, 95, 95)
                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(9, 9, 9)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(9, 9, 9)
                                                .addComponent(jLabel17))
                                        .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                                                .addGroup(pniCCenterLayout.createSequentialGroup()
                                                        .addGap(95, 95, 95)
                                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGap(9, 9, 9 )
                                                        .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel19,javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGap(80, 80, 80)
                                                        .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))))
                                .addContainerGap(2783, Short.MAX_VALUE))
        );
        pniCCenterLayout.setVerticalGroup(
                pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pniCCenterLayout.createSequentialGroup()
                                .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pniCCenterLayout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(2, 2, 2)
                                                .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel13))
                                                .addGap(82, 82, 82)
                                                .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                                                .addGap(100)
                                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))

                                        .addGroup(pniCCenterLayout.createSequentialGroup()
                                                .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGap (250)
                                                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lb01, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lb02, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lb03, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lb04, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lb05, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))

                                .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(pniCCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(182, Short.MAX_VALUE))
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
        int movetohome = JOptionPane.showConfirmDialog(null, "Do You Want Go to Voters Login Page",
                "Warning", JOptionPane.YES_NO_OPTION);
        if(movetohome == JOptionPane.YES_NO_OPTION){
            VotersLogin v = new VotersLogin();
            v.show();

            dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        JFrame frame = new JFrame("Exit");
        if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Admin Panel",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            AdminLogin c = new AdminLogin();
            c.show();

            dispose();
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        VotersPage h = new VotersPage(Voter_ID);
        h.show();

        dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel7MouseClicked

    private boolean isAfterElectionPeriod(String Election_ID) {
        String serverName = "MSI\\SQLEXPRESS";
        String databaseName = "Online-Voting";
        String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true;";
        try {
            PreparedStatement pst = con.prepareStatement("SELECT End_date FROM Election WHERE Election_ID =?");
            pst.setString(1, Election_ID);
            rs = pst.executeQuery();

            if (rs.next()) {
                LocalDateTime endDate = rs.getTimestamp("End_date").toLocalDateTime();
                LocalDateTime currentDate = LocalDateTime.now();

                return (currentDate.isAfter(endDate) || (currentDate.isEqual(endDate) ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        String serverName = "MSI\\SQLEXPRESS";
        String databaseName = "Online-Voting";
        String url = "jdbc:sqlserver://" + serverName + ":1433;databaseName=" + databaseName + ";encrypt=true;trustServerCertificate=true;";

        if(isAfterElectionPeriod(Election_ID)) {
            try {
                con = DriverManager.getConnection(url, "sa", "123456789");
                pst = con.prepareStatement("with counter_votes as (\n" +
                        "select Candidate_ID, Election_ID,  Count(Voter_ID) 'count'\n" +
                        "from votes\n" +
                        "where Candidate_ID is not null and \n" +
                        "Election_ID is not null and Voter_ID is not null\n" +
                        "group by votes.Candidate_ID, Election_ID), \n" +
                        "max_votes as (\n" +
                        "select max(count) 'Max'\n" +
                        "from counter_votes\n" +
                        "group by Election_ID)\n" +
                        "\n" +
                        "select counter_votes.*, Candidate.Full_name\n" +
                        "from max_votes, counter_votes, Candidate\n" +
                        "where max_votes.[Max] = counter_votes.[count]\n" +
                        "and counter_votes.Candidate_ID = Candidate.Candidate_ID\n" +
                        "and Election_ID = ?");
                pst.setString(1, Election_ID);
                rs = pst.executeQuery();

                if (rs.next()) {
                    jLabel14.setText("The Winner of the Election are");
                    jLabel16.setText("by");
                    jLabel17.setText("votes");

                    jLabel15.setText(rs.getString("Full_name"));
                    jLabel18.setText(Integer.toString(rs.getInt("count")));
                    if (rs.next()) {
                        jLabel19.setText(", " +rs.getString("Full_name"));
                        if (rs.next()) {
                            jLabel20.setText(", " +rs.getString("Full_name"));
                            if (rs.next()) {
                                jLabel21.setText(", " +rs.getString("Full_name"));
                                if (rs.next()) {
                                    jLabel22.setText(", " +rs.getString("Full_name"));
                                }
                            }
                        }
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "During the election period.");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

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
            Candidates h = new Candidates();
            h.show();

            dispose();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(ElectionResults.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ElectionResultsForVoters(Election_ID, Voter_ID).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lb01;
    private javax.swing.JLabel lb02;
    private javax.swing.JLabel lb03;
    private javax.swing.JLabel lb04;
    private javax.swing.JLabel lb05;
    // End of variables declaration//GEN-END:variables
}
