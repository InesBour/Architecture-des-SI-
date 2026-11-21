package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;
import java.util.List;

public interface IEmployeService {
    Employe ajouterEmploye(Employe employe);
    List<Employe> listerEmployes();
    Employe trouverEmploye(Long id);
    void supprimerEmploye(Long id);
}