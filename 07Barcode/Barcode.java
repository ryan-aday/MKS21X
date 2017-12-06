public class Barcode implements Comparable<Barcode>{

    /*public static void main(String[] args) {
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
	

	System.out.println(toCode("12341"));
	System.out.println(toZip("|:::||::|:|::|:|::||::|::|::|:||"));

    }
*/
    //-------------------
    
    private int checkSum;
    private String zip;
    private static String[] cod= {":::||", ":::||",  "::|:|",  "::||:", ":|::|",
			    ":|:|:", ":||::", "|:::|", "|::|:", "|:|::" };

    private boolean numVerif(String abc){
	for (int c= 0; c<abc.length(); c++){
	    if (Character.isDigit(abc.charAt(c))){
		return true;
	    }
	}return false;
    }
    
    public Barcode(String z){
      int check=0;
      int rep=0;
      if (z.length()!=5 || numVerif(z)==false){
	  throw new IllegalArgumentException();
      }
      for (int count=0; count<z.length(); count++){
	  check+= Integer.parseInt(z.substring(count, count+1));
	  //System.out.println(check);
      }
      checkSum=check%10;
      rep=Integer.valueOf(z)*10+checkSum;
      zip=Integer.toString(rep);
    }

    //------------------
    
    public String getZip(){
	return zip.substring(0,5)+"\n";
    }
    
    public String getCode(){
	String cd="|";
	for (int count=0; count<this.zip.length(); count++){
	    cd=cd+ cod[Integer.parseInt(zip.substring(count, count+1))]+"";	  
	}return cd+"|"+"\n";
    }
    
    public String toString(){
	System.out.println(this.getZip());
	return this.getCode()+"\n";
    }

    //-------------------

    public static String ZipS;
    
    public static String toCode(String zip){
	String re="|";
	int numSum=0;
	if (zip.length()!=5){
	    throw new IllegalArgumentException();
	}
	Barcode newBar= new Barcode(zip);
	newBar.ZipS=newBar.getZip();

	for (int count=0; count<5; count++){
	    for (int ncount=0; ncount<10; ncount++){
		if (count==ncount){
		    re+=cod[Integer.parseInt(ZipS.substring(count, count+1))];
		    numSum+=Integer.parseInt(ZipS.substring(count, count+1));
		}
	    }
	}return re + cod[numSum%10]+"|"; 

    }

    public static String codeS;

    public static String toZip(String code){
	Barcode newBar= new Barcode("00000");
	newBar.codeS=code;
	int zipT=0;
	int sum=0;
	for (int count=0; count<code.length(); count++){
	    if (code.charAt(count)!='|' && code.charAt(count)!=':'){
		throw new IllegalArgumentException();
	    }
	}
	if ((code.charAt(0)!='|' && code.charAt(code.length()-1)!='|')||
	    (code.length()!=32)||
	    (code.contains(":::::") || code.contains("|||||"))){
	    throw new IllegalArgumentException();
	}else for (int cou=1; cou<31; cou+=5){
		for (int co=0; co<9; co++){
		    if (cod[co].equals(code.substring(cou, cou+5))){
			zipT= zipT*10+co;
			sum+=co;
			if (cou==26){
			    sum-=co;
			}
		    }
		}
	    }
	if (zipT%10==sum%10){
	    return Integer.toString(zipT/10);
	}else throw new IllegalArgumentException();		
    }



    //-------------------

    
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

