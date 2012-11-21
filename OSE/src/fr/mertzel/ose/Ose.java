package fr.mertzel.ose;

import fr.mertzel.ose.vue.*;
import fr.mertzel.ose.controleur.*;
import fr.mertzel.ose.modele.*;

public class Ose {
	public static void main(String[] args) {
		PlanSalle modele = new PlanSalle("Sans Nom");
		FenetrePrincipale vue = new FenetrePrincipale(modele);
		new Controleur(vue, modele);
	}
}