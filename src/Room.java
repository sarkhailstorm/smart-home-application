public class Room {
    private String roomName;
    private int roomID;

    public Room(String roomName, int roomID) {
        this.roomName = roomName;
        this.roomID = roomID;
    }

    public String getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomID() {
        return roomID;
    }
    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String toString() {
        return String.format("%d - %s | ", roomID + 1, roomName);
    }


}
