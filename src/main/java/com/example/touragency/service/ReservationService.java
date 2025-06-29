package com.example.touragency.service;

import com.example.touragency.model.Reservation;
import com.example.touragency.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> updateReservation(Long id, Reservation reservation) {
        return reservationRepository.findById(id).map(existingReservation -> {
            existingReservation.setCustomer(reservation.getCustomer());
            existingReservation.setTour(reservation.getTour());
            existingReservation.setReservationDate(reservation.getReservationDate());
            existingReservation.setNumberOfPeople(reservation.getNumberOfPeople());
            // Diğer alanları ekle
            return reservationRepository.save(existingReservation);
        });
    }

    public boolean deleteReservation(Long id) {
        return reservationRepository.findById(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
    }
}
