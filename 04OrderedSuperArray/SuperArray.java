import java.util.*;
public class SuperArray{
    String[] ar;
    public SuperArray(int a){
	ar = new String[a];
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
		s = s+ar[x]+",";
		x++;
	    }
	}
	return ("[ "+s+"]");
    }
    public void add(String e){
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
	String[] bc;
	bc = new String[a];
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
    public String get(int a){
	if(a > -1 && a < arLength){
	    return ar[a];
	}
	else{
	    System.out.println("no String at this Index");
		return null;
	}
    }
    public String set(int x, String a){
	if(x >= 0 && x < ar.length){
	    String o = ar[x];
	    ar[x] = a;
	    return o;
	}
	else{
	    System.out.println("invalid index");
	    return null;
	}
    }
    public void add(int x, String e){
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
	    String ob = ar[x];
	    while(x < ar.length - 1){
		ar[x] = ar[x + 1];
		x++;
	    }
	    ar[ar.length - 1] = null;
	    arLength--;
	    if(size() * 4 < ar.length)
		resize(ar.length / 2);
	    return ob;
	}
    }
    public void swapSlowSort(){
	int x = 0;
	while(x < ar.length - 1){
	    if(ar[x].compareTo(ar[x+1]) <= 0){
		x++;
	    }else{
		String i = ar[x];
		ar[x] = ar[x+1];
		ar[x+1] = i;
		if(x>0){
		    x--;
		}
	    }
	}
    }
    public void insertionSort(){
	int i = 0;
	while(i < size() - 2){
	    if(ar[i].compareTo(ar[i+1]) <= 0)
		i++;
	    else{
		//	System.out.println(i);
		//	System.out.println(toString());
		int a = 0;
		for(int x = 0; ar[x].compareTo(ar[i + 1]) < 0; x++){
		    a++;
		}
		//	System.out.println(a);
		if(a > i){
		    add(a - 1, remove(i + 1));
		}else{
		    add(a, remove(i + 1));
		}
		//		if(a < i && i > 0)
		//  i--;
	    }
	}
    }
     public boolean check(){
	for(int i = 0; i < size() - 2; i++){
	    if(ar[i].compareTo(ar[i+1]) > 0){
		return false;
	    }
	}
	return true;
    }
    
    //this is linear
    public int find(String s){
	for(int i = 0; i < size(); i++){
	    if(s.compareTo(get(i)) == 0)
		return i;
	}
	System.out.println("String not in list");
	return -1;
    }
    public void selectionSort(){
	for(int i = 0; i < size(); i++){
	    int spot = i;
	    for(int x = i; x < size(); x++){
		if(ar[spot].compareTo(ar[x]) > 0){
		    spot = x;
		}
	    }
	    String a = ar[spot];
	    ar[spot] = ar[i];
	    ar[i] = a;
	}
	
    }
}
