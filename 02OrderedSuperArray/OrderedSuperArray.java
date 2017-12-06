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
    /*call the proper add.*/
    public void add(int index, String value){
	add(value);
    }
    /*Write this method and any
      appropriate helper methods.*/
    
    public int indexOfBinary(String element){
	startInd=0;
	endInd=super.size();
	int avg= ((startInd+endInd)/2);
	while (startInd!=endInd){
	    if ((super.get(avg).compareTo(element))>0){
		startInd=endInd/2+1;
	    }else if ((super.get(avg).compareTo(element))<0){
		endInd=endInd/2-1;
	    }else if (super.get(avg).equals(element)){
		return avg;
	    }else return avg;
	}return avg;
    }

    public int indexOf(String element){
	for (int count=0; count<super.size(); count++){
	    if ((super.get(count).compareTo(element))==0){
		return count;
	    }
	}System.out.println("NoSuchElementException()");
	return -1;
    }

    public int lastIndexOf(String element){
	for (int count=super.size()-1; count>-1; count--){
	    if ((super.get(count).compareTo(element))==0){
		return count;
	    }
	}System.out.println("NoSuchElementException");
	return -1;
    }	    

    private int findIndex(String value){
	int stop=-1;
	for (int count=0; count<super.size(); count++){
	    if ((value.compareTo(super.get(count)))>=0)
		stop=count+1;
	}return stop;
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
    
    return -1;
    }

    //REAL PROBLEM: THE INDEX IS REVERSED ONLY FOR THE 
    //BINARY, AND I HAVE NO CLUE HOW TO FIX IT	    
    //Linear's fine

   public boolean add(String value){
	//add to the correct spot.
       if (super.size()==0){
	   super.add(value);
       }else super.add(findIndex(value), value);
       return true;
    }
       
    //you may still use super.add(index,value)	
      
}
