public class TemperatureConverter{
    private static int temp;

    public static void main(String[]args){
	TemperatureConverter a= new TemperatureConverter();
	try{
	    if (args[1].equals("ftc")){
		System.out.println(a.FTC(Float.parseFloat(args[0])));
	    }else System.out.println(a.CTF(Float.parseFloat(args[0])));
	}
	catch (ArrayIndexOutOfBoundsException e){
	    System.out.println("Fields nnot inputed");
	}
    }	

    public TemperatureConverter(){
	    temp=0;
    }

    public float FTC(float f){
	System.out.println(f+ " in Fahrenheit to:");
	return (f-32)*5/9;
    }	

    public float CTF(float cel){
	System.out.println(cel+ " in Celcius to:");
	return ((9/5)*cel)+32;
    }	    
}  
