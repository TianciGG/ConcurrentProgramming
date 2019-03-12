package chauncy.concurrentprogramming;


class Res{
	//private int count=0;
	private ThreadLocal<Integer>
	
	/**
	 * 
	 * @methodDesc: 功能描述(生成订单号)  
	 * @author: ChauncyWang
	 * @param: @return   
	 * @createTime: 2019年3月12日 下午2:23:57   
	 * @returnType: int
	 */
	public int getNum(){
		count=count+1;
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
public class ThreadLocal {
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
