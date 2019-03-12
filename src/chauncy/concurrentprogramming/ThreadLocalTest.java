package chauncy.concurrentprogramming;


class Res{
	//private int count=0;
	/*
	 * 设置本地局部变量，和其他线程局部变量隔离开，互不影响
	 */
	private ThreadLocal<Integer> count=new ThreadLocal<Integer>(){
		protected Integer initialValue() {
			//设置当前线程局部变量的初始化值
			return 0;
		};
	};
	/**
	 * 
	 * @methodDesc: 功能描述(生成订单号)  
	 * @author: ChauncyWang
	 * @param: @return   
	 * @createTime: 2019年3月12日 下午2:23:57   
	 * @returnType: int
	 */
	public Integer getNum(){
		int count=this.count.get()+1;
		this.count.set(value);
		return count;
	}
}

class ThreadLocalDemo extends Thread{
	private Res res;
	
	public ThreadLocalDemo(Res res){
		this.res=res;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(getName()+"----i:"+i+",number:"+res.getNum());
		}
	}
}


/**   
 * @classDesc: 功能描述(本地线程的使用：创建三个线程，每个线程生成自己独立的序列号)  
 * @author: ChauncyWang
 * @createTime: 2019年3月12日 下午2:21:03   
 * @version: 1.0  
 */  
public class ThreadLocalTest {
	public static void main(String[] args) {
		Res res = new Res();
		ThreadLocalDemo t1 = new ThreadLocalDemo(res);
		ThreadLocalDemo t2 = new ThreadLocalDemo(res);
		ThreadLocalDemo t3 = new ThreadLocalDemo(res);
		t1.start();
		t2.start();
		t3.start();
	}
}
