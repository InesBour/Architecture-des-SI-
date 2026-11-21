package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.IMaintenanceRepository;
import java.util.List;

@Service
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final IMaintenanceRepository maintenanceRepository;

    public MaintenanceServiceImpl(IMaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @Override
    public Maintenance ajouterMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public List<Maintenance> listerMaintenances() {
        return maintenanceRepository.findAll();
    }

    @Override
    public Maintenance trouverMaintenance(Long id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerMaintenance(Long id) {
        maintenanceRepository.deleteById(id);
    }
}