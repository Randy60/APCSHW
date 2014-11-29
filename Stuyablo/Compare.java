import java.util.*;
public class Compare{
    public static void main(Integer[]args){
	Random r = new Random();
	Warrior[]people;
	people = new Warrior[args[0]];
	for(i=0; i<args[0]; i++){
	    people[i] = new Warrior(""+(char)('A'+i)+"owin");
	    people[1].setHP(r.nextInt(40));
	}
	System.out.println(Arrays.toString(people));
    }
}