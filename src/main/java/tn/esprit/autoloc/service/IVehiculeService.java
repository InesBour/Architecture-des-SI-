package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Vehicule;
import java.util.List;

public interface IVehiculeService {
    Vehicule ajouterVehicule(Vehicule vehicule);
    List<Vehicule> listerVehicules();
    Vehicule trouverVehicule(Long id);
    void supprimerVehicule(Long id);
}
