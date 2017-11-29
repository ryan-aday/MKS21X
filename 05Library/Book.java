public class Book{
    private String author;
    private String title;
    private String ISBN;

    public Book(){
	author= "-----";
	title= "-----";
	ISBN="-----";
    }
    
    public Book(String a, String t, String i){
	author=a;
	title=t;
	ISBN=i;
    }

    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public String getISBN(){
	return ISBN;
    }

    public String toString(){
	return author+", "+title+", "+ISBN;
    }
}

