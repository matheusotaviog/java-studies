package enumeracao.aplication;

import enumeracao.entities.Order;
import enumeracao.entities.enums.OrderStatus;

import java.util.Date;

public class Program {

    public static void main(String[] args) {

        /* EXEMPLO 1 */

        Order order = new Order(120, new Date(), OrderStatus.PENDING_PAYMENT);

        System.out.println(order);

        /* EXEMPLO 2  */

        OrderStatus os1 = OrderStatus.DELIVERED;
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");

        System.out.println(os1);
        System.out.println(os2);

    }

}
