package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Maintenance;
import java.util.List;

public interface IMaintenanceService {
    Maintenance ajouterMaintenance(Maintenance maintenance);
    List<Maintenance> listerMaintenances();
    Maintenance trouverMaintenance(Long id);
    void supprimerMaintenance(Long id);
}