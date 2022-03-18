package game.view;
import javax.swing.*;
import units.*;
import engine.*;
import exceptions.FriendlyCityException;
import exceptions.FriendlyFireException;
import exceptions.TargetNotReachedException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import units.*;

public class BattleView extends JPanel implements ActionListener{
	 GameView gv ;
	 Game g ;
	
	 JLabel TargetCity;
	 JComboBox cities;
	 //String [] c1;

	 JLabel myAttack;
	 JComboBox atk;
	 ArrayList<String>atk1;
	 
	 
	 JLabel toAttack;
	 JComboBox atk2;
	 ArrayList<String> atk3;
	
	 JButton Attack;
	 
	 JButton Auto;
	 
	 JButton ArmInfo;
	 
	 Armies ar;
	 JTextArea bt;
	 

	 
	public BattleView (GameView gv) {
		this.g=gv.g;
		
		ar = new Armies(gv);
		bt=new JTextArea();
		
		TargetCity= new JLabel("Choose your target city ");
	//	c1= new String [] {"Cairo","Rome","Sparta"};
		//cities=new JComboBox(c1);
		cities.setSelectedIndex(3);
		
		myAttack= new JLabel ("Choose your unit ");
		
	/*	for(int i =0;i<g.getPlayer().getControlledArmies().size();i++) {
			if( g.getPlayer().getControlledArmies().get(i).getCurrentLocation().equals(cities.getSelectedItem()))
			{
				for( int j=0;j<g.getPlayer().getControlledArmies().get(i).getUnits().size();j++) {
					atk1.add("Unit "+ (j+1)+ g.getPlayer().getControlledArmies().get(i).getUnits().get(j));
				}
				
			}
			
		}
		
		
		myAttack= new JLabel ("Choose a unit to attack with : ");
			
         for(int i =0; i< g.getAvailableCities().size();i++) {
        	 if(g.getAvailableCities().get(i).equals(cities.getSelectedItem()))
        	 {
        		  City x= g.getAvailableCities().get(i);
        	     
                 for(int j=0;j<g.getPlayer().getControlledArmies().size();j++) {
        	 
			     if( g.getPlayer().getControlledArmies().get(j).getCurrentLocation().equals(x.getName())) {
				   		Army a=g.getPlayer().getControlledArmies().get(j);
		
				   			for( int y=0; y<a.getUnits().size();y++) {
					        atk1.add("Unit "+ (y+1)+ a.getUnits().get(y));
				}
				   			atk= new JComboBox(atk1.toArray());
            }
         }
 }
  }
         myAttack= new JLabel ("Choose a unit to attack: ");
         
         for(int i =0; i< g.getAvailableCities().size();i++) {
        	 if(g.getAvailableCities().get(i).equals(cities.getSelectedItem()))
        	 {
        		  City x= g.getAvailableCities().get(i);
        	     
                 for(int j=0;j<x.getDefendingArmy().getUnits().size();j++) {
        	 

				atk3.add(" Unit "+ (j+1)+ x.getDefendingArmy().getUnits().get(j));
				}
              atk2= new JComboBox(atk3.toArray());
            }
         }
         */
 
  
		
		
		ArmInfo= new JButton("Show your Armies Information");
		Attack = new JButton("Attack ");
		Auto= new JButton("Auto Resolve");
		
		this.add(TargetCity);
		this.add(cities);
		this.add(myAttack);
		this.add(toAttack);
		this.add(Attack);
		this.add(Auto);
		this.add(ArmInfo);
		this.add(atk);
		this.add(atk2);
		this.add(bt);
		
		
		Attack.addActionListener(this);
		Auto.addActionListener(this);
		ArmInfo.addActionListener(this);
		
	}
		
	public void actionPerformed(ActionEvent e) {
		/*if(e.getSource().equals(Attack)) {
			int attackindex= atk.getSelectedIndex();
			
			for(int )
		}
		
	}*/
	
	}
			 
} 


