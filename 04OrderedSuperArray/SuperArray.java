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
	String ans = "";
	int c = size()/2;
	String s = "";
	String s2 = "";
	int x = 0;
	while(x < c){
	    if(null == ar[x])
		x++;
	    else{
		s = s+ar[x]+",";
		s2 = s2+ar[x+c]+",";
		x++;
	    }
	}
	ans = s+s2;
	return("[ "+ans+"]");
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
	if(check() == false)
	    insertionSort();
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
    public void mergeSort(){
	SuperArray ar1 = new SuperArray(size()/2);
	SuperArray ar2 = new SuperArray(size()/2);
	int i = 0;
	int ar1c = 0;
	int ar2c = 0;
	while(i < size()/2){
	    ar1.add(ar[i]);
	    i++;
	}
	while(i >= size()/2 && i < size()){
	    ar2.add(ar[i]);
	    i++;
	}
	ar1.selectionSort();
	ar2.selectionSort();
	for(int x = 0; x < size(); x++){
	    if(ar2c == size()/2){
		ar[x] = ar1.get(ar1c);
		ar1c++;
	    }else{
		if(ar1c == size()/2){
		    ar[x] = ar2.get(ar2c);
		    ar2c++;
		}else{
		    if(ar1.get(ar1c).compareTo(ar2.get(ar2c)) < 0){
			ar[x] = ar1.get(ar1c);
			ar1c++;
		    }
		    else{
			ar[x] = ar2.get(ar2c);
			ar2c++;
		    }
		}
	    }
	}
    }
    public void mergeSortMulti(){
	if(size() <= 64){
	    selectionSort();
	}else{
	    SuperArray ar1 = new SuperArray(size()/2);
	    SuperArray ar2 = new SuperArray(size()/2);
	    int i = 0;
	    while(i < size()/2){
		ar1.add(ar[i]);
		i++;
	    }
	    while(i >= size()/2 && i < size()){
		ar2.add(ar[i]);
		i++;
	    }
	    ar1.mergeSortMulti();
	    ar2.mergeSortMulti();
	    int ar1c = 0;
	    int ar2c = 0;
	    for(int x = 0; x < size(); x++){
		if(ar2c == ar2.size()){
		    ar[x] = ar1.get(ar1c);
		    ar1c++;
		}else{
		    if(ar1c == ar1.size()){
			ar[x] = ar2.get(ar2c);
			ar2c++;
		    }else{
			if(ar1.get(ar1c).compareTo(ar2.get(ar2c)) < 0){
			    ar[x] = ar1.get(ar1c);
			    ar1c++;
			}
			else{
			    ar[x] = ar2.get(ar2c);
			    ar2c++;
			}
		    }
		}
	    }
	}
    }
}