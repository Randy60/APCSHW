import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Driver{
    public static void main(String[] args) throws FileNotFoundException{

	
	wordSearch w = new wordSearch();
	if(args.length == 0){
	    w = new wordSearch(20, 20);
	    w.addWords(20);
	}
	if(args.length == 1){
	    w = new wordSearch(20, 20, 0 - "0".compareTo(args[0]));
	    w.addWords(20);
	}
	if(args.length == 2){
	    w = new wordSearch(0 - "0".compareTo(args[0]));
	    w.setSeed(0 - "0".compareTo(args[1]));
	    w.addWords((("0".compareTo(args[0]) * "0".compareTo(args[0]))/ 10) - 10);
	}
	if(args.length == 3){
	    w = new wordSearch(0 - "0".compareTo(args[1]),0 - "0".compareTo(args[0]));
	    w.setSeed(0 - "0".compareTo(args[2]));
	    w.addWords((("0".compareTo(args[1]) * "0".compareTo(args[0]))/ 10) - 10);
	}
	if(args.length == 4){
	    w = new wordSearch(0 - "0".compareTo(args[1]), 0 - "0".compareTo(args[0]));
	    w.setSeed(0 - "0".compareTo(args[2]));
	    w.addWords(0 - "0".compareTo(args[3]));
	}
	    System.out.println(w.toString());
	    w.fill();
	    System.out.println(w.toString());
    }
}