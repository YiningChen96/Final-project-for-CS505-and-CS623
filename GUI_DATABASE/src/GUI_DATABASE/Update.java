package GUI_DATABASE;

import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
import javax.swing.WindowConstants;


public class Update{

	//variables for gui design;
	protected JButton button1;
	protected JButton button2;
	private static JLabel labelU;
	private static JLabel labelS;
	private static JLabel labelW;
	private static JFrame iFrame;
	private static JPanel iPanel;
	private static JScrollPane Bar;
    protected static JTextArea outcome;	
	protected static JTextField Update;
	protected static JTextField Set;
	protected static JTextField Where;
	//variables for jdbc driver;
	final String JC_Driver="com.mysql.cj.jdbc.Driver";
	final String JC_Url="jdbc:mysql://localhost:3306/hospital?";
	final String user="root";
	final String password="Mpc123456";
	Connection conInstance=null;
	Statement staInstance=null;
	String sql;
	protected static String contentUpdate;
	protected static String contentSet;
	protected static String contentWhere;
	
	public static void main(String[] args) {	
		new Update();
    }
	

	
	private class Button1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// to make sure that gettext can't send a wrong value to tostring;
			    if(Update.getText().toString().isEmpty()) {contentUpdate="";}else {
				contentUpdate=Update.getText().toString();}
				if(Set.getText().toString().isEmpty()) {contentSet="";}else {
				contentSet=Set.getText().toString();}
				if(Where.getText().toString().isEmpty()) {contentWhere="";}else {
				contentWhere=Where.getText().toString();}				
				
				try {
					Class.forName(JC_Driver);
					conInstance=DriverManager.getConnection(JC_Url,user,password);
					staInstance=conInstance.createStatement();
					
					//sql="insert into "+contentInsert+" values"+"("+contentValues+")"+";";
					//use if statements to execute different sql statement in different condition
					if(contentWhere=="") {
						sql="update "+contentUpdate+" set "+contentSet+";";
					}else {
						sql="update "+contentUpdate+" set "+contentSet+" where "+contentWhere+";";
					}
					
					staInstance.executeUpdate(sql);
					outcome.append("Sucessfully!"+"\n");
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
			Update.setText("");
			Set.setText("");
			Where.setText("");
		}
	}
	
		Update(){
		this.makeFrame();	
		this.makePanel();
		this.makeTextField();
		this.makeButton();
		this.makeLabel();
		this.makeTextArea();
		this.makeScrollBar();
		this.close();
	}
	
		//to make gui interface;
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
	
	
	public void makeFrame() {
		iFrame=new JFrame();
		iFrame.setTitle("Database1.0");
		iFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
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
		labelU=new JLabel("Insert into");
		labelU.setBounds(40,100,80,20);
		labelS=new JLabel("Values");
		labelS.setBounds(40,140,80,20);
		labelW=new JLabel("Where");
		labelW.setBounds(40,180,80,20);
		iPanel.add(labelU);
		iPanel.add(labelS);
		iPanel.add(labelW);
	}
	
	private void makeTextField(){
		Update= new JTextField();
		Update.setBounds(140,100,120,20);
		Set= new JTextField();
		Set.setBounds(140,140,120,20);
		Where= new JTextField();
		Where.setBounds(140,180,120,20);
		iPanel.add(Update);
		iPanel.add(Set);
		iPanel.add(Where);
	}
	
	private void close() {
		iFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {iFrame.dispose();}});
		iFrame.pack();
	}
	
	public void makeTextArea() {
		outcome=new JTextArea("Notification:Values ​​of non-numeric types should be placed in a pair of single quotation marks!"+"\n");
		outcome.setBounds(10,220,280,70);
		outcome.setLineWrap(true);    //auto change line     
		outcome.setWrapStyleWord(true);     
	    iPanel.add(outcome);
	}
	
	public void makeScrollBar() {
	Bar = new JScrollPane(outcome);
    Bar.setBounds(10, 220, 280, 70);
    Bar.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    iPanel.add(Bar);
	}

	

		
	}
	

