package composicao.ex2.entities;

import composicao.ex2.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat sdfHour = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    private Date moment;
    private OrderStatus status;
    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order() {

    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public Double total() {
        double sum = 0;
        for (OrderItem i : items) {
            sum += i.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ").append(sdfHour.format(moment));
        sb.append("\nOrder status: ").append(status);
        sb.append("\nClient: ").append(client.getName())
                .append(" (").append(sdf.format(client.getBirthDate())).append(") - ");
        sb.append(client.getEmail());
        sb.append("\nOrder Items: ");
        for(OrderItem i : items) {
            sb.append("\n");
            sb.append(i.getProduct().getName()).append(", $").append(i.getProduct().getPrice()).append(", ");
            sb.append("Quantity: ").append(i.getQuantity());
            sb.append(", Subtotal: $").append(i.subTotal());
        }
        sb.append("\n Total Price; $").append(total());

        return sb.toString();
    }
}
