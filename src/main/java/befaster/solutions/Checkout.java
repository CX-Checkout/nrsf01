package befaster.solutions;

import java.util.ArrayList;
import java.util.List;

public class Checkout {
	
	private ItemStore itemStore = new ItemStore();
	private SkuReader skuReader = new SkuReader(itemStore);
	private OrderPricer orderPricer = new OrderPricer(ItemStore.FREEBIES);
	
	public static Integer checkout(String skus) {
		Checkout checkout = new Checkout();
		return checkout.checkoutItems(skus);
	}
	
	private Integer checkoutItems(String skus) {
		List<Order> orders = new ArrayList<>();
		try {
			 orders = skuReader.parseSkus(skus);
		} catch(IllegalArgumentException e) {
			return -1;
		}
		return orderPricer.price(orders);
	}
}
