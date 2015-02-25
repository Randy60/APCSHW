import java.util.*;
public class Sorts{
    public static String name(){
	return "Higgins, Randolph";
    }
    public static int period(){
	return 6;
    }
    public void selection(int[] ar){
	for(int i = 0; i < ar.length; i++){
	    int spot = i;
	    for(int x = i; x < ar.length; x++){
		if(ar[spot]-ar[x] > 0){
		    spot = x;
		}
	    }
	    int a = ar[spot];
	    ar[spot] = ar[i];
	    ar[i] = a;
	}
    }
    public boolean check(int[] ar){
	 for(int i = 0; i < ar.length - 1; i++){
	     if(ar[i] - ar[i+1] > 0){
		 return false;
	     }
	 }
	 return true;
     }
    public void insertion(int[] ar){
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
    public void bubble(int[] ar){
    	boolean swap = false;
	int i = 0;
	int z = 0;
	merge(ar); // ;)
	while(z < 1){
	    for(int x = 0; x < ar.length-(i+1); x++){
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
    public void prayerSort(int[] a){
	Random r = new Random();
	while(check(a) == false){
	    for(int i = 0; i < a.length; i++){
		int x = a[i];
		int y = r.nextInt(a.length);
		a[i] = a[y];
		a[y] = x;
	    }
	}
    }
		
    public int raiseTo(int a, int exp){
	if(exp == 0)
	    return 1;
	else{
	int b = a;
	while(exp > 1){
	    a*=b;
	    exp--;
	}
	return a;
	}
    }
    public void radix(int[] ar){
	int exp = 0;
	boolean done = false;
	while(done == false){
	    int[][] holder = new int[ar.length][10];
	    int[] counts = new int[10];
	    int modOf = raiseTo(10, exp);
	    for(int i = 0; i < ar.length; i++){
		int base = (ar[i]%(modOf*10))/modOf;
		holder[counts[base]][base]=ar[i];
		counts[base]++;
	    }
	    if(counts[0] == ar.length){
		ar = holder[0];
		done = true;
	    }
	    else{
		int i = 0;
		for(int x = 0; x < 10; x++){
		    for(int z = 0; z < counts[x]; z++){
			ar[i] = holder[z][x];
			i++;
		    }
		}
	    }
	    exp++;
	}
    }	
    public void merge(int[] ar){
	if(ar.length <= 64){
	    insertion(ar);
	}else{
	    int[] ar1 = new int[ar.length/2];
	    int[] ar2 = new int[ar.length - ar.length/2];
	    int i = 0;
	    while(i < ar1.length){
		ar1[i]= ar[i];
		i++;
	    }
	    i = 0;
	    while(i < ar2.length){
		ar2[i] = ar[i + ar1.length - 1];
		i++;
	    }
	    merge(ar1);
	    merge(ar2);
	    int ar1c = 0;
	    int ar2c = 0;
	    for(int x = 0; x < ar.length; x++){
		if(ar2c == ar2.length){
		    ar[x] = ar1[ar1c];
		    ar1c++;
		}else{
		    if(ar1c == ar1.length){
			ar[x] = ar2[ar2c];
			ar2c++;
		    }else{
			if(ar1[ar1c]-ar2[ar2c] < 0){
			    ar[x] = ar1[ar1c];
			    ar1c++;
			}
			else{
			    ar[x] = ar2[ar2c];
			    ar2c++;
			}
		    }
		}
	    }
	}
    }
}
