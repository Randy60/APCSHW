import java.util.*;
public class Driver{
    public static void main(String[]args){
	wordSearch w = new wordSearch(20);
	w.addWords(1);
	System.out.println(w.toString());
	w.fill();
	System.out.println(w.toString());
    }
}