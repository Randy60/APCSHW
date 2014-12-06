import java.util.*;
public class Driver{
    public static void main(String[]args){
	Random r = new Random(4523);
	SuperArray Phil = new SuperArray();
	for(int i = 0; i < 500000; i++){
	    Phil.add(""+ r.nextInt(1000));
	}
	System.out.println(Phil.check());
	Phil.mergeSortMulti();
	System.out.println(Phil.check());
    }
}