package GUI_DATABASE;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ThirdWindow {
	//variable for gui design;
	protected static JFrame iFrame;
	protected static JPanel iPanel;
	protected JButton button1;
	protected JButton button2;
	protected JButton button3;
	protected JButton button4;
	protected JButton button5;
	protected JButton button6;
    protected static JTextArea outcome;
	protected static JMenuBar Bar;
	protected static JMenu menu;
	protected static JMenuItem item;
	String sql;
	
	public static void main(String[] args) {	
		new ThirdWindow();
    }
	
	//each button to invoke a window;
	private class Button1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Department();
		 }
	}
	
	private class Button2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Doctor();
		}
	}
	
	private class Button3 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Nurse();
		}
	}
	
	private class Button4 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Patient();
		}
	}
	
	private class Button5 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Ward();
		}
	}
	
	private class Button6 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Nursing();
		}
	}
	
	    ThirdWindow() {
		this.makeFrame();	
		this.makePanel();
		this.makeTextArea();
		this.makeButton();
		this.makeMenu();
		this.close();
	}
	    
//methods to make gui interface;
	private void makeFrame() {
		iFrame=new JFrame();
		iFrame.setTitle("Pace Hospital Database System");
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
	    button1=new JButton("DEPARTMENT");
	    button2=new JButton("DOCTOR");	
	    button3=new JButton("NURSE");	
	    button4=new JButton("PATIENT");	
	    button5=new JButton("WARD");	
	    button6=new JButton("NURSING");	
	    button1.addActionListener(new Button1());
		button2.addActionListener(new Button2());
		button3.addActionListener(new Button3());
		button4.addActionListener(new Button4());
		button5.addActionListener(new Button5());
		button6.addActionListener(new Button6());
		button1.setBounds(20,100,120,50);
		button2.setBounds(160,100,120,50);
		button3.setBounds(20,170,120,50);
		button4.setBounds(160,170,120,50);
		button5.setBounds(20,240,120,50);
		button6.setBounds(160,240,120,50);
		iPanel.add(this.button1);
		iPanel.add(this.button2);
		iPanel.add(this.button3);
		iPanel.add(this.button4);
		iPanel.add(this.button5);
		iPanel.add(this.button6);
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
		
	
	public void makeTextArea() {
		outcome=new JTextArea("Welecome to use Pace Hospital Database System"+"\n"+"\n"+"      Please push buttons below to start query.");
		outcome.setBounds(10,10,280,60);
		outcome.setLineWrap(true);    //auto change line     
		outcome.setWrapStyleWord(true);     
	    iPanel.add(outcome);
	}
	
}
