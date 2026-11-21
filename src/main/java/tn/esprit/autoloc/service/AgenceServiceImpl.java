package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.IAgenceRepository;
import java.util.List;

@Service
public class AgenceServiceImpl implements IAgenceService {

    private final IAgenceRepository agenceRepository;

    public AgenceServiceImpl(IAgenceRepository agenceRepository) {
        this.agenceRepository = agenceRepository;
    }

    @Override
    public Agence ajouterAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public List<Agence> listerAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence trouverAgence(Long id) {
        return agenceRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerAgence(Long id) {
        agenceRepository.deleteById(id);
    }
}