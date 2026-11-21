package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Reservation;
import java.util.List;

public interface IReservationService {
    Reservation ajouterReservation(Reservation reservation);
    List<Reservation> listerReservations();
    Reservation trouverReservation(Long id);
    void supprimerReservation(Long id);
}