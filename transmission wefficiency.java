import java.util.Scanner;

public class TransmissionEfficiency {

    // Calculate transmission efficiency
    public static double calculateEfficiency(
            double sendingPower,
            double receivingPower) {

        return (receivingPower / sendingPower) * 100;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("    TRANSMISSION EFFICIENCY CALCULATOR");
        System.out.println("==========================================");

        try {
            System.out.print("Enter sending-end power (kW): ");
            double sendingPower = scanner.nextDouble();

            System.out.print("Enter receiving-end power (kW): ");
            double receivingPower = scanner.nextDouble();

            if (sendingPower <= 0) {
                System.out.println("Error: Sending-end power must be greater than zero.");
                return;
            }

            if (receivingPower < 0) {
                System.out.println("Error: Receiving-end power cannot be negative.");
                return;
            }

            if (receivingPower > sendingPower) {
                System.out.println(
                    "Warning: Receiving-end power is greater than " +
                    "sending-end power."
                );
            }

            double losses = sendingPower - receivingPower;
            double efficiency = calculateEfficiency(
                    sendingPower,
                    receivingPower
            );

            System.out.println("\n------------- RESULTS -------------");
            System.out.printf(
                "Sending-end Power   : %.2f kW%n",
                sendingPower
            );

            System.out.printf(
                "Receiving-end Power : %.2f kW%n",
                receivingPower
            );

            System.out.printf(
                "Transmission Loss   : %.2f kW%n",
                losses
            );

            System.out.printf(
                "Transmission Efficiency : %.2f %% %n",
                efficiency
            );

            System.out.println("-----------------------------------");

        } catch (Exception e) {
            System.out.println("Error: Please enter valid numerical values.");
        } finally {
            scanner.close();
        }
    }
}
