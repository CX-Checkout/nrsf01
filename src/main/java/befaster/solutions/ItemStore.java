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
	
	private static final MultiSaveGroup F_SAVES = new MultiSaveGroup(Arrays.asList(
			new MultiSave(3, 30 - 20)
	));
	
	private static final MultiSaveGroup H_SAVES = new MultiSaveGroup(Arrays.asList(
			new MultiSave(10, 100 - 80),
			new MultiSave(5, 50 - 45)
	));
	
	private static final MultiSaveGroup K_SAVES = new MultiSaveGroup(Arrays.asList(
			new MultiSave(2, 160 - 150)
	));
	
	private static final MultiSaveGroup P_SAVES = new MultiSaveGroup(Arrays.asList(
			new MultiSave(5, 250 - 200)
	));
	
	private static final MultiSaveGroup Q_SAVES = new MultiSaveGroup(Arrays.asList(
			new MultiSave(3, 90 - 80)
	));
	
	private static final MultiSaveGroup U_SAVES = new MultiSaveGroup(Arrays.asList(
			new MultiSave(4, 160 - 120)
	));
	
	private static final MultiSaveGroup V_SAVES = new MultiSaveGroup(Arrays.asList(
			new MultiSave(3, 150 - 130),
			new MultiSave(2, 100 - 90)
	));
	
	public static final Item A = new Item('A', 50, A_SAVES);
	public static final Item B = new Item('B', 30, B_SAVES);
	public static final Item C = new Item('C', 20);
	public static final Item D = new Item('D', 15);
	public static final Item E = new Item('E', 40);
	public static final Item F = new Item('F', 10, F_SAVES);
	public static final Item G = new Item('G', 20);
	public static final Item H = new Item('H', 10, H_SAVES);
	public static final Item I = new Item('I', 35);
	public static final Item J = new Item('J', 60);
	public static final Item K = new Item('K', 80, K_SAVES);
	public static final Item L = new Item('L', 90);
	public static final Item M = new Item('M', 15);
	public static final Item N = new Item('N', 40);
	public static final Item O = new Item('O', 10);
	public static final Item P = new Item('P', 50, P_SAVES);
	public static final Item Q = new Item('Q', 30, Q_SAVES);
	public static final Item R = new Item('R', 50);
	public static final Item S = new Item('S', 30);
	public static final Item T = new Item('T', 20);
	public static final Item U = new Item('U', 40, U_SAVES);
	public static final Item V = new Item('V', 50, V_SAVES);
	public static final Item W = new Item('W', 20);
	public static final Item X = new Item('X', 90);
	public static final Item Y = new Item('Y', 10);
	public static final Item Z = new Item('Z', 50);

	private static final List<Item> items = Arrays.asList(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z);
	
	public static final List<FreebieIdentifier> FREEBIES = Arrays.asList(
			new FreebieIdentifier(E, 2, B),
			new FreebieIdentifier(N, 3, M),
			new FreebieIdentifier(R, 3, Q)
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
