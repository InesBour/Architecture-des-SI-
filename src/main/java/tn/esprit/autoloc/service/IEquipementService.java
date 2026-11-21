package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;
import java.util.List;

public interface IEquipementService {
    Equipement ajouterEquipement(Equipement equipement);
    List<Equipement> listerEquipements();
    Equipement trouverEquipement(Long id);
    void supprimerEquipement(Long id);
}