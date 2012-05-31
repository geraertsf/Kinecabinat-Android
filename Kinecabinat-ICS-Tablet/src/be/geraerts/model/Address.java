package be.geraerts.model;

/**
 * @author François Geraerts
 *         <p/>
 *         Date: 31/05/12
 *         Time: 10:16
 */
public class Address {

    private long addressId;
    private String street;
    private int number;
    private String box;
    private int postCode;
    private String city;
    private String country;

    public Address(long addressId, String street, int number, String box, int postCode, String city, String country) {
        this.addressId = addressId;
        this.street = street;
        this.number = number;
        this.box = box;
        this.postCode = postCode;
        this.city = city;
        this.country = country;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
