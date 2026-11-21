package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;
import java.util.List;

public interface IClientService {
    Client ajouterClient(Client client);
    List<Client> listerClients();
    Client trouverClient(Long id);
    void supprimerClient(Long id);
}