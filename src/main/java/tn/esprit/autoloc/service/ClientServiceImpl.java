package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.IClientRepository;
import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {

    private final IClientRepository clientRepository;

    public ClientServiceImpl(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client ajouterClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> listerClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client trouverClient(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerClient(Long id) {
        clientRepository.deleteById(id);
    }
}