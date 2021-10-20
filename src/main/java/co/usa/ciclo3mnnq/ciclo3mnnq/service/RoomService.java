package co.usa.ciclo3mnnq.ciclo3mnnq.service;

/**
 *
 * @author mnnq
 */
import co.usa.ciclo3mnnq.ciclo3mnnq.model.Room;
import co.usa.ciclo3mnnq.ciclo3mnnq.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAll(){
        return roomRepository.getAll();
    }
    public Optional<Room> getRoom(int id){
        return roomRepository.getRoom(id);
    }
    public Room save(Room r){
        if(r.getId()==null){
            return roomRepository.save(r);
        }else{
            Optional<Room> raux=roomRepository.getRoom(r.getId());

            if(raux.isEmpty()){
                return roomRepository.save(r);
            }else {
                return r;
            }
        }
    }
    public Room update(Room r){
        if(r.getId()!=null){
            Optional<Room> u=roomRepository.getRoom(r.getId());
            if(!u.isEmpty()){
                if(r.getName()!=null){
                    u.get().setName(r.getName());
                }
                if(r.getHotel()!=null){
                    u.get().setHotel(r.getHotel());
                }
                if(r.getStars()!=null){
                    u.get().setStars(r.getStars());
                }
                if(r.getDescription()!=null){
                    u.get().setDescription(r.getDescription());
                }
                if(r.getCategory()!=null){
                    u.get().setCategory(r.getCategory());
                }
                roomRepository.save(u.get());
                return u.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }

    public boolean deleteRoom(int roomId) {
        Boolean ro = getRoom(roomId).map(room -> {
            roomRepository.delete(room);
            return true;
        }).orElse(false);
        return ro;
    }
}
