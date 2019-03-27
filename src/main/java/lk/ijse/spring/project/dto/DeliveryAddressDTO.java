package lk.ijse.spring.project.dto;

public class DeliveryAddressDTO {
    private String delivery_add_id;
    private String fullname;
    private String address;
    private String post_code;
    private String phone_no;
    private String email;

    public DeliveryAddressDTO() {
    }

    public DeliveryAddressDTO(String delivery_add_id, String fullname, String address, String post_code, String phone_no, String email) {
        this.delivery_add_id = delivery_add_id;
        this.fullname = fullname;
        this.address = address;
        this.post_code = post_code;
        this.phone_no = phone_no;
        this.email = email;
    }

    public String getDelivery_add_id() {
        return delivery_add_id;
    }

    public void setDelivery_add_id(String delivery_add_id) {
        this.delivery_add_id = delivery_add_id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DeliveryAddressDTO{" +
                "delivery_add_id=" + delivery_add_id +
                ", fullname='" + fullname + '\'' +
                ", address='" + address + '\'' +
                ", post_code='" + post_code + '\'' +
                ", phone_no='" + phone_no + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
