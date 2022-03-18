package game.view;

import javax.swing.*;

import engine.*;
import units.Status;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameView extends JFrame implements ActionListener {
	JPanel game;
	JTextField PlayerName;
	JLabel l;
	JButton ShowWorldMap;
	JButton StartGame;
    JComboBox Cities;
	JLabel C;
    WorldMapView wmv;
	JTextArea playerName = new JTextArea();
	JTextArea cityName = new JTextArea();
	Game g;
	ArmiesView arm;
	LabelView lv;
	
	CityView cv;
	BattleView Bv;
	Armies ar;
	
	   public JComboBox getCities() {
			return Cities;
		}

		public void setCities(JComboBox cities) {
			Cities = cities;
		}

	public GameView() {
		
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		//this.setBounds(350, 300, 700, 500);
		//this.setLayout(null);
		this.revalidate();
		this.repaint();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		game = new JPanel();
		game.setSize(1500, 700);
		this.add(game, BorderLayout.CENTER);

		l = new JLabel();
		l.setText("Enter Player's name");
		game.add(l);

		PlayerName = new JTextField();
		PlayerName.setEditable(true);
		//PlayerName.setBounds(150, 50, 150, 20);
		PlayerName.setText("           ");
		game.add(PlayerName);

		StartGame = new JButton();
		// StartGame.setBounds(300, 200, 50, 50);
		StartGame.setText("Start Game");
		StartGame.setFocusable(false);
		game.add(StartGame);
		StartGame.addActionListener(this);
		
		String [] AvCities={"Cairo" , "Rome", "Sparta"};
	
		Cities= new JComboBox(AvCities);
		Cities.setSelectedIndex(2);
		Cities.addActionListener(this);
		game.add(Cities);
		
	
		C= new JLabel();
		C.setText("Choose your city");
		game.add(C);
		this.repaint();
		this.revalidate();
       
       // lv.setVisible(true);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	

	}

	public JTextField getPlayerName() {
		return PlayerName;
	}

	public void setPlayerName(JTextField playerName) {
		PlayerName = playerName;
	}

	public static void main(String[] args) {
		new GameView();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String pn = playerName.getText();
		String city = Cities.getSelectedItem().toString();
		
		if (e.getSource().equals(StartGame)) {
			this.game.setVisible(false);
			try {
				System.out.println(city);
				this.g = new Game(pn, city);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			wmv = new WorldMapView(this);
			this.add(wmv,BorderLayout.WEST);
		    lv= new LabelView (this);
		    this.add(lv,BorderLayout.EAST);
		    lv.setVisible(true);
		    lv.getInfo().setVisible(true);
			wmv.setVisible(true);
			this.repaint();
			this.revalidate();
			wmv.cv.setVisible(false);
		
		
		}
		
		
		
	}
}
