import java.util.Scanner;

public class ConsoleHelper {
    private SmartHome home;

    public int getInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int integer;
        output(prompt);
        try {
            integer = scanner.nextInt();
        } catch (Exception e) {
            return getInt(prompt);
        }
        return integer;
    }

    public String getString(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String string;
        output(prompt);
        try {
            string = scanner.nextLine();
        } catch (Exception e) {
            return getString(prompt);
        }
        return string;
    }

    public void output(String prompt) {
        print(prompt);
    }

    public void breakLine() {
        System.out.println();
    }

    public void print(String prompt) {
        System.out.println(prompt);
    }

    public void attachServerObject(SmartHome home) {
        this.home = home;
    }

    public void getDeviceList() {
        print("""
                AVAILABLE DEVICE LIST OPTIONS
                These are standard devices that can be attached to
                the smart plug:
                1-Lamp
                2-TV
                3-Computer
                4-Phone Recharger
                5-Heater""");
    }

    public void populateRooms(int totalRooms) {
        String[] roomNumbers = {"first", "second", "third", "fourth"};
        for (int i = 0; i < totalRooms; i++) {
            String roomName = getString("Please provide a name for your " + roomNumbers[i] + " room: ");
            home.addRooms(roomName);
        }
    }

    public void populatePlugs() {
        for (int i = 0; i < home.getPlugSize(); i++) {
            breakLine();
            print("ENTER PLUG INFORMATION BELOW");
            breakLine();

            print("ROOMS AVAILABLE: " + home.displayRooms());
            breakLine();

            int roomID = getInt("Using the above list, please select the room for this\n" +
                    "plug (integer only)") - 1;
            breakLine();
            getDeviceList();
            int deviceID = getInt("Using the above list, please select the device to attach\n" +
                    "to the smart plug (integer only)") - 1;

            home.addPlugs(roomID, deviceID);
        }
    }

    public void displayDashboard() {
        output(home.dashboard());
    }

    public void menuOptions() {
        System.out.println("""
                                            -------------MENU OPTIONS-------------
                                            ----------Please select option--------
                1 - House Level Options
                2 - Room Level Options
                3 - Plug Level Options
                4 - System Options
                5 - Quit Application
                """);
    }

    public void houseLevelOptions() {
        System.out.println("""
                HOUSE LEVEL OPTIONS
                1 - Switch all plugs off
                2 - Switch all plugs on
                3 - Back to main menu""");

        int houseLevelOption = getInt("");
        switch (houseLevelOption) {
            case 1:
                home.switchAllPlugsOff();
                break;
            case 2:
                home.switchAllPlugsOn();
                break;
            case 3:
                break;
        }
    }

    public void roomLevelOptions() {
        print("ROOMS AVAILABLE: " + home.displayRooms());
        breakLine();
        int roomID = getInt("Please select room (Integer only)") - 1;

        System.out.println("""
                ROOM LEVEL OPTIONS
                1 - Switch all plugs off in room
                2 - Switch all plugs on in room
                3 - Select a plug in the room and toggle its on/off status
                4 - Back to main menu""");

        int roomLevelOption = getInt("Select an option");

        switch (roomLevelOption) {
            case 1:
                home.switchRoomPlugOff(roomID);
                break;
            case 2:
                home.switchRoomPlugOn(roomID);
                break;
            case 3:
                home.toggleRoomPlug(roomID);
                break;
            case 4:
                break;
        }
    }

    public void plugLevelOptions() {
        System.out.println("""
                PLUG LEVEL OPTIONS
                1 - Switch plug off
                2 - Switch plug on
                3 - Change attached device
                4 - Move plug to different room
                5 - Back to main menu""");

        int plugLevelOption = getInt("Select an option");

        print( "\n" + home.displayPlugs());

        switch (plugLevelOption) {
            case 1:
                switchPlugOff();
                break;
            case 2:
                switchPlugOn();
                break;
            case 3:
                changeAttachedDevice();
                break;
            case 4:
                changePlugRoom();
                break;
            case 5:
                break;
        }
    }

    public void switchPlugOff() {
        int plugID = getInt("Please select a plug  (Integer only)") - 1;
        home.plugOff(plugID);
    }

    public void switchPlugOn() {
        int plugID = getInt("Please select a plug  (Integer only)") - 1;
        home.plugOn(plugID);
    }

    public void changeAttachedDevice() {
        int plugID = getInt("Enter the plug ID (Integer only)") - 1;
        print("AVAILABLE DEVICE LIST OPTIONS\nSelect a new device to attach to the smart plug\n");
        print(home.displayDevices());
        int deviceID = getInt("Enter device to attach to smart plug (Integer only)") - 1;
        home.changeDevice(deviceID, plugID);
    }

    public void changePlugRoom() {
        int plugID = getInt("Enter the plug ID (Integer only)") - 1;
        print("ROOMS AVAILABLE: " + home.displayRooms());
        breakLine();
        int roomID = getInt("Please select room for device from list (integer only)") - 1;
        home.changePlugLocation(plugID, roomID);
    }

    public void systemLevelOptions() {
        System.out.println("""
                SYSTEM LEVEL OPTIONS
                1 - Add new smart plug
                2 - Add new device
                3 - Add new room
                4 - Back to main menu""");

        int systemLevelOption = getInt("Select an option");

        switch (systemLevelOption) {
            case 1:
                addNewSmartPlug();
                displayDashboard();
                break;
            case 2:
                addNewDevice();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                break;
        }
    }

    public void addNewSmartPlug() {
        print("ROOMS AVAILABLE: " + home.displayRooms());
        breakLine();
        int roomID = getInt("Please select room (Integer only)") - 1;

        breakLine();

        print("AVAILABLE DEVICE LIST OPTIONS\nSelect a new device to attach to the smart plug\n");
        print(home.displayDevices());

        int deviceID = getInt("Using the above list, please select the device to attach\n" +
                "to the smart plug (integer only)") - 1;

        home.newSmartPlug(roomID, deviceID);
        home.dashboard();
    }

    public void addNewDevice() {
        String newDevice = getString("Please enter a new device");
        home.newDevice(newDevice);
        print("\nUPDATED DEVICE LIST OPTIONS");
        print(home.displayDevices());
    }

    public void addNewRoom() {
        String room = getString("Please enter a new room");
        home.newRoom(room);
        print("\nROOMS AVAILABLE (UPDATED): " + home.displayRooms() + "\n");
    }
}

