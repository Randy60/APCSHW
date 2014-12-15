import java.util.*;
public class Driver{
    public static void main(String[]args){
	Random r = new Random();
	SuperArray Phil = new SuperArray();
	for(int i = 0; i < 48000; i++){
	    Phil.add(""+ r.nextInt(1000));
	}
	System.out.println(Phil.check());
	Phil.doubleBubbleSort();
	System.out.println(Phil.check());
    }
}