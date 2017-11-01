package befaster.solutions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GroupDiscount {
	
	public static final int GROUP_SIZE = 3;
	public static final int GROUP_PRICE = 45;
	
	public int calculateGroupDiscount(List<Order> orders) {
		Order zs = locateInOrders(orders, ItemStore.Z);
		Order ss = locateInOrders(orders, ItemStore.S);
		Order ts = locateInOrders(orders, ItemStore.T);
		Order ys = locateInOrders(orders, ItemStore.Y);
		Order xs = locateInOrders(orders, ItemStore.X);
		
		int totalToConsider = zs.getCount() + ss.getCount() + ts.getCount() + ys.getCount() + xs.getCount();
		int numberOfGroups = totalToConsider / GROUP_SIZE;
		int itemsToRemove = numberOfGroups * GROUP_SIZE;
		
		List<Order> ordersToReduce = Arrays.asList(zs, ss, ts, ys, xs);
		
		int individualItemReduction = 0;
		for(Order order: ordersToReduce) {
			Order revisedOrder = order.removeFree(new Order(order.getItem(), itemsToRemove));
			int itemsRemoved = order.getCount() - revisedOrder.getCount();
			itemsToRemove -= itemsRemoved;
			individualItemReduction += order.getItem().priceMany(itemsRemoved);
		}
		int priceOfGroups = GROUP_PRICE * numberOfGroups;
		return individualItemReduction - priceOfGroups;
	}
	
	private Order locateInOrders(List<Order> orders, Item item) {
		return orders.stream().filter(it -> it.getItem().equals(item)).findFirst().orElse(new Order(item, 0));
	}
}
