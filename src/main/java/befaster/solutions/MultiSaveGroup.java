package befaster.solutions;

import java.util.Collections;
import java.util.List;

public class MultiSaveGroup {

	public static MultiSaveGroup NO_MULTI_SAVES = new MultiSaveGroup(Collections.emptyList());
	
	private List<MultiSave> multiSaves;

	public MultiSaveGroup(List<MultiSave> multiSaves) {
		this.multiSaves = multiSaves;
	}
	
	public int getDiscount(int total) {
		if(multiSaves.isEmpty()) {
			return 0;
		}
		int toConsider = total;
		int totalDiscount = 0;
		for(MultiSave multiSave: multiSaves) {
			DiscountResult discountResult = multiSave.getDiscount(toConsider);
			totalDiscount += discountResult.getDiscount();
			toConsider = discountResult.getRemaining();
		}
		return totalDiscount;
	}
}
