package dao;

import java.util.ArrayList;

import beans.Utilisateurs;

public class UtilisateursDao {
	
	public static int lastId = 0;
	public final static ArrayList<Utilisateurs> utilisateurs = new ArrayList<Utilisateurs>();
	
	static {
		
		utilisateurs.add(new Utilisateurs("Super","User","administrateur","adminP@ssword"));
	}
	
	
	public static ArrayList<Utilisateurs> lister()
	{
		return utilisateurs;
	}
	
	public static boolean Ajouter(Utilisateurs utilisateur) 
	{
		lastId++;
		utilisateur.setId(lastId);
		utilisateurs.add(utilisateur);
		return true;
	}
	
	public static boolean supprimer(int id) {
		
		for(Utilisateurs utilisateur : utilisateurs) 
		{
			if (utilisateur.getId() == id){
				utilisateurs.remove(utilisateur);
				return true;
			}
		}
		return false;
	}
	
	public static Utilisateurs get(String login) {
		for(Utilisateurs utilisateur:utilisateurs) {
			if(utilisateur.getLogin().equals(login)) {
				return utilisateur;
			}
			
		}
		
		return null;
	}
	
	public static Utilisateurs getId(int id) {
		for(Utilisateurs utilisateur:utilisateurs) {
			if(utilisateur.getId()==id) {
				return utilisateur;
			}
			
		}
		
		return null;
	}
	
	
	public static boolean modification(Utilisateurs user) {
		
		for (Utilisateurs utilisateur : utilisateurs) {
				if(utilisateur.getId() == user.getId()) {
					
					utilisateur.setNom(user.getNom());
					utilisateur.setPrenom(user.getPrenom());
					utilisateur.setLogin(user.getLogin());
					utilisateur.setPassword(user.getPassword());
					return true;
				}
		}
		
		return false;
	}
	
	

}
