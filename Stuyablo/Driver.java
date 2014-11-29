import java.util.*;
public class Driver{
    public static void main(String[]args){
	Random r = new Random();
	Warrior[] War;
	War = new Warrior[15];
	for(int i = 0; i < War.length; i++){
	    String s;
	    if(r.nextInt(2) == 0){
		s = "eomere";
	    }else{
		s = "owin";
	    }
	    War[i] = new Warrior(""+(char)('A'+i)+s);
	}
	System.out.println(Arrays.toString(War));
	Arrays.sort(War);
	System.out.println(Arrays.toString(War));
    }
}