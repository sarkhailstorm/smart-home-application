public class Dashboard {
    public static void main(String[] args) {
        ConsoleHelper console = new ConsoleHelper();

        console.breakLine();
        console.print("                        ----------------SMART HOME CONSOLE DASHBOARD----------------");
        console.breakLine();

        int totalRooms = console.getInt("How many rooms are there in this property?");
        int totalPlugs = console.getInt("How many plugs do you want to place in this property?");

        SmartHome home = new SmartHome(totalRooms, totalPlugs);

        console.attachServerObject(home);

        console.populateRooms(totalRooms);

        console.populatePlugs();

        console.displayDashboard();

        boolean isMenuActive = true;
        while (isMenuActive) {
            console.menuOptions();
            int option = console.getInt("");
            switch (option) {
                case 1:
                    console.houseLevelOptions();
                    console.displayDashboard();
                    break;
                case 2:
                    console.roomLevelOptions();
                    console.displayDashboard();
                    break;
                case 3:
                    console.plugLevelOptions();
                    console.displayDashboard();
                    break;
                case 4:
                    console.systemLevelOptions();
                    break;
                case 5:
                    isMenuActive = false;
                    break;
            }
        }
    }
}