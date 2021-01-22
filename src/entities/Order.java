package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entities.enums.Order_Status;

public class Order {
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

	private Date moment;
	private Order_Status status;

	private List<OrderItem> orderItens = new ArrayList<>();
	private Client client;

	public Order() {

	}

	public Order(Date moment, Order_Status status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	// GETTERS AND SETTERS
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public Order_Status getStatus() {
		return status;
	}

	public void setStatus(Order_Status status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItens() {
		return orderItens;
	}

	// METHODS

	public void addItem(OrderItem item) {
		orderItens.add(item);
	}

	public void removeItem(OrderItem item) {
		orderItens.remove(item);
	}

	public double total() {
		double valor = 0;
		for (OrderItem orderItem : orderItens) {
			valor += orderItem.subTotal();
		}
		return valor;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdf1.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client + "\n");
		sb.append("Order Itens: \n");
		for (OrderItem orderItem : orderItens) {
			sb.append(orderItem + "\n");
		}
		sb.append("Total price: ");
		sb.append(String.format("%.2f", total()));

		return sb.toString();
	}

}
