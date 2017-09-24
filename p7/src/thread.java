import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;
public class thread {
	public static void main(String[] agrs)  throws 
	 InterruptedException, ExecutionException{
		Random random = new Random(50);
		int array[] = new int[50];
		int total = 0;
		for (int i = 0; i < 50; i++) {
			array[i] = random.nextInt(100);
			System.out.println(array[i]);
		}
		ExecutorService pool=Executors.newFixedThreadPool(5);
		Callable c1=new SubSumOne(array, 0, 10,"first");
		Callable c2=new SubSumOne(array, 10, 20,"secend");
		Callable c3=new SubSumOne(array, 20, 30,"third");
		Callable c4=new SubSumOne(array, 30, 40,"forth");
		Callable c5=new SubSumOne(array, 40, 50,"fifth");
		
		Future f1=pool.submit(c1);
		Future f2=pool.submit(c2);
		Future f3=pool.submit(c3);
		Future f4=pool.submit(c4);
		Future f5=pool.submit(c5);
		
		
        total=(int) f1.get()+(int) f2.get()+(int) f3.get()+(int) f4.get()+(int) f5.get();
        System.out.println("the sum of the total is:" + total);
        pool.shutdown(); 
		
		
	}

}

class SubSumOne implements Callable {
	private int sum = 0;
	private int array[] = new int[50];
	private String name;
    private int a,b;
public SubSumOne(int array[],int a,int b,String name)
{  
    this.a=a;
    this.b=b;
    this.name=name;
	for(int j=a;j<b;j++)
	{
		this.array[j]=array[j];
	}
}

	public Object call() {

		for (int i =a; i <b; i++) {
			sum += array[i];
		}
		System.out.println("the sum of "+name+" is :" + sum);
		return sum;
	}
}

