package lk.ijse.spring.project.service.impl;

import lk.ijse.spring.project.dto.CategorieDTO;
import lk.ijse.spring.project.dto.ProductDTO;
import lk.ijse.spring.project.entity.Product;
import lk.ijse.spring.project.repository.CategorieRepository;
import lk.ijse.spring.project.repository.ProductRepository;
import lk.ijse.spring.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductServiceImpl implements ProductService{

    private String file;

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public ArrayList<ProductDTO> getAllProducts() {
//        List<Product>products = repository.findAll();
//        ArrayList<ProductDTO>alProducts = new ArrayList<>();
//
//        for(Product product:products){
//            ProductDTO productDTO = new ProductDTO(product.getCategorie(),product.getProduct_id(),product.getProduct_name(),product.getDescription(),product.getProduct_image(),product.getColor(),product.getSize(),product.getQuantity(),product.getUnitPrice());
//                alProducts.add(productDTO);
//        }
//        return alProducts;
        List<Product> products = repository.findAll();

        ArrayList<ProductDTO> alProducts = new ArrayList<>();
        for (Product product: products) {
                ProductDTO productDTO = new ProductDTO(
                        product.getProduct_id(),
                        product.getProduct_name(),
                        product.getDescription(),
                        product.getProduct_image(),
                        product.getQuantity(),
                        product.getUnitPrice(),
                    new CategorieDTO(
                            product.getCategorie().getCategorie_id(),
                            product.getCategorie().getDescription()));
            alProducts.add(productDTO);
        }
        return alProducts;
    }

    @Override
    public ProductDTO getProduct(String product_id) {
        Product product = repository.findById(product_id).get();
        ProductDTO productDTO = new ProductDTO(
                product.getProduct_id(),
                product.getProduct_name(),
                product.getDescription(),
                product.getProduct_image(),
                product.getQuantity(),
                product.getUnitPrice(),
                new CategorieDTO(
                        product.getCategorie().getCategorie_id(),
                        product.getCategorie().getDescription()));
        return productDTO;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean deleteProduct(String product_id) {
        repository.deleteById(product_id);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveProduct(ProductDTO dto) {
        Product product = new Product(dto.getProduct_id(),dto.getProduct_name(),dto.getDescription(),dto.getProduct_image(),dto.getQuantity(),dto.getUnitPrice(),categorieRepository.findById(dto.getCategorieDTO().getCategorie_id()).get());
        repository.save(product);
        return true;
    }

    @Override
    public String uploadFile(MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        if (!file.getOriginalFilename().isEmpty()) {
            BufferedOutputStream outputStream = null;
            try {
                outputStream = new BufferedOutputStream(
                        new FileOutputStream(
                        new File("C:/Users/Krishanthi/Documents/3rd Semester Project/New folder/springshoppingproject/FrontEnd/src/assets/uploadImage", file.getOriginalFilename())));
                String path = "http://localhost:8080/api/v1/file/files?files=C:/Users/Krishanthi/Documents/3rd Semester Project/New folder/springshoppingproject/FrontEnd/src/assets/uploadImage/" + file.getOriginalFilename();
                System.out.println(path);
                outputStream.write(file.getBytes());
                outputStream.flush();
                outputStream.close();
                return "C:/Users/Krishanthi/Documents/3rd Semester Project/New folder/springshoppingproject/FrontEnd/src/assets/uploadImage/" + file.getOriginalFilename();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public ResponseEntity<InputStreamResource> getImage(String path) {
        String FILE_PATH=path;
        File file = new File(FILE_PATH);
        InputStreamResource resource = null;
        try {
            resource = new InputStreamResource(new FileInputStream(file));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename=" + file.getName())
                .contentType(MediaType.APPLICATION_PDF).contentLength(file.length())
                .body(resource);


    }

    @Override
    public long getTotalProducts() {
        return repository.getTotalProducts();
    }
}
