import java.util.ArrayList;

public class SuperArray{

    //PART A
    private String[] data;
    private int size;

    //1
    public SuperArray(){
	data= new String[10];
	size=0;
    }

    //NewStuff
    public SuperArray(int startingCapacity){
	data= new String[startingCapacity];
	size=0;
    }

    public SuperArray(String[] elements){
	data= elements;
    }
 
    //2
    public void clear(){
    data=new String[0];
    size=0;
    }

    public boolean isEmpty(){
    if (size==0){
        return true;
    }return false;
    }

    //3
    public int size(){
	return size;
    }

    public boolean add(String element){
	data[this.size()]=element;
	size++;
	return true;
    }

    //4
    public String toString(){
	String returnString="["+data[0];
	for (int count=1; count<data.length; count++){
	    returnString=returnString+", "+data[count];
	}
	return returnString+"]";
    }

    //5
    public String get(int index){
	if (index>data.length|| index<0){
	    throw new IndexOutOfBoundsException();
	}
	return data[index];
    }    

    //6
    public String set(int index, String element){
	if (index >= data.length){
	    throw new IndexOutOfBoundsException();
	}
	else data[index]=element;
	return "Index "+String.valueOf(index)+" equals "+element+".";
    }

    //PART B

    //7
    public void resize(){
	String[] oldData=this.data;
	data=new String[oldData.length*2];
	for (int count=0; count<oldData.length;count++){
	    data[count]=oldData[count];
	}
	//for (int count=oldData.length; count<data.length;count++){
	//   data[count]=oldData[count-oldData.length];
	//	}
    //size=size*2;
    }

    //PART C

    //8
    public boolean contains(String element){
	for (int count=0; count<data.length; count++){
	    if (data[count]==(element)){
		return true;
	    }}return false;
    }

    //9
    public int indexOf(String element){
	    for (int count=0; count<size; count++){
       	        if (data[count].equals(element)){
		    return count;
		}
	}return -1;
    }

    public int lastIndexOf(String element){
	    for (int count=size-1; count>-1; count--){
       	        if (data[count].equals(element)){
		    return count;
		}
	}return -1;
    }

    //10
    public void add(int index, String element){
	if (index<0 || index>size()){
	    throw new IndexOutOfBoundsException();
	    }
	if (size()==data.length){
	    resize();
	}  
	for (int count=size(); count>index; count--){
		data[count]=data[count-1];
	    }
	data[index]=element;
	size++;
    }	

    //11
   public String remove(int index){
	String[] oldData=data;
	if (index<0){
	    throw new IndexOutOfBoundsException();
	}else if (index>=size){
	    throw new IndexOutOfBoundsException();
	}else data[index]=oldData[index+1];
	for (int count=index+1; count<size-2; count++){
	    data[count]=oldData[count+index+2];
	}
	data[data.length-1]=null;
	size--;
	return oldData[index];
    }	
    
    //12
    public boolean remove(String element){
	String[] oldData=data;
	for (int count=0; count<size; count++){
	    if (data[count].equals(element)){
		data[count]=null;
		for (int ncount=count; ncount<size; ncount++){
		    data[ncount]=oldData[ncount-count];
		}data[size-1]=null;
		size--;
		return true;
	    }
	}return false;
    }

    //Test
    public static void runTest01(int testID){
	if(testID<0){
	    System.out.println("Error in driver usage!");
	    System.exit(0);
	}
	
	SuperArray s1 = new SuperArray();
	ArrayList<String> s2 = new ArrayList<>();
	
	try{
	    if(testID == 0 ){
	    }
	    
	    if(testID == 1 ){
		s1.add("0");
		s2.add("0");
		s1.add("1");
		s2.add("1");
	    }
	    
	    if(testID == 2 ){
		
		s1.add("0");
		s2.add("0");
		s1.add("1");
		s2.add("1");
		s1.add(1,"5");
		s2.add(1,"5");
		s1.add(0,"6");
		s2.add(0,"6");
		s1.add(s1.size()-1,"4");
		s2.add(s2.size()-1,"4");
	    }
	    
	    if(testID == 3 ){
		s1.add("0");
		s2.add("0");
		s1.add("1");
		s2.add("1");
		s1.add(1,"5");
		s2.add(1,"5");
		s1.add(0,"6");
		s2.add(0,"6");
		s1.add(s1.size(),"4");
		s2.add(s2.size(),"4");
	    }
	    
	    if(testID == 4 ){
		s1.add(0,"0");
		s2.add(0,"0");
	    }
	    
	    if(testID == 5 ){
		s1.add("1");
		s2.add("1");
		for(int i = 0; i < 10; i ++){
		    String v = ""+(int)(Math.random()*1000);
		    int in = (int)(Math.random()*s2.size());
		    s1.add(in,v);
		    s2.add(in,v);
		}
	    }
	    
	    if(testID == 6 ){
		try{
		    s1.get(0);
		} catch(IndexOutOfBoundsException e){
		    
		}
	    }
	    
	    if(testID == 7 ){
		try{
		    s1.set(0,"");
		} catch(IndexOutOfBoundsException e){
		    
		}
	    }
	    
	    if(testID == 8 ){
		try{
		    s1.add(1,"");
		} catch(IndexOutOfBoundsException e){
		    
		}
	    }
	    if(testID == 9 ){
		s1.add("1");
		s2.add("1");

		for(int i = 0; i < 1000;   i ++){
		    String v = ""+(int)(Math.random()*1000);
		    int in = (int)(Math.random()*s2.size());
		    s1.add(in,v);
		    s2.add(in,v);
		}
	    }
	    
	    
	}catch(Exception f){
	    s2.add("0");
	    //f.printStackTrace();
	}
	
	if(equals(s1,s2)){
	    System.out.println("Test "+testID+",PASS");
	}else{
	    System.out.println("Test "+testID+",FAIL");
	}
	
	
	
    }
    
    //oops! forgot this
    public static boolean equals(SuperArray s, ArrayList<String> a){
	if(s.size() == a.size()){
	    for(int i = 0; i < s.size(); i++){
		if(! s.get(i).equals( a.get(i))){
		    return false;
		}
	    }
	    return true;
	}
	return false;
    }
    

    public static void main(String[]args){

	runTest01(0);
	runTest01(1);
	runTest01(2);
	runTest01(3);
	runTest01(4);
	runTest01(5);
	runTest01(6);
	runTest01(7);
	runTest01(8);
	runTest01(9);
    }
}
