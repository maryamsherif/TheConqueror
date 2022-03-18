package game.view;
import javax.swing.*;
import units.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import engine.*;
import units.Unit;


public class WorldMapView extends JPanel implements ActionListener{
	 JButton Cairo;
	  JButton Rome;
	 JButton Sparta;
	  GameView gv;
	  Game g ;
	 JLabel availableCities;
	 JTextArea error ;
	  CityView cv ;
	 JTextArea def;
	 JTextArea defUnit;
	 JButton atk;
	// BattleView Bv;
	 JComboBox TCities;
	 String [] c;
	 JLabel  c2;
     JButton av;
     ArmiesView a;
	 City my;

	public WorldMapView(GameView gv ) {
		this.gv=gv;	
		this.g=gv.g;
		availableCities = new JLabel("Available Cities:     ");
		this.add(availableCities);
		availableCities. setVisible(true);
		 availableCities.setBounds(400, 400, 70, 50);
	    	/*	this.setLayout(null);
			this.setVisible(true);
			this.revalidate();
			this.repaint();*/
	
			this.setBounds(550, 100, 300, 200);
			this.setBounds(500, 400, 500, 500);
			//this.add(map,BorderLayout.CENTER);
			
			
			Cairo= new JButton("Cairo");
			Cairo.setFocusable(false);
			Cairo.setBounds(150,50,10,20);
			//Cairo.setName(Cairo.getText());
			this.add(Cairo);
			
			Rome = new JButton("Rome");
			Rome.setFocusable(false);
			Rome.setBounds(300,50,10,20);
			this.add(Rome);
			
			Sparta = new JButton("Sparta");
			Sparta.setFocusable(false);
			Sparta.setBounds(500,50,10,20);
			this.add(Sparta);
		
			cv= new CityView(gv,this);
			gv.add(cv);
			
			atk= new JButton ("attack");
			this.add(atk);
			atk.addActionListener(this);
			
			//Bv= new BattleView(gv);
			//gv.add(Bv);
			//Bv.setVisible(false);
			
			c2= new JLabel("Choose your target ");
			c=new String [] {"Cairo","Rome","Sparta"};
			TCities= new JComboBox(c);
			 this.add(c2);
			 this.add(TCities);
			 
			 av=new JButton("Show Armies Info");
			 this.add(av);
			 av.addActionListener(this);
			
			
	if(g.getPlayer().getControlledCities().get(0).getName().equals((this.Cairo.getText()))) {
			this.Cairo.addActionListener(this);
			g.getPlayer().getControlledCities().add(new City("Cairo"));
			City my = g.getPlayer().getControlledCities().get(0);
		
		}
		else if(g.getPlayer().getControlledCities().get(0).getName().equals((this.Rome.getText()))) {
			this.Rome.addActionListener(this);
			g.getPlayer().getControlledCities().add(new City("Rome"));
			City my = g.getPlayer().getControlledCities().get(0);
			
		}
		else if (g.getPlayer().getControlledCities().get(0).getName().equals((this.Sparta.getText())))  {
			this.Sparta.addActionListener(this);
			g.getPlayer().getControlledCities().add(new City("Sparta"));
			City my = g.getPlayer().getControlledCities().get(0);
			
		}

	
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
		if(e.getSource().equals(Cairo)) {
			for (int i=0;i<g.getPlayer().getControlledCities().size();i++) {
			if(g.getPlayer().getControlledCities().get(i).getName().equals("Cairo") ){
				this.setVisible(false);
				cv.setVisible(true);
				//Bv.setVisible(false);
				def= new JTextArea();
				def.setText("Defending Army:  "+g.getPlayer().getControlledCities().get(i).getDefendingArmy()+" ");  
				def.setVisible(true);
				for (int x=0;x<g.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().size();x++) {
					defUnit = new JTextArea();
					defUnit.setText("Type  : "+ g.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().get(x).toString()+"\n" +
		         			 "Level : " + g.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().get(x).getLevel()+"\n"+
		         					 " Current Soldier Count "+g.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().get(x).getCurrentSoldierCount()+
		         					 "\n"+ " Max Soldier Count "+g.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().get(x).getMaxSoldierCount());
		         			 this.add(defUnit);
		         			defUnit.setVisible(true);
		         		
				}
				
		     }
			else {
				error=new JTextArea("Error you can't click this button!! ");
				this.add(error,BorderLayout.SOUTH);
				error.setEditable(false);
				error.setVisible(true);	
				} 
			}
		}
	     if(e.getSource().equals(Rome)) {
	    	 for (int i=0;i<g.getPlayer().getControlledCities().size();i++) {
			if(g.getPlayer().getControlledCities().get(0).getName().equals("Rome") ){
				this.setVisible(false);
				cv.setVisible(true);
				//Bv.setVisible(false);
				def= new JTextArea();
				def.setText("Defending Army:  "+g.getPlayer().getControlledCities().get(i).getDefendingArmy()+" ");
				def.setVisible(true);
				for (int x=0;x<g.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().size();x++) {
					defUnit = new JTextArea();
					defUnit.setText("Type  : "+ g.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().get(x).toString()+"\n" +
		         			 "Level : " + g.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().get(x).getLevel()+"\n"+
		         					 " Current Soldier Count "+g.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().get(x).getCurrentSoldierCount()+
		         					 "\n"+ " Max Soldier Count "+g.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().get(x).getMaxSoldierCount());
		         			 this.add(defUnit);
		         			defUnit.setVisible(true);
		         			
					
				}
				
		     }
			else {
				error=new JTextArea("Error you can't click this button!! ");
				this.add(error,BorderLayout.SOUTH);
				error.setEditable(false);
				error.setVisible(true);	
		   	}
	     }
	  }
	     
		if(e.getSource().equals(Sparta)) {
			for (int i=0;i<g.getPlayer().getControlledCities().size();i++) {
			if(g.getPlayer().getControlledCities().get(0).getName().equals("Sparta") ){
				this.setVisible(false);
				cv.setVisible(true);
				//Bv.setVisible(false);
				def= new JTextArea();
				def.setText("Defending Army:  "+g.getPlayer().getControlledCities().get(i).getDefendingArmy()+" ");
				def.setVisible(true);
				for (int x=0;x<g.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().size();x++) {
					defUnit = new JTextArea();
					defUnit.setText("Type  : "+ g.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().get(x).toString()+"\n" +
		         			 "Level : " + g.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().get(x).getLevel()+"\n"+
		         					 " Current Soldier Count "+g.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().get(x).getCurrentSoldierCount()+
		         					 "\n"+ " Max Soldier Count "+g.getPlayer().getControlledCities().get(i).getDefendingArmy().getUnits().get(x).getMaxSoldierCount());
		         			 this.add(defUnit);
		         			defUnit.setVisible(true);
			   	
				}
				
		     }
			else {
				error=new JTextArea("Error you can't click this button!! ");
			     this.add(error,BorderLayout.SOUTH);
			     error.setEditable(false);
				 error.setVisible(true);	
				}
			}
		
		}
		if  (e.getSource().equals(atk)) {
			  this.setVisible(false);
			  //Bv.setVisible(true);
	
					
					
					
				}
		
		if(e.getSource().equals(av)) {
			this.setVisible(false);
			a=new ArmiesView(gv,this);
			gv.add(a);
			a.setVisible(true);
			
		}
	
			}
			
		
		
		
		
		
	}
		

		 



