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
}
