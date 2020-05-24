package pglp_5_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DAOPersonnel extends DAO<Personnel>{

	private static final long serialVersionUID = -155707383354982018L;

	@Override
	public boolean creer(Personnel objet) throws IOException {
		
		File fichier = new File("DAO/GroupePersonnel" + objet.toString() + ".data");
		if(!fichier.exists())
		{
			ObjectOutputStream stream =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
			stream.writeObject(objet);
			stream.close();
			
			return true;
		}
		System.out.print("Le fichier " + fichier.getName() + " existe déja création impossible." );
		
		return false;
	}

	@Override
	public Personnel lire(String identifiant) throws IOException, ClassNotFoundException {
		
		FileInputStream fichier = new FileInputStream("DAO/GroupePersonnel" + identifiant + ".data");
		ObjectInputStream input = new ObjectInputStream(fichier);
		Personnel groupe = (Personnel)input.readObject();
		
		input.close();
		fichier.close();
		
		return groupe;
	}

	@Override
	public boolean supprimer(Personnel objet) {
		File fichier = new File("DAO/GroupePersonnel" + objet.toString() + ".data");
		if(fichier.exists())
		{
			fichier.delete();
			return true;
		}
		System.out.print("Le fichier : " + fichier.getName() + " n'existe pas suppression impossible." );
		return false;
	}

	@Override
	public boolean maj(Personnel objet) throws FileNotFoundException, IOException {
		File fichier = new File("bdd/gpersonnel/" + objet.toString() + ".data");
		if(fichier.exists())
		{
			ObjectOutputStream stream =  new ObjectOutputStream(new FileOutputStream(fichier)) ;
			stream.writeObject(objet);
			stream.close();
			return true;
		}
		System.out.print("Le fichier " + fichier.getName() + " n'existe pas MAJ impossible." );
		return false;
	}

}
