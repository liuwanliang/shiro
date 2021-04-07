package com.lwl.shiro_session.web.thread2;

public class ThreadJoin implements Runnable{

    private String name;

    private Thread lastThread;

    public ThreadJoin(String name) {
        this.name = name;
    }

    public void setLastThread(Thread lastThread){
        this.lastThread=lastThread;
    }

    @Override
    public void run(){
        if(lastThread!=null){
            try {
                lastThread.join();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(this.name);
    }


    public static void main(String[] args) throws Exception {




        ThreadJoin A = new ThreadJoin("A");
        Thread threadA=new Thread(A);

        ThreadJoin B = new ThreadJoin("B");
        B.setLastThread(threadA);
        Thread threadB=new Thread(B);

        ThreadJoin C = new ThreadJoin("C");
        C.setLastThread(threadB);
        Thread threadC=new Thread(C);
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
