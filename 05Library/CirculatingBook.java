public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String a, String t, String i, String c){
	super(a, t, i, c);
	super.callNumber=c;
    }

    public String getAuthor(){
	return super.getAuthor();
    }

    public String getTitle(){
	return super.getTitle();
    }

    public String getISBN(){
	return super.getISBN();
    }

    
    public String getCurrentHolder(){
	return currentHolder;
    }

    public String getDueDate(){
	return dueDate;
    }

    public void checkout(String patron, String due){
	currentHolder=patron;
	dueDate=due;
    }

    public void returned(){
	currentHolder=null;
	dueDate=null;
    }

    public String circulationStatus(){
	if (currentHolder==null){
	    return  "Book available on shelves.";
	}return "Current Holder: "+getCurrentHolder()+", Due Date: "+getDueDate();
    }

    public String toString(){
	return getAuthor()+", "+getTitle()+", "+getISBN()+", "+getCallNumber()+", "+currentHolder+", "+dueDate;
    }
}
