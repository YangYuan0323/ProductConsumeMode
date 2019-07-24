package com.main.oneproductor2oneconsumer;

public class Product implements Runnable {
	private Goods goods;
	
	public Product(Goods goods){
		this.goods =goods;
	}

	public void run() {
		goods.set("°®¶¹");
		
	}
	
	

}
