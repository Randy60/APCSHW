import java.util.*;
public class Driver{
    public static void main(String[]args){
	Random r = new Random();
	Sort Phil = new Sort();
	for(int i = 0; i < 10000000; i++){
	    Phil.add(r.nextInt(1000));
	}
	System.out.println(Phil.check());
	Phil.longSort();
	System.out.println(Phil.check());
    }
}