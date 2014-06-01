/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pages;


import static Pages.SignInPage.profilePage;
import static Pages.SignInPage.signOutPage;
import static Pages.journals.AddmissionPage.admissionTable;
import Pages.journals.addPatient.AddPatientAdmission;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static medical.client.Main.signInPage;
import sun.misc.IOUtils;

/**
 *
 * @author iRoma
 */
public class ProfilePage extends javax.swing.JFrame {
    public static JournalPage journalPage;
    public static ChangeGraphicPage changeGraphicPage;
    static JLabel lblMonth, lblYear;
    static JButton btnPrev, btnNext;
    static JTable tblCalendar;
    static JComboBox cmbYear;
    static JPanel pnlCalendar;
    static DefaultTableModel mtblCalendar; //Table model
    static JScrollPane stblCalendar; //The scrollpane
    static int realYear, realMonth, realDay, currentYear, currentMonth;
   

    /**
     * Creates new form LoginPage
     */
    public void Calendar(){
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}
        //Create controls
        lblMonth = new JLabel ("January");
        lblYear = new JLabel ("Change year:");
        cmbYear = new JComboBox();
        btnPrev = new JButton ("&lt;&lt;");
        btnNext = new JButton ("&gt;&gt;");
        mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tblCalendar = new JTable(mtblCalendar);
        stblCalendar = new JScrollPane(tblCalendar);
        pnlCalendar = new JPanel(null);
        
