package heig.igl3.roc2.Business;

import java.util.Date;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class Mouvement {
	
	public enum TypeMouvement {PONCTUEL, RECURENT}
	public enum TypeES {ENTREE, SORTIE}
	
	public int id;
	public String libelle;
	public float montant;
	public int type;
	public int ESType;
	public GregorianCalendar date;
	public int periodicite;
	public int idCategorie;
	public int idSousCategorie;
	public int idBudget;
	
	public Mouvement(int id, String libelle, float montant, int type,int ESType, GregorianCalendar date, int periodicite, int idCategorie, int idSousCategorie, int idBudget) {
		this.id = id;
		this.libelle = libelle;
		this.montant = montant;
		this.type = type;
		this.ESType = ESType;
		this.date = date;
		this.periodicite = periodicite;
		this.idCategorie = idCategorie;
		this.idSousCategorie = idSousCategorie;
		this.idBudget = idBudget;
	}
	
	

}
