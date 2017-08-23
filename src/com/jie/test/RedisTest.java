package com.jie.test;

import com.jie.util.JedisUtil;

import redis.clients.jedis.Jedis;

public class RedisTest {
	public static void main(String[] args) {
		RedisTest test = new RedisTest();
		test.listTest();
	}

	public void listTest() {
		Jedis jedis = JedisUtil.getInstance().getJedis();
		try {
			// 设置指定 key 的值,将一个或多个值插入到列表头部(没有就创建一个key,有则添加在头部)
			// jedis.lpush("strList", "String1", "String2", "String3",
			// "String4", "String5");
			// 获取指定列表长度
			System.out.println(jedis.llen("strList"));
			// 获取指定 ListKey的值,从开始start开始,向后面取出stop个值
			// System.out.println(jedis.lrange("strList", 1, 5));
			// 若超出则没有数据,不会报错
			// System.out.println(jedis.lrange("strList", 15, 5));
			// 取出第几个索引值(索引从0开始)
			// System.out.println(jedis.lindex("strList", 0));
			// 为第几个索引赋值(替换)
			// jedis.lset("strList", 3, "three");
			// 超出索引的会报错(索引从0开始)
			// jedis.lset("strList", 9, "ten");// ERR index out of range
			// 移出并获取列表的第一个元素
			// System.out.println(jedis.lpop("strList"));
			// 移出并获取列表的最后一个元素
			// System.out.println(jedis.rpop("strList"));
			// 在键的尾部插入值,并返回键的长度
			System.out.println(jedis.rpush("strList", "may", "be"));
			// jedis.expire("strList", 15);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接
			JedisUtil.getInstance().closeJedis(jedis);
		}
	}

	public void stringTest() {
		Jedis jedis = JedisUtil.getInstance().getJedis();
		try {
			// 设置指定 key 的值
			jedis.set("strTest", "String");
			// 获取指定 key 的值
			System.out.println(jedis.get("strTest"));
			// 将给定 key 的值设为 value ,并返回 key 的旧值(old value)
			System.out.println(jedis.getSet("strTest", "Test"));
			// 获取所有(一个或多个)给定 key 的值。
			System.out.println(jedis.mget("email", "strTest"));
			// 对某个键设置过期时间
			jedis.expire("strTest", 15);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接
			JedisUtil.getInstance().closeJedis(jedis);
		}
	}

}
