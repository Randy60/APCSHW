import java.util.*;
public class ArrayListMethods{
    public static void main(String[]args){
	Random rand = new Random();
	ArrayList<Integer> L;
	L = new ArrayList<Integer>();
	int i = 0;
	while(i < 15){
	    L.add(rand.nextInt(10));
	    i++;
	}
	System.out.println(show(L));
	randomize(L);
	System.out.println(show(L));
	collapseDuplicates(L);
	System.out.println(show(L));
    }
    public static String show(ArrayList<Integer> c){
	String s = "";
	int x = 0;
	while(x < c.size()){
	    s = s + c.get(x)+",";
	    x++;
	}
	s = "["+s+"]";
	return s;
    }
    public static void collapseDuplicates(ArrayList<Integer> L){
	int x = 0;
	while(x < L.size()-1){
	    if(L.get(x) == L.get(x+1))
		L.remove(x);
	    else
		x++;
	}
    }
    public static void randomize(ArrayList<Integer> L){
	Random r = new Random();
	int i = 0;
	while(i < L.size()){
	    int a = r.nextInt(L.size()- i) + i;
	    int b = L.get(i);
	    L.set(i, L.get(a));
	    L.set(a, b);
	    i++;
	}
    }
}
