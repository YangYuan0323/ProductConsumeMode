package com.main.oneproductor2oneconsumer;

public class Goods {

	private String goodsName;
	private int count;

	/**
	 * 生产商品
	 */
	public synchronized void set(String goodsName) {
		try {
			if (count > 0) {
				System.out.println("商品还有库存，先用完...");
				//等待消费
				wait();
			}
			this.goodsName = goodsName;
			count++;
			System.out.println(Thread.currentThread().getName()+"生产: "+goodsName);
			//通知消费
			notify();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 消费商品
	 * @return
	 */
	public synchronized void get(){
		try {
			if(count == 0){
				System.out.println("商品卖完了，等待进货...");
				wait();
			}
			System.out.println(Thread.currentThread().getName()+"消费: "+goodsName);
			count--;
			//通知生产
			notify();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String toString() {
		return "Goods [goodsName=" + goodsName + ", count=" + count + "]";
	}

}