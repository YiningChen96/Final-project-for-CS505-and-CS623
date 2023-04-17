package GUI_DATABASE;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class SecondWindow {
	//variables for gui design,two frame,two ipanel,a lot of buttonsa and text fields,etc
	protected static JFrame iFrame;
	protected static JPanel iPanel;
	protected JButton button1;
	protected JButton button2;
	protected static JTextField select;
	protected static JTextField where;
    protected static JTextField from;
	protected static JTextField groupby;
	protected static JTextField having;
	protected static JTextField orderby;
	private static JLabel labelS;
	private static JLabel labelW;
	private static JLabel labelF;
	private static JLabel labelG;
	private static JLabel labelH;
	private static JLabel labelO;
	protected static String contentSelect;
	protected static String contentFrom;
	protected static String contentWhere;
	protected static String contentGroupby;
	protected static String contentHaving;
	protected static String contentOrderby;
	private JFrame iFrame2;
	private static JPanel iPanel2;
    protected static JTextArea outcome;
	protected static JMenuBar Bar2;
	protected static JMenu menu2;
	protected static JMenuItem item2;
	private static JScrollPane ScrollBar;
	//variables for jdbc;
	final String JC_Driver="com.mysql.cj.jdbc.Driver";
	final String JC_Url="jdbc:mysql://localhost:3306/hospital?";
	final String user="root";
	final String password="Mpc123456";
	Connection conInstance=null;
	Statement staInstance=null;
	String sql;
	
	public static void main(String[] args) {	
		new SecondWindow();
    }
	
	//execute sql query;
	private class Button1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//to make sure that gettext won't give a wrong value to tostring;
			    if(select.getText().toString().isEmpty()) {contentSelect="";}else {
				contentSelect=select.getText().toString();}
				if(from.getText().toString().isEmpty()) {contentFrom="";}else {
				contentFrom=from.getText().toString();}
				if(where.getText().toString().isEmpty()) {contentWhere="";}else {
				contentWhere=where.getText().toString();}
				if(groupby.getText().toString().isEmpty()) {contentGroupby="";}else {
				contentGroupby=groupby.getText().toString();}
				if(having.getText().toString().isEmpty()) {contentHaving="";}else {
				contentHaving=having.getText().toString();}
				if(orderby.getText().toString().isEmpty()) {contentOrderby="";}else {
				contentOrderby=orderby.getText().toString();}
				
				//call gui methods to make a second window to output outcome;
				makeFrame2();
				makePanel2();
				makeTextArea();
				makeMenu2();
				makeScrollBar();
				close2();
				
				try {
					Class.forName(JC_Driver);
					conInstance=DriverManager.getConnection(JC_Url,user,password);
					staInstance=conInstance.createStatement();
					    //just like permutation and combination, all the possible combination with all the values in the six textfields;
					    if(contentWhere.length()==0||contentGroupby.length()==0||contentHaving.length()==0||contentOrderby.length()==0) {
						if(contentWhere.length()==0&&contentGroupby.length()==0&&contentHaving.length()==0&&contentOrderby.length()==0) {
							sql="select "+contentSelect+" from "+contentFrom+";";
						}
						else if(contentWhere.length()==0&&contentGroupby.length()==0&&contentHaving.length()==0&&contentOrderby.length()!=0) {
							sql="select "+contentSelect+" from "+contentFrom+" Order by "+contentOrderby+";";
						}
						else if(contentGroupby.length()==0&&contentHaving.length()!=0) {
							outcome.append("You have an error in your SQL syntax;  check the manual that corresponds to your MySQL server version for the right syntax !");
						}
						else if(contentWhere.length()==0&&contentGroupby.length()!=0&&contentHaving.length()==0&&contentOrderby.length()==0) {
							sql="select "+contentSelect+" from "+contentFrom+" Group by "+contentGroupby+";";
						}
						else if(contentWhere.length()==0&&contentGroupby.length()!=0&&contentHaving.length()==0&&contentOrderby.length()!=0) {
							sql="select "+contentSelect+" from "+contentFrom+" Group by "+contentGroupby+" Order by "+contentOrderby+";";
						}
						else if(contentWhere.length()==0&&contentGroupby.length()!=0&&contentHaving.length()!=0&&contentOrderby.length()!=0) {
							sql="select"+contentSelect+" from "+contentFrom+" Group by "+contentGroupby+" having "+contentHaving+" Order by "+contentOrderby+";";
						}
						else if(contentWhere.length()==0&&contentGroupby.length()!=0&&contentHaving.length()!=0&&contentOrderby.length()==0) {
							sql="select "+contentSelect+" from "+contentFrom+" Group by "+contentGroupby+" having "+contentHaving+";";
						}
						else if(contentWhere.length()!=0&&contentGroupby.length()==0&&contentHaving.length()==0&&contentOrderby.length()==0) {
							sql="select "+contentSelect+" from "+contentFrom+" where "+contentWhere+";";
						}
						else if(contentWhere.length()!=0&&contentGroupby.length()!=0&&contentHaving.length()==0&&contentOrderby.length()==0) {
							sql="select "+contentSelect+" from "+contentFrom+" where "+contentWhere+" Group by "+contentGroupby+";";
						}
						else if(contentWhere.length()!=0&&contentGroupby.length()!=0&&contentHaving.length()!=0&&contentOrderby.length()==0) {
							sql="select "+contentSelect+" from "+contentFrom+" where "+contentWhere+" Order by "+contentGroupby+" havin "+contentHaving+";";
						}
						else if(contentWhere.length()!=0&&contentGroupby.length()!=0&&contentHaving.length()==0&&contentOrderby.length()!=0) {
							sql="select "+contentSelect+" from "+contentFrom+" where "+contentWhere+" Group by "+contentGroupby+" Order by "+contentOrderby+";";
						}
						else if(contentWhere.length()!=0&&contentGroupby.length()==0&&contentHaving.length()==0&&contentOrderby.length()!=0) {
							sql="select "+contentSelect+" from "+contentFrom+" where "+contentWhere+" Order by "+contentOrderby+";";
						}
					}else{sql="select"+contentSelect+" from "+contentFrom+" where "+contentWhere+" Group by "+contentGroupby+" having "+contentHaving+" Order by "+contentOrderby+";";}

					//use setmetadata to get all the values in the resultset and output them by using while loop and for each;
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
	}
	
	private class Button2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			select.setText("");
			from.setText("");
			where.setText("");
			groupby.setText("");
			having.setText("");
			orderby.setText("");
		}
	}
	
	    SecondWindow(){
		this.makeFrame();	
		this.makePanel();
		this.makeTextField();
		this.makeButton();
		this.makeMenu();
		this.makeLabel();
		this.close();
		
	}
	    
