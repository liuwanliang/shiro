package com.lwl.shiro_session.web.thread2;

public class MyRunnable implements Runnable {


    @Override
    public void run() {
        synchronized (MyRunnable.class){

            System.out.println(Thread.currentThread().getName()+"进入锁块代码");
            try {
                MyRunnable.class.notifyAll();
                System.out.println(Thread.currentThread().getName()+"开始wait");
                MyRunnable.class.wait();
                System.out.println(Thread.currentThread().getName()+"被唤醒");
            }catch (Exception e){
                e.printStackTrace();
            }


        }
    }

    public static void main(String[] args) throws Exception {
        MyRunnable myRunnable=new MyRunnable();

        Thread thread1=new Thread(myRunnable);
        Thread thread2=new Thread(myRunnable);
        thread1.start();
        Thread.sleep(2000);
        thread2.start();
        System.out.println("main ");
    }
}
