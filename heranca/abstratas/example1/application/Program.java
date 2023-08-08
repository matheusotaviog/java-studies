package heranca.abstratas.example1.application;

import heranca.abstratas.example1.entities.Account;
import heranca.abstratas.example1.entities.BusinessAccount;
import heranca.abstratas.example1.entities.SavingsAccount;


import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        List<Account> list = new ArrayList<>();

        //Account acc1 = new Account(101, "Cleber", 2000.00); //Não permitido, pois classe abstrata
        Account Bacc1 = new BusinessAccount(103, "Matheus", 2000.00, 500.00);

        list.add(Bacc1);
        list.add(new SavingsAccount(102, "Maria", 2000.00, 0.01));
        list.add(new BusinessAccount(104, "Maria", 3000.00, 100.00));
        list.add(new SavingsAccount(105, "Ana", 1000.00, 0.08));

        double total = 0.0;
        for (Account c : list) {
            total += c.getBalance();
        }
        System.out.printf("%.2f%n", total);

        for (Account c : list) {
            c.deposit(10.0);
            System.out.println("("+ c.getNumber() + ")" + c.getHolder() + " $" + String.format("%.2f", c.getBalance()));
        }

    }

}

