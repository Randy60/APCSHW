import java.util.*;
public class Warrior extends Adventurer implements Comparable<Warrior>{ 
    Random r = new Random();
    private int rage;
    public Warrior(){
	setName("Bjorn");
	setHP(r.nextInt(20) + 20);
	setRage(10);
	setSTR(20);
	setINT(5);
	setDEX(12);
    }
    public Warrior(String s){
	super(s);
	setName(s);
	setHP(r.nextInt(30) + 10);
	setRage(10);
	setSTR(20);
	setINT(5);
	setDEX(12);
    }
    public Warrior(int a){
	super("Bjorn");
	setHP(r.nextInt(20)+20);
	setRage(a);
	setSTR(20);
	setINT(5);
	setDEX(12);
    }
    public String toString(){
	return(getName()+" HP:" + getHP());
    }
    public int compareTo(Warrior other){
	return(getHP() - other.getHP());
    }
    public int getRage(){
	return rage;
    }
    public void setRage(int a){
	rage = a;
    }
     public String getStats(){
	String s = super.getStats();
	return s + " Rage"+getRage();
    }
    public void specialAttack(Adventurer other){
	Random r = new Random();
	if(r.nextInt(STR + rage) >= r.nextInt(2 * other.getDEX())){
	    specialHit(other, ((rage / 2) + r.nextInt(STR)));
	    setRage(0);
	}
	else{
	    System.out.println(name + " screams and misses epiclly");
	    setRage(getRage() + 5);
	}
    }
    public void specialHit(Adventurer other, int a){
	other.setHP(other.getHP() - a);
	System.out.println("with an epic roar, " + name + " smashes " + other.getName() + " and does " + a + " damage");
    }
    public void hit(Adventurer other, int a){
	other.setHP(other.getHP() - a);
	System.out.println(getName() + " assaults " 
			   + other.getName() + " and does " + a + " damage");
	if(getRage() > 1) setRage(getRage() - 2);
    }
    public void attack(Adventurer other){
	Random r = new Random();
	if(r.nextInt(STR + DEX + 4) > r.nextInt(other.getDEX() + other.getINT())){
	    int a = r.nextInt(STR + 1);
	    hit(other, a);
	}
	else{
	    System.out.println(name + " misses " + other.getName());
	    setRage(getRage() + 3);
	}
    }
    public void rest(){
	System.out.println(getName() + " chews on a healing root");
	setHP(getHP() + 15);
	if(getRage()  > 4)
	    setRage(getRage() - 4);
	else
	    setRage(0);
    }

}