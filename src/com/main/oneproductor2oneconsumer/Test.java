package com.main.oneproductor2oneconsumer;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Goods goods = new Goods();
		Thread consumeThread = new Thread(new Consume(goods), "������");
		Thread productThread = new Thread(new Product(goods), "������");
		consumeThread.start();
		productThread.start();
	}

}
