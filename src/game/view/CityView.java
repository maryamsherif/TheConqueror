package game.view;
import javax.swing.*;
import engine.*;
import exceptions.*;
import units.Status;
import buildings.*;
import engine.Game;
import units.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class CityView extends JPanel implements ActionListener {
	 Game g;
	 GameView gv;
	 ArmiesView arm;
	 JTextArea buildings=new JTextArea();
	 JComboBox b;
	 JComboBox mil;
	 JButton rec;
	 JTextField tf;
	 LabelView lv;
	 ArrayList <String> comboE;
	 ArrayList <String> comboM;
	 ArrayList <String> comboB;
	 ArrayList<String>comboM1;
	 JTextArea z;
	 
	 
	 City c ;
	 JButton Farm1;
	 JButton Market1;
	 JButton ArcheryRange1;
	 JButton Barracks1;
	 JButton Stable1;
	 JButton IntArmy;
	 
	 JButton ArcheryRange2;
	 JButton Barracks2;
	 JButton Stable2;
	 JTextArea cost1;
	 JTextArea recost;
	 
	 JButton BuildFarm1;
	 JButton BuildMarket1;
	 JButton BuildArcheryRange1;
	 JButton BuildBarracks1;
	 JButton BuildStable1;
	 JButton Armview;
	 
	 public CityView(GameView gv, WorldMapView mv){
		 this.gv=gv;
		  this.g= gv.g;
		 this.c=mv.my;
		 JTextArea buildings=new JTextArea();
		 
		  rec=new JButton();
		  comboE=new ArrayList<String> ();
		  comboM=new ArrayList<String> ();
		  comboM1=comboM;
		  comboB=new ArrayList<String> ();
		 
		 
		  
		  
		  BuildFarm1=new JButton("Build Farm");
		  BuildMarket1=new JButton("Build Market");
		  BuildArcheryRange1=new JButton("Build Archery Range");
		  BuildBarracks1=new JButton("Build Barracks");
		  BuildStable1=new JButton("Build Stable");
		  
		  Armview = new JButton("Army View");
		 
		  
		  Farm1=new JButton("Upgrade Farm");
		  Market1=new JButton("Upgrade Market");
		  ArcheryRange1=new JButton("Upgarde Archery Range");
		  Barracks1=new JButton("Upgarde Barracks");
		  Stable1=new JButton("Upgrade Stable");
		  IntArmy= new JButton ("Initiate Army");
		  
		  
		  
		  ArcheryRange2=new JButton("Recruit Archer");
		  Barracks2=new JButton("Recruit Infantry");
		  Stable2=new JButton("Recruit Cavalry");

		    cost1=new JTextArea ();
		    recost=new JTextArea();
		    cost1.setEditable(false);
		    recost.setEditable(false);
		    
		    arm=new ArmiesView(gv,mv);
		  
		  this.add(Armview);
		  this.add(BuildArcheryRange1);
		  this.add(BuildBarracks1);
		  this.add(BuildStable1);
		  this.add(BuildFarm1);
		  this.add(BuildMarket1); 
		  this.add(ArcheryRange1);
		  this.add(Barracks1);
		  this.add(Stable1);
		  this.add(Farm1);
		  this.add(Market1);
		  this.add(ArcheryRange2);
		  this.add(Barracks2);
		  this.add(Stable2);
		  this.add(cost1);
		  this.add(recost);
		  this.add(IntArmy);
		  
		  this.setLayout(new GridLayout(0,2));
		 
		  
		  
		  
		  Farm1.addActionListener(this);
		  Market1.addActionListener(this);
		  Barracks1.addActionListener(this);
		  Stable1.addActionListener(this);
		  ArcheryRange1.addActionListener(this);
		  ArcheryRange2.addActionListener(this);
		  Barracks2.addActionListener(this);
		  Stable2.addActionListener(this);
		  
		  BuildFarm1.addActionListener(this);
		  BuildMarket1.addActionListener(this);
		  BuildBarracks1.addActionListener(this);
		  BuildStable1.addActionListener(this);
		  BuildArcheryRange1.addActionListener(this);
		  Armview.addActionListener(this);
		  IntArmy.addActionListener(this);
		  
		  this.add(buildings);
		  
		
		    
		
		/*for (int i=0;i<g.getPlayer().getControlledCities().size();i++) {
			for(int j=0;j<g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().size();j++) {
				buildings.setText("Type of Economical Building :"+g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).toString()
             + "Level of Economical Building :"+g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).getLevel());
				
			}
			
			for(int j=0;j<g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size();j++) {
				
			
				buildings.setText("Type of Military Building :"+g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).toString()
				+ "Level of Military Building :"+g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getLevel());
			
			}
		}*/

			
		}
		
		/*public void updatebuilding(){
			for (int i=0;i<g.getPlayer().getControlledCities().size();i++) {
				for(int j=0;j<g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().size();j++) {
					buildings.setText("Type of Economical Building :"+g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).toString()
	             + "Level of Economical Building :"+g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).getLevel());
				}
				for(int j=0;j<g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size();j++) {
					buildings.setText("Type of Military Building :"+g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).toString()
					+ "Level of Military Building :"+g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getLevel());
				}
		}
	 }*/

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(BuildMarket1)) {
		
						try {
							g.getPlayer().build("Market",this.gv.Cities.getSelectedItem().toString());
							
							
							this.gv.lv.getInfo().repaint();
							this.gv.revalidate();
							this.gv.lv.setVisible(true);
							this.gv.lv.getInfo().setVisible(true);
							this.gv.lv.refreshlabels();
						    this.gv.lv.updatebuilding();
							this.buildings.setVisible(true);
							
							
						} catch (NotEnoughGoldException e1) {
							tf=new JTextField();
							tf.setText("Not Enough Gold for building");
							tf.setVisible(true);
							this.add(tf,BorderLayout.SOUTH);
							this.repaint();
							this.revalidate();
							// TODO Auto-generated catch block
							e1.printStackTrace();
							
						}
						
			
		
	}
		
		if(e.getSource().equals(BuildArcheryRange1)) {
			
					
						try {
							g.getPlayer().build("ArcheryRange",this.gv.Cities.getSelectedItem().toString());
							this.gv.lv.getInfo().repaint();
							this.gv.revalidate();
							this.gv.lv.setVisible(true);
							this.gv.lv.getInfo().setVisible(true);
							this.gv.lv.refreshlabels();
						    this.gv.lv.updateMil();
							this.buildings.setVisible(true);
						   
							
						} catch (NotEnoughGoldException e1) {
							tf=new JTextField();
							tf.setText("Not Enough Gold for building");
							tf.setVisible(true);
							this.add(tf,BorderLayout.SOUTH);
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
			}
		
	
		if(e.getSource().equals(BuildStable1)) {
			
						try {
							g.getPlayer().build("Stable",this.gv.Cities.getSelectedItem().toString());
							this.gv.lv.getInfo().repaint();;
							this.gv.revalidate();
							this.gv.lv.setVisible(true);
							this.gv.lv.getInfo().setVisible(true);
							this.gv.lv.refreshlabels();
							this.gv.lv.updateMil();
							
						} catch (NotEnoughGoldException e1) {
							tf=new JTextField();
							tf.setText("Not Enough Gold for building");
							tf.setVisible(true);
							this.add(tf,BorderLayout.SOUTH);
							// TODO Auto-generated catch block
						
							e1.printStackTrace();
						}
						
	
	}
		if(e.getSource().equals(BuildBarracks1) ){
			
						try {
							g.getPlayer().build("Barracks",this.gv.Cities.getSelectedItem().toString());
							this.gv.lv.getInfo().repaint();;
							this.gv.revalidate();
							this.gv.lv.setVisible(true);
							this.gv.lv.getInfo().setVisible(true);
							this.gv.lv.refreshlabels();
							this.gv.lv.updateMil();
						
						} catch (NotEnoughGoldException e1) {
							tf=new JTextField();
							tf.setText("Not Enough Gold for building");
							tf.setVisible(true);
							this.add(tf,BorderLayout.SOUTH);
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
		
		
	}
		if(e.getSource().equals(BuildFarm1)) {
					
						try {
							g.getPlayer().build("Farm",this.gv.Cities.getSelectedItem().toString());
							this.gv.lv.getInfo().repaint();
							this.gv.revalidate();
							this.gv.lv.setVisible(true);
							this.gv.lv.getInfo().setVisible(true);
							this.gv.lv.refreshlabels();
							this.gv.lv.updatebuilding();
							
						} catch (NotEnoughGoldException e1) {
							tf=new JTextField();
							tf.setText("Not Enough Gold for building");
							tf.setVisible(true);
							this.add(tf,BorderLayout.SOUTH);
							// TODO Auto-generated catch block
							e1.printStackTrace();
							
						}
						
		
	}
			
		if(e.getSource().equals(Farm1)) {
			for (int i=0;i<g.getPlayer().getControlledCities().size();i++) {
				for (int j=0;j<g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().size();j++) {

				   if(g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j) instanceof Farm) {
		
						try {
							g.getPlayer().upgradeBuilding(g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j));
							cost1.setText("Upgarde cost : "+g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).getUpgradeCost()+" ");
							cost1.setVisible(true);
							 z= new JTextArea(); 
							this.add(z);
							z.setText("Type of Economical Building :"+ "\n-------\n"+
									        			g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).getType() +
												"\n-------\n"		
										        + "Level of Economical Building :"+g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).getLevel());
							z.setVisible(true);		
							this.gv.lv.getInfo().repaint();
							this.gv.revalidate();
							this.gv.lv.setVisible(true);
							this.gv.lv.getInfo().setVisible(true);
							this.gv.lv.refreshlabels();
							//this.gv.lv.updateMil();
							
						} catch (NotEnoughGoldException e1) {
							tf=new JTextField();
							tf.setText("Not Enough Gold for building");
							tf.setVisible(true);
							this.add(tf,BorderLayout.SOUTH);
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					 catch (BuildingInCoolDownException e1) {
						 tf=new JTextField();
							tf.setText("BuildingInCoolDownException");
							tf.setVisible(true);
							this.add(tf,BorderLayout.SOUTH);
						e1.printStackTrace();
					} catch (MaxLevelException e2) {
						tf=new JTextField();
						tf.setText("MaxLevelException");
						tf.setVisible(true);
						this.add(tf,BorderLayout.SOUTH);
						e2.printStackTrace();
					}
			
				}	
				}
	}
		}
		if(e.getSource().equals(Market1)) {
			 for (int i=0;i<g.getPlayer().getControlledCities().size();i++) {
					for (int j=0;j<g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().size();j++) {

					   if(g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j) instanceof Market) {
			
							try {
								g.getPlayer().upgradeBuilding(g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j));
								cost1.setText("Upgarde cost : "+g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).getUpgradeCost()+" ");
								cost1.setVisible(true);
								 z= new JTextArea(); 
								this.add(z);
								z.setText("Type of Economical Building :"+ "\n-------\n"+
										        			g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).getType() +
													"\n-------\n"		
											        + "Level of Economical Building :"+g.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).getLevel());
								z.setVisible(true);		
								this.gv.lv.getInfo().repaint();
								this.gv.revalidate();
								this.gv.lv.setVisible(true);
								this.gv.lv.getInfo().setVisible(true);
								this.gv.lv.refreshlabels();
								//this.gv.lv.updateMil();
								
							} catch (NotEnoughGoldException e1) {
								tf=new JTextField();
								tf.setText("Not Enough Gold for building");
								tf.setVisible(true);
								this.add(tf,BorderLayout.SOUTH);
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						 catch (BuildingInCoolDownException e1) {
							 tf=new JTextField();
								tf.setText("BuildingInCoolDownException");
								tf.setVisible(true);
								this.add(tf,BorderLayout.SOUTH);
							e1.printStackTrace();
						} catch (MaxLevelException e2) {
							tf=new JTextField();
							tf.setText("MaxLevelException");
							tf.setVisible(true);
							this.add(tf,BorderLayout.SOUTH);
							e2.printStackTrace();
						}
				
					}	
					}
		}
			}
		       if(e.getSource().equals(ArcheryRange1)) {
		    	   
		    	   for (int i=0;i<g.getPlayer().getControlledCities().size();i++) {
						for (int j=0;j<g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size();j++) {

						   if(g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j) instanceof ArcheryRange) {
				
								try {
									g.getPlayer().upgradeBuilding(g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j));
									cost1.setText("Upgarde cost : "+g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getUpgradeCost()+" ");
									cost1.setVisible(true);
									 z= new JTextArea(); 
									this.add(z);
									z.setText("Type of Military Building :"+ "\n-------\n"+
											        			g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getType() +
														"\n-------\n"		
												        + "Level of Military Building :"+g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getLevel());
									z.setVisible(true);		
									this.gv.lv.getInfo().repaint();
									this.gv.revalidate();
									this.gv.lv.setVisible(true);
									this.gv.lv.getInfo().setVisible(true);
									this.gv.lv.refreshlabels();
									//this.gv.lv.updateMil();
									
								} catch (NotEnoughGoldException e1) {
									tf=new JTextField();
									tf.setText("Not Enough Gold for building");
									tf.setVisible(true);
									this.add(tf,BorderLayout.SOUTH);
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							 catch (BuildingInCoolDownException e1) {
								 tf=new JTextField();
									tf.setText("BuildingInCoolDownException");
									tf.setVisible(true);
									this.add(tf,BorderLayout.SOUTH);
								e1.printStackTrace();
							} catch (MaxLevelException e2) {
								tf=new JTextField();
								tf.setText("MaxLevelException");
								tf.setVisible(true);
								this.add(tf,BorderLayout.SOUTH);
								e2.printStackTrace();
							}
					
						}	
						}
			}
	}
		       
		if(e.getSource().equals(Barracks1)) {
			 for (int i=0;i<g.getPlayer().getControlledCities().size();i++) {
					for (int j=0;j<g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size();j++) {

					   if(g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j) instanceof Barracks) {
			
							try {
								g.getPlayer().upgradeBuilding(g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j));
								cost1.setText("Upgarde cost : "+g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getUpgradeCost()+" ");
								cost1.setVisible(true);
								 z= new JTextArea(); 
								this.add(z);
								z.setText("Type of Military Building :"+ "\n-------\n"+
										        			g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getType() +
													"\n-------\n"		
											        + "Level of Military Building :"+g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getLevel());
								z.setVisible(true);		
								this.gv.lv.getInfo().repaint();
								this.gv.revalidate();
								this.gv.lv.setVisible(true);
								this.gv.lv.getInfo().setVisible(true);
								this.gv.lv.refreshlabels();
								//this.gv.lv.updateMil();
								
							} catch (NotEnoughGoldException e1) {
								tf=new JTextField();
								tf.setText("Not Enough Gold for building");
								tf.setVisible(true);
								this.add(tf,BorderLayout.SOUTH);
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						 catch (BuildingInCoolDownException e1) {
							 tf=new JTextField();
								tf.setText("BuildingInCoolDownException");
								tf.setVisible(true);
								this.add(tf,BorderLayout.SOUTH);
							e1.printStackTrace();
						} catch (MaxLevelException e2) {
							tf=new JTextField();
							tf.setText("MaxLevelException");
							tf.setVisible(true);
							this.add(tf,BorderLayout.SOUTH);
							e2.printStackTrace();
						}
				
					}	
					}
		}
		}
				if(e.getSource().equals(Stable1)) {
					  for (int i=0;i<g.getPlayer().getControlledCities().size();i++) {
				for (int j=0;j<g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size();j++) {

				   if(g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j) instanceof Stable) {
		
						try {
							g.getPlayer().upgradeBuilding(g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j));
							cost1.setText("Upgarde cost : "+g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getUpgradeCost()+" ");
							cost1.setVisible(true);
							 z= new JTextArea(); 
							this.add(z);
							z.setText("Type of Military Building :"+ "\n-------\n"+
									        			g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getType() +
												"\n-------\n"		
										        + "Level of Military Building :"+g.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getLevel());
							z.setVisible(true);		
							this.gv.lv.getInfo().repaint();
							this.gv.revalidate();
							this.gv.lv.setVisible(true);
							this.gv.lv.getInfo().setVisible(true);
							this.gv.lv.refreshlabels();
							//this.gv.lv.updateMil();
							
						} catch (NotEnoughGoldException e1) {
							tf=new JTextField();
							tf.setText("Not Enough Gold for building");
							tf.setVisible(true);
							this.add(tf,BorderLayout.SOUTH);
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					 catch (BuildingInCoolDownException e1) {
						 tf=new JTextField();
							tf.setText("BuildingInCoolDownException");
							tf.setVisible(true);
							this.add(tf,BorderLayout.SOUTH);
						e1.printStackTrace();
					} catch (MaxLevelException e2) {
						tf=new JTextField();
						tf.setText("MaxLevelException");
						tf.setVisible(true);
						this.add(tf,BorderLayout.SOUTH);
						e2.printStackTrace();
					}
			
				}	
				}
	}}
		
				if(e.getSource().equals(Stable2)) {
					
							try {
								for(int j=0;j<g.getPlayer().getControlledCities().size();j++) {	
								if (g.getPlayer().getControlledCities().get(j).getName().equals(this.gv.Cities.getSelectedItem().toString())) {
									City l= g.getPlayer().getControlledCities().get(j);
								g.getPlayer().recruitUnit("Stable",this.gv.Cities.getSelectedItem().toString());
								for (int i=0;i<l.getMilitaryBuildings().size();i++) {
								recost.setText("Recruitment cost : "+l.getMilitaryBuildings().get(i).getRecruitmentCost()+" ");
								recost.setVisible(true);
								
								this.gv.lv.getInfo().repaint();
								this.gv.revalidate();
								this.gv.lv.setVisible(true);
								this.gv.lv.getInfo().setVisible(true);
								this.gv.lv.refreshlabels();
								this.repaint();
								this.revalidate();
								}}
								}
								
							} catch (NotEnoughGoldException e1) {
								tf=new JTextField();
								tf.setText("Not Enough Gold for building");
								tf.setVisible(true);
								this.add(tf,BorderLayout.SOUTH);
								e1.printStackTrace();
							}
						 catch (BuildingInCoolDownException e1) {
							 tf=new JTextField();
								tf.setText("BuildingInCoolDownException");
								tf.setVisible(true);
								this.add(tf,BorderLayout.SOUTH);
							e1.printStackTrace();
						} catch (MaxRecruitedException e2) {
							tf=new JTextField();
							tf.setText("MaxRecruitedException");
							tf.setVisible(true);
							this.add(tf,BorderLayout.SOUTH);
							e2.printStackTrace();
						}
						
			
					}
		
				if(e.getSource().equals(ArcheryRange2)) {
							try {
								for(int j=0;j<g.getPlayer().getControlledCities().size();j++) {	
									if (g.getPlayer().getControlledCities().get(j).getName().equals(this.gv.Cities.getSelectedItem().toString())) {
										City l= g.getPlayer().getControlledCities().get(j);
									g.getPlayer().recruitUnit("ArcheryRange",this.gv.Cities.getSelectedItem().toString());
									for (int i=0;i<l.getMilitaryBuildings().size();i++) {
									recost.setText("Recruitment cost : "+l.getMilitaryBuildings().get(i).getRecruitmentCost()+" ");
									recost.setVisible(true);
									this.gv.lv.getInfo().repaint();
									this.gv.revalidate();
									this.gv.lv.setVisible(true);
									this.gv.lv.getInfo().setVisible(true);
									this.gv.lv.refreshlabels();
									this.repaint();
									this.revalidate();
									}}
									
								}
							} catch (NotEnoughGoldException e1) {
								tf=new JTextField();
								tf.setText("Not Enough Gold for building");
								tf.setVisible(true);
								this.add(tf,BorderLayout.SOUTH);
								e1.printStackTrace();
							}
							
						 catch (BuildingInCoolDownException e1) {
							 tf=new JTextField();
								tf.setText("BuildingInCoolDownException");
								tf.setVisible(true);
								this.add(tf,BorderLayout.SOUTH);
							e1.printStackTrace();
						} catch (MaxRecruitedException e2) {
							tf=new JTextField();
							tf.setText("MaxRecruitedException");
							tf.setVisible(true);
							this.add(tf,BorderLayout.SOUTH);
							e2.printStackTrace();
						}
		}
				if(e.getSource().equals(Barracks2)) {
							try {
								for(int j=0;j<g.getPlayer().getControlledCities().size();j++) {	
									if (g.getPlayer().getControlledCities().get(j).getName().equals(this.gv.Cities.getSelectedItem().toString())) {
										City l= g.getPlayer().getControlledCities().get(j);
									g.getPlayer().recruitUnit("Barracks",this.gv.Cities.getSelectedItem().toString());
									for (int i=0;i<l.getMilitaryBuildings().size();i++) {
									recost.setText("Recruitment cost : "+l.getMilitaryBuildings().get(i).getRecruitmentCost()+" ");
									recost.setVisible(true);
									this.gv.lv.getInfo().repaint();
									this.gv.revalidate();
									this.gv.lv.setVisible(true);
									this.gv.lv.getInfo().setVisible(true);
									this.gv.lv.refreshlabels();
									this.repaint();
									this.revalidate();
									}}
								
								
								}
						} catch (NotEnoughGoldException e1) {
							tf=new JTextField();
							tf.setText("Not Enough Gold for building");
							tf.setVisible(true);
							this.add(tf,BorderLayout.SOUTH);
								e1.printStackTrace();
						} catch (BuildingInCoolDownException e1) {
							tf=new JTextField();
							tf.setText("BuildingInCoolDownException");
							tf.setVisible(true);
							this.add(tf,BorderLayout.SOUTH);
							e1.printStackTrace();
						} catch (MaxRecruitedException e2) {
							tf=new JTextField();
							tf.setText("MaxRecruitedException");
							tf.setVisible(true);
							this.add(tf,BorderLayout.SOUTH);
							e2.printStackTrace();
						}

		}
				
				if(e.getSource().equals(Armview)) {
					
					 this.setVisible(false);
					 arm.setVisible(true);
				}
				
				if(e.getSource().equals(IntArmy)) {
						
				    Unit unit1 =this.c.getDefendingArmy().getUnits().get((int) (Math.random() * g.getPlayer().getControlledArmies().size())); 
				    
					g.getPlayer().initiateArmy(this.c, unit1);
					
			}
				
				
		
		
	}
	}

