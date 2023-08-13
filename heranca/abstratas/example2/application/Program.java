package heranca.abstratas.example2.application;

import heranca.abstratas.example2.entities.Circle;
import heranca.abstratas.example2.entities.Rectangle;
import heranca.abstratas.example2.entities.Shape;
import heranca.abstratas.example2.entities.enums.Color;

import java.util.*;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Shape> shapeList = new ArrayList<>();

        System.out.print("Enter the number of shapes: ");
        int shapes = sc.nextInt();

        for (int i=1; i <= shapes; i++) {
            System.out.println("SHAPE #" + i + " DATA: ");
            System.out.print("Rectangle or Circle (r/c): ");
            char form = sc.next().charAt(0);
            System.out.print("Color (BLACK/BLUE/RED): ");
            Color color = Color.valueOf(sc.next());

            if (form == 'r') {
                System.out.print("Width: ");
                double width = sc.nextDouble();
                System.out.print("Height: ");
                double height = sc.nextDouble();
                shapeList.add(new Rectangle(color, width, height));

            } else if (form == 'c') {
                System.out.print("Radius: ");
                double radius = sc.nextDouble();
                shapeList.add(new Circle(color, radius));
            }
        }

        System.out.println("\n SHAPE AREAS: ");
        for (Shape s : shapeList) {
            System.out.format("\n%.2f", s.area());
        }

        sc.close();
    }

}
