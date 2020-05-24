package pglp_5_1;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;

public enum App {
	APPLICATION;
	
	public static void main(String[] args) throws IOException 
	{
		Personnel p1;
		Personnel p2;
		GroupePersonnel Agents;
		
		LocalDate date = LocalDate.of(1994, 06, 03);
		HashSet<NumeroTelephone> tel = new HashSet<NumeroTelephone>();
		tel.add(new NumeroTelephone("0156668965"));
		tel.add(new NumeroTelephone("0669133742"));
		
		p1 = new Personnel.Builder("Hubert", "Bonisseur de La Bath").build();
		p2 = new Personnel.Builder("Noel", "Flantier").poste("Eleveur").datedenaissance(date).telephone(tel).build();
		
		Agents = new GroupePersonnel();
		Agents.AjouterPersonnel(p1);
		Agents.AjouterPersonnel(p2);
		
		System.out.println(Agents.toString());
		
		DAOGroupePersonnel daogroupe = new DAOGroupePersonnel();
		daogroupe.creer(Agents);
	}

}
