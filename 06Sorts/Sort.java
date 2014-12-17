import java.util.*;
public class Sort{
    Integer[] ar;
    public Sort(int a){
	ar = new Integer[a];
    }
    public Sort(){
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
    public void add(int e){
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
	Integer[] bc;
	bc = new Integer[a];
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
    public Integer get(int a){
	if(a > -1 && a < arLength){
	    return ar[a];
	}
	else{
	    System.out.println("no String at this Index");
		return null;
	}
    }
    public Integer set(int x, int a){
	if(x >= 0 && x < ar.length){
	    int o = ar[x];
	    ar[x] = a;
	    return o;
	}
	else{
	    System.out.println("invalid index");
	    return null;
	}
    }
    public void add(int x, int e){
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
    public Integer remove(int x){
	if(x < 0 || x >= arLength){
	    System.out.println("invalid index");
	    return null;
	}
	else{
	    int c = x;
	    int ob = ar[x];
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
	    if(ar[x]-ar[x+1] <= 0){
		x++;
	    }else{
		int i = ar[x];
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
	    if(ar[i]-ar[i+1] <= 0)
		i++;
	    else{
		//	System.out.println(i);
		//	System.out.println(toString());
		int a = 0;
		for(int x = 0; ar[x]-ar[i + 1] < 0; x++){
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
	    if(ar[i] - ar[i+1] > 0){
		return false;
	    }
	}
	return true;
    }
    
    //this is linear
    public int find(int s){
	for(int i = 0; i < size(); i++){
	    if(s-get(i) == 0)
		return i;
	}
	System.out.println("String not in list");
	return -1;
    }
    public void selectionSort(){
	for(int i = 0; i < size(); i++){
	    int spot = i;
	    for(int x = i; x < size(); x++){
		if(ar[spot]-ar[x] > 0){
		    spot = x;
		}
	    }
	    int a = ar[spot];
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
		    if(ar1.get(ar1c) - ar2.get(ar2c) < 0){
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
    public void longSort(){
	/*String s = "0";
	int v = size();
	while(v > 2){
	    s = s + "0";
	    v/=2;
	    }*/
	if(size() <= 64){
	    // System.out.println(s);
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
	    ar1.longSort();
	    ar2.longSort();
	    //System.out.println(s);
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
			if(ar1.get(ar1c)-ar2.get(ar2c) < 0){
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
    public void doubleBubbleSort(){
	boolean swap = false;
	for(int i = 0; i < size() - 1; i++){
	    if(get(i)-get(i+1) > 0){
		int s = get(i);
		ar[i] = ar[i+1];
		ar[i+1] = s;
		swap = true;
	    }
	}
	if(swap){
	    swap = false;
	    for(int i = size() - 2; i > 0; i--){
		if(get(i)-get(i+1) > 0){
		    int s = get(i);
		    ar[i] = ar[i+1];
		    ar[i+1] = s;
		    swap = true;
		}
	    }
	    if(swap){
		doubleBubbleSort();
	    }
	}
    }
    public void bubbleSort(){
	boolean swap = false;
	int i = 0;
	int z = 0;
	while(z < 1){
	    for(int x = 0; x < size()-(i+1); x++){
		if(ar[x]-ar[x+1] > 0){
		    int a = ar[x];
		    ar[x] = ar[x+1];
		    ar[x+1] = a;
		    swap = true;}
	    }
	    if(swap){
		i++;
		swap = false;
	    }else{
		z++;
	    }
	}
    }	    
}