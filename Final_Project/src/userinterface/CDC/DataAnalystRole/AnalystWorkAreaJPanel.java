/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.CDC.DataAnalystRole;

import Busines.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.University.Student;
import Business.University.StudentDirectory;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FoundDeadWorkRequest;
import Business.WorkQueue.VaccinationWorkRequest;
import Business.WorkQueue.WorkRequest;
import com.orsoncharts.util.TextAnchor;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;





import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;





/**
 *
 * @author Jiaqi Wang
 * @author PeiLingChiang
 */
public class AnalystWorkAreaJPanel extends javax.swing.JPanel {
private JPanel upc;
private UserAccount account;
private Organization organization;
private Enterprise enterprise;
private EcoSystem system;
    /**
     * Creates new form AnalystWorkAreaJPanel
     */
    public AnalystWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.upc=userProcessContainer;
        this.account=account;
        this.organization=organization;
        this.enterprise=enterprise;
        this.system=system; 
        //call piechart method           
        createPieChart();
  
        //call linechart method
        createLineChart();
        
        populateDeathTable();
    }
    
    private void populateDeathTable(){
        DefaultTableModel model = (DefaultTableModel)tblDeath.getModel();
        model.setRowCount(0);
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            if (request instanceof FoundDeadWorkRequest){
                Object[] row = new Object[2];
                row[0] = request.getMessage();
                row[1] = request.getRequestDate();

                //System.out.println("pp "+request.getRequestDate());

                model.addRow(row);
            }
        }
        tblDeath.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblDeath.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
    
    //input month and get number of deaths 
    private int populateMonthlyDeath(int month){
        int count=0;
        
        //get FoundDeadWorkRequest from CDC_Staff
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            if (request instanceof FoundDeadWorkRequest){
                LocalDate localDate = request.getRequestDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int request_month = localDate.getMonthValue();
                if (request_month==month){
                    count++;
                }
            }
        }
        return count;
    }
    
    private int populateWeeklyDeath(int day){
        int count=0;
        
        //get FoundDeadWorkRequest from CDC_Staff
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            if (request instanceof FoundDeadWorkRequest){
                LocalDate localDate = request.getRequestDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int request_day = localDate.getDayOfWeek().getValue();
                if (request_day==day){
                    count++;
                }
            }
        }
        return count;
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
        lblPie = new javax.swing.JLabel();
        lblLine = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblPositive = new javax.swing.JLabel();
        lblNegative = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDeath = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Latest Data Analysis");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 0, 257, 29));
        add(lblPie, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 396, 343));
        add(lblLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 414, 343));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setText("Proportion of infected population");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 98, -1, -1));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel4.setText("Trend of death toll");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 98, 202, -1));
        add(lblPositive, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 90, 20));
        add(lblNegative, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 100, 20));

        tblDeath.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Death Time"
            }
        ));
        jScrollPane1.setViewportView(tblDeath);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, 420, 130));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLine;
    private javax.swing.JLabel lblNegative;
    private javax.swing.JLabel lblPie;
    private javax.swing.JLabel lblPositive;
    private javax.swing.JTable tblDeath;
    // End of variables declaration//GEN-END:variables

    private void createPieChart() {
        //initialize parameter for piechart
        List<Student> P_students = new ArrayList<Student>();
        List<Student> N_students = new ArrayList<Student>();
        for (Student s : system.getStudentDir().getStudentList()) {
            if (s.getTestingStatus().equalsIgnoreCase("positive")) {
                P_students.add(s);
            } 
            else if (s.getTestingStatus().equalsIgnoreCase("negative")) {
                N_students.add(s);
            }
        }
        int positiveNum = P_students.size();
        int negativeNum = N_students.size();
        
        lblPositive.setText("Positive: "+String.valueOf(positiveNum));
        lblNegative.setText("Negative: "+String.valueOf(negativeNum));

        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Negative", negativeNum);
        dataset.setValue("Positive", positiveNum);

        JFreeChart chart = ChartFactory.createPieChart(
                "Test Result", // chart title
                dataset, // data
                true, // include legend
                true,
                false);

        int width = 370;
        int height = 300;
        
        File pieChart = new File("PieChart.jpeg");
        try {
            ChartUtilities.saveChartAsJPEG(pieChart, chart, width, height);//这句可能要报错
        } catch (IOException ex) {
            Logger.getLogger(AnalystWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageIcon ii = new ImageIcon("PieChart.jpeg");
//        ii.setImage(ii.getImage().getScaledInstance(350,300 ,Image.SCALE_DEFAULT ));
        lblPie.setSize(370, 300);
        lblPie.setIcon(ii);
    }

    private void createLineChart() {
        //initialize parameter for linechart
        List<Student> D_students = new ArrayList<Student>();
        for (Student s : system.getStudentDir().getStudentList()) {
            if (s.getContactStatus().equalsIgnoreCase("dead")) {
                D_students.add(s);
            }
        }

        //System.out.println("Dead list: "+D_students);

        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        
        /** monthly
        line_chart_dataset.addValue( populateMonthlyDeath(1) , "death Count" , "Jan" );
        line_chart_dataset.addValue( populateMonthlyDeath(2) , "death Count" , "Feb" );
        line_chart_dataset.addValue( populateMonthlyDeath(3) , "death Count" , "Mar" );
        line_chart_dataset.addValue( populateMonthlyDeath(4)  , "death Count" , "Feb" );
        line_chart_dataset.addValue( populateMonthlyDeath(5) , "death Count" , "May" ); 
        line_chart_dataset.addValue( populateMonthlyDeath(6)  , "death Count" , "Jun" );
        line_chart_dataset.addValue( populateMonthlyDeath(7) , "death Count" , "Jul" );
        line_chart_dataset.addValue( populateMonthlyDeath(8) , "death Count" , "Aug" );
        line_chart_dataset.addValue( populateMonthlyDeath(9) , "death Count" , "Sep" );
        line_chart_dataset.addValue( populateMonthlyDeath(10)  , "death Count" , "Oct" );
        line_chart_dataset.addValue( populateMonthlyDeath(11) , "death Count" , "Nov" );
        line_chart_dataset.addValue( populateMonthlyDeath(12)  , "death Count" , "Dec" );
        **/
        
        //daily
        line_chart_dataset.addValue( populateWeeklyDeath(1) , "# of Death" , "Mon" );
        line_chart_dataset.addValue( populateWeeklyDeath(2) , "# of Death" , "Tue" );
        line_chart_dataset.addValue( populateWeeklyDeath(3) , "# of Death" , "Wed" );
        line_chart_dataset.addValue( populateWeeklyDeath(4) , "# of Death" , "Thu" );
        line_chart_dataset.addValue( populateWeeklyDeath(5) , "# of Death" , "Fri" );
        line_chart_dataset.addValue( populateWeeklyDeath(6) , "# of Death" , "Sat" );
        line_chart_dataset.addValue( populateWeeklyDeath(7) , "# of Death" , "Sun" );
        
        
        
        JFreeChart lineChartObject = ChartFactory.createLineChart(
        "Weekly Death Report","Day",
        "# of Death",
        line_chart_dataset,PlotOrientation.VERTICAL,
        true,true,false);

        int width = 400;    
        int height = 300;    
        
        File lineChart = new File( "LineChart.jpeg" ); 
        try {
            ChartUtilities.saveChartAsJPEG(lineChart ,lineChartObject, width ,height);
        } catch (IOException ex) {
        Logger.getLogger(AnalystWorkAreaJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        ImageIcon ii=new ImageIcon( "LineChart.jpeg");
//        ii.setImage(ii.getImage().getScaledInstance(350,300 ,Image.SCALE_DEFAULT ));
        lblLine.setSize(400, 300);
        lblLine.setIcon(ii);

    }

  
}
