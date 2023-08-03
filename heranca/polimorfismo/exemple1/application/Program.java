package heranca.polimorfismo.exemple1.application;

import heranca.polimorfismo.exemple1.entities.Employee;
import heranca.polimorfismo.exemple1.entities.OutsourcedEmployee;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employeeList = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int x = sc.nextInt();

        for(int i=1; i <= x; i++) {
            System.out.println("\nEMPLOYEE #" + i + " DATA:");
            System.out.print("Outsourced (y/n)? ");
            char outsourced = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Hours: ");
            Integer hours = sc.nextInt();
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();

            if (outsourced == 'y') {
                System.out.print("Value per hour: ");
                Double additional = sc.nextDouble();

                Employee employee = new OutsourcedEmployee(name, hours, valuePerHour, additional);
                employeeList.add(employee);

            } else if (outsourced == 'n') {

                Employee employee = new Employee(name, hours, valuePerHour);
                employeeList.add(employee);
            }
        }

        System.out.println("\nPAYMENTS: ");
        for(Employee e : employeeList) {
            System.out.println(e.toString());
        }

        sc.close();
    }

}
