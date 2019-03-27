package lk.ijse.spring.project.dto;

public class FavoriteDTO {
    private int favorite_id;
    private String product_name;
    private String cust_id;
    private int favorite;

    public FavoriteDTO() {
    }

    public FavoriteDTO(int favorite_id, String product_name, String cust_id, int favorite) {
        this.favorite_id = favorite_id;
        this.product_name = product_name;
        this.cust_id = cust_id;
        this.favorite = favorite;
    }

    public int getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(int favorite_id) {
        this.favorite_id = favorite_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return "FavoriteDTO{" +
                "favorite_id=" + favorite_id +
                ", product_name='" + product_name + '\'' +
                ", cust_id=" + cust_id +
                ", favorite=" + favorite +
                '}';
    }
}
