package GUI_DATABASE;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Nursing {

	protected static JFrame iFrame;
	protected static JPanel iPanel;
    protected static JTextArea outcome;
	protected static JMenuBar Bar;
	protected static JMenu menu;
	protected static JMenuItem item;
	private static JScrollPane ScrollBar;
	final String JC_Driver="com.mysql.cj.jdbc.Driver";
	final String JC_Url="jdbc:mysql://localhost:3306/hospital?";
	final String user="root";
	final String password="Mpc123456";
	Connection conInstance=null;
	Statement staInstance=null;
	String sql;
	
	public static void main(String[] args) {
	
		new Nursing();
	}
	
	public Nursing() {
		makeFrame();
		makePanel();
		makeTextArea();
		makeMenu();
		makeScrollBar();
		close();
		
		try {
			Class.forName(JC_Driver);
			conInstance=DriverManager.getConnection(JC_Url,user,password);
			staInstance=conInstance.createStatement();
			    
			sql="select * from hospital.nursing;";

			ResultSet resultSet = staInstance.executeQuery(sql);
			ResultSetMetaData dataset =resultSet.getMetaData();
			int columnsNumber = dataset.getColumnCount();
			 
			while (resultSet.next()) {
			    for (int i = 1; i <= columnsNumber; i++) {
			    	String ColumnName= dataset.getColumnName(i);
			    	outcome.append(ColumnName+": ");
			        String ColumnValue = resultSet.getString(i);
				    outcome.append(ColumnValue+";	");
			    }
			    outcome.append("\n");
			}
			
			resultSet.close();
			conInstance.close();
			staInstance.close();
			}catch(ClassNotFoundException ee) {
				outcome.append("ERROR PLEASE CONNECT THE DBMA!");
			}catch(SQLException se) {
				outcome.append("You have an error in your SQL syntax;  check the manual that corresponds to your MySQL server version for the right syntax !");
			}
	}
	
	public void makeFrame() {
	    iFrame=new JFrame();
	    iFrame.setTitle("Pace Hospital Database System");
	    iFrame.setSize(1100,600);
	    iFrame.setLocation(0,0);
	    iFrame.setVisible(true);
	    iFrame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
	    iFrame.setResizable(false);
	}

	public void close() {
		iFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {iFrame.dispose();}});
		iFrame.pack();
	}

	public void makeMenu() {
		Bar=new JMenuBar();
		iFrame.setJMenuBar(Bar);
		menu=new JMenu("Menu");
		Bar.add(menu);
		item=new JMenuItem("Version information");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"This program is made by Yining Chen \n Version 1.0","Version information",JOptionPane.PLAIN_MESSAGE);
			}
		});
		menu.add(item);
	}
		

	public void makePanel() {
		iPanel=new JPanel();
		iPanel.setPreferredSize(new Dimension(1100,600));
		iPanel.setLayout(null);
		iPanel.add(new JScrollPane(outcome)); // add a scroll
		iFrame.getContentPane().add(iPanel);
	}
	
	public void makeTextArea() {
		outcome=new JTextArea(1100,600);
		outcome.setBounds(10,10,1080,580);
		outcome.setLineWrap(true);    //auto change line     
		outcome.setWrapStyleWord(true);     
	    iPanel.add(outcome);
	}
	
	public void makeScrollBar() {
	ScrollBar = new JScrollPane(outcome);
	ScrollBar.setBounds(10, 10, 1080, 580);
	ScrollBar.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	ScrollBar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    iPanel.add(ScrollBar);
	}
}

