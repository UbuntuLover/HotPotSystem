package com.luojuan.bean;

public class Hotpot {
private String flavour;
private String price;
private String id;

public Hotpot() {
	// TODO Auto-generated constructor stub
}

public Hotpot(String flavour, String price, String id) {
	super();
	this.flavour = flavour;
	this.price = price;
	this.id = id;
}

public String getFlavour() {
	return flavour;
}

public void setFlavour(String flavour) {
	this.flavour = flavour;
}

public String getPrice() {
	return price;
}

public void setPrice(String price) {
	this.price = price;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

@Override
public String toString() {
	return "Hotpot [flavour=" + flavour + ", price=" + price + ", id=" + id + "]";
}

}
