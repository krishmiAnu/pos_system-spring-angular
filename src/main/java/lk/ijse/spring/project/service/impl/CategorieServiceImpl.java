package lk.ijse.spring.project.service.impl;

import lk.ijse.spring.project.dto.CategorieDTO;
import lk.ijse.spring.project.entity.Categorie;
import lk.ijse.spring.project.repository.CategorieRepository;
import lk.ijse.spring.project.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class CategorieServiceImpl implements CategorieService{

   @Autowired
    private CategorieRepository repository;

    @Override
    public ArrayList<CategorieDTO> getAllCategories() {
        List<Categorie>categories = repository.findAll();
        ArrayList<CategorieDTO>alCategories = new ArrayList<>();
        for (Categorie categorie:categories){
            CategorieDTO categorieDTO = new CategorieDTO(categorie.getCategorie_id(),categorie.getDescription());
            alCategories.add(categorieDTO);
        }
        return alCategories;
    }

    @Override
    public CategorieDTO getCategorie(String categorie_id) {
        Categorie categorie = repository.findById(categorie_id).get();
        CategorieDTO categorieDTO = new CategorieDTO(categorie.getCategorie_id(),categorie.getDescription());
        return categorieDTO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteCategorie(String categorie_id) {
        repository.deleteById(categorie_id);
        return true;
    }

    @Override
    public boolean saveCategorie(CategorieDTO dto) {
        Categorie categorie = new Categorie(dto.getCategorie_id(),dto.getDescription());
        repository.save(categorie);
        return true;
    }

    @Override
    public long getTotalCategories() {
        return repository.getTotalCategories();
    }
}
