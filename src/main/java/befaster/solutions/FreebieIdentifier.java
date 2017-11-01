package befaster.solutions;

import java.util.List;
import java.util.Optional;

public class FreebieIdentifier {
	
	private Item matchingItem;
	private int matchingQuantity;
	private Item freeItem;
	
	public FreebieIdentifier(Item matchingItem, int matchingQuantity, Item freeItem) {
		this.matchingItem = matchingItem;
		this.matchingQuantity = matchingQuantity;
		this.freeItem = freeItem;
	}
	
	public Optional<Order> identifyAnyFreeOrder(List<Order> orders) {
		for(Order order: orders) {
			if(order.getItem().equals(matchingItem)) {
				return calculateFreeOrder(order);
			}
		}
		return Optional.empty();
	}
	
	private Optional<Order> calculateFreeOrder(Order order) {
		int quantityGroups = order.getCount() / matchingQuantity;
		if(quantityGroups > 0) {
			return Optional.of(new Order(freeItem, quantityGroups));
		} else {
			return Optional.empty();
		}
	}
}
