package tn.esprit.autoloc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.esprit.autoloc.domain.*;
import tn.esprit.autoloc.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class AutolocApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutolocApiApplication.class, args);
    }

    @Bean
    CommandLineRunner test(IAgenceService agenceService,
                           IVehiculeService vehiculeService,
                           IClientService clientService,
                           IReservationService reservationService) {
        return args -> {
            // 1. Agence
            Agence agence = new Agence();
            agence.setNom("AutoLoc Tunis");
            agence.setVille("Tunis");
            agence.setAdresse("Centre ville");
            agence.setTelephone("71000000");
            agence = agenceService.ajouterAgence(agence);

            // 2. Véhicule rattaché à l'agence
            Vehicule vehicule = new Vehicule();
            vehicule.setImmatriculation("TUN-" + System.currentTimeMillis());
            vehicule.setMarque("Renault");
            vehicule.setModele("Clio");
            vehicule.setCategorie(CategorieVehicule.CITADINE);
            vehicule.setTarifJournalier(new BigDecimal("80.00"));
            vehicule.setStatut(StatutVehicule.DISPONIBLE);
            vehicule.setAgence(agence);
            vehicule = vehiculeService.ajouterVehicule(vehicule);

            // 3. Client
            Client client = new Client();
            client.setNom("Ben Ali");
            client.setPrenom("Sami");
            client.setEmail("sami@test.tn");
            client.setTelephone("22000000");
            client.setNumPermis("P12345");
            client.setDateInscription(LocalDate.now());
            client = clientService.ajouterClient(client);

            // 4. Réservation liée au client et au véhicule
            Reservation reservation = new Reservation();
            reservation.setDateDebut(LocalDate.now());
            reservation.setDateFin(LocalDate.now().plusDays(3));
            reservation.setStatut(StatutReservation.EN_ATTENTE);
            reservation.setClient(client);
            reservation.setVehicule(vehicule);
            reservation = reservationService.ajouterReservation(reservation);

            System.out.println("===== TEST AUTOLOC =====");
            System.out.println("Nb agences : " + agenceService.listerAgences().size());
            System.out.println("Nb véhicules : " + vehiculeService.listerVehicules().size());
            System.out.println("Nb clients : " + clientService.listerClients().size());
            System.out.println("Nb réservations : " + reservationService.listerReservations().size());
            System.out.println("Réservation " + reservation.getIdReservation()
                    + " : " + reservation.getClient().getNom()
                    + " -> " + reservation.getVehicule().getMarque() + " " + reservation.getVehicule().getModele());
            System.out.println("========================");
        };
    }
}