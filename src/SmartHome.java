public class SmartHome {
    public SmartPlug[] smartPlugs;
    public AttachedDevice[] attachedDevices;
    private Room[] rooms;
    private int plugIndex;
    private int roomIndex;
    private int deviceIndex;


    public SmartHome(int totalRooms, int totalPlugs) {
        this.smartPlugs = new SmartPlug[totalPlugs];
        this.attachedDevices = new AttachedDevice[5];
        this.rooms = new Room[totalRooms];
        this.plugIndex = 0;
        this.roomIndex = 0;
        this.deviceIndex = 0;
        addDevices();
    }

    public int getPlugSize() {
        return smartPlugs.length;
    }

    public void addPlugs(int roomID, int deviceID) {
        if (plugIndex >= smartPlugs.length) {
            return;
        }
        for (Room room : rooms) {
            if (room.getRoomID() == roomID) {
                SmartPlug plug = new SmartPlug(false, plugIndex, roomIDToString(roomID), deviceIDToString(deviceID));
                smartPlugs[plugIndex] = plug;
            }
        }
        plugIndex++;
    }

    public void addDevices() {
        String[] devices = {"Lamp", "TV", "Computer", "Phone Recharger", "Heater"};
        if (deviceIndex >= attachedDevices.length) {
            return;
        }
        for (String device : devices) {
            AttachedDevice attachedDevice = new AttachedDevice(device, deviceIndex);
            attachedDevices[deviceIndex] = attachedDevice;
            deviceIndex++;
        }
    }

    public void addRooms(String roomName) {
        if (roomIndex >= rooms.length) {
            return;
        }
        Room room = new Room(roomName, roomIndex);
        rooms[roomIndex] = room;
        roomIndex++;
    }

    public String deviceIDToString(int deviceID) {
        String deviceName = "";
        for (AttachedDevice device : attachedDevices) {
            if (deviceID == device.getDeviceID()) {
                deviceName = device.getDeviceName();
            }
        }
        return deviceName;
    }

    public String roomIDToString(int roomID) {
        String roomName = "";
        for (Room room : rooms) {
            if (roomID == room.getRoomID()) {
                roomName = room.getRoomName();
            }
        }
        return roomName;
    }


    public String displayRooms() {
        String string = "";
        for (Room room : rooms) {
            string += room.toString();
        }
        return string;
    }

    public String dashboard() {
        String string = "";
        string += "                            ---------------Dashboard---------------\n";
        for (int i = 0; i < roomIndex; i++) {
            string += "Room " + (i + 1) + "\n";
            for (SmartPlug plug : smartPlugs) {
                if (rooms[i].getRoomName() == plug.getRoom()) {
                    string += plug.toString();
                }
            }
        }
        return string;
    }

    public void switchAllPlugsOn() {
        for (SmartPlug plug : smartPlugs) {
            plug.on();
        }
    }

    public void switchAllPlugsOff() {
        for (SmartPlug plug : smartPlugs) {
            plug.off();
        }
    }

    public void switchRoomPlugOn(int roomID) {
        for (SmartPlug plug : smartPlugs) {
            if (plug.getRoom() == roomIDToString(roomID)) {
                plug.on();
            }
        }
    }

    public void switchRoomPlugOff(int roomID) {
        for (SmartPlug plug : smartPlugs) {
            if (plug.getRoom() == roomIDToString(roomID)) {
                plug.off();
            }
        }
    }

    public void toggleRoomPlug(int roomID) {
        for (SmartPlug plug : smartPlugs) {
            if (plug.getRoom() == roomIDToString(roomID)) {
                plug.toggle();
            }
        }
    }

    public String displayPlugs() {
        String string = "";
        for (SmartPlug plug : smartPlugs) {
            string += plug.toString();
        }
        return string;
    }

    public void plugOn(int plugID) {
        for (SmartPlug plug : smartPlugs) {
            if (plug.getID() == plugID) {
                plug.on();
            }
        }
    }

    public void plugOff(int plugID) {
        for (SmartPlug plug : smartPlugs) {
            if (plug.getID() == plugID) {
                plug.off();
            }
        }
    }

    public String displayDevices() {
        String string = "";
        for (AttachedDevice device : attachedDevices) {
            string += device.toString() + "\n";
        }
        return string;
    }

    public void changeDevice(int deviceID, int plugID) {
        for (SmartPlug plug : smartPlugs) {
            if (plug.getID() == plugID) {
                plug.setDevice(deviceIDToString(deviceID));
            }
        }
    }

    public void changePlugLocation(int plugID, int roomID) {
        for (SmartPlug plug : smartPlugs) {
            if (plug.getID() == plugID) {
                plug.setRoom(roomIDToString(roomID));
            }
        }
    }

    public void newSmartPlug(int roomID, int deviceID) {
        SmartPlug[] tempSmartPlugs = new SmartPlug[smartPlugs.length + 1];
        for (int i = 0; i < smartPlugs.length; i++) {
            tempSmartPlugs[i] = smartPlugs[i];
        }

        for (Room room : rooms) {
            if (room.getRoomID() == roomID) {
                SmartPlug plug = new SmartPlug(false, plugIndex, roomIDToString(roomID), deviceIDToString(deviceID));
                tempSmartPlugs[plugIndex] = plug;
            }
        }
        plugIndex++;

        smartPlugs = tempSmartPlugs;
    }

    public void newDevice(String device) {
        AttachedDevice[] tempAttachedDevices = new AttachedDevice[attachedDevices.length + 1];
        for (int i = 0; i < attachedDevices.length; i++) {
            tempAttachedDevices[i] = attachedDevices[i];
        }
        AttachedDevice attachedDevice = new AttachedDevice(device, deviceIndex);
        tempAttachedDevices[deviceIndex] = attachedDevice;
        deviceIndex++;

        attachedDevices = tempAttachedDevices;
    }

    public void newRoom(String roomName) {
        Room[] tempRooms = new Room[rooms.length + 1];
        for (int i = 0; i < rooms.length; i++) {
            tempRooms[i] = rooms[i];
        }

        Room room = new Room(roomName, roomIndex);
        tempRooms[roomIndex] = room;
        roomIndex++;

        rooms = tempRooms;
    }
}
