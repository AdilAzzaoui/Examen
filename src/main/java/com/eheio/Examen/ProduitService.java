package com.eheio.Examen;

import java.util.ArrayList;
import java.util.List;

public class ProduitService {
	private List<Produit> produits = new ArrayList<Produit>();
	
	
	public boolean verification(Produit produit) {
		for (Produit product : produits) {
			if(product.getId() == produit.getId()) {
				return true;
			}
		}
		return false;
	}
	
	public void AjouterProduit(Produit produit) {
		try {
		if(verification(produit)) {
			throw new Exception();
		}
		produits.add(produit);
		}catch(Exception e) {
			System.out.println("Ce produit existe deja !");
		}
	}
	
	public void ModifierProduit(Produit produit)
	{
		
		try {
			if(!verification(produit)) {
				throw new Exception();
			}
			if(produit.getPrix()<0 || produit.getQuantité()<0)
			{
				throw new IllegalArgumentException();
			}
			for(Produit product : produits)
			{
				if(product.getId()==produit.getId())
				{
					product.setNom(produit.getNom());
					product.setPrix(produit.getPrix());
					product.setQuantité(produit.getQuantité());
				}
			}
		   }
		catch(IllegalArgumentException a)
		{
			System.out.println("La quantité et le prix doivent être positifs!");
		}
		catch(Exception e)
		{
			System.out.println("Le produit n'existe pas !");
		}	
	}
	public void SupprimerProduit(Produit produit) {
		try {
			if(!verification(produit)) {
				throw new NullPointerException();
			}
			for (Produit product : produits) {
				if(product.getId() == produit.getId()) {
					produits.remove(product);
				}
			}
		}catch(NullPointerException e) {
			
		}
	}
	
	public void ListerProduit()
	{
		try {
			if(produits.isEmpty())
			{
				throw new IllegalStateException();
			}
			for(Produit product : produits)	
			{ 
				System.out.println("\t\t**********Produit*************");
				System.out.println("Numéro   :"+product.getId());
				System.out.println("Nom      :"+product.getNom());
				System.out.println("Prix     :"+product.getPrix());
				System.out.println("Quantité :"+product.getQuantité());
				System.out.println("___________________________________");
			}
		}
		catch(IllegalStateException e)
		{
			System.out.println("Aucun produit n'existe !");
		}
	}
}
