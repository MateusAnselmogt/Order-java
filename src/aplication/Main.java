import entities.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() throws ParseException {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    System.out.println("-------IMPORTANT--------");
    System.out.println("Order status available:");
    for (OrderStatus status : OrderStatus.values()){
        System.out.println(status);
    }
    System.out.println();

    System.out.println(">Enter client data<");
    System.out.print("Name: ");
    String name = sc.nextLine();
    System.out.print("Email: ");
    String email = sc.nextLine();
    System.out.print("Birth date (DD/MM/YYYY): ");
    Date birthDate = sdf.parse(sc.nextLine());

    Client client = new Client(birthDate,email,name);

    System.out.println(">Enter order data<");
    System.out.print("Status: ");
    OrderStatus status = OrderStatus.valueOf(sc.nextLine().toUpperCase());
    Order order = new Order(client,status,new Date());
    System.out.print("How many items to this order: ");
    int n = sc.nextInt();

    for (int i = 1; i <= n; i++ ){
        System.out.println("->Enter #"+i+" data<- ");
        System.out.print("Product name: ");
        sc.nextLine();
        String nameP = sc.nextLine();
        System.out.print("Product price: ");
        double priceP = sc.nextDouble();
        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        Product product = new Product(nameP,priceP);

        OrderItem it = new OrderItem(quantity,priceP,product);

        order.addItem(it);

    }


    System.out.println(order);

}
