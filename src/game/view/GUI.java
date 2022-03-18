package game.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener{
	JFrame frame;
	JPanel panel;
	JButton button;
	JLabel label;
	
	int count=0;
	
	@SuppressWarnings("deprecation")
	public GUI() {
		frame=new JFrame();
		panel=new JPanel();
		button= new JButton("Click Here");
		label=new JLabel("Number of clicks=    ");
		
	
		//frame.setSize(1200,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Our Gui");
		frame.setBounds(350, 300, 700, 500);
		frame.setVisible(true);
		frame.setFocusable(false);
		//frame.pack();
		frame.revalidate();
		frame.repaint();
		frame.add(panel,BorderLayout.CENTER);
		
		panel.setBounds(600, 500, 1000,1000);
		//panel.setLayout(new GridLayout(0,1));
		panel.add(button);
		panel.add(label);
		//panel.setSize(frame.size());
		
		//createEmptyBorder(top, left, bottom, right)
		//button.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
		button.setFocusable(false);
		//button.setBounds(new Rectangle(560,400));
 //button.setBounds(300, 200, 50, 50);
		//button.setSize(new Dimension(150,150));
		button.addActionListener(this);
		
		
	//	label.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
		
		
		
		
	}
	

	public static void main(String[] args) {
		new GUI();

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		label.setText("Number of clicks=   " + count);
		
	}

}
