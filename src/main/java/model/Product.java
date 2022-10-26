package model;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length=35,nullable = false)
	private  String label;
	@Column(length=35,nullable = false)
	private Double price;
	
	@OneToMany(mappedBy ="product")
	private OrderDetail orderDetail;
	
	private   int  stock;
	@OneToMany(mappedBy ="product")
	private List<BasketDetail> basketDetails = new ArrayList();
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('New','Reconditioned','Repaired')")
	private Status status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public List<BasketDetail> getBasketDetails() {
		return basketDetails;
	}
	public void setBasketDetails(List<BasketDetail> basketDetails) {
		this.basketDetails = basketDetails;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@ManyToOne
	private Category category ;
	
	public Product( String label, Double price, int stock) {
		
		
		this.label = label;
		this.price = price;
		this.stock = stock;
	}
	public Product() {
		
	}
	
	public String getlabel() {
		return label;
	}
	public void setlabel(String label) {
		this.label = label;
	}
	public Double getprice() {
		return price;
	}
	public void setprice(Double price) {
		this.price = price;
	}
	public Category getCategorie() {
		return category;
	}
	public void setCategorie(Category categorie) {
		this.category = categorie;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Product [ label=" + label + ", price=" + price + ", stock=" + stock + "]";
	}
	


}
