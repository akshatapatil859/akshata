import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Ask for the radius of the circle
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();

        // Calculate the area
        double area = Math.PI * radius * radius;

        // Display the area
        System.out.println("The area of the circle is: " + area);

        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
