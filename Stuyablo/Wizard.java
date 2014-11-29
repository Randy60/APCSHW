import java.util.Random;
public class Wizard extends Adventurer{
    private int mana;
    public Wizard(){
	super("Max");
	mana = 20;
	setSTR(5);
	setINT(25);
	setDEX(12);

    }
    public Wizard(String s){
	super(s);
	setHP(30);
	setSTR(5);
	setINT(20);
	setDEX(12);
	setMana(20);
    }
    public int getMana(){
	return mana;
    }
    public void setMana(int a){
	mana = a;
    }
    public String getStats(){
	String s = super.getStats();
	return s + " mana"+getMana();
    }
    public void hit(Adventurer other, int a){
	other.setHP(other.getHP() - a);
	System.out.println(getName() + " gestures magically at " 
			   + other.getName() + " and does " + a + " damage");
	;
	setMana(getMana() + 5);
    }
    public void specialAttack(Adventurer other){
	Random r = new Random();
	int a = r.nextInt(mana + 1);
	if((r.nextInt(2 * INT) >= r.nextInt(other.getDEX()+other.getINT()+3)) && mana > 0){
	    specialHit(other, 2 * a);
	    mana = mana - a;}
	else
	    System.out.println("voilently waving his hands, " + name + " misses and passes it off as a funny it off as a funny dance");
	if(getMana() > 3)
	setMana(getMana() - 3);
	else
	    setMana(0);
    }
    public void specialHit(Adventurer other, int a){
	other.setHP(other.getHP() - a);
	System.out.println("invoking the power of epic jazz hands, " + name + " magically attacks " + other.getName() + " and does " + a + " damage");
    }
    public void rest(){
	System.out.println(getName() + " ponders the wonders of the earth");
	setHP(getHP() + 8);
	setMana(getMana() + 5);
    }

}
