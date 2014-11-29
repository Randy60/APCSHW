import java.util.Scanner;
import java.util.Random;
public class Adventurer{
    public String name;
    public int HP, STR, INT, DEX;
    public Adventurer(String s, int a, int b, int c, int d){
	name = s;
	HP = a;
	STR = b;
	INT = c;
	DEX = d;
    }
    public Adventurer(String s){
	this(s, 40, 10, 10, 10);
    }
    public Adventurer(){
	this("Paul", 40, 10, 10, 10);
    }
    public String getStats(){
	return (name +"\n"+"HP"+getHP()+" STR"+ getSTR()+" INT"+getINT()+" DEX"+getDEX());
    }
    public int getHP(){
	return HP;
    }
    public void setHP(int a){
	HP = a;
    }
    public void setName(String s){
	name = s;
    }
    public String getName(){
	return name;
    }
    public void setSTR(int a){
	STR = a;
    }
    public int getSTR(){
	return STR;
    }
    public void setINT(int a){
	INT = a;
    }
    public int getINT(){
	return INT;
    }
    public void setDEX(int a){
	DEX = a;
    }
    public int getDEX(){
	return DEX;
    }
    public void specialAttack(Adventurer other){
	setSTR(STR + 3);
	attack(other);
	setSTR(STR - 3);
    }
    public void attack(Adventurer other){
	Random r = new Random();
	if(r.nextInt(STR + DEX + 4) > r.nextInt(other.getDEX() + other.getINT())){
	    int a = r.nextInt(STR + 1);
	    hit(other, a);
	}
	else
	    System.out.println(name + " misses " + other.getName());
    }
    public void hit(Adventurer other, int a){
	other.setHP(other.getHP() - a);
	System.out.println(getName() + " attacks " 
			   + other.getName() + " and does " + a + " damage");
    }
    public void randomAttack(Adventurer other){
	Random x = new Random();
	if(x.nextInt(10) > 7)
	    specialAttack(other);
	else
	    attack(other);
    }
    public void rest(){
	System.out.println(getName() + " takes a breather");
	setHP(getHP() + 6);
    }
    public void fight(Adventurer other, Adventurer you){
	if(HP < 1){
	    System.out.println("You died, "+ other.getName() +" wins");}
	else{
		if(other.getHP() < 1)
	    System.out.println(other.getName()+" died, you win");
	    else{
	System.out.println("(you)"+ getStats() +"\n"+ other.getStats()+"\n"+"\n"+"1:attack"+"\n"+"2:special"+"\n"+"3:rest"+"\n"+"4:flee"+"\n");
	Scanner s = new Scanner(System.in);
	int a = s.nextInt();
	if(a == 1){
	    System.out.println("\n");
	    attack(other);
	    if(other.getHP() > 0){
		other.randomAttack(you);
		fight(other, you);
	    }
	    else
		System.out.println(other.getName()+" died, you win");
	}
	 if(a == 2){
	    System.out.println("\n");
	    specialAttack(other);
	    if(other.getHP() > 0){
		other.randomAttack(you);
		nonSpecialFight(other, you);
	    }
	    else
		System.out.println(other.getName()+" died, you win");
	   
	 }
	 if(a == 3){
	    System.out.println("\n");
	    rest();
	    other.randomAttack(you);
	    fight(other, you);
	 }
	 if(a == 4)
	     System.out.println("you fled, "+other.getName()+" wins");
	 if(a != 1 && a != 2 && a != 3 && a != 4){
	     System.out.println("Invalid input, try again");
	     fight(other, you);
	 }
	    }
	}
    }
    public void nonSpecialFight(Adventurer other, Adventurer you){
	if(HP < 1){
	    System.out.println("You died, "+ other.getName() +" wins");}
	else{
		if(other.getHP() < 1)
	    System.out.println(other.getName()+" died, you win");
	    else{
	System.out.println("(you)"+ getStats() +"\n"+ other.getStats()+"\n"+"\n"+"1:attack"+"\n"+"2:rest"+"\n"+"3:flee"+"\n");
	Scanner s = new Scanner(System.in);
	int a = s.nextInt();
	if(a == 1){
	    System.out.println("\n");
	    attack(other);
	    if(other.getHP() > 0){
		other.randomAttack(you);
		fight(other, you);
	    }
	    else
		System.out.println(other.getName()+" died, you win");
	}
	 if(a == 28){
	    System.out.println("\n");
	    specialAttack(other);
	    if(other.getHP() > 0){
		other.randomAttack(you);
		fight(other, you);
	    }
	    else
		System.out.println(other.getName()+" died, you win");
	   
	 }
	 if(a == 2){
	    System.out.println("\n");
	    rest();
	    other.randomAttack(you);
	    fight(other, you);
	 }
	 if(a == 3)
	     System.out.println("you fled, "+other.getName()+" wins");
	 if(a != 1 && a != 2 && a != 3){
	     System.out.println("Invalid input, try again");
	     fight(other, you);
	 }
	    }
	}
    }


    public void fightGroupOne(Adventurer[] ar, Adventurer enemy){
	int HPcount = 0;
	int x = 0;
        while(x < ar.length){
	    if(ar[x].getHP() > 0){
		HPcount = HPcount + 1;}
	    x++;
	}
	if(HPcount > 0){
	    Scanner sc = new Scanner(System.in);
	    int clap = 0;
	    while(clap < ar.length){
		if(ar[clap].getHP() > 0){
		    System.out.println("Player"+ (clap+1) +" "+ ar[clap].getStats() +"\n");}
		clap++;
	    }
	    int blob = 0;
	    System.out.println(enemy.getStats()+"\n");
	    while(blob < ar.length){
		if(ar[blob].getHP() > 0){
		System.out.println("Player "+(blob+1));
		chooseAttack(ar[blob], enemy);}
		blob++;
	    }
	    if(enemy.getHP() > 0){
		Random r = new Random();
		int hitcount = 0;
		while(hitcount < 2){
		    int a = r.nextInt(ar.length);
		    if(ar[a].getHP() > 0){
			enemy.randomAttack(ar[a]);
			hitcount++;
		    }
		}
		fightGroupOne(ar, enemy);
	    }
	    else{
		System.out.println(enemy.getName() + " is dead, you win");
	    }
	}
	else{
	    System.out.println("Your party died, you loose");
	}
    }



    public void chooseAttack(Adventurer you, Adventurer other){
	Scanner s = new Scanner(System.in);
	System.out.println("Choose attack:"+"\n"+"1:attack"+"2:special"+"3:rest");
	int a = s.nextInt(4);
	if(a == 1){
	    System.out.println("\n");
	    you.attack(other);
	}
	 if(a == 2){
	    System.out.println("\n");
	    you.specialAttack(other);
	 }
	 if(a == 3){
	    System.out.println("\n");
	    you.rest();
	 }
    }

}
