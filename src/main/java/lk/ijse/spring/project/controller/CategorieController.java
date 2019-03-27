package lk.ijse.spring.project.controller;

import lk.ijse.spring.project.dto.CategorieDTO;
import lk.ijse.spring.project.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/categories")
public class CategorieController {

    @Autowired
    private CategorieService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CategorieDTO>getAllCategories(){
        return service.getAllCategories();
    }
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public CategorieDTO getCategorie(@PathVariable("id")String categorie_id){
        return service.getCategorie(categorie_id);
    }
    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteCategorie(@PathVariable("id")String categorie_id){
        return service.deleteCategorie(categorie_id);
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveCategorie(@RequestBody CategorieDTO categorie){
        return service.saveCategorie(categorie);
    }
    @GetMapping(value = "/count",produces = MediaType.APPLICATION_JSON_VALUE)
    public long getCategorieCount(){
        return service.getTotalCategories();
    }
}
