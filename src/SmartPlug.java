public class SmartPlug {
    private boolean status;
    private int plugID;
    private String room;
    private String device;

    public SmartPlug(boolean status, int plugID, String room, String device) {
        this.status = status;
        this.room = room;
        this.device = device;
        this.plugID = plugID;
    }

    public boolean getStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getID() {
        return plugID;
    }
    public void setID(int ID) {
        this.plugID = ID;
    }

    public String getRoom() {
        return room;
    }
    public void setRoom(String room) {
        this.room = room;
    }

    public String getDevice() {
        return device;
    }
    public void setDevice(String device) {
        this.device = device;
    }

    public void off() {
        setStatus(false);
    }
    public void on() {
        setStatus(true);
    }

    public void toggle() {
        setStatus(!status);
    }

    public String booleanToString(boolean status) {
        if (status) {
            return "On";
        }
        return "Off";
    }

    public String toString() {
        return String.format("SmartPlug | attached to: %-30s | room: %s | ID: %d | status: %s\n",
                device, room, plugID + 1, booleanToString(status));
    }
}
