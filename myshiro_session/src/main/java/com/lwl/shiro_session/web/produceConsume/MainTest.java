package com.lwl.shiro_session.web.produceConsume;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MainTest {
    //队列最大数
    public static final int MAX_POOL=10;
    //生产者最大数量
    public static final int MAX_P=5;
    //消费者最大数量
    public static final int MAX_C=50;
    //队列
    public static Queue<Goods> goodsQueue=new ArrayBlockingQueue<>(MAX_POOL);

    public static void main(String[] args) {

        Produce produce=new Produce();
        Consume consume=new Consume();
        for(int i=0;i<MAX_P;i++){
            Thread thread=new Thread(produce,"生产者"+i+"：");
            thread.start();
        }

        for(int i=0;i<MAX_C;i++){
            Thread thread=new Thread(consume,"消费者"+i+"：");
            thread.start();
        }

    }
}
