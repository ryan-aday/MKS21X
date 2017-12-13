public class TemperatureConverter{
    private static int temp;

    public static void main(String[]args){
	TemperatureConverter a= new TemperatureConverter();
	try{
	    if (args[1].equals("ftc")){
		System.out.println(a.FtoC(Double.parseDouble(args[0])));
	    }else System.out.println(a.CtoF(Double.parseDouble(args[0])));
	}
	catch (ArrayIndexOutOfBoundsException e){
	    System.out.println("Fields not inputed");
	}
    }	

    public TemperatureConverter(){
	    temp=0;
    }

    public static double  FtoC(double f){
	System.out.println(f+ " in Fahrenheit to:");
	return (f-32)*5/9;
    }	

    public static double CtoF(double cel){
	System.out.println(cel+ " in Celcius to:");
	return ((9/5)*cel)+32;
    }	    
}  
