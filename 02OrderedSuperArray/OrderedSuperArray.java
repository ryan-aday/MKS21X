import java.util.*;

public class OrderedSuperArray extends SuperArray{
    private int startInd;
    private int endInd;

    /*constructor initializes an empty List*/
    public OrderedSuperArray(){
	//Complete this.
	super();
    }

    public OrderedSuperArray(int capacity){
	super(capacity);
    }

    public OrderedSuperArray(String[] elements){
	super(elements.length);
	for (int count=0; count<elements.length; count++){
	    add(elements[count]);
	}
    }	

    /*call the proper add.*/
    public void add(int index, String value){
	add(value);
    }
    /*Write this method and any
      appropriate helper methods.*/
    
    public int indexOfBinary(String element){
	startInd=0;
	endInd=super.size();
	int avg= (startInd+endInd)/2;
	if (super.size()==0){
	    super.add(element);
	}
	while (startInd!=endInd){
	    avg=(startInd+endInd)/2;
	    if ((super.get(avg).compareTo(element))>0){
		startInd=avg;
		System.out.println(startInd);
		System.out.println(endInd+"\n");
	    }else if ((super.get(avg).compareTo(element))<0){
		endInd=avg;
		System.out.println(startInd);
		System.out.println(endInd+"\n");
	    }else return avg;
	}return avg;
    }

    public int indexOf(String element){
	for (int count=0; count<super.size(); count++){
	    if ((super.get(count).compareTo(element))==0){
		return count;
	    }
	}throw new NoSuchElementException();
    }

    public int lastIndexOf(String element){
	for (int count=super.size()-1; count>-1; count--){
	    if ((super.get(count).compareTo(element))==0){
		return count;
	    }
	}throw new NoSuchElementException();
    }	    

    private int findIndex(String value){
	int index=0;
	for (int count=0; count<super.size(); count++){
	    if ((value.compareTo(super.get(count)))>=0)
		index=count+1;
	}return index;
    }

    private int findIndexBinary(String value){
    int start = 0;
    int end = super.size()-1;
    int current=0;
 
    while (start <= end) {
        current = (start + end) / 2;
	
        if (value.compareTo(super.get(current))<0) {
            start  = current + 1;
	}
        else if (value.compareTo(super.get(current))<0) {
            end = current - 1;
        }
        else {
            return current;
        }
    }
    throw new NoSuchElementException();
    }
    
    //REAL PROBLEM: THE INDEX IS REVERSED ONLY FOR THE 
    //BINARY, AND I HAVE NO CLUE HOW TO FIX IT	    
    //Linear's fine

    public String set(int index, String value){
	throw new UnsupportedOperationException();
    } 

   public boolean add(String value){
	//add to the correct spot.
       if (super.size()==0){
	   super.add(value);
       }else super.add(findIndex(value), value);
       return true;
    }
       
    //you may still use super.add(index,value)	

    public static void runTest02(int testID){
	
	if(testID<0){
	    System.out.println("Error in driver usage!");
	    System.exit(0);
	}
	
	OrderedSuperArray s1 = new OrderedSuperArray();
	ArrayList<String> s2 = new ArrayList<>();
	
	try{
	    if(testID == 0 ){
	    }
	    
	    if(testID == 1 ){
		s1.add("4");
		s2.add("4");
		s1.add("1");
		s2.add("1");
		s1.add("0");
		s2.add("0");
	    }
	    
	    if(testID == 2 ){
		s1.add("3");
		s2.add("3");
		s1.add("1");
		s2.add("1");
		s1.add("5");
		s2.add("5");
		s1.add("0");
		s2.add("0");
	    }
	    
	    if(testID == 3 ){
		s1.add("1");
		s2.add("1");
		for(int i = 0; i < 10; i ++){
		    String v = ""+(int)(Math.random()*1000);
		    int in = (int)(Math.random()*s2.size());
		    s1.add(in,v);
		    s2.add(in,v);
		}
	    }
	    
	    if(testID == 4 ){
		s1.add("1");
		s2.add("1");
		try{
		    s1.set(0,"");
		} catch(UnsupportedOperationException e){
		    
		}
	    }
	    
	    if(testID == 5 ){
		try{
		    s1.set(0,"");
		} catch(UnsupportedOperationException e){
		    
		}
	    }
	    
	    if(testID == 6 ){
		String[] x= {"adsf","b","X","C","fish","cat","Abby","break","romp"};
		s1 = new OrderedSuperArray(x);
		s2.addAll(Arrays.asList(x));
	    }
	    if(testID == 7 ){
		s1.add("1");
		s2.add("1");
		
		for(int i = 0; i < 1000;   i ++){
		    String v = ""+(int)(Math.random()*1000);
		    s1.add(v);
		    s2.add(v);
		}
	    }
	    
	    
	}catch(Exception f){
	    s2.add("0");
	    //f.printStackTrace();
	}
	
	Collections.sort(s2);
	if(equals(s1,s2)){
	    System.out.println("Test "+testID+",PASS");
	}else{
	    System.out.println("Test "+testID+",FAIL!");// "+s1+"!="+s2);
	}
    }
    
    
    //oops!
    public static boolean equals(OrderedSuperArray s, ArrayList<String> a){
	if(s.size() == a.size()){
	    for(int i = 0; i < s.size(); i++){
		if(!s.get(i).equals( a.get(i))){
		    return false;
		}
	    }
	    return true;
	}
	return false;
    }

    public static void main (String[ ]args){
	runTest02(0);
	runTest02(1);
	runTest02(2);
	runTest02(3);
	runTest02(4);
	runTest02(5);
       	runTest02(6);
	runTest02(7);
    }
}
