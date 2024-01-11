package com.eheio.Examen;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ProduitServiceTest {
	 private ProduitService produitService;

	    @Before
	    public void setUp() {
	        produitService = new ProduitService();
	    }
	    @Test
	    public void testAjouterProduit() {
	        Produit produit1 = new Produit(1, "Produit A", 10.0, 5);
	        Produit produit2 = new Produit(2, "Produit B", 15.0, 8);

	        produitService.AjouterProduit(produit1);

	        assertTrue(produitService.verification(produit1));

	        produitService.AjouterProduit(produit1);

	        assertFalse(produitService.verification(produit2));

	        produitService.AjouterProduit(produit2);

	        assertTrue(produitService.verification(produit2));
	    }
	    
	    @Test
	    public void testModifierProduit() {
	        
	        Produit produitInitial = new Produit(1, "Produit A", 10.0, 5);
	        produitService.AjouterProduit(produitInitial);

	       
	        Produit produitModifie = new Produit(1, "Produit Modifié", 15.0, 8);

	       
	        produitService.ModifierProduit(produitModifie);

	        
	        assertTrue(produitService.verification(produitModifie));
	    }

}
