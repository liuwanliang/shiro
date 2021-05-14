package com.lwl.shiro_session.web.session.dao;

import com.lwl.shiro_session.util.RedisUtils;
import com.lwl.shiro_session.util.SerializableUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import redis.clients.jedis.ShardedJedis;

import java.io.Serializable;

public class MySessionDao extends CachingSessionDAO {

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        ShardedJedis redis = RedisUtils.getJedis();
        redis.set(sessionId.toString(), SerializableUtils.serialize(session));
        RedisUtils.closeJedis(redis);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        ShardedJedis redis = RedisUtils.getJedis();
        String sessionStr = redis.get(sessionId.toString());

        return SerializableUtils.deserialize(sessionStr);
    }

    @Override
    protected void doUpdate(Session session) {
        if (session instanceof ValidatingSession && !((ValidatingSession) session).isValid()) {
            return;
        }
        ShardedJedis redis = RedisUtils.getJedis();
        redis.set(session.getId().toString(), SerializableUtils.serialize(session));
        RedisUtils.closeJedis(redis);
    }

    @Override
    protected void doDelete(Session session) {
        ShardedJedis redis = RedisUtils.getJedis();
        redis.del(session.getId().toString());
        RedisUtils.closeJedis(redis);
    }


}
