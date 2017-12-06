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
	if (index<0){
	    throw new IndexOutOfBoundsException();
	    }else if (size()==data.length){
	    resize();
	}else for (int count=size(); count>index; count--){
		data[count]=data[count-1];
	    }
	data[index]=element;
	size++;
    }	

    //11
   public String remove(int index){
	String[] oldData=data;
	if (index<0){
	    System.out.println("Index must be an integer = to or greater than 0.");
	    return null;
	}else if (index>=size){
	    System.out.println( "Index must be smaller than the size of the array.");
	    return null;
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
}
