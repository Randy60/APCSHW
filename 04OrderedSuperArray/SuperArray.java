import java.util.*;
public class SuperArray{
    Object[] ar;
    public SuperArray(int a){
	ar = new Object[a];
    }
    public SuperArray(){
	this(10);
    }
    int arLength = 0;
    public String toString(){
	String s = "";
	int x = 0;
	while(x < ar.length){
	    if(null == ar[x]){
		x++;
	    }
	    else{
		s = s + ar[x] + ", ";
		x++;
	    }
	}
	return ("[ "+s+"]");
    }
    public void add(Object e){
	if(arLength < ar.length){
	    ar[arLength] = e;
	    arLength++;
	}
	else{
	    resize(ar.length * 2);
	    ar[arLength] = e;
	    arLength++;
	}
    }	    
    public int size(){
	return arLength;
    }
    public void resize(int a){
	Object[] bc;
	bc = new Object[a];
	int x = 0;
	arLength = 0;
	while(x < bc.length && x < ar.length){
	    bc[x] = ar[x];
	    x++;
	    arLength++;
	}
	ar = bc;
    }
    public void clear(){
	int x = 0;
	while(x < ar.length){
	    ar[x] = null;
	}
    }
    public Object get(int a){
	if(a > -1 && a < arLength){
	    return ar[a];
	}
	else{
	    System.out.println("no Object at this Index");
		return null;
	}
    }
    public String set(int x, Object a){
	if(x >= 0 && x < ar.length){
	    Object o = ar[x];
	    ar[x] = a;
	    return ""+o+" is replaced by "+a+" at index "+x;
	}
	else{
	    System.out.println("invalid index");
	    return null;
	}
    }
    public void add(int x, Object e){
	if(x >= 0 && x <= ar.length){
	    if(arLength == ar.length){
		resize(ar.length + 1);
	    }
	    int b = ar.length - 1;
	    while(x < b){
		ar[b] = ar[b-1];
		b--;
	    }
	    ar[x] = e;
	    arLength++;
	}
	else
	    System.out.println("invalid Index");
    }
    public String remove(int x){
	if(x < 0 || x >= arLength){
	    System.out.println("invalid index");
	    return null;
	}
	else{
	    int c = x;
	    Object ob = ar[x];
	    while(x < ar.length - 1){
		ar[x] = ar[x + 1];
		x++;
	    }
	    ar[ar.length - 1] = null;
	    arLength--;
	    if(size() * 4 < ar.length)
		resize(ar.length / 2);
	    return ""+ob+" was removed at index "+c;
	}
    }
    public int compare(Object a, Object b){
	    String sa = "" + a;
	    String sb = ""+b;
	    return sa.compareTo(sb);
    }
    public void sort(){
	int x = 0;
	while(x < ar.length - 1){
	    if(compare(ar[x], ar[x+1]) <= 0){
		x++;
	    }else{
		Object i = ar[x];
		ar[x] = ar[x+1];
		ar[x+1] = i;
		if(x>0){
		    x--;
		}
	    }
	}
    }
}
