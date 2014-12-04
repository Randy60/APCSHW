import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;


public class wordSearch{
    public char[][] box;
    Random r = new Random();
    ArrayList<String> Limp = new ArrayList<String>(10);
    ArrayList<String> Words = new ArrayList<String>(10);
    public wordSearch(int x, int y, int seed) throws FileNotFoundException{
	if(x == 0 || y == 0){
	    x = 10;
	    y = 10;
	    System.out.println("You're a tricky one aren't you");
	 
	}
	r = new Random(seed);
	box = new char[y][x];
	clear(box);
	File text = new File("words.txt");
	Scanner s = new Scanner(text);
	while (s.hasNext()){
	    Limp.add(s.next());
	}
    }
    public wordSearch(int x, int y) throws FileNotFoundException{
	if(x == 0 || y == 0){
	    x = 10;
	    y = 10;
	    System.out.println("You're a tricky one aren't you");
	 
	}
	box = new char[y][x];
	clear(box);
	File text = new File("words.txt");
	Scanner s = new Scanner(text);
	while (x < 150){
	    Limp.add(s.next());
	    x++;
	}
    }
    public wordSearch(int square) throws FileNotFoundException {
	this(square, square);
    }
    public wordSearch() throws FileNotFoundException {
	this(10);
    }
    public void setSeed(int i){
	r = new Random(i);
    }
    public String getWord() throws FileNotFoundException {
	int a = r.nextInt(Limp.size());
	String x = Limp.get(a);
	return x;
    }
    public void fill(){
	for(int i = 0; i < box.length; i++){
	    for(int x = 0; x < box[i].length; x++){
		if(box[i][x] == '_')
		    box[i][x] = (char)('a'+r.nextInt(26));
	    }
	}
    }
    
    public void clear(char[][] ar){
	for(int x = 0; x < ar.length; x++){
	    for(int i = 0; i < ar[x].length; i++){
		ar[x][i] = '_';
	    }
	}
    }
    public String toString(){
	String s = "";
	for(int x = 0; x < box.length; x++){
	    for(int i = 0; i < box[x].length; i++){
		s = s + box[x][i] + " ";
	    }
	    s = s + "\n";
	}
	return s;
    }
    public boolean checkWordOmn(String s, int y, int x, int dx, int dy){
	int a = x;
	int b = y;
	if(dx == 0 && dy == 0)
	    return false;
	for(int i = 0; i < s.length(); i++){
	    //System.out.println(a +" "+ b);
	    if(a >= box[0].length || b >= box.length){
		return false;
	    }

	    if( a < 0 || b < 0){
		return false;
	    }
	    if(s.charAt(i) != box[b][a] &&  box[b][a] != '_')
		return false;
	    a += dx;
	    b -= dy;
	}
	return true;
    }
    public void addWordOmn(String s, int x, int y, int dx, int dy){
	    for(int i = 0; i < s.length(); i++){
		box[y][x] = s.charAt(i);
		x+=dx;
		y-=dy;
	    }
    }

    public boolean addWord(String s, int tries){
	if(tries == 0)
	    return false;
	int dx = r.nextInt(2);
	int dy = r.nextInt(3) - 1;
	int y = 0;
	int x = 0;

	y = r.nextInt(box.length);
	x = r.nextInt(box[0].length);

	if(checkWordOmn(s, y, x, dx, dy)){
	    addWordOmn(s,  x, y, dx, dy);
	    return true;
	}
	    return addWord(s, --tries);
    }
    
    public void WordMe(){
	System.out.println(Words.toString());
    }
    public void addWords(int i) throws FileNotFoundException {
	int x = 0;
	while(x < i){
	    String q = new String(getWord());
	    if(addWord(q, 100)){
		Words.add(q);
		    x++;
	    }
	}

    }
}