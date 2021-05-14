package com.lwl.shiro_session.web.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

public class MySessionListener1 implements SessionListener {

    /**
     * 会话创建时触发
     *
     * @param session
     */
    @Override
    public void onStart(Session session) {
        System.out.println("会话创建:" + session.getId());
    }

    /**
     * 退出/会话过期时触发
     *
     * @param session
     */
    @Override
    public void onStop(Session session) {
        System.out.println("会话停止：" + session.getId());
    }

    /**
     * 会话过期时触发
     *
     * @param session
     */
    @Override
    public void onExpiration(Session session) {
        System.out.println("会话过期：" + session.getId());
    }
}
