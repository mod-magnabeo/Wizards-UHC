package com.Wolf_IV.WizardUHC.tasks;

import java.util.Random;

import org.bukkit.Bukkit;

import com.Wolf_IV.WizardUHC.MainW;

public class RoleShuffle {
	
	Random rand = new Random();
	public String j1;
	public String j2;
	public String j3;
	public String j4;
	public String j5;
	public String j6;
	public String j7;
	public String j8;
	public String j9;
	public String j10;
	public String j11;
	public String j12;
	public String E1p1;
	public String E1p2;
	public String E1p3;
	public String E2p1;
	public String E2p2;
	public String E2p3;
	public String E3p1;
	public String E3p2;
	public String E3p3;
	public String E4p1;
	public String E4p2;
	public String E4p3;
	public String Nj[]= new String[5];
	public String Fj[]= new String[5];
	public String Pj[]= new String[5];
	public String Ej[]= new String[5];
	public String EM[]= new String[5];
	public String SwizN;
	public String SwizF;
	public String SwizP;
	public String SwizE;
	public String SNser1;
	public String SNser2;
	public String SFser1;
	public String SFser2;
	public String SPser1;
	public String SPser2;
	public String SEser1;
	public String SEser2;
	
	public int jnub=0;
	public int nubsE=12;
	public int nubpaN=12;
	public boolean erreurNull=false;
	public boolean erreurPseudo=false;
	public String j[]= new String[15];
	public int jc[]=new int[8];
	
