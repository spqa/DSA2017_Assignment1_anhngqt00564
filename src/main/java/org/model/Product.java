package org.model;

public class Product implements Comparable<Product> {

	// About a product:
	// 1. pcode (string): the code of the product (this should be unique for the
	// product).
	public String pcode;
	// 2. pro_name (string): the name of the product.
	public String pro_name;
	// 3. quantity (integer): the number of products with the same code in a
	// shop at beginning of a day.
	public Integer quantity;
	// 4. saled (integer): the number of products with the same code, which are
	// saled in the day. Condition: saled ≤ quantity.
	public Integer sale;
	// 5. price (double): The price of the product.
	public Double price;
	
	public String pro_image_url;

	public Product() {

	}

	public Product(String pcode, String pro_name, Integer quantity, Integer saled, Double price) {
		this.pcode = pcode;
		this.pro_name = pro_name;
		this.quantity = quantity;
		this.sale = saled;
		this.price = price;
	}

	public String getPcode() {
		return pcode;
	}

	public Product(String pcode) {
		super();
		this.pcode = pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getSaled() {
		return sale;
	}

	public void setSaled(Integer saled) {
		this.sale = saled;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [pcode=" + pcode + ", pro_name=" + pro_name + ", quantity=" + quantity + ", saled=" + sale
				+ ", price=" + price + "]";
	}

	@Override
	public int compareTo(Product o) {
		return pcode.compareTo(o.pcode);
	}

}
