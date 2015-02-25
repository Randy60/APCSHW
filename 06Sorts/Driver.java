import java.util.*;
public class Driver{
    public static void main(String[]args){
	Random r = new Random();
	Sorts Phil = new Sorts();
	int[] ar = new int[10000000];
	for(int i = 0; i < ar.length; i++){
	    ar[i] = r.nextInt(1000);
	}
	System.out.println(Phil.check(ar));
	Phil.merge(ar);
	System.out.println(Phil.check(ar));
    }
}
