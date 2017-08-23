package com.jie.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

public class JedisUtil {
	/**
	 * 私有构造器
	 */
	private JedisUtil() {
	}

	/**
	 * 全局的Map
	 */
	private static Map<String, JedisPool> maps = new HashMap<String, JedisPool>();

	/**
	 * @Description	获取连接池
	 * @auth weishujie
	 * @creattime 2017年8月18日上午10:52:30
	 * @param ip
	 * @param port
	 * @return
	 */
	private static JedisPool getPool(String ip, int port) {
		String key = ip + ":" + port;// jedis的地址
		JedisPool pool = null;
		if (!maps.containsKey(key)) {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(GenericObjectPoolConfig.DEFAULT_MAX_TOTAL);
			config.setMaxIdle(GenericObjectPoolConfig.DEFAULT_MAX_IDLE);
			config.setMaxWaitMillis(GenericObjectPoolConfig.DEFAULT_MAX_WAIT_MILLIS);
			config.setTestOnBorrow(true);
			config.setTestOnReturn(true);
			try {
				pool = new JedisPool(config, ip, port);
				maps.put(key, pool);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			pool = maps.get(key);
		}
		return pool;
	}

	/**
	 * @Description 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例 
	 * 					没有绑定关系，而且只有被调用到时才会装载，从而实现了延迟加载。 
	 * @author weishujie
	 * @data 2017年8月18日上午11:54:30
	 */
	private static class RedisUtilHolder {
		/** 
		 * 静态初始化器，由JVM来保证线程安全 
		 */
		private static JedisUtil instance = new JedisUtil();
	}

	/** 
	 * 当getInstance方法第一次被调用的时候，它第一次读取 
	 * RedisUtilHolder.instance，导致RedisUtilHolder类得到初始化；而这个类在装载并被初始化的时候，会初始化它的静态域，
	 * 从而创建RedisUtil的实例，由于是静态的域，因此只会在虚拟机装载类的时候初始化一次，并由虚拟机来保证它的线程安全性。 
	 * 这个模式的优势在于，getInstance方法并没有被同步，并且只是执行一个域的访问，因此延迟初始化并没有增加任何访问成本。 
	 */
	public static JedisUtil getInstance() {
		return RedisUtilHolder.instance;
	}

	/**
	 * @Description	获取Jedis
	 * @auth weishujie
	 * @creattime 2017年8月18日下午12:06:51
	 * @param ip
	 * @param port
	 * @return
	 */
	public Jedis getJedis(String ip, int port) {
		Jedis jedis = null;
		int count = 0;
		do {
			jedis = getPool(ip, port).getResource();
			count++;
		} while (jedis == null && count < 3);// 重启三次,三次获取不到就结束
		return jedis;
	}

	/**
	 * @Description	获取默认的Jedis
	 * @auth weishujie
	 * @creattime 2017年8月18日下午2:34:09
	 * @return
	 */
	public Jedis getJedis() {
		return getJedis(Protocol.DEFAULT_HOST, Protocol.DEFAULT_PORT);
	}

	/**
	 * @Description 释放Jdeis到连接池
	 * @auth weishujie
	 * @creattime 2017年8月18日下午2:16:55
	 * @param jedis
	 * @param ip
	 * @param port
	 */
	@SuppressWarnings("deprecation")
	public void closeJedis(Jedis jedis, String ip, int port) {
		if (jedis != null) {
			getPool(ip, port).returnResource(jedis);
		}
	}

	/**
	 * @Description	直接关闭连接
	 * @auth weishujie
	 * @creattime 2017年8月18日下午2:36:57
	 * @param jedis
	 */
	public void closeJedis(Jedis jedis) {
		if (jedis != null) {
			jedis.close();
		}
	}

}
