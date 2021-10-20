package co.usa.ciclo3mnnq.ciclo3mnnq.service;

/**
 *
 * @author mnnq
 */
import co.usa.ciclo3mnnq.ciclo3mnnq.model.Category;
import co.usa.ciclo3mnnq.ciclo3mnnq.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category c){
        if(c.getId()==null){
            return categoryRepository.save(c);
        }else{
            Optional<Category> caux=categoryRepository.getCategory(c.getId());

            if(caux.isEmpty()){
                return categoryRepository.save(c);
            }else{
                return c;
            }
        }
    }

    public Category update(Category c){
        if(c.getId()!=null){
            Optional<Category>y=categoryRepository.getCategory(c.getId());
            if(!y.isEmpty()){
                if(c.getName()!=null){
                    y.get().setName(c.getName());
                }
                if(c.getDescription()!=null){
                    y.get().setDescription(c.getDescription());
                }
                return categoryRepository.save(y.get());
            }
        }
        return c;
    }
    public boolean deleteCategory(int categoryId){
        Boolean ca=getCategory(categoryId).map(category ->
        {
            categoryRepository.delete(category);
            return true;
        }
        ).orElse(false);
        return ca;
    }
    }
