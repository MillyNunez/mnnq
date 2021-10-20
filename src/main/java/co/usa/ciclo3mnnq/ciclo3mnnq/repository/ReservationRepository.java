package co.usa.ciclo3mnnq.ciclo3mnnq.repository;

/**
 *
 * @author mnnq
 */
import co.usa.ciclo3mnnq.ciclo3mnnq.model.Reservation;
import co.usa.ciclo3mnnq.ciclo3mnnq.repository.crud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation rt){
        return reservationCrudRepository.save(rt);
    }
    public void delete(Reservation rt){
        reservationCrudRepository.delete(rt);
    }
}
