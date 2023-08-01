package composicao.ex2.application;

import composicao.ex2.entities.Client;
import composicao.ex2.entities.Order;
import composicao.ex2.entities.OrderItem;
import composicao.ex2.entities.Product;
import composicao.ex2.entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println(new Date() + " " + sdf.format(new Date()));

        Scanner sc = new Scanner(System.in);

        System.out.println("ENTER CLIENT DATA:");
        System.out.print("Name: ");
        String clientName = sc.next();
        System.out.print("Email: ");
        String clientEmail = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date clientBirth = sdf.parse(sc.next());
        Client client = new Client(clientName, clientEmail, clientBirth);

        System.out.println("\nENTER ORDER DATA:");
        System.out.print("Status: ");
        OrderStatus statusOrder = OrderStatus.valueOf(sc.next());
        System.out.print("How many items to this order? ");
        Integer quantOrder = sc.nextInt();

        Order order = new Order(new Date(), statusOrder, client);

        for (int i = 1; i <= quantOrder; i++) {
            System.out.println("\nENTER #"+ i +" ITEM DATA:");
            System.out.print("Product Name: ");
            String prodName = sc.next();
            System.out.print("Product Price: ");
            Double prodPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            Integer prodQuant = sc.nextInt();

            OrderItem orderItem = new OrderItem(prodQuant, prodPrice, new Product(prodName, prodPrice));
            order.addItem(orderItem);
        }

        System.out.println("\nORDER SUMARY");
        System.out.println(order);

        sc.close();
    }

}
