package GUI_DATABASE;

import java.awt.Dimension;		
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.*;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FirstWindow{
	//variables for gui design;
	protected JButton button1;
	protected JButton button2;
	protected JButton button3;
	protected JButton button4;
	protected JButton button5;
	protected static JTextField password;
	protected static JTextField account;
	private static JLabel labelP;
	private static JLabel labelA;
	protected static String Password;
	protected static String Account;
	private static JFrame iFrame;
	private static JPanel iPanel;
	protected static JMenuBar Bar;
	protected static JMenu menu;
	protected static JMenuItem item;
	
	public static void main(String[] args) {	
		new FirstWindow();
    }
	
	private class Button1 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			FileInputStream originalFiles = null ;
			FileOutputStream OriginalFiles = null ;
			//we need to make sure that gettext method can get a value
			if(password.getText().toString().isEmpty()) {Password="";}else {
			Password=password.getText().toString();}
			if(account.getText().toString().isEmpty()) {Account="";}else {
			Account=account.getText().toString();}	
			//use properties to save password and account in a propertie fies
			Properties properties = new Properties();
			Set<?> keys = properties.keySet();
			
			
			try {
				originalFiles= new FileInputStream("DataBaseAccountProperties.properties");
				properties.load(originalFiles);
				OriginalFiles= new FileOutputStream("DataBaseAccountProperties.properties");
				properties.store(OriginalFiles,null);
				if(keys.contains(Account)) {
					JOptionPane.showMessageDialog(null,"Duplicate Account","Error",JOptionPane.WARNING_MESSAGE);
				}else {
				properties.setProperty(Account,Password);
				properties.store(new FileWriter(new File("DataBaseAccountProperties.properties")), null);}
				originalFiles.close();
				OriginalFiles.close();
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private class Button2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			FileInputStream originalFiles = null ;
			if(password.getText().toString().isEmpty()) {Password="";}else {
			Password=password.getText().toString();}
			if(account.getText().toString().isEmpty()) {Account="";}else {
			Account=account.getText().toString();}
			Properties properties = new Properties();
			Set<?> keys = properties.keySet();
			try {
				originalFiles= new FileInputStream("DataBaseAccountProperties.properties");
				properties.load(originalFiles);
				//if account is right, we need verify password next;
				if(keys.contains(Account)) {
				       String Value= properties.getProperty(Account);
				       if(Password.equals(Value)) {
				        new ThirdWindow();
				       }else{JOptionPane.showMessageDialog(null,"The password isn't avaliable","Error",JOptionPane.WARNING_MESSAGE);}
				    }else {JOptionPane.showMessageDialog(null,"This account does not exist","Error", JOptionPane.WARNING_MESSAGE);}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		    
		}
	}
	
	private class Button3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			account.setText("");
			password.setText("");
		}
	}
	
	private class Button4 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			/*old password and properties will be covered each time you add a new one. So we need to output the old
			one first and input the old one with the new one together;*/
			FileInputStream originalFiles = null ;
			FileOutputStream OriginalFiles = null ;
			if(password.getText().toString().isEmpty()) {Password="";}else {
			Password=password.getText().toString();}
			if(account.getText().toString().isEmpty()) {Account="";}else {
			Account=account.getText().toString();}		
			Properties properties = new Properties();
			Set<?> keys = properties.keySet();
			
			
			try {
				originalFiles= new FileInputStream("DBMA-AccountProperties.properties");
				properties.load(originalFiles);
				OriginalFiles= new FileOutputStream("DBMA-AccountProperties.properties");
				properties.store(OriginalFiles,null);
				if(keys.contains(Account)) {
					JOptionPane.showMessageDialog(null,"Duplicate Account","Error",JOptionPane.WARNING_MESSAGE);
				}else {
				properties.setProperty(Account,Password);
				properties.store(new FileWriter(new File("DBMA-AccountProperties.properties")), null);}
				originalFiles.close();
				OriginalFiles.close();
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	private class Button5 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			FileInputStream originalFiles = null ;
			if(password.getText().toString().isEmpty()) {Password="";}else {
			Password=password.getText().toString();}
			if(account.getText().toString().isEmpty()) {Account="";}else {
			Account=account.getText().toString();}
			Properties properties = new Properties();
			Set<?> keys = properties.keySet();
			//verify the account and the password;
			try {
				originalFiles= new FileInputStream("DBMA-AccountProperties.properties");
				properties.load(originalFiles);
				if(keys.contains(Account)) {
				       String Value= properties.getProperty(Account);
				       if(Password.equals(Value)) {
				        new SecondWindow();
				       }else{JOptionPane.showMessageDialog(null,"The password isn't avaliable","Error",JOptionPane.WARNING_MESSAGE);}
				    }else {JOptionPane.showMessageDialog(null,"This account does not exist","Error", JOptionPane.WARNING_MESSAGE);}
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		    
		}
	}
	
	FirstWindow() {
		this.makeFrame();	
		this.makePanel();
		this.makeTextField();
		this.makeButton();
		this.makeMenu();
		this.makeLabel();
		this.close();
	}
	
	//these methods for gui design;
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
			public void windowClosing(WindowEvent e) {iFrame.dispose();}});
		iFrame.pack();
	}

	private void makeButton() {
	    button1=new JButton("Register");
	    button2=new JButton("Login");	
	    button3=new JButton("Clear");
	    button4=new JButton("DBMA-Register");
	    button5=new JButton("DBMA-Login");
	    button1.addActionListener(new Button1());
		button2.addActionListener(new Button2());
		button3.addActionListener(new Button3());
		button4.addActionListener(new Button4());
		button5.addActionListener(new Button5());
		button1.setBounds(5,20,90,50);
		button2.setBounds(105,20,90,50);
		button3.setBounds(205,20,90,50);
		button4.setBounds(10,180,130,50);
		button5.setBounds(150,180,130,50);
		iPanel.add(this.button1);
		iPanel.add(this.button2);
		iPanel.add(this.button3);
		iPanel.add(this.button4);
		iPanel.add(this.button5);
	}

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
	}
		

	private void makePanel() {
		iPanel=new JPanel();
		iPanel.setPreferredSize(new Dimension(300,300));
		iPanel.setLayout(null);
		iFrame.getContentPane().add(iPanel);
				
	}
	
	private void makeLabel() {
		labelP=new JLabel("PASSWORD");
		labelP.setBounds(40,100,80,20);
		labelA=new JLabel("ACCOUNT");
		labelA.setBounds(40,140,80,20);
		iPanel.add(labelP);
		iPanel.add(labelA);
	}
	
	private void makeTextField(){
		account= new JTextField();
		account.setBounds(140,100,120,20);
		password= new JTextField();
		password.setBounds(140,140,120,20);
		iPanel.add(account);
		iPanel.add(password);
	}
	
}