        //Set border
        pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));
        
        //Register action listeners
        btnPrev.addActionListener(new btnPrev_Action());
        btnNext.addActionListener(new btnNext_Action());
        cmbYear.addActionListener(new cmbYear_Action());
        
        //Add controls to pane
        calendar.add(pnlCalendar);
        pnlCalendar.add(lblMonth);
        pnlCalendar.add(lblYear);
        pnlCalendar.add(cmbYear);
        pnlCalendar.add(btnPrev);
        pnlCalendar.add(btnNext);
        pnlCalendar.add(stblCalendar);
        pnlCalendar.setBounds(0, 0, 320, 335);
        lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2, 25, 100, 25);
        lblYear.setBounds(10, 305, 80, 20);
        cmbYear.setBounds(230, 305, 80, 20);
        btnPrev.setBounds(10, 25, 50, 25);
        btnNext.setBounds(260, 25, 50, 25);
        stblCalendar.setBounds(10, 50, 300, 250);
        GregorianCalendar cal = new GregorianCalendar(); //Create calendar
        realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
        realMonth = cal.get(GregorianCalendar.MONTH); //Get month
        realYear = cal.get(GregorianCalendar.YEAR); //Get year
        currentMonth = realMonth; //Match month and year
        currentYear = realYear;
        
        //Add headers
        String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
        for (int i=0; i<7; i++){
            mtblCalendar.addColumn(headers[i]);
        }
        
        tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background
        
        //No resize/reorder
        tblCalendar.getTableHeader().setResizingAllowed(false);
        tblCalendar.getTableHeader().setReorderingAllowed(false);
        
        //Single cell selection
        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Set row/column count
        tblCalendar.setRowHeight(38);
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(6);
        
        //Populate table
        for (int i=realYear-100; i<=realYear+100; i++){
            cmbYear.addItem(String.valueOf(i));
        }
        
        //Refresh calendar
        refreshCalendar (realMonth, realYear); //Refresh calendar
    }
    
    public static void refreshCalendar(int month, int year){
        //Variables
        String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int nod, som; //Number Of Days, Start Of Month
        
        //Allow/disallow buttons
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        if (month == 0 && year <= realYear-10){btnPrev.setEnabled(false);} //Too early
        if (month == 11 && year >= realYear+100){btnNext.setEnabled(false);} //Too late
        lblMonth.setText(months[month]); //Refresh the month label (at the top)
        lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2, 25, 180, 25); //Re-align label with calendar
        cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box
        
        //Clear table
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                mtblCalendar.setValueAt(null, i, j);
            }
        }
        
        //Get first day of month and number of days
        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);
        
        //Draw calendar
        for (int i=1; i<=nod; i++){
            int row = new Integer((i+som-2)/7);
            int column  =  (i+som-2)%7;
            mtblCalendar.setValueAt(i, row, column);
        }
        
        //Apply renderers
        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
    }
    
    static class tblCalendarRenderer extends DefaultTableCellRenderer{
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (column == 0 || column == 6){ //Week-end
                setBackground(new Color(255, 220, 220));
            }
            else{ //Week
                setBackground(new Color(255, 255, 255));
            }
            if (value != null){
                if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear){ //Today
                    setBackground(new Color(220, 220, 255));
                }
            }
            setBorder(null);
            setForeground(Color.black);
            return this;
        }
    }
    
    static class btnPrev_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentMonth == 0){ //Back one year
                currentMonth = 11;
                currentYear -= 1;
            }
            else{ //Back one month
                currentMonth -= 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }
    static class btnNext_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentMonth == 11){ //Foward one year
                currentMonth = 0;
                currentYear += 1;
            }
            else{ //Foward one month
                currentMonth += 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }
    static class cmbYear_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (cmbYear.getSelectedItem() != null){
                String b = cmbYear.getSelectedItem().toString();
                currentYear = Integer.parseInt(b);
                refreshCalendar(currentMonth, currentYear);
            }
        }
    
        
    }
    public ProfilePage() {
        initComponents();
        FillComboBox();
        Calendar();
    }
    public void UpdateTable(String email){
        ArrayList columnNames = new ArrayList();
        ArrayList data = new ArrayList();

        //  Connect to an MySQL Database, run query, get result set
        String url = "jdbc:mysql://localhost:3306/medical_client";
        String userid = "root";
        String password = "yana246897531";
        String sql = "SELECT moday, tuesday, wednesday, thursday, friday "
                + "from graphic where user_name like '"+email+"'";

        // Java SE 7 has try-with-resources
        // This will ensure that the sql objects are closed when the program
        // is finished with them
         try  {
            Connection connection = DriverManager.getConnection( url, userid, password );
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery( sql );
             while (rs.next()) {
               monday.setText(rs.getString("moday"));
               tuesday.setText(rs.getString("tuesday"));
               wed.setText(rs.getString("wednesday"));
               thu.setText(rs.getString("thursday"));
               fri.setText(rs.getString("friday"));
               
            }
         }
//            System.out.println(sql);
//            ResultSetMetaData md = rs.getMetaData();
//            int columns = md.getColumnCount();
//
//            //  Get column names
//            System.out.println("1");
//            columnNames.add( "Понеділок");
//            columnNames.add( "Вівторок");
//            columnNames.add( "Середа");
//            columnNames.add( "Четвер");
//            columnNames.add( "П'ятниця");
//
//
//            //  Get row data
//            while (rs.next())
//            {
//                ArrayList row = new ArrayList(columns);
//
//                for (int i = 1; i <= columns; i++)
//                {
//                    
//                    row.add( rs.getObject(i) );
//                    System.out.println("2");
//                }
//
//                data.add( row );
//            }
//        }
        catch (SQLException e)
        {
            System.out.println( e.getMessage() );
        }
//
//        Vector columnNamesVector = new Vector();
//        Vector dataVector = new Vector();
//
//        for (int i = 0; i < data.size(); i++)
//        {
//            ArrayList subArray = (ArrayList)data.get(i);
//            Vector subVector = new Vector();
//            for (int j = 0; j < subArray.size(); j++)
//            {
//                subVector.add(subArray.get(j));
//                System.out.println("3");
//            }
//            dataVector.add(subVector);
//        }
//        for (int i = 0; i < columnNames.size(); i++ )
//            columnNamesVector.add(columnNames.get(i));
//
//        //  Create table with database data
//        graphicTable= new JTable(dataVector, columnNamesVector)
//        {
//            public Class getColumnClass(int column)
//            {
//                for (int row = 0; row < getRowCount(); row++)
//                {
//                    
//                    Object o = getValueAt(row, column);
//                    System.out.println("4");
//
//                    if (o != null)
//                    {
//                         System.out.println("5");
//                        return o.getClass();
//                       
//                    }
//                }
//
//                return Object.class;
//            }
//        };
    }
    public void FillComboBox(){
         String url = "jdbc:mysql://localhost:3306/medical_client";
        String userid = "root";
        String password = "yana246897531";
        String sql = "SELECT last_name, e_mail FROM user_table ";

        try  {
            Connection connection = DriverManager.getConnection( url, userid, password );
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery( sql );
             while (rs.next()) {
               String name = rs.getString("last_name");
               listOfDoctors.addItem(name);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
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

        MainPanel = new javax.swing.JPanel();
        TopPanel = new javax.swing.JPanel();
        journalBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        listOfDoctors = new javax.swing.JComboBox();
        graphicOfWork = new javax.swing.JLabel();
        Change_graphic = new javax.swing.JButton();
        monday = new javax.swing.JTextField();
        tuesday = new javax.swing.JTextField();
        wed = new javax.swing.JTextField();
        thu = new javax.swing.JTextField();
        fri = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        calendar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        firstSample = new javax.swing.JButton();
        secondSample = new javax.swing.JButton();
        thirdSample = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBackground(new java.awt.Color(204, 255, 204));

        TopPanel.setBackground(new java.awt.Color(153, 255, 153));

        journalBtn.setText("Журнал");
        journalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                journalBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Вихід");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(journalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(journalBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/65.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(51, 102, 0));
        jLabel2.setFont(new java.awt.Font("Arial", 3, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 153, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("АРМ Лікаря");

        listOfDoctors.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Оберіть лікаря" }));
        listOfDoctors.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listOfDoctorsItemStateChanged(evt);
            }
        });

        graphicOfWork.setText("Графік роботи лікарів");

        Change_graphic.setText("Змінити розклад");
        Change_graphic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Change_graphicActionPerformed(evt);
            }
        });

        monday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mondayActionPerformed(evt);
            }
        });

        jLabel4.setText("Понеділок");

        jLabel5.setText("Вівторок");

        jLabel6.setText("Середа");

        jLabel7.setText("Четвер");

        jLabel8.setText("П'ятниця");

        calendar.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout calendarLayout = new javax.swing.GroupLayout(calendar);
        calendar.setLayout(calendarLayout);
        calendarLayout.setHorizontalGroup(
            calendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );
        calendarLayout.setVerticalGroup(
            calendarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel3.setText("Зразки документів");

        firstSample.setText("Зразок №1");
        firstSample.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstSampleActionPerformed(evt);
            }
        });

        secondSample.setText("Зразок №2");
        secondSample.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondSampleActionPerformed(evt);
            }
        });

        thirdSample.setText("Зразок №3");
        thirdSample.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thirdSampleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(192, 192, 192)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(MainPanelLayout.createSequentialGroup()
                                .addComponent(graphicOfWork, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, MainPanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel4)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(41, 41, 41)
                                            .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(thu, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(wed, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(tuesday, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(fri, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(monday, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(listOfDoctors, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                            .addGap(35, 35, 35)
                                            .addComponent(Change_graphic, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(MainPanelLayout.createSequentialGroup()
                                        .addComponent(firstSample)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(secondSample)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(thirdSample)))))
                        .addGap(66, 66, 66)
                        .addComponent(calendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MainPanelLayout.createSequentialGroup()
                        .addComponent(graphicOfWork, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(listOfDoctors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(monday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tuesday, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(wed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(thu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addComponent(Change_graphic)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstSample)
                            .addComponent(secondSample)
                            .addComponent(thirdSample))
                        .addGap(0, 50, Short.MAX_VALUE))
                    .addComponent(calendar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mondayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mondayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mondayActionPerformed

    private void Change_graphicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Change_graphicActionPerformed
        changeGraphicPage = new ChangeGraphicPage();
        changeGraphicPage.setVisible(true);
        profilePage.setVisible(false);
    }//GEN-LAST:event_Change_graphicActionPerformed

    private void listOfDoctorsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listOfDoctorsItemStateChanged
        String lastName = (String) listOfDoctors.getSelectedItem();
        System.out.println(lastName);
        String email = null;
        String url = "jdbc:mysql://localhost:3306/medical_client";
        String userid = "root";
        String password = "yana246897531";
        String sql = "SELECT e_mail from user_table where last_name like '"+lastName+"'";

        try  {
            Connection connection = DriverManager.getConnection( url, userid, password );
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            while (rs.next()) {
                email = rs.getString("e_mail");

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
        System.out.println(email);
        UpdateTable(email);

    }//GEN-LAST:event_listOfDoctorsItemStateChanged

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed

        signInPage = new SignInPage();
        signInPage.setVisible(true);
        profilePage.setVisible(false);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void journalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_journalBtnActionPerformed
        journalPage = new JournalPage();
        journalPage.setVisible(true);
        profilePage.setVisible(false);
    }//GEN-LAST:event_journalBtnActionPerformed

    private void firstSampleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstSampleActionPerformed
            try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(".\\src\\documents\\sample1.doc"));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }//GEN-LAST:event_firstSampleActionPerformed

    private void secondSampleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondSampleActionPerformed
            try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(".\\src\\documents\\sample2.doc"));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }//GEN-LAST:event_secondSampleActionPerformed

    private void thirdSampleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thirdSampleActionPerformed
                    try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(".\\src\\documents\\sample3.doc"));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }//GEN-LAST:event_thirdSampleActionPerformed
    
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
            java.util.logging.Logger.getLogger(ProfilePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfilePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfilePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfilePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfilePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Change_graphic;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel TopPanel;
    public javax.swing.JPanel calendar;
    private javax.swing.JButton cancelBtn;
    public javax.swing.JButton firstSample;
    private javax.swing.JTextField fri;
    private javax.swing.JLabel graphicOfWork;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton journalBtn;
    private javax.swing.JComboBox listOfDoctors;
    private javax.swing.JTextField monday;
    public javax.swing.JButton secondSample;
    public javax.swing.JButton thirdSample;
    private javax.swing.JTextField thu;
    private javax.swing.JTextField tuesday;
    private javax.swing.JTextField wed;
    // End of variables declaration//GEN-END:variables

}

