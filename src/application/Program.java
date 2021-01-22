package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.Order_Status;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter client data");
		System.out.print("Name:");
		String name = sc.nextLine();
		System.out.print("Email");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY)");
		Date birthDate = sdf.parse(sc.next());

		Client client = new Client(name, email, birthDate);

		System.out.println("Enter order data:");
		System.out.print("Status");
		Order_Status status = Order_Status.valueOf(sc.next());
		Order order = new Order(new Date(), status, client);

		System.out.print("How many items to this order?");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter #" + i + ":");
			System.out.print("Product name: ");
			sc.nextLine();
			String nameProduct = sc.nextLine();
			System.out.print("Product price: ");
			double priceProduct = sc.nextDouble();
			Product product = new Product(nameProduct, priceProduct);

			System.out.print("Quantity: ");
			int quantityProduct = sc.nextInt();
			OrderItem orderitem = new OrderItem(quantityProduct, priceProduct, product);
			order.addItem(orderitem);

		}
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.print(order);
		

		sc.close();

	}

}
