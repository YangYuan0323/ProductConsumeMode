package com.main.oneproductor2oneconsumer;

public class Consume implements Runnable {
	
	private Goods goods;
	public Consume(Goods goods){
		this.goods = goods;
	}

	public void run() {
		goods.get();
	}

}
