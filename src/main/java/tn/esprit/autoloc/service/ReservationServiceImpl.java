package tn.esprit.autoloc.service;

import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.repository.IReservationRepository;
import java.util.List;

@Service
public class ReservationServiceImpl implements IReservationService {

    private final IReservationRepository reservationRepository;

    public ReservationServiceImpl(IReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation ajouterReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> listerReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation trouverReservation(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerReservation(Long id) {
        reservationRepository.deleteById(id);
    }
}