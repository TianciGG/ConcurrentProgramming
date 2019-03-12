package chauncy.concurrentprogramming;

class ThreadVolatile extends Thread {
	public volatile boolean flag = true;

	@Override
	public void run() {
		System.out.println("子线程开始执行...");
		while (flag) {

		}
		System.out.println("子线程结束执行...");
	}

	public void isRun(boolean flag) {
		this.flag = flag;
	}
}

/**
 * @classDesc: 功能描述(Volatile关键字的使用)
 * @author: ChauncyWang
 * @createTime: 2019年3月12日 上午10:17:14
 * @version: 1.0
 */
public class Volatile {
	public static void main(String[] args) throws InterruptedException {
		ThreadVolatile threadVolatile1 = new ThreadVolatile();
		threadVolatile1.start();
		Thread.sleep(300);
		/**
		 * 如果不对变量加Volatile关键字，则子线程不会停止运行 原因：线程之间是不可见的，读取的是副本，没有及时读取到主内存结果。
		 * 解决办法：使用Volatile关键字解决线程之间的可见性，强制线程每次读取该值的时候都去“主内存”中取值。
		 */
		threadVolatile1.isRun(false);
		System.out.println("flag:" + threadVolatile1.flag);
	}
}
