public class Driver{

    public static void main(String[] args){

    SuperArray a= new SuperArray();
    SuperArray b= new SuperArray();
    System.out.println(a.toString());

    System.out.println("Initialization");
    System.out.println(a.size());
    System.out.println(a.add("one"));
    System.out.println(a.add("two"));
    System.out.println(a.add("three"));
    System.out.println(a.add("four"));
    System.out.println(a.add("five"));
    System.out.println(a.add("six"));
    System.out.println(a.add("seven"));
    System.out.println(a.add("eight"));
    System.out.println(a.add("nine"));
    System.out.println(a.add("ten"));
    System.out.println("\t");

    System.out.println(a.get(3));
    System.out.println(a.toString());
    System.out.println("\t");

    System.out.println(a.set(0, "heywaddup"));
    System.out.println(a.toString());
    System.out.println("\t");

    System.out.println(a.set(6, "getridofmepls"));
    System.out.println(a.toString());
    System.out.println(a.size());
    System.out.println("\t");

    a.remove(8);
    System.out.println(a.toString());
    a.add(8, "newnine");
    System.out.println(a.toString());
    System.out.println("\t");
    a.remove("newnine");
    System.out.println(a.toString());
    a.add(8, "newnine");
    System.out.println(a.toString());
    System.out.println("\t");
    

    System.out.println(a.contains("heywaddup"));
    System.out.println("\t");

    System.out.println(a.indexOf("getridofmepls"));
    System.out.println(a.lastIndexOf("getridofmepls"));
    System.out.println("\t");

    a.resize();
    System.out.println(a.toString());
    System.out.println(a.size());
    System.out.println("\t");

    a.resize();
    System.out.println(a.toString());
    System.out.println("\t");

    a.clear();
    System.out.println(a.isEmpty());
    System.out.println("\t");

    b.add(0, "check");    
    b.add(1, "check"); 
    b.add(2, "check");
    b.add(3, "check");
    b.add(4, "check");
    b.add(2, "f");
    b.add(5, "check");    
    b.add(6, "check"); 
    b.add(7, "check");
    b.add(8, "check");
    b.add(9, "check");
    b.add(10, "f");

    b.add(12, "plds");
    b.add(12, "newplds");
    System.out.println(b.toString());
    System.out.println("\t");

    System.out.println(c.add("2"));    
    System.out.println(c.toString());
    System.out.println(c.size());
    System.out.println("\t");
    
    c.add("one");    
    System.out.println(c.toString());
    System.out.println(c.size());
    System.out.println("\t");

    c.add(1,"two");    
    System.out.println(c.toString());
    System.out.println(c.size());
    System.out.println("\t");
   
    c.add("one");    
    System.out.println(c.toString());
    System.out.println(c.size());
    System.out.println("\t");

    c.add(1,"three");    
    System.out.println(c.toString());
    System.out.println(c.size());
    System.out.println("\t");

    c.add(1,"3");    
    System.out.println(c.toString());
    System.out.println(c.size());
    System.out.println("\t");


    System.out.println(c.indexOf("2"));
    System.out.println(c.indexOf("one"));
    System.out.println(c.lastIndexOf("one"));
    System.out.println(c.indexOf("two"));
    System.out.println(c.indexOf("three"));
    //  System.out.println(c.findIndex("three"));
    
    
    }
}
