package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.IEquipementRepository;
import java.util.List;

@Service
public class EquipementServiceImpl implements IEquipementService {

    private final IEquipementRepository equipementRepository;

    public EquipementServiceImpl(IEquipementRepository equipementRepository) {
        this.equipementRepository = equipementRepository;
    }

    @Override
    public Equipement ajouterEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public List<Equipement> listerEquipements() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement trouverEquipement(Long id) {
        return equipementRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerEquipement(Long id) {
        equipementRepository.deleteById(id);
    }
}