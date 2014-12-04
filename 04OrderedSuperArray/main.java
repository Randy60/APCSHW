import java.util.*;
public class main{
    public static void main(String[]args){
	Random r = new Random(28130);
	OrderedSuperArray Phil = new OrderedSuperArray();
	for(int i = 0; i < 15; i++){
	    Phil.add(0, ""+ r.nextInt(10));
	}
	System.out.println(Phil.check());
	System.out.println(Phil.toString());
	System.out.println(Phil.find("6"));
	System.out.println(Phil.get(Phil.find("6")));
	Phil.insertionSort();
	System.out.println(Phil.check());
	System.out.println(Phil.toString());
	System.out.println(Phil.find("6"));
	System.out.println(Phil.get(Phil.find("6")));
    }
}