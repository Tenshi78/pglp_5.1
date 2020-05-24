package pglp_5_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public abstract class DAO<T> implements Serializable{

	private static final long serialVersionUID = 2218718748708688119L;
	
	public abstract boolean creer(T objet) throws IOException;
	public abstract T lire(String identifiant) throws IOException, ClassNotFoundException;
	public abstract boolean supprimer(T objet);
	public abstract boolean maj(T objet) throws FileNotFoundException, IOException;

}