import java.util.Scanner;
import java.util.Random;
public class Game{
    public static void main(String[]args){
	Adventurer p1 = new Adventurer();
	System.out.println("you are about to embark on an epic journey, choose your group");
	p1.fightGroupOne(chooseGroup(), selectEnemy());
	System.out.println("game over");
    }


    public static Adventurer[] chooseGroup(){
	Scanner scan = new Scanner(System.in);
	Adventurer[] Addy;
	Addy = new Adventurer[4];
	int i = 0;
	while(i < 4){
	    System.out.println("Player "+ (i + 1) +",");
	    Addy[i] = selectFriend();
	    i++;
	}    
	return Addy;
    }
    public static void chooseAdventurer(){
	Scanner sc = new Scanner(System.in);
	System.out.println("choose a name");
	String i = sc.nextLine();
	System.out.println("your name is "+i+"\n");
	System.out.println("Select your class"+"\n"+"1:Warrior"+"\n"+"2:Wizard"+"\n"+"3:Rogue"+"\n"+"4:Custom"+"\n");
	int x = sc.nextInt();
	    if(x == 1){
		System.out.println("Warrior selected");
		Warrior p1 = new Warrior(i);
		p1.fight(selectEnemy(), p1);
	    }
	    if(x == 2){
		System.out.println("Wizard selected");
		Wizard p1 = new Wizard(i);
		p1.fight(selectEnemy(), p1);
	    }
	    if(x == 3){
		System.out.println("Rogue selected");
		Rogue p1 = new Rogue(i);
		p1.fight(selectEnemy(), p1);
	    }
	    if(x == 4){
		System.out.println("Custom selected, select name, then STR, then INT, then DEX values totalling 40 or less:"+"\n"+"STR=");
		int e = sc.nextInt();
		System.out.println("INT=");
		int f = sc.nextInt();
		System.out.println("DEX=");
		int g = sc.nextInt();
		if(e+f+g <= 40){
		    Adventurer p1 = new Adventurer(i, 40, e, f, g);
		    p1.fight(selectEnemy(), p1);
		}
	    }
    }
    public static Adventurer selectEnemy(){
	    Random r = new Random();

	    int b = r.nextInt();
	    Adventurer enemy = new Adventurer();
	    if(b == 2){
		enemy = new Warrior("Smarshbiorg the evil");}
	    if(b == 3){
		enemy = new Wizard("Harry the Evil");}
	    if(b == 4){
		enemy = new Rogue("Keanue the Evil");}
	    if(b > 4 || b < 2){
		enemy = new Adventurer("Albert the Intolerably Evil");}
	    return enemy;
   }
    public static Adventurer selectEnemyHard(){
	    Random r = new Random();
	    int b = r.nextInt(3) + 1;
	    Adventurer enemy = new Adventurer();
	    if(b == 2){
		enemy = new Warrior(10);}
	    if(b == 3){
		enemy = new Wizard("Harry");
	    }
	    if(b == 4){
		enemy = new Rogue("Keanue");}
	    if(b > 4 || b < 2){
		enemy = new Adventurer();}
	    enemy.setHP(enemy.getHP() * 5);
	    enemy.setSTR(enemy.getSTR() * 2);
	    return enemy;
   }
    public static Adventurer selectFriend(){
	    Scanner r = new Scanner(System.in);
	    System.out.println("Select your class"+"\n"+"1:Warrior"+"\n"+"2:Wizard"+"\n"+"3:Rogue"+"\n"+"4:Custom"+"\n");
	    int b = r.nextInt(5);
	    Adventurer enemy = new Adventurer();
	    if(b == 1){
		System.out.println("Warrior selected");
		enemy = new Warrior("Crazy Dude");}
	    if(b == 2){
		System.out.println("Wizard seylected");
		enemy = new Wizard("Fred");
	    }
	    if(b == 3){
		System.out.println("Rogue selected");
		enemy = new Rogue("McClowski");}
	    if(b == 4){
		System.out.println("Custom selected, select name, then STR, then INT, then DEX values totalling 40 or less:"+"\n"+"STR=");
		int e = r.nextInt();
		System.out.println("INT=");
		int f = r.nextInt();
		System.out.println("DEX=");
		int g = r.nextInt();
		if(e+f+g <= 40){
		    enemy = new Adventurer("John Johnson", 40, e, f, g);
		}
		else{
		    System.out.println("-_-");
		}
	    }
	    if(b > 5 || b < 1){
		enemy = new Adventurer();}
	    return enemy;
   }
}
