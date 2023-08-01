package heranca.example2.application;

import heranca.example2.entities.Account;
import heranca.example2.entities.BusinessAccount;
import heranca.example2.entities.SavingsAccount;

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

    }

}
