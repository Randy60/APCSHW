public class main{
    public static void main(String[]args){
	OrderedSuperArray Phil = new OrderedSuperArray();
	System.out.println(Phil.toString());
	System.out.println(Phil.size());
	Phil.add("Ambiguous");
	System.out.println(Phil.get(0));
	System.out.println(Phil.toString());
	Phil.add("Paul");
	System.out.println(Phil.toString());
	Phil.add("34.24");
	System.out.println(Phil.toString());
	System.out.println(Phil.size());
	Phil.add("Mystery");
	System.out.println(Phil.toString());
	Phil.add("60");
	System.out.println(Phil.toString());
	Phil.add("h");
	System.out.println(Phil.set(2, "newset"));
	System.out.println(Phil.toString());
	System.out.println(Phil.remove(2));
	System.out.println(Phil.toString());
    }
}