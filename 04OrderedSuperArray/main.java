import java.util.*;
public class main{
    public static void main(String[]args){
	Random r = new Random(283);
	OrderedSuperArray Phil = new OrderedSuperArray();
	for(int i = 0; i < 10000; i++){
	    Phil.add(""+ r.nextInt(300));
	}
	System.out.println(Phil.check());
	System.out.println(Phil.find("140"));
	System.out.println(Phil.get(Phil.find("140")));
	System.out.println(Phil.get(Phil.find("140")-1));
    }
}