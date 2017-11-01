package befaster.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SkuReader {
	
	private ItemStore itemStore;

	private SkuLineParser skuLineParser = new SkuLineParser();
	
	public SkuReader(ItemStore itemStore) {
		this.itemStore = itemStore;
	}

	public List<Order> parseSkus(String skuLine) {
		char[] skus = skuLineParser.parse(skuLine);
		
		Map<Item, Integer> countByItem = new LinkedHashMap<>();
		for(char sku: skus) {
			Item item = lookupItem(sku);
			addToCount(countByItem, item);
		}
		return mapCountToList(countByItem);
	}

	private List<Order> mapCountToList(Map<Item, Integer> countByItem) {
		List<Order> orders = new ArrayList<>();
		for(Item item: countByItem.keySet()) {
			orders.add(new Order(item, countByItem.get(item)));
		}
		return orders;
	}

	private void addToCount(Map<Item, Integer> countByItem, Item item) {
		Integer currentCount = countByItem.get(item);
		if(currentCount == null) {
			countByItem.put(item, 1);
		} else {
			countByItem.put(item, currentCount + 1); 
		}
	}

	private Item lookupItem(char sku) {
		Item item = itemStore.lookupItem(sku);
		if(item == null) {
			throw new IllegalArgumentException("Sku '"+sku+"' not valid sku.");
		}
		return item;
	}
}
