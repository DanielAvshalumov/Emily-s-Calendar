package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class ToDo implements KeyListener, Serializable, ActionListener {

	JFrame frame;
	JTextField notes;
	JLabel dateTitle;
	JPanel eventBoard;
	JTextArea event;
	FileOutputStream fileOut;
	ObjectOutputStream out; 
	FileInputStream fileIn;
	ObjectInputStream in;
	Rep rep;
	String name;
	JButton button;
	
	
	ToDo(Integer dir) throws IOException, ClassNotFoundException, FileNotFoundException {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(new Dimension(500,500));
		dateTitle = new JLabel();
		dateTitle.setPreferredSize(new Dimension(500,100));
		dateTitle.setLayout(new BorderLayout());
		dateTitle.setText(dir.toString());
		
		String code = dir.toString();
		frame.setName(code);
		name = code;
		
		eventBoard = new JPanel();
		eventBoard.setPreferredSize(new Dimension(500,400));
		eventBoard.setBorder(BorderFactory.createEtchedBorder());
		
		dateTitle.setFont(new Font("Comic Sans",Font.ITALIC,25));
		dateTitle.setHorizontalAlignment(JLabel.CENTER);
		
		notes = new JTextField();
		notes.setPreferredSize(new Dimension(475,50));
		notes.addKeyListener(this);
		
		event = new JTextArea();
		event.setPreferredSize(new Dimension(450,300));
		
		button = new JButton("Save");
		button.addActionListener(this);
		
		if(new File("C:\\Users\\avsha\\Desktop\\Emilys Notes\\"+dir.toString()+".ser").exists()) {
			fileIn = new FileInputStream("C:\\Users\\avsha\\Desktop\\Emilys Notes\\"+dir.toString()+".ser");
			in = new ObjectInputStream(fileIn);
			rep = (Rep) in.readObject();
			event.setText(rep.string1);
			in.close();
		}
		
		eventBoard.add(notes,BorderLayout.NORTH);
		eventBoard.add(event,BorderLayout.NORTH);
		eventBoard.add(button,BorderLayout.SOUTH);
		frame.add(eventBoard);
		frame.add(dateTitle,BorderLayout.NORTH);	
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
			if(e.getKeyCode()==KeyEvent.VK_ENTER){
				
				event.append(notes.getText()+" \n");
				
				
				notes.setText("");
				
			}
			
			
			
		}
		
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			String dir = frame.getName();
			try {
				fileOut = new FileOutputStream("C:\\Users\\avsha\\Desktop\\Emilys Notes\\"+dir.toString()+".ser");
				out = new ObjectOutputStream(fileOut);
				rep = new Rep(event.getText());
				out.writeObject(rep);
				out.close();
				fileOut.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			notes.disable();
			event.disable();
			
			
		}
		
	}
	
	
	

}
