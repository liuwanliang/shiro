package com.lwl.shiro_session.web.thread;

public class ThreadA extends Thread {

    private static int i=0;
    private int flag;

    public void setFlag(int flag){
        this.flag=flag;
    }

    public ThreadA(int flag){
        this.flag=flag;
    }

    @Override
    public void run() {
        /*synchronized (String.class){*/
            while (i < 99) {
                synchronized (ThreadA.class) {
                    if(i%4==flag){
                        i++;
                        System.out.println(currentThread().getName() + i);
                        ThreadA.class.notifyAll();
                        try {
                            ThreadA.class.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                }
            }

        /*}*/

    }

    public static void main(String[] args) {
        ThreadA threadA=new ThreadA(0);
        ThreadA threadB=new ThreadA(1);
        ThreadA threadC=new ThreadA(2);
        ThreadA threadD=new ThreadA(3);
        threadA.setName("A:");
        threadB.setName("B:");
        threadC.setName("C:");
        threadD.setName("D:");

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        /*System.out.println(6%3);*/
    }

}
