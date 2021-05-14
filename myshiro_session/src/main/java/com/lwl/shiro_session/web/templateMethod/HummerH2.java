package com.lwl.shiro_session.web.templateMethod;

public class HummerH2 extends HummerModel {

    private boolean alarmFlag = true;

    @Override
    protected void start() {
        System.out.println("H2 启动");
    }

    @Override
    protected void stop() {
        System.out.println("H2 停止");
    }

    @Override
    protected void alarm() {
        System.out.println("H2 鸣笛");
    }

    @Override
    protected void engineBoom() {
        System.out.println("H2 轰鸣");
    }

    @Override
    protected boolean isAlarm() {
        return this.alarmFlag;
    }

    public void setAlarmFlag(boolean alarmFlag) {
        this.alarmFlag = alarmFlag;
    }
}
