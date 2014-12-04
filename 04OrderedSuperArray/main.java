import java.util.*;
public class main{
    public static void main(String[]args){
	Random r = new Random(28130);
	OrderedSuperArray Phil = new OrderedSuperArray();
	for(int i = 0; i < 100000; i++){
	    Phil.add(i, ""+(char)('A' + r.nextInt(26)));
	}
	System.out.println(Phil.check());
	Phil.sort();
	System.out.println(Phil.check());
    }
}