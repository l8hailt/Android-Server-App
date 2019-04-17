package vn.poly.hailt.assignmentfinal;

public class Hotel {

    private String hotelId;
    private String name;
    private String city;
    private String address;
    private String owner;
    private long licenseNumber;
    private int totalFloor;
    private String image;

    public Hotel(String hotelId, String name, String city, String address, String owner, long licenseNumber, int totalFloor, String image) {
        this.hotelId = hotelId;
        this.name = name;
        this.city = city;
        this.address = address;
        this.owner = owner;
        this.licenseNumber = licenseNumber;
        this.totalFloor = totalFloor;
        this.image = image;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public int getTotalFloor() {
        return totalFloor;
    }

    public void setTotalFloor(int totalFloor) {
        this.totalFloor = totalFloor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
