package GUI_DATABASE;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Insert{
	//variables for the gui design;
	protected JButton button1;
	protected JButton button2;
	private static JLabel labelI;
	private static JLabel labelV;
	private static JFrame iFrame;
	private static JPanel iPanel;
	private static JScrollPane Bar;
    protected static JTextArea outcome;	
	protected static JTextField InsertInto;
	protected static JTextField Values;
	//variables for jdbc driver;
	final String JC_Driver="com.mysql.cj.jdbc.Driver";
	final String JC_Url="jdbc:mysql://localhost:3306/hospital?";
	final String user="root";
	final String password="Mpc123456";
	Connection conInstance=null;
	Statement staInstance=null;
	String sql;
	protected static String contentInsert;
	protected static String contentValues;
	
	public static void main(String[] args) {	
		new Insert();
    }
	
	//whe someone pushes the button execute sql statement by get the values that were typed in the textfiedl;
	private class Button1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			    if(InsertInto.getText().toString().isEmpty()) {contentInsert="";}else {
				contentInsert=InsertInto.getText().toString();}
				if(Values.getText().toString().isEmpty()) {contentValues="";}else {
				contentValues=Values.getText().toString();}
				try {
					Class.forName(JC_Driver);
					conInstance=DriverManager.getConnection(JC_Url,user,password);
					staInstance=conInstance.createStatement();
					sql="insert into "+contentInsert+" values"+"("+contentValues+")"+";";
					staInstance.executeUpdate(sql);
					outcome.append("Sucessfully"+"\n");
					conInstance.close();
					staInstance.close();
				
				}catch(ClassNotFoundException ee) {
					outcome.append("ERROR PLEASE CONNECT THE DBMA!"+"\n");
				}catch(SQLException se) {
					outcome.append("You have an error in your SQL syntax;  check the manual that corresponds to your MySQL server version for the right syntax !"+"\n");
				}
	}
	}
					
	private class Button2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			InsertInto.setText("");
			Values.setText("");
		}
	}
	
		Insert(){
		this.makeFrame();	
		this.makePanel();
		this.makeTextField();
		this.makeButton();
		this.makeLabel();
		this.makeTextArea();
		this.makeScrollBar();
		this.close();
	}
	
	//these methods to make gui infertace;
	private void makeButton() {
	    button1=new JButton("Execute");
	    button2=new JButton("Clear");	
	    button1.addActionListener(new Button1());
		button2.addActionListener(new Button2());
		button1.setBounds(40,20,90,50);
		button2.setBounds(170,20,90,50);
		iPanel.add(this.button1);
		iPanel.add(this.button2);
	}
	
	public static void makeFrame() {
		iFrame=new JFrame();
		iFrame.setTitle("Database1.0");
		iFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		iFrame.setSize(300,300);
		iFrame.setLocationRelativeTo(null);
		iFrame.setVisible(true);
		iFrame.setResizable(false);
	}
	
	private void makePanel() {
		iPanel=new JPanel();
		iPanel.setPreferredSize(new Dimension(300,300));
		iPanel.setLayout(null);
		iFrame.getContentPane().add(iPanel);
	}
	
	private void makeLabel() {
		labelI=new JLabel("Insert into");
		labelI.setBounds(40,100,80,20);
		labelV=new JLabel("Values");
		labelV.setBounds(40,140,80,20);
		iPanel.add(labelI);
		iPanel.add(labelV);
	}
	
	private void makeTextField(){
		InsertInto= new JTextField();
		InsertInto.setBounds(140,100,120,20);
		Values= new JTextField();
		Values.setBounds(140,140,120,20);
		iPanel.add(InsertInto);
		iPanel.add(Values);
	}
	
	//the way to close the window(frame)
	private void close() {
		iFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {iFrame.dispose();}});
		iFrame.pack();
	}
	
	public void makeTextArea() {
		outcome=new JTextArea("Notification:Values ​​of non-numeric types should be placed in a pair of single quotation marks!"+"\n");
		outcome.setBounds(10,170,280,120);
		outcome.setLineWrap(true);    //auto change line     
		outcome.setWrapStyleWord(true);     
	    iPanel.add(outcome);
	}
	
	public void makeScrollBar() {
	Bar = new JScrollPane(outcome);
    Bar.setBounds(10, 170, 280, 120);
    Bar.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    iPanel.add(Bar);
	}
	
}
