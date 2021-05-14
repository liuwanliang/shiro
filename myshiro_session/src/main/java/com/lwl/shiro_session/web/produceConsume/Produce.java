package com.lwl.shiro_session.web.produceConsume;

public class Produce implements Runnable {


    @Override
    public void run() {
        while (true) {
            /*try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }*/
            synchronized (MainTest.goodsQueue) {
                if (MainTest.MAX_POOL > MainTest.goodsQueue.size()) {
                    Goods goods = new Goods(1, "商品");
                    MainTest.goodsQueue.add(goods);
                    System.out.println(Thread.currentThread().getName() + ":生产商品:" + MainTest.goodsQueue.size());
                    MainTest.goodsQueue.notifyAll();
                } else {
                    //队列满了生产者wait()
                    try {
                        MainTest.goodsQueue.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }
}
