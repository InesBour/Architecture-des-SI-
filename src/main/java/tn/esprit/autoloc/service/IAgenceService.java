package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Agence;
import java.util.List;

public interface IAgenceService {
    Agence ajouterAgence(Agence agence);
    List<Agence> listerAgences();
    Agence trouverAgence(Long id);
    void supprimerAgence(Long id);
}