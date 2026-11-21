package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Paiement;
import java.util.List;

public interface IPaiementService {
    Paiement ajouterPaiement(Paiement paiement);
    List<Paiement> listerPaiements();
    Paiement trouverPaiement(Long id);
    void supprimerPaiement(Long id);
}