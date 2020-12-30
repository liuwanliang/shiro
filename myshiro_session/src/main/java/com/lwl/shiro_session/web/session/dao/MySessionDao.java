package com.lwl.shiro_session.web.session.dao;

import com.lwl.shiro_session.util.RedisUtils;
import com.lwl.shiro_session.util.SerializableUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;

import java.io.Serializable;

public class MySessionDao extends CachingSessionDAO {

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId=generateSessionId(session);
        RedisUtils.getJedis().set(sessionId.toString(), SerializableUtils.serialize(session));

        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        return null;
    }

    @Override
    protected void doUpdate(Session session) {

    }

    @Override
    protected void doDelete(Session session) {

    }


}
