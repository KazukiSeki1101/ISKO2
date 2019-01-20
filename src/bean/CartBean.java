package bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CartBean {
	private Map<Integer, KensakuBean> items = new HashMap<Integer, KensakuBean>();
	private int total;

	public CartBean() {
	}

	public Map<Integer, KensakuBean> getItems() {
		return items;
	}

	public void deleteCart(int itemCode) {
		items.remove(new Integer(itemCode));
		recalcTotal();
	}

	public int getTotal() {
		return total;
	}

	private void recalcTotal() {
		total = 0;
		Collection<KensakuBean> list = items.values();
		for (KensakuBean item : list) {
			total += item.getPrice() * 1;
		}
	}
}