//methods to make gui interface;
	private void makeFrame() {
		iFrame=new JFrame();
		iFrame.setTitle("Database1.0");
		iFrame.setSize(300,300);
		iFrame.setLocationRelativeTo(null);
		iFrame.setVisible(true);
		iFrame.setResizable(false);
	}

	private void close() {
		iFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {System.exit(0);}});
		iFrame.pack();
	}

	private void makeButton() {
	    button1=new JButton("QUERY");
	    button2=new JButton("Clear");	
	    button1.addActionListener(new Button1());
		button2.addActionListener(new Button2());
		button1.setBounds(50,20,100,50);
		button2.setBounds(160,20,100,50);
		iPanel.add(this.button1);
		iPanel.add(this.button2);
	}
	//add more information via menubar;
	private void makeMenu() {
		JMenuBar Bar=new  JMenuBar();
		iFrame.setJMenuBar(Bar);
		JMenu menu=new JMenu("Menu");
		Bar.add(menu);
		JMenuItem item1=new JMenuItem("Version information");
		item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"This program is made by Yining Chen \n Version 1.0","Version information",JOptionPane.PLAIN_MESSAGE);
			}
		});
		menu.add(item1);
		JMenuItem item2=new JMenuItem("Show all tables");
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				makeFrame2();
				makePanel2();
				makeTextArea();
				makeMenu2();
				makeScrollBar();
				close2();
				
				try {
					Class.forName(JC_Driver);
					conInstance=DriverManager.getConnection(JC_Url,user,password);
					staInstance=conInstance.createStatement();
					sql="show tables;";
					ResultSet resultSet= staInstance.executeQuery(sql);
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
						se.printStackTrace();
					}
			}
		});
		menu.add(item2);
		
		JMenuItem item3=new JMenuItem("Insert");
		item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Insert();
			}
		});
		menu.add(item3);
		
		JMenuItem item4=new JMenuItem("Update");
		item4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Update();
			}
		});
		menu.add(item4);
		
		JMenuItem item5=new JMenuItem("Delete");
		item5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Delete();
			}
		});
		menu.add(item5);
		
	}
		

	private void makePanel() {
		iPanel=new JPanel();
		iPanel.setPreferredSize(new Dimension(300,300));
		iPanel.setLayout(null);
		iFrame.getContentPane().add(iPanel);
	}
	
	private void makeLabel() {
		labelS=new JLabel("SELECT");
		labelS.setBounds(50,100,50,20);
		labelF=new JLabel("FROM");
		labelF.setBounds(50,130,50,20);
		labelW=new JLabel("WHERE");
		labelW.setBounds(50,160,50,20);
		labelG=new JLabel("GROUP BY");
		labelG.setBounds(30,190,70,20);
		labelH=new JLabel("HAVING");
		labelH.setBounds(50,220,50,20);
		labelO=new JLabel("ORDER BY");
		labelO.setBounds(30,250,70,20);
		
		iPanel.add(labelS);
		iPanel.add(labelF);
		iPanel.add(labelW);
		iPanel.add(labelG);
		iPanel.add(labelH);
		iPanel.add(labelO);	
	}
	
	private void makeTextField(){
		select = new JTextField();
		select.setBounds(120,100,140,20);
		from = new JTextField();
		from.setBounds(120,130,140,20);
		where = new JTextField();
		where.setBounds(120,160,140,20);
	    groupby = new JTextField();
	    groupby.setBounds(120,190,140,20);
	    having= new JTextField();
	    having.setBounds(120,220,140,20);
	    orderby= new JTextField();
	    orderby.setBounds(120,250,140,20);
	    
		iPanel.add(select);
		iPanel.add(from);
		iPanel.add(where);
		iPanel.add(groupby);
		iPanel.add(having);
		iPanel.add(orderby);
	}
	//methods to make the second window;
	public void makeFrame2() {
	    iFrame2=new JFrame();
	    iFrame2.setTitle("Database1.0");
	    iFrame2.setSize(300,300);
	    iFrame2.setLocationRelativeTo(null);
	    iFrame2.setVisible(true);
	    iFrame2.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
	    iFrame2.setResizable(false);
	}

	public void close2() {
		iFrame2.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {iFrame2.dispose();}});
		iFrame2.pack();
	}

	public void makeMenu2() {
		Bar2=new JMenuBar();
		iFrame2.setJMenuBar(Bar2);
		menu2=new JMenu("Menu");
		Bar2.add(menu2);
		item2=new JMenuItem("Version information");
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"This program is made by Yining Chen \n Version 1.0","Version information",JOptionPane.PLAIN_MESSAGE);
			}
		});
		menu2.add(item2);
	}
		

	public void makePanel2() {
		iPanel2=new JPanel();
		iPanel2.setPreferredSize(new Dimension(300,300));
		iPanel2.setLayout(null);
		iPanel2.add(new JScrollPane(outcome)); // add a scroll
		iFrame2.getContentPane().add(iPanel2);
	}
	
	public void makeTextArea() {
		outcome=new JTextArea(280,280);
		outcome.setBounds(10,10,280,280);
		outcome.setLineWrap(true);    //auto change line     
		outcome.setWrapStyleWord(true);     
	    iPanel2.add(outcome);
	}
	
	public void makeScrollBar() {
	ScrollBar = new JScrollPane(outcome);
	ScrollBar.setBounds(10, 10, 280, 280);
	ScrollBar.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    iPanel2.add(ScrollBar);
	}
	
}