	private static MainW main;
	public RoleShuffle(MainW mainW) { 
		this.main= mainW;
		
	}
	
	
	public boolean Shuffle() {
		
		boolean matchW=false;
		 int i;
		 int rando;
		 int choose;
		 int choose2;
		 String container = null;
		 
		 
		 /*E1p1 = "wolf331";
			Nj[1]=E1p1;
			
			
		E1p2 = "sharky332";
			Nj[2]=E1p2;
		
			
		E1p3 = "null";
			Nj[3]=E1p3;
			
			
			 E2p1 = "null";
				Pj[1]=E2p1;
				
				
			E2p2 = "null";
				Pj[2]=E2p2;
			
				
			E2p3 = "null";
				Pj[3]=E2p3;
				
				
				
				 E3p1 = "soindj333";
					Ej[1]=E3p1;
					
					
				E3p2 = "null";
					Ej[2]=E3p2;
				
					
				E3p3 = "null";
					Ej[3]=E3p3;
					
					
					
					 E4p1 = "null";
						Fj[1]=E4p1;
						
						
					E4p2 = "null";
						Fj[2]=E4p2;
					
						
					E4p3 = "null";
						Fj[3]=E4p3;
		 
		 

			j1 = "Wolf1";
			j[0]=j1;
			
			
			

			j2 = "Jamie2";
			j[1]=j2;
		
			
			

			j3 = "yism3";
			j[2]=j3;
		
			
			

			j4 = "minecraft4";
			j[3]=j4;
			
			
			

			j5 = "Technoblade5";
			j[4]=j5;
			
			
			
			
		
		
		
		
			j6 = "Bob6";
			j[5]=j6;
			
			j7 = "Tomshaz7";
			j[6]=j7;
			
			j8 = "JAckdaw8";
			j[7]=j8;
			
			j9 = "Diplo9";
			j[8]=j9;
			
			j10 = "null";
			j[9]=j10;
			
			j11 = "null";
			j[10]=j11;
			
			j12 = "null";
			j[11]=j12;*/
			
			
			E1p1=main.getConfig().getString("wizard.player.E1p1");
			E1p2=main.getConfig().getString("wizard.player.E1p2");
			E1p3=main.getConfig().getString("wizard.player.E1p3");
			
			E2p1=main.getConfig().getString("wizard.player.E2p1");
			E2p2=main.getConfig().getString("wizard.player.E2p2");
			E2p3=main.getConfig().getString("wizard.player.E2p3");
			
			E3p1=main.getConfig().getString("wizard.player.E3p1");
			E3p2=main.getConfig().getString("wizard.player.E3p2");
			E3p3=main.getConfig().getString("wizard.player.E3p3");
			
			E4p1=main.getConfig().getString("wizard.player.E4p1");
			E4p2=main.getConfig().getString("wizard.player.E4p2");
			E4p3=main.getConfig().getString("wizard.player.E4p3");
			
			
			j1=main.getConfig().getString("wizard.player.j1");
			
			j2=main.getConfig().getString("wizard.player.j2");
			
			j3=main.getConfig().getString("wizard.player.j3");
			
			j4=main.getConfig().getString("wizard.player.j4");
			
			j5=main.getConfig().getString("wizard.player.j5");
			
			j6=main.getConfig().getString("wizard.player.j6");
			
			j7=main.getConfig().getString("wizard.player.j7");
			
			j8=main.getConfig().getString("wizard.player.j8");
			
			j9=main.getConfig().getString("wizard.player.j9");
			
			j10=main.getConfig().getString("wizard.player.j10");
			
			j11=main.getConfig().getString("wizard.player.j11");
			
			j12=main.getConfig().getString("wizard.player.j12");
			
			Nj[1]=E1p1;
			
			Nj[2]=E1p2;
			
			Nj[3]=E1p3;
			
			Pj[1]=E2p1;
			
			Pj[2]=E2p2;
			
			Pj[3]=E2p3;
			
			Ej[1]=E3p1;
			
			Ej[2]=E3p2;
			
			Ej[3]=E3p3;
			
			Fj[1]=E4p1;
			
			Fj[2]=E4p2;
			
			Fj[3]=E4p3;
			
			j[0]=j1;
			
			j[1]=j2;
			
			j[2]=j3;
			
			j[3]=j4;
			
			j[4]=j5;
			
			j[5]=j6;
			
			j[6]=j7;
			
			j[7]=j8;
			
			j[8]=j9;
			
			j[9]=j10;
			
			j[10]=j11;
			
			j[11]=j12;
			
			
	
	for(i=11;i>=0;i--) {
		if(j[i].equalsIgnoreCase("null")) {
			nubsE--;
		}else {
			i=0;
		}
		}
	
	
	rando=rand.nextInt(100)+15;
	for(i=0;i<=rando;i++) {
		choose=rand.nextInt(nubsE);
		choose2=rand.nextInt(nubsE);
		container=j[choose2];
		j[choose2]=j[choose];
		j[choose]=container;
		}
	
	
	for(i=1;i<=3;i++) {
		if(Nj[i].equalsIgnoreCase("null")) {
			if(j[jnub].equalsIgnoreCase("null")) {
				erreurNull=true;
			}else {
			Nj[i]=j[jnub];
			jnub++;
			}
		}else {
			nubpaN--;
		}
		}
	for(i=1;i<=3;i++) {
		if(Pj[i].equalsIgnoreCase("null")) {
			if(j[jnub].equalsIgnoreCase("null")) {
				erreurNull=true;
			}else {
			Pj[i]=j[jnub];
			jnub++;
			}
		}else {
			nubpaN--;
		}
		}
	for(i=1;i<=3;i++) {
		if(Ej[i].equalsIgnoreCase("null")) {
			if(j[jnub].equalsIgnoreCase("null")) {
				erreurNull=true;
			}else {
			Ej[i]=j[jnub];
			jnub++;
			}
		}else {
			nubpaN--;
		}
		}
	for(i=1;i<=3;i++) {
		if(Fj[i].equalsIgnoreCase("null")) {
			if(j[jnub].equalsIgnoreCase("null")) {
				erreurNull=true;
			}else {
			Fj[i]=j[jnub];
			jnub++;
			}
		}else {
			nubpaN--;
		}
		}
	
	 
	rando=rand.nextInt(25)+5;
	for(i=0;i<=rando;i++) {
		choose=rand.nextInt(3)+1;
		choose2=rand.nextInt(3)+1;
		container=Nj[choose2];
		Nj[choose2]=Nj[choose];
		Nj[choose]=container;
		}
	
	rando=rand.nextInt(25)+5;
	for(i=0;i<=rando;i++) {
		choose=rand.nextInt(3)+1;
		choose2=rand.nextInt(3)+1;
		container=Pj[choose2];
		Pj[choose2]=Pj[choose];
		Pj[choose]=container;
		}
	
	rando=rand.nextInt(25)+5;
	for(i=0;i<=rando;i++) {
		choose=rand.nextInt(3)+1;
		choose2=rand.nextInt(3)+1;
		container=Ej[choose2];
		Ej[choose2]=Ej[choose];
		Ej[choose]=container;
		}
	
	rando=rand.nextInt(25)+5;
	for(i=0;i<=rando;i++) {
		choose=rand.nextInt(3)+1;
		choose2=rand.nextInt(3)+1;
		container=Fj[choose2];
		Fj[choose2]=Fj[choose];
		Fj[choose]=container;
		}
		
	EM[1]="N";
	EM[2]="F";
	EM[3]="E";
	EM[4]="P";
	
	rando=rand.nextInt(50)+10;
	for(i=0;i<=rando;i++) {
		choose=rand.nextInt(4)+1;
		choose2=rand.nextInt(4)+1;
		container=EM[choose2];
		EM[choose2]=EM[choose];
		EM[choose]=container;
		}
	
	for(i=1;i<=4;i++) {
		String EP1=null;
		String EP2=null;
		String EP3=null;
		if(i==1) {
			EP1=Nj[1];
			EP2=Nj[2];
			EP3=Nj[3];
		}else if(i==2) {
			EP1=Pj[1];
			EP2=Pj[2];
			EP3=Pj[3];
		}else if(i==3) {
			EP1=Fj[1];
			EP2=Fj[2];
			EP3=Fj[3];
		}else if(i==4) {
			EP1=Ej[1];
			EP2=Ej[2];
			EP3=Ej[3];
		}
		
		if(EM[i]=="N") {
			SNser1=EP1;
			SNser2=EP2;
			SwizN=EP3;
		}else if(EM[i]=="P") {
			SPser1=EP1;
			SPser2=EP2;
			SwizP=EP3;
		}else if(EM[i]=="F") {
			SFser1=EP1;
			SFser2=EP2;
			SwizF=EP3;
		}else if(EM[i]=="E") {
			SEser1=EP1;
			SEser2=EP2;
			SwizE=EP3;
		}
	}
	if(nubpaN!=nubsE) {
		erreurNull=true;
	}
	
	/*
	 * Test
	 */
	if(erreurNull==true) {
		Bukkit.broadcastMessage("§a il y a surement un null dans les equipe");
		Bukkit.broadcastMessage("§a il y a surement un null dans les equipe");
		Bukkit.broadcastMessage("§a il y a surement un null dans les equipe");
		Bukkit.broadcastMessage("§a il y a surement un null dans les equipe");
		Bukkit.broadcastMessage("§a il y a surement un null dans les equipe");
		Bukkit.broadcastMessage("§a il y a surement un null dans les equipe");
		Bukkit.broadcastMessage("§a il y a surement un null dans les equipe");
		Bukkit.broadcastMessage("§a il y a surement un null dans les equipe");
		Bukkit.broadcastMessage("§a il y a surement un null dans les equipe");
	}
	/*Bukkit.broadcastMessage("  "+j1);
	Bukkit.broadcastMessage("Equipe Necromancié "+SNser1+" et "+SNser2+" et pour scorcier "+SwizN);
	Bukkit.broadcastMessage("Equipe Feu "+SFser1+" et "+SFser2+" et pour scorcier "+SwizF);
	Bukkit.broadcastMessage("Equipe Pierre "+SPser1+" et "+SPser2+" et pour scorcier "+SwizP);
	Bukkit.broadcastMessage("Equipe Eau "+SEser1+" et "+SEser2+" et pour scorcier "+SwizE);*/
	
	
	/*
	 * Test
	 */
	
	
	
	
	return true;
}
	
	
	
	
	
	
	
	
	
	
	
}
