package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Month;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CFrame  extends JFrame  implements ActionListener {
	
	JFrame frame;
	JLabel monthLabel;
	JPanel datePanel;
	JButton[] dates;
	
	
	
	
	
	
	
	
	CFrame(String month, int monthLength, int today){
		new JFrame();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setSize(500,500);
		
		monthLabel = new JLabel(month);
		monthLabel.setHorizontalAlignment(JLabel.CENTER);
		monthLabel.setFont(new Font("Comic Sans", Font.BOLD,25));
		monthLabel.setPreferredSize(new Dimension(500,100));
		monthLabel.setBackground(Color.PINK);
		monthLabel.setOpaque(true);
		
		datePanel = new JPanel();
		datePanel.setLayout(new GridLayout(6,7,10,10));
		datePanel.setPreferredSize(new Dimension(500,400));
		
		
		dates = new JButton[monthLength];
		for(Integer i=0;i<monthLength;i++) {
			dates[i] = new JButton();
			Integer name = i+1;
			dates[i]= new JButton(name.toString());
			dates[i].setName(name.toString());
			dates[i].addActionListener(this);
			datePanel.add(dates[i]);
			
		}
		dates[today-1].setBackground(Color.pink);
		
		this.add(monthLabel,BorderLayout.NORTH);
		this.add(datePanel);
		
		this.setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<dates.length;i++) {
			if(e.getSource()==dates[i]) {
				try {
					ToDo newWindow = new ToDo((i+1));
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				
			}
		}
			
		
		
	}
	
	
	

}
