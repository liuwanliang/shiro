package com.lwl.shiro_session.web.produceConsume;

public class Consume implements Runnable{


    @Override
    public void run() {
        while (true){
            /*try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }*/
            synchronized (MainTest.goodsQueue){
                if(MainTest.goodsQueue.size()>0){
                    MainTest.goodsQueue.remove();
                    System.out.println(Thread.currentThread().getName()+"消费商品:"+MainTest.goodsQueue.size());
                    MainTest.goodsQueue.notifyAll();
                }else{
                    try {
                        MainTest.goodsQueue.wait();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

            }

        }
    }
}
