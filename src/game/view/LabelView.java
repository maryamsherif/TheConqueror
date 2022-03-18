package game.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import engine.*;

public class LabelView extends JPanel implements ActionListener{
	JTextArea Info;
	GameView gv;
	JTextArea b;

    Game g ;
    JButton end;
	 
    public LabelView (GameView gv) {
    	
    	//this.setBounds(700, 100, 30, 20);
    	//this.setBounds(550, 100, 300, 200);
    	
    	this.g=gv.g;
    	this.gv=gv;
    
    	
    	
    	Info= new JTextArea();
    	Info.setEditable(false);
    	
    	b=new JTextArea();
    	b.setEditable(false);
    	this.add(Info);
    	this.add(b);
    	
    	this.repaint();
		this.revalidate();
		
		
		this.getInfo().setText("PlayerName : "+gv.getPlayerName().getText()+ "\n----\n"+"Food : "+ g.getPlayer().getFood()+"\n----\n"+"Gold : "
			    + g.getPlayer().getTreasury()+"\n----\n"+"Turn : "+g.getCurrentTurnCount());
				
		
		 end= new JButton("End Turn");
	     this.add(end);
			
			end.addActionListener(this);
			end.setVisible(true);
			
   	
    }

	public JTextArea getInfo() {
		return Info;
	}

	public void setInfo(JTextArea info) {
		Info = info;
	}
	
	public void refreshlabels() {
		this.getInfo().setText("PlayerName : "+gv.getPlayerName().getText()+ "\n----\n"+"Food : "+ g.getPlayer().getFood()+"\n----\n"+"Gold : "
			    + g.getPlayer().getTreasury()+"\n----\n"+"Turn : "+g.getCurrentTurnCount());
	}
	
	public void updatebuilding(){
         for (int i=0;i<g.getPlayer().getControlledCities().size();i++) {
			for(int j=0;j< g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().size();j++) {
				b.setText("Type of Economical Building :"+ "\n-------\n" +
						g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).getType() +" "+
		             	"\n-------\n"
                        + "Level of Economical Building :"+ g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).getLevel());
			} }
	}
         public void updateMil(){
         for (int i=0;i<g.getPlayer().getControlledCities().size();i++) {
			for(int j=0;j<g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size();j++) {
			        	b.setText("Type of Military Building :"+ "\n-------\n"+
			        			g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getType() +
						"\n-------\n"		
				        + "Level of Military Building :"+g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getLevel());
			}}
	}
 

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(end)) {
		   g.endTurn();
		   gv.lv.refreshlabels();
		   //gv.lv.updatebuilding();
			
		}
	}

	
    
  

}
