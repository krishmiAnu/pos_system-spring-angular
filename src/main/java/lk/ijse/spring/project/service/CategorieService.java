package lk.ijse.spring.project.service;

import lk.ijse.spring.project.dto.CategorieDTO;

import java.util.ArrayList;

public interface CategorieService {

    public ArrayList<CategorieDTO>getAllCategories();

    public  CategorieDTO getCategorie(String categorie_id);

    public boolean deleteCategorie(String categorie_id);

    public boolean saveCategorie(CategorieDTO categorie);

    public long getTotalCategories();

}
