import java.util.Scanner;

public class BikeMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AutomatedBikeSystem bike = new AutomatedBikeSystem();

        boolean running = true;

        while (running) {
            System.out.println("""
                    
                    Please enter an option:
                    1. Power On
                    2. Accelerate
                    3. Decelerate
                    0. Power Off
                    """);

            int userChoice = sc.nextInt();

            switch (userChoice) {
                case 1 -> {
                    bike.togglePower();
                    System.out.println("Bike powered on.");
                }
                case 2 -> {
                    if (bike.isBikeOn()) {
                        bike.increaseAcceleration();
                        System.out.println("Bike acceleration ===> " + bike.getAcceleration());
                    } else {
                        System.out.println("The bike is off. Please power it on first.");
                    }
                }
                case 3 -> {
                    if (bike.isBikeOn()) {
                        bike.decreaseAcceleration();
                        System.out.println("Bike deceleration ===> " + bike.getAcceleration());
                    } else {
                        System.out.println("The bike is off. Please power it on first.");
                    }
                }
                case 0 -> {
                    if (bike.isBikeOn()) {
                        bike.togglePower(); // Turn off
                        System.out.println("Bike powered off.");
                    }
                    running = false;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
