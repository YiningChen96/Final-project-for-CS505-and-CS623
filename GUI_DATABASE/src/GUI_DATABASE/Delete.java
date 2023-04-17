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


public class Delete {
	/*Build all variables used by gui components and jdbc into global variables*/
	protected JButton button1;
	protected JButton button2;
	private static JLabel labelD;
	private static JLabel labelW;
	private static JFrame iFrame;
	private static JPanel iPanel;
	private static JScrollPane Bar;
    protected static JTextArea outcome;	
	protected static JTextField Delete;
	protected static JTextField Where;
	/*Build all variables used by jdbc into global variables*/
	final String JC_Driver="com.mysql.cj.jdbc.Driver";
	final String JC_Url="jdbc:mysql://localhost:3306/hospital?";
	final String user="root";
	final String password="Mpc123456";
	Connection conInstance=null;
	Statement staInstance=null;
	String sql;
	protected static String contentDelete;
	protected static String contentWhere;
	
	public static void main(String[] args) {	
		new Delete();
    }
	
	private class Button1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//if getText method can't get anything, the toString will get a wrong outcome
			    if(Delete.getText().toString().isEmpty()) {contentDelete="";}else {
				contentDelete=Delete.getText().toString();}
				if(Where.getText().toString().isEmpty()) {contentWhere="";}else {
				contentWhere=Where.getText().toString();}				
				
				try {
					Class.forName(JC_Driver);
					conInstance=DriverManager.getConnection(JC_Url,user,password);
					staInstance=conInstance.createStatement();
					//if statement helps us to select diferrence sql statement in different conditions
					if(contentWhere=="") {
						sql="Delete from "+contentDelete;
					}else {
						sql="Delete from "+contentDelete+" Where "+contentWhere+";";
					}
					//execute sql in the mysql
					staInstance.executeUpdate(sql);
					outcome.append("Sucessfully"+"\n");
					conInstance.close();
					staInstance.close();
					//if there is something wrong throw this exception and tell them what the problem is.
				}catch(ClassNotFoundException ee) {
					outcome.append("ERROR PLEASE CONNECT THE DBMA!"+"\n");
				}catch(SQLException se) {
					outcome.append("You have an error in your SQL syntax;  check the manual that corresponds to your MySQL server version for the right syntax !"+"\n");
				}
	}
	}
		
	//the clear button
	private class Button2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Delete.setText("");
			Where.setText("");
		}
	}
	
		Delete(){
		this.makeFrame();	
		this.makePanel();
		this.makeTextField();
		this.makeButton();
		this.makeLabel();
		this.makeTextArea();
		this.makeScrollBar();
		this.close();
	}
	
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
	/*make all things needed by GUI interfaces*/
	public void makeFrame() {
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
		labelD=new JLabel("Delete from");
		labelD.setBounds(40,100,90,20);
		labelW=new JLabel("Where");
		labelW.setBounds(40,140,90,20);
		iPanel.add(labelD);
		iPanel.add(labelW);
	}
	
	private void makeTextField(){
		Delete= new JTextField();
		Delete.setBounds(140,100,120,20);
		Where= new JTextField();
		Where.setBounds(140,140,120,20);
		iPanel.add(Delete);
		iPanel.add(Where);
	}
	//set how to close a window(or say a frame);
	private void close() {
		iFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {iFrame.dispose();}});
		iFrame.pack();
	}
	
	public void makeTextArea() {
		outcome=new JTextArea("Notification:Values ​​of non-numeric types should be placed in a pair of single quotation marks."+"\n"+"Caution!!! Without where statement, you will delete all things in tables!"+"\n");
		outcome.setBounds(10,180,280,100);
		outcome.setLineWrap(true);    //auto change line     
		outcome.setWrapStyleWord(true);     
	    iPanel.add(outcome);
	}
	
	public void makeScrollBar() {
	Bar = new JScrollPane(outcome);
    Bar.setBounds(10, 180, 280, 100);
    Bar.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    iPanel.add(Bar);
	}
	
}

