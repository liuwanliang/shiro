package com.lwl.shiro_session.web.templateMethod;

public abstract class HummerModel {

    protected abstract void start();

    protected abstract void stop();

    protected abstract void alarm();

    protected abstract void engineBoom();

    public final void run() {
        this.start();
        this.engineBoom();
        if (this.isAlarm()) {
            this.alarm();
        }
        this.stop();
    }

    protected boolean isAlarm() {
        return true;
    }


}
