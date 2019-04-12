package vn.poly.hailt.assignmentfinal;

public class Room {

    private String roomId;
    private String roomNumber;
    private int floor;
    private String hotelId;
    private boolean singleRoom;
    private int price;
    private int status;
    private String image;
    private String detail;

    public Room(String roomId, String roomNumber, int floor, String hotelId, boolean singleRoom, int price, int status, String image, String detail) {
        this.roomId = roomId;
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.hotelId = hotelId;
        this.singleRoom = singleRoom;
        this.price = price;
        this.status = status;
        this.image = image;
        this.detail = detail;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public boolean isSingleRoom() {
        return singleRoom;
    }

    public void setSingleRoom(boolean singleRoom) {
        this.singleRoom = singleRoom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
