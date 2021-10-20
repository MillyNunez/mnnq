package co.usa.ciclo3mnnq.ciclo3mnnq.repository;

import co.usa.ciclo3mnnq.ciclo3mnnq.model.Admin;
import co.usa.ciclo3mnnq.ciclo3mnnq.model.Category;
import co.usa.ciclo3mnnq.ciclo3mnnq.repository.crud.AdminCrudRepository;
import co.usa.ciclo3mnnq.ciclo3mnnq.repository.crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCrudRepository adminCrudRepository;

    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }
    public Optional<Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }

    public Admin save(Admin a){
        return adminCrudRepository.save(a);
    }
}
