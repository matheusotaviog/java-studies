package composicao.ex1.application;

import composicao.ex1.entities.Departament;
import composicao.ex1.entities.HourContract;
import composicao.ex1.entities.Worker;
import composicao.ex1.entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

   public static void main(String[] args) throws ParseException {

      Locale.setDefault(Locale.US);
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      Scanner sc = new Scanner(System.in);

      System.out.print("Enter department's name: ");
      String departamentName = sc.nextLine();

      System.out.println("Enter worker data:");
      System.out.print("Name: ");
      String workerName = sc.nextLine();
      System.out.print("Level: ");
      String workerLevel = sc.nextLine();
      System.out.print("Base Salary: ");
      Double workerBaseSalary = sc.nextDouble();
      Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Departament(departamentName));

      System.out.print("How many contracts to this worker? ");
      int x = sc.nextInt();

      for (int i=1; i<=x; i++) {
         System.out.println("#" + i + " contract data: ");
         System.out.print("Date (DD/MM/YYYY): ");
         Date dateContract = sdf.parse(sc.next());
         System.out.print("Value per hour: ");
         double valueHourContract = sc.nextDouble();
         System.out.print("Hours: ");
         int hoursContract = sc.nextInt();

         HourContract contract = new HourContract(dateContract, valueHourContract, hoursContract);
         worker.addContract(contract);
      }

      System.out.println(" ");
      System.out.print("Enter month and year to calculate income (MM/YYYY): ");
      String calcIncome = sc.next();
      int month = Integer.parseInt(calcIncome.substring(0,2));
      int year = Integer.parseInt(calcIncome.substring(3));

      System.out.println("Name: " + worker.getName());
      System.out.println("Name: " + worker.getDepartament().getName());
      System.out.println("Income for " + calcIncome + ": " + String.format("%.2f", worker.income(year, month)));

      sc.close();

   }

}
