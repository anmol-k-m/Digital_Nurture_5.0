public class BuilderPatternExample {

    public static void main(String[] args) {

        Computer gamingComputer = new Computer.Builder()
                .setCPU("Intel Core i9")
                .setRAM("32 GB")
                .setStorage("1 TB SSD")
                .setGraphicsCard("NVIDIA RTX 4080")
                .setOperatingSystem("Windows 11")
                .build();

        Computer officeComputer = new Computer.Builder()
                .setCPU("Intel Core i5")
                .setRAM("16 GB")
                .setStorage("512 GB SSD")
                .setOperatingSystem("Windows 11")
                .build();

        System.out.println("Gaming Computer");
        gamingComputer.display();

        System.out.println("Office Computer");
        officeComputer.display();
    }
}