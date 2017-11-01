package befaster.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderPricer {

	private List<FreebieIdentifier> freebieIdentifiers;
	
	public OrderPricer(List<FreebieIdentifier> freebieIdentifiers) {
		this.freebieIdentifiers = freebieIdentifiers;
	}
	
	public int price(List<Order> orders) {
		List<Order> paidForOrders = removeFreebies(orders);
		
		return paidForOrders.stream()
				.map(it -> it.getItem().priceMany(it.getCount()))
				.reduce(0, (a,b) -> a + b);
	}

	private List<Order> removeFreebies(List<Order> orders) {
		List<Order> freebies = new ArrayList<>();
		
		for(FreebieIdentifier freebieIdentifier: freebieIdentifiers) {
			Optional<Order> freebie = freebieIdentifier.identifyAnyFreeOrder(orders);
			freebie.ifPresent(it -> freebies.add(it));
		}
		
		List<Order> reducedOrders = new ArrayList<>();
		for(Order order: orders) {
			Order reducedOrder = order;
			for(Order freebie: freebies) {
				reducedOrder = reducedOrder.removeFree(freebie);
			}
			reducedOrders.add(reducedOrder);
		}
		return reducedOrders;
	}
}
