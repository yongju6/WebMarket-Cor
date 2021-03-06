package DTO;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = -8943425380512267111L;

	private String productId; 		// 상품 코드
	private String name; 			// 상품명
	private int unitPrice;			// 상품 가격
	private String description; 	// 상세 설명
	private String manufacturer; 	// 제조사
	private String category; 		// 카테고리
	private long unitsInStock; 		// 재고
	private String condition; 		// 새제품 or 중고 or 리퍼비시
	private String imagePath; 		// 이미지 파일 경로
	private int quantity;			// 장바구니에 담은 물건 개수
	
	

	public Product(String productId, String name, int unitPrice) {
		setProductId(productId);
		setName(name);
		setUnitPrice(unitPrice);
	}
	
	public Product(String productId, String name, String unitPrice, String description, String manufacturer, 
			String category, String unitsInStock, String condition, String imagePath) {
		this.productId = productId;
		this.name = name;
		this.unitPrice = Integer.parseInt(unitPrice);
		this.description = description;
		this.manufacturer = manufacturer;
		this.category = category;
		this.unitsInStock = Integer.parseInt(unitsInStock);
		this.condition = condition;
		this.imagePath = imagePath;
	}
	
	public Product(String productId, String name, int unitPrice, String description, String manufacturer, 
			String category, int unitsInStock, String condition, String imagePath) {
		this.productId = productId;
		this.name = name;
		this.unitPrice = unitPrice;
		this.description = description;
		this.manufacturer = manufacturer;
		this.category = category;
		this.unitsInStock = unitsInStock;
		this.condition = condition;
		this.imagePath = imagePath;
	}
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}
