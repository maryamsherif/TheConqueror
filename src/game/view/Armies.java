package game.view;
import engine.*;
import units.Status;

import javax.swing.*;
import java.awt.*;

public class Armies extends JPanel {
	GameView gv;
	Game g ;
	JTextArea ArmInfo;
	 

	   public Armies (GameView gv) {
		   
		   this.g=gv.g;
		   
		   for (int i =0; i<g.getPlayer().getControlledArmies().size();i++) {
				 
	          
	         		 JTextField ArmInfo=new JTextField();
	         		 this.add(ArmInfo);
	         		ArmInfo.setText("Army current location: "+ g.getPlayer().getControlledArmies().get(i).getCurrentLocation()+"\n"+
	         		"Army's status : "+ g.getPlayer().getControlledArmies().get(i).getCurrentStatus()+"\n"+
	         		"Army's Target : "+ g.getPlayer().getControlledArmies().get(i).getMaxToHold());
	         		ArmInfo.setVisible(true);
	         		 for (int j=0;j<g.getPlayer().getControlledArmies().get(i).getUnits().size();j++) {
	         			 JLabel a=new JLabel();
	         			 a.setText("Type  : "+ g.getPlayer().getControlledArmies().get(i).getUnits().get(j).toString()+"\n" +
	         			 "Level : " + g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getLevel()+"\n"+
	         					 " Current Soldier Count "+g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getCurrentSoldierCount()+
	         					 "\n"+ " Max Soldier Count "+g.getPlayer().getControlledArmies().get(i).getUnits().get(j).getMaxSoldierCount());
	         			 this.add(a);
	         			 a.setVisible(true);
	         			 
	         		 }
	         	}
	   }
		   
		   
	   
	
	
	
}
