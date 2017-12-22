import java.util.Arrays;
public class Sorts{
  /**EDIT THIS METHOD TO MATCH YOUR NAME 
  */
  public static String name(){
    return "10.Aday.Ryan"; 
  }

  /**Selection sort of an int array. 
  *Upon completion, the elements of the array will be in increasing order.
  *@param data  the elements to be sorted.
  */

                                                                                
    public static boolean isSorted(int[]ary){                                   
        for(int i = 0; i < ary.length - 1 ; i++){                               
            if(ary[i] > ary[i+1]){                                              
                return false;                                                   
            }                                                                   
        }                                                                       
        return true;                                                            
    }                                                                           
                                          
    private static void swap(int[]ary,int a, int b){                            
        int c =ary[a];                                                          
        ary[a] = ary[b];                                                        
        ary[b] = c;                                                             
    }

    public static void bogoSort(int[] ary){                                    
        while(!isSorted(ary)){                                                
            for(int i = 0 ; i < ary.length; i++){                               
                int temp = ary[i];                                              
                int newSpot = (int)(Math.random()*ary.length);                  
                ary[i] = ary[newSpot];                                          
                ary[newSpot] = temp;                                            
            }                                                                 
        }                                                                       
    }                                                                           
                                                                                
    public static void selectionSort(int[] data){
	int min;
	
	for (int count=0; count<data.length-1; count++){
	    min= count;
	    for (int counts=count+1; counts<data.length; counts++){
		if (data[counts]<data[min]){
		    min=counts;
		}
	    }swap(data, count, min);
	}
    }

    public static void insertionSort(int[] data){
	for (int count=1; count < data.length; count++){
	    int min=data[count];
	    int comp=count-1;
	    while(comp >=0  && data[comp]>min){
		data[comp+1]=data[comp];
		comp--;
	    }
	    data[comp+1]=min;
	}
    }
    
    public static void bubbleSort(int[] data){
	int currentIndex, cutoff, swapCount;
	swapCount=0;	
	for (int count=0; count<data.length-1; count++){
	    cutoff=count;
	    
	    for (int check=0; check<data.length-cutoff-1; check++){
		currentIndex=check;
		if (data[currentIndex]>data[currentIndex+1]){
		    swap(data, check, check+1);
		    swapCount++;
		}
	    }
	    if (swapCount==0){
		count=data.length-1;
	    }
	}
    }
					     
    public static void main(String[]artie){                                    
        int[] randish = new int[10];
        
	for(int i = 0 ; i < randish.length; i++){                               
            randish[i] =(int)(Math.random()*100);                               
        }

	System.out.println(Arrays.toString(randish));
	try{
	    if (artie[0].equals("1")){
		bogoSort(randish);
		System.out.println(Arrays.toString(randish));
	    }else if (artie[0].equals("2")){
		bogoSort(randish);
		System.out.println(Arrays.toString(randish));
	    } else if (artie[0].equals("3")){
		bogoSort(randish);
		System.out.println(Arrays.toString(randish));
	    }else if (artie[0].equals("4")){
		bogoSort(randish);
		System.out.println(Arrays.toString(randish));
	    }else System.out.println(Arrays.toString(randish)+"\n No artie input from 1-4");
	}
	catch(ArrayIndexOutOfBoundsException e){
	    System.out.println("No artie input\n"+Arrays.toString(randish)+"\n");
	}

	//swap testing
	//swap(randish, 0, 1);
        //System.out.println(Arrays.toString(randish));   
  
	//bogoSort testing
	//bogoSort(randish);
	//System.out.println(Arrays.toString(randish));   

	//selectionSort testing
	//selectionSort(randish);
	//System.out.println(Arrays.toString(randish));

	//insertionSort testing
        //insertionSort(randish);
        //System.out.println(Arrays.toString(randish));    

	//bubbleSort testing
	//bubbleSort(randish);
	//System.out.println(Arrays.toString(randish));    
    }                                                            
}                                 
