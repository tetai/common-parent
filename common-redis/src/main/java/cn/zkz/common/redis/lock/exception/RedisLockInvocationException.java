package cn.zkz.common.redis.lock.exception;

/**
 * @author zkz
 * @date 2020/12/28
 */
public class RedisLockInvocationException extends RuntimeException {

    public RedisLockInvocationException() {
    }

    public RedisLockInvocationException(String message) {
        super(message);
    }

    public RedisLockInvocationException(String message, Throwable cause) {
        super(message, cause);
    }
}
