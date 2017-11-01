package befaster.solutions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ItemStore {
	
	private static final MultiSaveGroup A_SAVES = new MultiSaveGroup(Arrays.asList(
			new MultiSave(5, 250 - 200),
			new MultiSave(3, 150 - 130)
	));
	
	private static final MultiSaveGroup B_SAVES = new MultiSaveGroup(Arrays.asList(
			new MultiSave(2, 60 - 45)
	));
	public static final Item A = new Item('A', 50, A_SAVES);
	public static final Item B = new Item('B', 30, B_SAVES);
	public static final Item C = new Item('C', 20);
	public static final Item D = new Item('D', 15);
	public static final Item E = new Item('E', 40);

	private static final List<Item> items = Arrays.asList(A, B, C, D, E);
	
	public static final List<FreebieIdentifier> FREEBIES = Arrays.asList(
			new FreebieIdentifier(E, 2, B)
	);
	
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
