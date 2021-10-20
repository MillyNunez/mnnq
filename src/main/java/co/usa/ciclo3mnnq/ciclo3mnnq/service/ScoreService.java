package co.usa.ciclo3mnnq.ciclo3mnnq.service;

import co.usa.ciclo3mnnq.ciclo3mnnq.model.Score;
import co.usa.ciclo3mnnq.ciclo3mnnq.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    public Score save(Score sc){
        if(sc.getId()==null){
            return scoreRepository.save(sc);
        }else{
            Optional<Score> scaux=scoreRepository.getScore(sc.getId());

            if(scaux.isEmpty()){
                return scoreRepository.save(sc);
            }else {
                return sc;
            }
        }
    }
}
