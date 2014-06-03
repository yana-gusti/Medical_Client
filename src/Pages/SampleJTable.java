/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pages;

import java.awt.Dimension;

import java.awt.GridBagConstraints;

import java.awt.Insets;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.ResultSetMetaData;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Vector;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.JScrollPane;

import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

 

public class SampleJTable extends JFrame{

    JTable table;

    JButton button;

    JPanel panel = new JPanel();

 

    String dbusername = "AAAA";

    String dbpassword = "BBBB";

    String url = "CCC.com";

    String sidIn = "DDDD";

    transient Connection connection = null;

    transient Statement stmt = null;

 

    public SampleJTable() {

        String [] columnName = {"ID","Name","Gender"};

        String [][] data = {

                            {"111","AAA","M"},

                            {"222","BBB","F"},

                            {"333","CCC","M"},

                            {"444","DDD","F"},

                        };

        table = new JTable(data,columnName);

        table.setPreferredScrollableViewportSize(new Dimension(500,50));

        table.setFillsViewportHeight(true);

       

        JScrollPane scrollPanel = new JScrollPane(table);

        GridBagConstraints gbc = new GridBagConstraints();

       

        gbc.insets = new Insets(15,15,15,15);

        gbc.gridx = 0;

        gbc.gridy = 0;

        JButton fetchButton = new JButton("Fetch");

        fetchButton.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e)

            {

                //Execute when button is pressed

                System.out.println("You clicked the fetch button");

                    try {

                        fetchTopics();

                    } catch (SQLException f) {

                    }

                }

            });

        panel.add(fetchButton,gbc);

 

        gbc.gridx = 0;

        gbc.gridy = 1;

        panel.add(scrollPanel,gbc);

       

        add(panel);       

    }

   

    public void fetchTopics()throws SQLException{

        System.out.println("Fetch Topcis");   

 

        String fetchSql = "select * from patienttable";

       

        System.out.println("FETCH SQL"+fetchSql);

        

     

        stmt = connection.createStatement();

        ResultSet rs = null;

       

        rs = stmt.executeQuery(fetchSql);

        table.setModel(buildTableModel(rs));

        table.setVisible(true);

        JScrollPane sPane = new JScrollPane(table);

        panel.add(sPane);

        panel.repaint();

    }

   

    public static DefaultTableModel buildTableModel(ResultSet rs)

            throws SQLException {

 

        ResultSetMetaData metaData = rs.getMetaData();

 

        // names of columns

        Vector<String> columnNames = new Vector<String>();

        int columnCount = metaData.getColumnCount();

        for (int column = 1; column <= columnCount; column++) {

            columnNames.add(metaData.getColumnName(column));

        }

 

        // data of the table

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        while (rs.next()) {

            Vector<Object> vector = new Vector<Object>();

            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {

                vector.add(rs.getObject(columnIndex));

            }

            data.add(vector);

        }

 

        return new DefaultTableModel(data, columnNames);

 

    }   

 

    public static void main(String args[]){

        SampleJTable table = new SampleJTable();

        table.setVisible(true);

        table.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        table.setSize(new Dimension(700,500));

       

       

    }

}