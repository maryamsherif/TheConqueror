package game.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import engine.*;
import exceptions.FriendlyCityException;
import exceptions.TargetNotReachedException;
import units.Army;
import units.Status;

public class ArmiesView extends JPanel implements ActionListener {
	JButton ControlledArmies;
	GameView gv;  
	Game g;
	WorldMapView wmv;
	City cit;
	 JButton Idle;
	 JButton Marching;
	 JButton Besieging;
	 
	 JButton Inf;
	 JButton Cav;
	 JButton Arc;
	 
	 JTextArea dist;
	 JTextArea tf;
	 JTextArea s;
	
	
	 public ArmiesView (GameView gv,WorldMapView wmv ) {
		  this.gv=gv;
		  this.g= gv.g;
		  this.wmv=gv.wmv;
		  
		  this.cit=wmv.my;
		  
		 
		  Idle=new JButton("Idle Army");
		  Marching=new JButton("Marching Army");
		  Besieging=new JButton("Besieging Army");
		 
		  Inf=new JButton("Infantry");
		  Cav=new JButton("Cavalry");
		  Arc=new JButton("Archer");
		  
		 
		 
		 
		 this.add(Idle);
		 this.add(Marching);
		 this.add(Besieging);
		 this.add(Inf);
		 this.add(Cav);
		 this.add(Arc);
		 
		 Marching.addActionListener(this);
		 Besieging.addActionListener(this);
		
		 
		 Idle.setVisible(true);
		 Marching.setVisible(true);
		 Besieging.setVisible(true);
		 Inf.setVisible(true);
		 Cav.setVisible(true);
		 Arc.setVisible(true);
		 
		
		 for (int i =0; i<g.getPlayer().getControlledArmies().size();i++) {
			 
	         	if(g.getPlayer().getControlledArmies().get(i).getCurrentStatus().equals(Status.IDLE)) {
	         		 JTextField Currentlocation=new JTextField();
	         		 this.add(Currentlocation);
	         		 Currentlocation.setText(g.getPlayer().getControlledArmies().get(i).getCurrentLocation());
	         		 Currentlocation.setVisible(true);
	         		 
	         		 for (int j=0;j<g.getPlayer().getControlledArmies().get(i).getUnits().size();j++) {
	         			 JTextArea a=new JTextArea();
	         			 
	         			 a.setText("Type  : "+ g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getType()+"\n" +
	         			 "Level : " + g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getLevel()+"\n"+
	         					 " Current Soldier Count "+g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getCurrentSoldierCount() +
	         					 "\n"+ " Max Soldier Count "+g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getMaxSoldierCount());
	         			 this.add(a);
	         			 a.setVisible(true);
	         			 
	         		 }
	         	}
	         	
	         	if(g.getPlayer().getControlledArmies().get(i).getCurrentStatus().equals(Status.MARCHING)) {
	         		JTextField DistanceToTarget = new JTextField();
	         		 JTextField Currentlocation=new JTextField();
	         		 this.add(Currentlocation);
	         		 this.add(DistanceToTarget);
	         		
	         		 DistanceToTarget.setText(g.getPlayer().getControlledArmies().get(i).getDistancetoTarget()+" ");
	         		 
	         		 Currentlocation.setText(g.getPlayer().getControlledArmies().get(i).getCurrentLocation());
	         		 Currentlocation.setVisible(true);
	         		 for (int j=0;j<g.getPlayer().getControlledArmies().get(i).getUnits().size();j++) {
	         			 JLabel a=new JLabel();
	         			 a.setText("Type  : "+ g.getPlayer().getControlledArmies().get(i).getUnits().get(j).toString()+"\n" +
	         			 "Level : " + g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getLevel()+"\n"+
	         					 " Current Soldier Count "+g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getCurrentSoldierCount()+
	         					 "\n"+ " Max Soldier Count "+g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getMaxSoldierCount());
	         			 this.add(a);
	         			a.setVisible(true);
	         			 
	         		 }
	         		 JLabel TargetCity=new JLabel();
	         		 this.add(TargetCity);
	         		 
	         		 TargetCity.setText(g.getPlayer().getControlledArmies().get(i).getTarget());
	         		 TargetCity.setVisible(true);
	         		 
	         		 
	         		 
	         		 
	         	}
	         	if(g.getPlayer().getControlledArmies().get(i).getCurrentStatus().equals(Status.BESIEGING)) {
	         		 JTextField Currentlocation=new JTextField();
	         		 this.add(Currentlocation);
	         		 
	         		 Currentlocation.setText(g.getPlayer().getControlledArmies().get(i).getCurrentLocation());
	         		 Currentlocation.setVisible(true);
	         		 
	         		 for(int x=0;x<g.getAvailableCities().size();x++) {
	         			 if(g.getAvailableCities().get(x).getName().equals(g.getPlayer().getControlledArmies().get(i).getCurrentLocation())) {
	         				 JTextArea t=new JTextArea();
	         				 t.setText(g.getAvailableCities().get(x).getTurnsUnderSiege()+" ");
	         				 
	         			 }
	         			 
	         		 }
	         		 for (int j=0;j<g.getPlayer().getControlledArmies().get(i).getUnits().size();j++) {
	         			 JLabel a=new JLabel();
	         			 a.setText("Type  : "+ g.getPlayer().getControlledArmies().get(i).getUnits().get(j).toString()+"\n" +
	         			 "Level : " + g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getLevel()+"\n"+
	         					 " Current Soldier Count "+g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getCurrentSoldierCount()+
	         					 "\n"+ " Max Soldier Count "+g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getMaxSoldierCount());
	         			 this.add(a);
	         			a.setVisible(true);
	         			 
	         		 }
	         		 JLabel TargetCity=new JLabel();
	         		 this.add(TargetCity);
	         		 
	         		 TargetCity.setText(g.getPlayer().getControlledArmies().get(i).getTarget());
	         		 TargetCity.setVisible(true);
	         		 
	         		for (int x = 0;x<g.getAvailableCities().size();x++) {
	         			if(g.getAvailableCities().get(x).isUnderSiege()==true) {
	         				JLabel siege=new JLabel();
	         				siege.setText("City Under Siege:  "+ g.getAvailableCities().get(x).getName());
	         				siege.setVisible(true);
	         			}
	         		}
	         		 
	         	}
	         	
	         	
	         }
		
		
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(Marching)) {
			Army a=new Army(gv.Cities.getSelectedItem().toString());
			g.targetCity(a,wmv.TCities.getSelectedItem().toString());
			System.out.print(a.getDistancetoTarget());
			
			 dist=new JTextArea();
			 dist.setText("Distance to Target: "+ a.getDistancetoTarget());
			 this.add(dist,BorderLayout.SOUTH);
			 dist.setVisible(true);
			 this.repaint();
				this.revalidate();
		}
		if(e.getSource().equals(Besieging)) {
			Army a=new Army(gv.Cities.getSelectedItem().toString());
			try {
				g.getPlayer().laySiege(a, g.getAvailableCities().get(2));
				s=new JTextArea();
				s.setText("Turns Under Siege:  "+  g.getAvailableCities().get(2).getTurnsUnderSiege());
				s.setVisible(true);
				this.add(s,BorderLayout.CENTER);
				this.repaint();
				this.revalidate();
				
			} catch (TargetNotReachedException e1) {
				tf=new JTextArea();
				tf.setText("TargetNotReachedException");
				tf.setVisible(true);
				this.add(tf,BorderLayout.SOUTH);
				this.repaint();
				this.revalidate();
				e1.printStackTrace();
			} catch (FriendlyCityException e1) {
				tf=new JTextArea();
				tf.setText("FriendlyCityException");
				tf.setVisible(true);
				this.add(tf,BorderLayout.SOUTH);
				this.repaint();
				this.revalidate();
				e1.printStackTrace();
			}
		}
		
	}
}


