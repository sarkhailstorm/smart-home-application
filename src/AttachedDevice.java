public class AttachedDevice {
    private String deviceName;
    private int deviceID;

    public AttachedDevice(String deviceName, int deviceID) {
        this.deviceName = deviceName;
        this.deviceID = deviceID;
    }
    public String getDeviceName() {
        return deviceName;
    }
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    public int getDeviceID() {
        return deviceID;
    }
    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    public String toString() {
        return String.format("%d - %s", deviceID + 1, deviceName);
    }
}
