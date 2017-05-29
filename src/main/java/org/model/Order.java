package org.model;

public class Order implements Comparable<Order>{

	// About ordering:
	// 1. pcode (string): the code of the product to be ordered.
	public String pcode;
	// 2. ccode (string): the code of the customer.
	public String ccode;
	// 3. quantity (integer): the number of ordered products.
	public Integer quantity;

	public Order(String pcode, String ccode, Integer quantity) {
		super();
		this.pcode = pcode;
		this.ccode = ccode;
		this.quantity = quantity;
	}

	public Order() {
		super();
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [pcode=" + pcode + ", ccode=" + ccode + ", quantity=" + quantity + "]";
	}

	@Override
	public int compareTo(Order o) {
		int pcodeCmp=this.pcode.compareTo(o.pcode);
	
		if (pcodeCmp==0) {
			return this.ccode.compareTo(o.ccode);
		}
		return pcodeCmp;
	}

}
