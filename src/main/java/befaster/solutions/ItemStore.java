package befaster.solutions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ItemStore {
	public static final Item A = new Item('A', 50, new MultiSave(3, 150 - 130));
	public static final Item B = new Item('B', 30, new MultiSave(2, 60 - 45));
	public static final Item C = new Item('C', 20);
	public static final Item D = new Item('D', 15);

	private static final List<Item> items = Arrays.asList(A, B, C, D);
	
	public List<Item> getItems() {
		return items;
	}
	
	public List<Character> getItemSkus() {
		return items.stream()
				.map(Item::getSku)
				.collect(Collectors.toList());
	}

	public Item lookupItem(char sku) {
		for(Item item: items) {
			if(item.getSku() == sku) {
				return item;
			}
		}
		return null;
	}
}
