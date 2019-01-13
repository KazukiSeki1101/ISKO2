package bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CartBean {
	private Map<Integer, KensakuBean> items = new HashMap<Integer, ItemBean>();
	private int total;

	public CartBean() {
	}

	public Map<Integer, KensakuBean> getItems() {
		return items;
	}

	public void addCart(KensakuBean bean, int nums) {
		KensakuBean item = (KensakuBean) items.get(new Integer(bean.getCode()));
		if (item == null) {
			bean.setQuantity(nums);
			items.put(new Integer(bean.getCode()), bean);
		} else {
			item.setQuantity(nums + item.getQuantity());
		}
		recalcTotal();
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
			total += item.getPrice() * item.getQuantity();
		}
	}
}
