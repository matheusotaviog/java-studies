package heranca.abstratas.example3.application;

import heranca.abstratas.example3.entities.FisicalPerson;
import heranca.abstratas.example3.entities.LegalPerson;
import heranca.abstratas.example3.entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Person> personList = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int numPayers = sc.nextInt();

        for(int i=1; i <= numPayers; i++) {
            System.out.println("TAX PAYER " + i + " DATA: ");
            System.out.print("Individual or Company (i/c)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Annual Income: ");
            Double annualIncome = sc.nextDouble();
            if(ch == 'i') {
                System.out.print("Health Expenditures: ");
                Double healthExpenses = sc.nextDouble();

                personList.add(new FisicalPerson(name, annualIncome, healthExpenses));
            } else if(ch == 'c') {
                System.out.print("Number of employees: ");
                Integer numberEmployees = sc.nextInt();

                personList.add(new LegalPerson(name, annualIncome, numberEmployees));
            }
        }

        System.out.println("\n TAXES PAID: ");
        Double total = 0.0;
        for(Person p : personList) {
            System.out.println(p.getName() + ": $" + String.format("%.2f",p.tax()));
            total += p.tax();
        }

        System.out.println("\nTOTAL TAXES: $" + String.format("%.2f", total));
        sc.close();
    }

}
