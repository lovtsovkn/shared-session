package ru.udya.sharedsession.redis.permission.codec;

import com.haulmont.cuba.core.sys.serialization.SerializationSupport;
import com.haulmont.cuba.security.global.UserSession;
import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.codec.StringCodec;
import org.springframework.stereotype.Component;
import ru.udya.sharedsession.permission.domain.SharedUserPermission;
import ru.udya.sharedsession.permission.helper.SharedUserPermissionStringRepresentationHelper;

import java.nio.ByteBuffer;

@Component("ss_RedisUserPermissionCodec")
public class RedisSharedUserPermissionCodec implements RedisCodec<String, SharedUserPermission> {

    public RedisSharedUserPermissionCodec() { }

    @Override
    public String decodeKey(ByteBuffer buf) {
        return StringCodec.UTF8.decodeKey(buf);
    }

    @Override
    public SharedUserPermission decodeValue(ByteBuffer buf) {
        byte[] bytes = new byte[buf.remaining()];
        buf.get(bytes);

        return (SharedUserPermission) SerializationSupport.deserialize(bytes);
    }

    @Override
    public ByteBuffer encodeKey(String key) {
        return StringCodec.UTF8.encodeKey(key);
    }

    @Override
    public ByteBuffer encodeValue(SharedUserPermission permission) {
        return ByteBuffer.wrap(SerializationSupport.serialize(permission));
    }
}
