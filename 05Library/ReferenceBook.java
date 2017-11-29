public class ReferenceBook extends LibraryBook{
    private String collection="";

    public ReferenceBook(String a, String t, String i, String call, String collect){
	super(a, t, i, call);
	collection=collect;
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

    //public String getCallNumber(){
    //	return super.getCallNumber();
    //}
    

    public String getCollection(){
	return collection;
    }

    public void checkout(String patron, String due){
	System.out.println("Patron cannot check out a reference book");
    }

    public void returned(){
	System.out.println("Reference book could not have been checked out -- return impossible");
    }
    
    public String circulationStatus(){
	return "Non-circulating reference book";
    }
    
    public String toString(){
	return getAuthor()+", "+getTitle()+", "+getISBN()+", "+getCallNumber()+", "+collection;
    }
}
