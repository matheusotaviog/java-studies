package heranca.example1.application;

import heranca.example1.entities.BusinessAccount;

public class Program {

    public static void main(String[] args) {

        BusinessAccount account = new BusinessAccount();

        System.out.println(account.getLoanLimit());

    }

}
