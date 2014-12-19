import java.util.*;
public class Driver{
    public static void main(String[]args){
	Random r = new Random();
	Sorts Phil = new Sorts();
	int[] ar = new int[1000000];
	for(int i = 0; i < 1000000; i++){
	    ar[i] = r.nextInt(1000);
	}
	System.out.println(Phil.name());
	Phil.multi(ar);
	System.out.println(Phil.period());
    }
}