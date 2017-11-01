package befaster.solutions;

import java.util.List;

public class OrderPricer {

	public int price(List<Order> orders) {
		return orders.stream()
				.map(it -> it.getItem().priceMany(it.getCount()))
				.reduce(0, (a,b) -> a + b);
	}

}
