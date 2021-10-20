package co.usa.ciclo3mnnq.ciclo3mnnq.repository;

/**
 *
 * @author mnnq
 */
import co.usa.ciclo3mnnq.ciclo3mnnq.model.Room;
import co.usa.ciclo3mnnq.ciclo3mnnq.repository.crud.RoomCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoomRepository {

    @Autowired
    private RoomCrudRepository roomCrudRepository;

    public List<Room> getAll(){
        return (List<Room>) roomCrudRepository.findAll();
    }
    public Optional<Room> getRoom(int id){
        return roomCrudRepository.findById(id);
    }

    public Room save(Room r){
        return roomCrudRepository.save(r);
    }
    public void delete(Room r){
        roomCrudRepository.delete(r);
    }
}
