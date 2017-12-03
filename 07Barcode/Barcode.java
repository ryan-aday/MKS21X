public class Barcode implements Comparable<Barcode>{
    public static void main(String[] args) {
	Barcode a= new Barcode(args[0]);
	Barcode b= new Barcode(args[1]);
	System.out.println(a.getZip());
	System.out.println(a.getCode());
	System.out.println(a.toString());
	System.out.println(a.checkCheckSum());

	System.out.println(b.toString());
	System.out.println(b.getZip());
	System.out.println(b.getCode());
	System.out.println(b.toString());
	System.out.println(b.checkCheckSum());	

	System.out.println(a.compareTo(b));
	System.out.println(a.equals(b));
    }
    private int checkSum;
    private String zip;
    private String[] code= {":::||", ":::||",  "::|:|",  "::||:", ":|::|",
			    ":|:|:", ":||::", "|:::|", "|::|:", "|:|::" };
    
    public Barcode(String z){
      int check=0;
      int rep=0;
      for (int count=0; count<z.length(); count++){
	  check+= Integer.parseInt(z.substring(count, count+1));
	  //System.out.println(check);
      }
      checkSum=check%10;
      rep=Integer.valueOf(z)*10+check%10;
      this.zip=Integer.toString(rep);
    }
    
    public String getZip(){
	return zip+"\n";
    }
    
    public String getCode(){
	String cd="|";
	for (int count=0; count<zip.length(); count++){
	    cd=cd+ code[Integer.parseInt(zip.substring(count, count+1))]+"";	  
	}return cd+"|"+"\n";
    }
    
    public String toString(){
	System.out.println(this.zip);
	return this.getCode()+"\n";
    }
    
    public int compareTo(Barcode other){
	if (this.zip.compareTo(other.zip)>0){
	    return 1;
	}else if (this.zip.compareTo(other.zip)<0){
	    return -1;
	}else return 0;
    }

    public boolean equals(Barcode other){
	if (this.zip.compareTo(other.zip)==0){
	    return true;
	}return false;
    }

    private boolean checkCheckSum(){
	if (Integer.parseInt(zip.substring(zip.length()-1, zip.length()))==checkSum){
	    return true;
	}System.out.println(checkSum);
	System.out.println(Integer.parseInt(zip.substring(zip.length()-1, zip.length())));
	return false;
    }
}

