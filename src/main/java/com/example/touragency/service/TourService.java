package com.example.touragency.service;

import com.example.touragency.model.Tour;
import com.example.touragency.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourService {

    @Autowired
    private TourRepository tourRepository;

    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }

    public Optional<Tour> getTourById(Long id) {
        return tourRepository.findById(id);
    }

    public Tour saveTour(Tour tour) {
        return tourRepository.save(tour);
    }

    public Optional<Tour> updateTour(Long id, Tour tour) {
        return tourRepository.findById(id).map(existingTour -> {
            existingTour.setTourName(tour.getTourName());
            existingTour.setPrice(tour.getPrice());
            existingTour.setDuration(tour.getDuration());
            existingTour.setDescription(tour.getDescription());
            // Diğer alanları ekle
            return tourRepository.save(existingTour);
        });
    }

    public boolean deleteTour(Long id) {
        return tourRepository.findById(id).map(tour -> {
            tourRepository.delete(tour);
            return true;
        }).orElse(false);
    }
}
