public abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    String callNumber;

    public LibraryBook(String a, String t, String i, String c){
	super(a,t,i);
	callNumber=c;
    }
    
    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();

    public String getAuthor(){
	return super.getAuthor();
    }

    public String getTitle(){
	return super.getTitle();
    }

    public String getISBN(){
	return super.getISBN();
    }

    public String getCallNumber(){
	return callNumber;
    }
    
    public int compareTo(LibraryBook other){
	if (this.getCallNumber().compareTo(other.getCallNumber())>0){
	    return 1;
	}else if (this.getCallNumber().compareTo(other.getCallNumber())<0){
	    return -1;
	}else return 0;
    }
    
    public String toString(){
	return getAuthor()+", "+getTitle()+", "+getISBN()+", "+callNumber;
    }
    
}
							  
