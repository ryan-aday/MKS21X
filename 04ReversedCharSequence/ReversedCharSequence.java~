public class ReversedCharSeq implements CharSequence{
    private String data="";
    
    public static void main (String[]args){
	ReversedCharSeq b = new ReversedCharSeq("hello");
	System.out.println(b.toString());
	System.out.println(b.charAt(3));
	System.out.println(b.length());
	System.out.println(b.subSequence(2, 4));
    }

    public ReversedCharSeq(){
	data="";
    }

    public ReversedCharSeq(String seq){
	for (int ccount=seq.length(); ccount>0; ccount--){
	    data=data.concat(seq.substring(ccount-1, ccount));
	}
    }

    public char charAt(int index){
	if (index>-1 && index< data.length()){
	    return data.charAt(index);
	}throw new IndexOutOfBoundsException();
    }

    public int length(){
	return data.length();
    }

    public String toString(){
	return data;
    }

    public CharSequence subSequence(int start, int end){
	if (start>-1 && end< data.length()){
	    if (start==end){
		return "";
	    }else return data.substring(start, end+1);
	}throw new IndexOutOfBoundsException();
    }
}

