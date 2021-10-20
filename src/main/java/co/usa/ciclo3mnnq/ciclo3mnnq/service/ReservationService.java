package co.usa.ciclo3mnnq.ciclo3mnnq.service;


/**
 *
 * @author mnnq
 */
import co.usa.ciclo3mnnq.ciclo3mnnq.model.Reservation;
import co.usa.ciclo3mnnq.ciclo3mnnq.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save(Reservation rt){
        if(rt.getIdReservation()==null){
            return reservationRepository.save(rt);
        }else{
            Optional<Reservation> rtaux=reservationRepository.getReservation(rt.getIdReservation());

            if(rtaux.isEmpty()){
                return reservationRepository.save(rt);
            }else {
                return rt;
            }
        }
    }
    public Reservation update(Reservation rt){
        if(rt.getIdReservation()!=null){
            Optional<Reservation> v= reservationRepository.getReservation(rt.getIdReservation());
            if(!v.isEmpty()){

                if(rt.getStartDate()!=null){
                    v.get().setStartDate(rt.getStartDate());
                }
                if(rt.getEndDate()!=null){
                    v.get().setEndDate(rt.getEndDate());
                }
                if(rt.getStatus()!=null){
                    v.get().setStatus(rt.getStatus());
                }
                reservationRepository.save(v.get());
                return v.get();
            }else{
                return rt;
            }
        }else{
            return rt;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean re = getReservation(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return re;
    }

}
