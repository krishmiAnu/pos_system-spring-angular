package lk.ijse.spring.project.service;

import lk.ijse.spring.project.dto.ProductDTO;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface ProductService {

    public ArrayList<ProductDTO>getAllProducts();

    public ProductDTO getProduct(String product_id);

    public boolean deleteProduct(String product_id);

    public boolean saveProduct(ProductDTO product);

    public String uploadFile(MultipartFile file);

    public ResponseEntity<InputStreamResource> getImage(String path);

    public long getTotalProducts();

}
