package cn.zkz.common.redis.lock.lock;

/**
 * @author zkz
 * @date 2020/12/25
 */
public interface Lock {

    /**
     * 获取锁
     *
     * @return
     */
    boolean acquire();

    /**
     * 释放锁
     *
     * @return
     */
    boolean release();
}