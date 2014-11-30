import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class wordSearch{
    public char[][] box;
    Random r = new Random();
    public wordSearch(int x, int y, int seed){
	if(x == 0 || y == 0){
	    x = 10;
	    y = 10;
	    System.out.println("You're a tricky one aren't you");
	 
	}
	r = new Random(seed);
	box = new char[y][x];
	clear(box);
    }
    public wordSearch(int x, int y){
	if(x == 0 || y == 0){
	    x = 10;
	    y = 10;
	    System.out.println("You're a tricky one aren't you");
	 
	}
	box = new char[y][x];
	clear(box);
    }
    public wordSearch(int square){
	box = new char[square][square];
	clear(box);
    }
    public wordSearch(){
	box = new char[10][10];
	clear(box);
    }
    public String getWord() throws FileNotFoundException {
	File text = new File("words.txt");
	Scanner s = new Scanner(text);
	for(int i = 0; i < r.nextInt(149); i++){
	    s.next();
	}
	return s.next();
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
	if(box.length < s.length() || box[1].length < s.length())
	    return false;
	int a = x;
	int b = y;
	for(int i = 0; i < s.length(); i++){
	    if(s.charAt(i) != box[a][b] && box[a][b] != '_')
		return false;
	    a += dx;
	    b -= dy;
	}
	return true;
    }
    public boolean addWordOmn(String s, int x, int y, int dx, int dy){
	if((dx != 0) || (dy != 0) && checkWordOmn(s, y, x, dx, dy)){
	    for(int i = 0; i < s.length(); i++){
		box[y][x] = s.charAt(i);
		x+=dx;
		y-=dy;
	    }
	    return true;
	}
	else
	    return false;
    }
    public boolean addWord(String s, int tries){
	if(tries == 0)
	    return false;
	else{
	    int dx = r.nextInt(2);
	    int dy = r.nextInt(3) - 1;
	    int y = 0;
	    if(dy == 1)
		y = r.nextInt(box.length - s.length()) + s.length();
	    if(dy == -1)
		y = r.nextInt(box.length - s.length());
	    if(addWordOmn(s, r.nextInt(box[y].length - (dx * s.length())), y, dx, dy))
		return true;
	}
	    return addWord(s, tries--);
    }
    public void fill(){
	for(int i = 0; i < box.length; i++){
	    for(int x = 0; x < box[i].length; x++){
		if(box[i][x] == '_')
		    box[i][x] = (char)('a'+r.nextInt(26));
	    }
	}
    }
    
    public void addWords(int i) throws FileNotFoundException {
	int x = 0;
	String[] str = new String[i];
	while(x < i){
	    String q = new String();
	    q = getWord();
	    if(addWord(q, 100)){
		str[x] = q;
		x++;    
	    }
	    System.out.println(Arrays.toString(str));
	}
    }
}