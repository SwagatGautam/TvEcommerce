package model;

public class Cart{
	
	private int userId;
	private int productId;
	private int cartQuantity;
	private Product product;
	
	public Cart() {
	}
	public int getcartQuantity() {
		return cartQuantity;
	}
	public void setcartQuantity(int cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

}
