package lk.ijse.spring.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Categorie {

    @Id
    private String categorie_id;
    private String description;
//    private Byte image;

    public Categorie() {
    }

    public Categorie(String categorie_id, String description) {
        this.categorie_id = categorie_id;
        this.description = description;
//        this.image = image;
    }

    public String getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(String categorie_id) {
        this.categorie_id = categorie_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Byte getImage() {
//        return image;
//    }
//
//    public void setImage(Byte image) {
//        this.image = image;
//    }

    @Override
    public String toString() {
        return "Categorie{" +
                "categorie_id='" + categorie_id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
