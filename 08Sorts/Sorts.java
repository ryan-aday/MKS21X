import java.util.Arrays;
public class Sorts{
  /**EDIT THIS METHOD TO MATCH YOUR NAME 
  */
  public static String name(){
    return "01.Aday.Ryan"; 
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
                                                                                
    private static void swap(int[]ary,int a, int b){                            
        int c =ary[a];                                                          
        ary[a] = ary[b];                                                        
        ary[b] = c;                                                             
    }

    public static void selectionSort(int[] data){
	int min;
	
	for (int count=0; count<data.length; count++){
	    min= data[count];
	    for (int counts=1; counts<data.length; counts++){
		if (data[counts]<min){
		    swap(data, count, counts);
		    count=0;
		    min=data[count];
		}
	    }
	}
    }

    public static void insertionSort(int[] data){
	for (int count=1; count < data.length-1; count++){
	    if (data[count]>data[count+1]){
		swap(data, count, count+1);
		    }
	}
    }
	    
    
    public static void main(String[]artie){                                    
        int[] randish = new int[5];                                            
        for(int i = 0 ; i < randish.length; i++){                               
            randish[i] =(int)(Math.random()*100);                               
        }
	System.out.println(Arrays.toString(randish));
	swap(randish, 0, 1);
        System.out.println(Arrays.toString(randish));                           
        //      bogoSort(randish);
	System.out.println(Arrays.toString(randish));                         
        insertionSort(randish);
        System.out.println(Arrays.toString(randish));                         
	//	selectionSort(randish);
	System.out.println(Arrays.toString(randish));    
    }                                                            
}                                                                               
                                                       
