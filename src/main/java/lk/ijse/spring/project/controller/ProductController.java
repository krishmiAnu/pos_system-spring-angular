package lk.ijse.spring.project.controller;

import lk.ijse.spring.project.dto.ProductDTO;
import lk.ijse.spring.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ProductDTO>getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO getProduct(@PathVariable("id")String product_id){
        return service.getProduct(product_id);
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteProduct(@PathVariable("id")String product_id){
        return service.deleteProduct(product_id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveProduct(@RequestBody ProductDTO product){
//        return service.saveProduct(product);
        return service.saveProduct(product);
    }

    @GetMapping(value = "/count",produces = MediaType.APPLICATION_JSON_VALUE)
    public long getProductCount(){
        return service.getTotalProducts();
    }

    @PostMapping(value = "/file")
    public List<String> postImage(@RequestParam("file")MultipartFile file){
        System.out.println("uploadFile>file:"+file);
        List<String>urls= new ArrayList<>();
         urls.add(service.uploadFile(file));
         return urls;
    }
}
