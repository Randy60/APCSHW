import java.util.*;
public class OrderedSuperArray{
    String[] ar;
    public OrderedSuperArray(int a){
	ar = new String[a];
    }
    public OrderedSuperArray(){
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
    public boolean add(String e){
	if(arLength == 0){
	    add(0, e);
	    return true;
	}
	else{
	    if(arLength >= ar.length){
		resize(ar.length * 2);
	    }
	    int x = 0;
	    while(ar[x] != null && ar[x].compareTo(e) < 0){ 
		x++;
	    }
	    add(x, e);
	    return true;
	}
    }	    

    public int size(){
	return arLength;
    }

    public void resize(int a){
	String[] bc;
	bc = new String[a];
	int x = 0;
	while(x < bc.length && x < arLength){
	    bc[x] = ar[x];
	    x++;
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
	    System.out.println("no Object at this Index");
	    return null;
	}
    }
    public String set(int x, String a){
	if(x >= 0 && x < ar.length){
	    String s = get(x);
	    remove(x);
	    add(a);
	    return s;
	}
	else{
	    System.out.println("invalid index");
	    return null;
	}
    }
    public void add(int x, String e){
	if(x >= 0 && x <= ar.length){
	    if(arLength >= ar.length){
		resize(ar.length * 2);
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
	    System.out.println("invalid index");
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
    public void addBad(String s){
	if(arLength == 0)
	    add(0, s);
	else
	    add(arLength - 1, s);
    }
    public void badInsertionSort(){

        OrderedSuperArray c = new OrderedSuperArray();
        while( this.size() > 0){ 
            c.add(this.remove(0));
        }
        while(c.size() > 0){
            this.add(c.remove(0));
        }
    }
    public void sort(){
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
	//	if(check() == false){
	//  sort();
	//}
    public void sortSlow(){
	int x = 0;
	while(x < arLength - 2){
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
    public boolean check(){
	for(int i = 0; i < size() - 2; i++){
	    if(ar[i].compareTo(ar[i+1]) > 0){
		return false;
	    }
	}
	return true;
    }
}