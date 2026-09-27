package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Client client;

    private List<OrderItem> items = new ArrayList<OrderItem>();

    public Order() {
    }

    public Order(Client client, OrderStatus status, Date moment) {
        this.client = client;
        this.status = status;
        this.moment = moment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public double total(){
        double sum = 0;
        for (OrderItem it : items){
            sum += it.subTotal();
        }
        return sum;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(">ORDER SUMMARY<\n ");
        sb.append("Order moment: ");
        sb.append(sdf.format(moment)+"\n");
        sb.append("Order Status: ");
        sb.append(status+ "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("\n");
        sb.append(">Order items< \n");
        for (OrderItem item : items){
            sb.append(item + "\n");
        }
        sb.append("Total price: $");
        sb.append(String.format("%.2f",total()));
        return sb.toString();


    }
}
