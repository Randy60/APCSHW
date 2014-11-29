import java.util.Random;
public class Rogue extends Adventurer{
    private int stamina;
    public Rogue(){
	super("Max", 20, 10, 12, 15);
	
    }
    public Rogue(String s){
	super(s);
	setSTR(10);
	setINT(20);
	setDEX(12);

    }
    public int getStamina(){
	return stamina;
    }
    public void setStamina(int a){
	stamina = a;
    }
     public String getStats(){
	String s = super.getStats();
	return s + " Stamina"+getStamina();
    }
    public void hit(Adventurer other, int a){
	other.setHP(other.getHP() - a - 2);
	System.out.println(getName() + " slashes " 
			   + other.getName() + " and does " + (a + 2) + " damage");
	setStamina(getStamina() + 5);
    }
    public void attack(Adventurer other){
	Random r = new Random();
	if(r.nextInt(STR + DEX + 4) > r.nextInt(other.getDEX() + other.getINT())){
	    int a = r.nextInt(STR + 1);
	    hit(other, a);
	}
	else{
	    System.out.println(name + " misses " + other.getName());
	    setStamina(getStamina() + 3);
	}
    }
    public void specialAttack(Adventurer other){
	Random r = new Random();
	int a = r.nextInt(stamina + 1);
	if(r.nextInt(DEX) > r.nextInt(other.getDEX())){
	    if(other.getSTR() > other.getINT()){
		specialHit(other, r.nextInt(6 * STR));}
	    else
		specialHit(other, r.nextInt(STR));
	   }
	else
	    System.out.println(name + " sees no opening and continues to circle");
    }
    public void specialHit(Adventurer other, int a){
	other.setHP(other.getHP() - a);
	System.out.println("moving with blinding speed, " + name + " gets inside " + other.getName() + "'s guard and does " + a + " damage");
	if(a > getStamina()) 
	    setStamina(0);
	else 
	    setStamina(getStamina() - a);
    }
    public void rest(){
	System.out.println(getName() + " carefully backs away");
	setHP(getHP() + 6);
	setStamina(getStamina() + 5);
    }

}