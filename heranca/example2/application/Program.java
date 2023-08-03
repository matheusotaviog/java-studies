package heranca.example2.application;

import heranca.example2.entities.Account;
import heranca.example2.entities.BusinessAccount;
import heranca.example2.entities.SavingsAccount;
import org.w3c.dom.ls.LSOutput;

public class Program {

    public static void main(String[] args) {

        Account acc = new Account(1023, "Vinicius", 0.0);
        BusinessAccount bacc = new BusinessAccount(1024, "Maria", 0.0, 500.0);

        //UPCASTING
        Account acc1 = bacc;
        Account acc2 = new BusinessAccount(1025, "Matheus", 0.0, 200.0);
        Account acc3 = new SavingsAccount(1026, "Ana", 0.0, 0.01);

        //DOWNCASTING
        BusinessAccount bacc1 = (BusinessAccount) acc2;
        //BusinessAccount bacc2 = (BusinessAccount) acc3; //Erro apenas em tempo de execução

        if (acc3 instanceof BusinessAccount) {
            BusinessAccount bacc2 = (BusinessAccount) acc3;
            bacc2.loan(100.0);
            System.out.println("Balance after loan = " + bacc2.getBalance());
        }

        if (acc3 instanceof SavingsAccount) {
            SavingsAccount sacc = (SavingsAccount) acc3;
            sacc.updateBalance();
            System.out.println("Balance after update = " + sacc.getBalance());
        }

        Account acc4 = new Account(101, "Alex", 1000.0);
        acc4.withdraw(200.0);
        System.out.println(acc4.getBalance());

        SavingsAccount sacc2 = new SavingsAccount(102, "Alex2", 1000.0, 0.01);
        sacc2.withdraw(200.0);
        System.out.println(sacc2.getBalance());

        BusinessAccount bacc5 = new BusinessAccount(104, "Ana", 1000.0, 500.0);
        bacc5.withdraw(200.0);
        System.out.println(bacc5.getBalance());


        //POLIMORFISMO

        Account x = new Account(50, "Cleber", 300.00);
        Account y = new SavingsAccount(51, "Luiza", 300.00, 0.02);

        x.withdraw(50.0);
        y.withdraw(50.0);

        System.out.println("\n POLIMORFISM: ");
        System.out.println(x.getBalance());
        System.out.println(y.getBalance());

    }

}
