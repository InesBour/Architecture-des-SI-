package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.IContratRepository;
import java.util.List;

@Service
public class ContratServiceImpl implements IContratService {

    private final IContratRepository contratRepository;

    public ContratServiceImpl(IContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    @Override
    public Contrat ajouterContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public List<Contrat> listerContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat trouverContrat(Long id) {
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerContrat(Long id) {
        contratRepository.deleteById(id);
    }
}