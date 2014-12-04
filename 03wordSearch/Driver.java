import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Driver{
    public static void main(String[] args) throws FileNotFoundException{
	int[] ar = new int[args.length];
	for(int i = 0; i < ar.length; i++){
	    ar[i] = Integer.parseInt(args[i]);
	}
 	wordSearch w = new wordSearch();
	if(ar.length == 0){
	    w = new wordSearch(20, 20);
	    w.addWords(20);
	}
	if(args.length == 1){
	    w = new wordSearch(20, 20, ar[0]);
	    w.addWords(20);
	}
	if(args.length == 2){
	    w = new wordSearch(ar[0]);
	    w.setSeed(ar[1]);
	    w.addWords(((ar[0] * ar[0]) / 10) - 10);
	}
	if(args.length == 3){
	    w = new wordSearch(ar[1] , ar[0]);
	    w.setSeed(ar[2]);
	    w.addWords(((ar[1] * ar[0])/ 10) - 10);
	}
	if(args.length == 4){
	    w = new wordSearch(ar[1] , ar[0]);
	    w.setSeed(ar[2]);
	    w.addWords(((ar[1] * ar[0])/ 10) - 10);
	    if(ar[3] == 0){
		System.out.println(w.toString());
		w.WordMe();
	    }else{
		w.fill();
		System.out.println(w.toString()+"\n"+"look for:");
		w.WordMe();
	    }
	}
	if(ar.length <= 3){
	w.WordMe();
	System.out.println(w.toString());
	w.fill();
	w.WordMe();
	System.out.println(w.toString());
	}   
    }
}