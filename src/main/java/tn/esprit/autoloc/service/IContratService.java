package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Contrat;
import java.util.List;

public interface IContratService {
    Contrat ajouterContrat(Contrat contrat);
    List<Contrat> listerContrats();
    Contrat trouverContrat(Long id);
    void supprimerContrat(Long id);
}