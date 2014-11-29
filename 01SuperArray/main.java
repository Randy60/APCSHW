public class main{
    public static void main(String[]args){
	SuperArray Phil = new SuperArray();
	System.out.println(Phil.toString());
	Phil.add(23);
	Phil.add("Paul");
	Phil.add(34.24);
	System.out.println(Phil.toString());
	Phil.resize(2);
	System.out.println(Phil.toString());
	System.out.println(Phil.size());
	Phil.add("Mystery");
	System.out.println(Phil.toString());
	Phil.add(1, 60);
	System.out.println(Phil.toString());
	Phil.add(5, "h");
	System.out.println(Phil.set(2, "newset"));
	System.out.println(Phil.toString());
	System.out.println(Phil.remove(2));
	System.out.println(Phil.toString());
    }
}