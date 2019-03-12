package chauncy.concurrentprogramming;

import java.util.concurrent.atomic.AtomicInteger;

class VolatileNoAtomicThread extends Thread {
	// private static volatile int count = 0;
	private static AtomicInteger atomicInteger = new AtomicInteger(0);

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			// count++;
			atomicInteger.incrementAndGet();// count++
		}
		System.out.println(getName() + "-----" + atomicInteger);
	}
}

/**
 * @classDesc: 功能描述(Volatile修饰不具有原子性(不具有同步性)，不能解决线程安全问题)
 * @author: ChauncyWang
 * @createTime: 2019年3月12日 上午10:39:30
 * @version: 1.0
 */
public class VolatileNoAtomic {
	public static void main(String[] args) {
		// 初始化10个线程
		VolatileNoAtomicThread[] volatileNoAtomicThread = new VolatileNoAtomicThread[10];
		for (int i = 0; i < volatileNoAtomicThread.length; i++) {
			// 创建每一个线程
			volatileNoAtomicThread[i] = new VolatileNoAtomicThread();
		}
		for (int i = 0; i < volatileNoAtomicThread.length; i++) {
			// 启动每一个线程
			volatileNoAtomicThread[i].start();
		}
	}
}
