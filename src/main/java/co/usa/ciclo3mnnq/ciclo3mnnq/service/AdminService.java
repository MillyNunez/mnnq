package co.usa.ciclo3mnnq.ciclo3mnnq.service;

import co.usa.ciclo3mnnq.ciclo3mnnq.model.Admin;
import co.usa.ciclo3mnnq.ciclo3mnnq.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin a){
        if(a.getId()==null){
            return adminRepository.save(a);
        }else{
            Optional<Admin> aaux=adminRepository.getAdmin(a.getId());

            if(aaux.isEmpty()){
                return adminRepository.save(a);
            }else{
                return a;
            }
        }
    }
    public Admin update(Admin a){
        if(a.getId()!=null){
            Optional<Admin>z=adminRepository.getAdmin(a.getId());
            if(!z.isEmpty()){
                if(a.getName()!=null){
                    z.get().setName(a.getName());
                }
                if(a.getEmail()!=null){
                    z.get().setEmail(a.getEmail());
                }
                if(a.getPassword()!=null){
                    z.get().setPassword(a.getPassword());
                }
                return adminRepository.save(z.get());
            }
        }
        return a;
    }

}
