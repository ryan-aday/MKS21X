import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{
    private SuperArray currentA;
    private int currentE;
    private int startP=0;


    public SuperArrayIterator(SuperArray sa){
	this.currentA= sa;
	this.currentE= sa.size();
    }
    
    public boolean hasNext(){
	return startP<=currentE;
    }
    
    public String next(){
	return this[startP+1];
    }

    public void remove(){
    
    }

    public SuperArray getCurrentA(){
	return currentA;
    }
    public int getCurrentE(){
	return currentE;
    }
	
}
