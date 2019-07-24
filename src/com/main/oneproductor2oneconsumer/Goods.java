package com.main.oneproductor2oneconsumer;

public class Goods {

	private String goodsName;
	private int count;

	/**
	 * ������Ʒ
	 */
	public synchronized void set(String goodsName) {
		try {
			if (count > 0) {
				System.out.println("��Ʒ���п�棬������...");
				//�ȴ�����
				wait();
			}
			this.goodsName = goodsName;
			count++;
			System.out.println(Thread.currentThread().getName()+"����: "+goodsName);
			//֪ͨ����
			notify();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * ������Ʒ
	 * @return
	 */
	public synchronized void get(){
		try {
			if(count == 0){
				System.out.println("��Ʒ�����ˣ��ȴ�����...");
				wait();
			}
			System.out.println(Thread.currentThread().getName()+"����: "+goodsName);
			count--;
			//֪ͨ����
			notify();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String toString() {
		return "Goods [goodsName=" + goodsName + ", count=" + count + "]";
	}

}