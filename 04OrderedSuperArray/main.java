import java.util.*;
public class main{
    public static void main(String[]args){
	Random r = new Random(283);
	SuperArray Phil = new SuperArray();
	for(int i = 0; i < 100000; i++){
	    Phil.add(""+ r.nextInt(499));
	}
	System.out.println(Phil.check());
	Phil.insertionSort();
	System.out.println(Phil.check());
    }
}