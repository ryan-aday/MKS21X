import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;

public class WordSearch{
    private static char[][]data;
    private static Random randgen= new Random();
    private static ArrayList<String>wordsToAdd = new ArrayList<String>();
    private static ArrayList<String>wordsAdded= new ArrayList<String>();

    /**Initialize the grid to the size specified 
     *fill all of the positions with '_'
     *@param row is the starting height of the WordSearch
     *@param col is the starting width of the WordSearch
     */

    public static void main(String[]args){
	String fileName = "fileName.txt";
	int row=0;
	int col=0;
	int seed=(int)(Math.random()*100000);
	File g=new File("rip.txt");
	String key="";
	String key1="fish";
	String key2="key";
	try{
	    wordsToAdd.clear();
	    if (args.length<3){
		throw new NullPointerException();
	    }
	    
	    fileName=args[2].toString();
	    File f = new File(fileName);//can combine
	    Scanner in = new Scanner(f);//into one line
	    while(in.hasNext()){
		String line = in.next();
		//do something with line
		wordsToAdd.add(line);
	    }
	    g=f;
	}catch (FileNotFoundException a){
	    System.out.println("File not found: "+fileName);
	    System.exit(1);
	}catch (NullPointerException b){
	    System.out.println("Minimum number of fields filled out.\nMust fill in this order: Row Column FileName.txt Seed Key\nFor seedless puzzle: Row Column FileName.txt\nFor seeded puzzle: Row Column FileName.txt Seed\nFor puzzle with printed answer key: Row Column FileName.txt Seed Key\n");
	    System.exit(1);
	}
	//	System.out.println(wordsToAdd);
	try{
	    row=Integer.parseInt(args[0]);
	    col=Integer.parseInt(args[1]);
	    if (args.length<4){
		throw new NullPointerException();
	    }
	    seed=Integer.parseInt(args[3]);
	    System.out.println("Seed: "+seed);
	    WordSearch ws= new WordSearch(row, col, g, seed);
	    System.out.println(ws.addAllWords());
	    System.out.println(ws.puzzle());
	    System.out.println(ws.wordsToFind());
	    //System.out.println("Key is 'key' or 'fish'");

	    if (args.length<4){
		throw new ArithmeticException();
	    }else
	    key=args[args.length-1].toString();
	    //System.out.println(args[4].toString());
	    if ((key.equals(key1))||(key.equals(key2))){
		System.out.println(ws.solution());
	    }
	}catch(NullPointerException c){
	    WordSearch ws= new WordSearch(row, col, g);
	    randgen=new Random(seed);
	    System.out.println("Seed: "+seed);
	    System.out.println(ws.addAllWords());
	    System.out.println(ws.puzzle());
	    System.out.println(ws.wordsToFind());
	    System.out.println("Key is 'key' or 'fish'");
	}catch(ArithmeticException d){
	    System.out.println("No or incorrect key.");
	}catch(NumberFormatException e){
	    WordSearch ws= new WordSearch(row, col, g);
	    randgen=new Random(seed);
	    System.out.println("Seed: "+seed);
	    System.out.println(ws.addAllWords());
	    System.out.println(ws.puzzle());
	    System.out.println(ws.wordsToFind());
	    // System.out.println("Key is 'key' or 'fish'");
	    key=args[args.length-1].toString();
	    //System.out.println(args[4].toString());
	    if ((key.equals(key1))||(key.equals(key2))){
		System.out.println(ws.solution());
	    }
	}
	
	//How can we use the file here? Where should you put it?
    }
	
    public WordSearch(int rows,int cols, File filename){
	data=new char[rows][cols];
	if (rows<0 || cols<0){
	    System.out.println("Sizes nonexistent.");
	}else for (int rcount=0; rcount<rows; rcount++){
		for (int ccount=0; ccount<cols; ccount++){
		    data[rcount][ccount]='_';
		}
	    }
    }

    public WordSearch(int rows,int cols, File filename, int randseed){
	randgen=new Random(randseed);
	data=new char[rows][cols];
	if (rows<0 || cols<0){
	    System.out.println("Sizes nonexistent.");
	}else for (int rcount=0; rcount<rows; rcount++){
		for (int ccount=0; ccount<cols; ccount++){
		    data[rcount][ccount]='_';
		}
	    }
    }

    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
	for (int rcount=0; rcount<data.length; rcount++){
	    for (int ccount=0; ccount<data[rcount].length; ccount++){
		data[rcount][ccount]='_';
	     }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
	String dataS= "";
	for (int rcount=0; rcount<data.length; rcount++){
	   dataS+="\n";
	     for (int ccount=0; ccount<data[rcount].length; ccount++){
		dataS+=data[rcount][ccount]+"\t";
	     }
	}return dataS;
    }

    public String puzzle(){
	String puzzle= "";
	String alphabet="abcdefghijklmnopqrstuvwxyz";
	for (int rcount=0; rcount<data.length; rcount++){
	   puzzle+="\n";
	     for (int ccount=0; ccount<data[rcount].length; ccount++){
		if (data[rcount][ccount] == '_'){
		     puzzle+=alphabet.charAt(randgen.nextInt(12)+13)+"\t";
		}else puzzle+=data[rcount][ccount]+"\t";
	     }
	}return puzzle;
    }

    public String solution(){
	String solution= "";
	for (int rcount=0; rcount<data.length; rcount++){
	   solution+="\n";
	     for (int ccount=0; ccount<data[rcount].length; ccount++){
		if (data[rcount][ccount] == '_'){
		     solution+=" \t";
		}else solution+=data[rcount][ccount]+"\t";
	     }
	}return solution;
    }


    public String wordsToFind(){
	String wstuff="\n";
	for (int count=0; count<wordsAdded.size(); count++){
	    wstuff+=wordsAdded.get(count)+"\n";
	}return wstuff;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned 
     * and the board is NOT modified.
     */
    public boolean addWordHorizontal(String word,int row, int col){
	if (row<0 || col<0){
	    return false;
	}
	if (data[row].length-col-word.length()<0){
	    return false;
	}
	
	for (int ccount=0; ccount<word.length(); ccount++){ 	
	    if (data[row][col+ccount]!='_' && data[row][col+ccount]!=word.charAt(ccount)){
		//System.out.println("Overlap between words is bad, or usage of null value.\n");
		    return false;
	    }
	}for (int count=0; count<word.length(); count++){
	    data[row][count+col]=word.charAt(count);
	}return true;
    }

   /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.
     */
    public boolean addWordVertical(String word,int row, int col){
	if (row<0 || col<0){
	    return false;
	}
	if (data.length-row-word.length()<0){
	    return false;
	}
	for (int rcount=0; rcount<word.length(); rcount++){ 
	    if (data[rcount+row][col]!='_' && data[rcount+row][col]!=word.charAt(rcount)){
		//System.out.println("Overlap between words is bad, or usage of null value.\n");
		return false;
	    }
	}for (int count=0; count<word.length(); count++){
	    data[count+row][col]=word.charAt(count);
	}return true;
    }

    public boolean addWordDiagonal(String word,int row, int col){
	if (row<0 || col<0){
	    //System.out.println("Neg val for r or c.");
	    return false;
	}	 
	int wcount=0;
	int rcount=row;
	int ccount=col;
	while (rcount<data.length && ccount<data[row].length){
	    wcount++;
	    rcount++;
	    ccount++;
	}
	//System.out.println(row);
	//System.out.println(wcount);
	int nrcount=0;
	int nccount=0;
	for (int dcount=0; dcount<word.length(); dcount++){
	    if (word.length()>wcount){
		//System.out.print("ERROR: Diagonal space too small for word to fit.\n");
		return false;
	    }if (data[nrcount+row][nccount+col]!='_' && data[nrcount+row][nccount+col]!=word.charAt(dcount)){
		return false;
	    }
	    nrcount++;
	    nccount++;
	}nrcount=0;
	nccount=0;
	for (int count=0; count<word.length(); count++){
	    data[nrcount+row][nccount+col]=word.charAt(count);
	    nrcount++;
	    nccount++;
	}return true;
    }

    public boolean addWordRevDiagonal(String word,int row, int col){	 
	if (row<0 || col<0){
	    //System.out.println("Neg val for r or c.");
	    return false;
	}
	int wcount=0;
	int rcount=row;
	int ccount=col;
	while (rcount>0 && ccount>0){
	    wcount++;
	    rcount--;
	    ccount--;
	}
	//System.out.println(word.length());
	//System.out.println(wcount);
	int nrcount=row;
	int nccount=col;
	if (word.length()>wcount || nrcount-word.length()<0 ||nccount+word.length()>data[0].length){
	    //System.out.print("ERROR: Diagonal space too small for word to fit.\n");
	    return false;
	    }
	for (int dcount=0; dcount<word.length(); dcount++){
	    if (data[nrcount][nccount]!='_' && data[nrcount][nccount]!=word.charAt(dcount)){
		return false;
	    }nrcount--;
	     nccount++;
	}nrcount=row;
	nccount=col;

	for (int count=0; count<word.length(); count++){
	    data[nrcount][nccount]=word.charAt(count);
	    nrcount--;
	    nccount++;
	}return true;
    }

    
    private boolean addWord( int r, int c, String word, int rowIncrement, int colIncrement){
	String rev="";
	    //Horizontals
	if (rowIncrement==0 && colIncrement==0){
	    ///System.out.println("Double null increments.");
	    return false;
        }else if (rowIncrement==0 && colIncrement==1){
	    if (this.addWordHorizontal(word, r, c)){
		return true;
	    }
	}else if (rowIncrement==0 && colIncrement==-1){
	    rev=new StringBuffer(word).reverse().toString();
	    if (this.addWordHorizontal(rev, r, c)){
		return true;
	    }  
	    //Verticals
	}else if (rowIncrement==1 && colIncrement==0){
	    if (this.addWordVertical(word, r, c)){
		    return true;
	    }
	}else if (rowIncrement==-1 && colIncrement==0){
	    rev=new StringBuffer(word).reverse().toString();
	    if (this.addWordVertical(rev, r, c)){
		return true;
	    }
	    //Diagonals
	}else if (rowIncrement==1 && colIncrement==1){
	    if(this.addWordDiagonal(word, r, c)){
		return true;
	    }
	}else if (rowIncrement==-1 && colIncrement==-1){
	    rev=new StringBuffer(word).reverse().toString();
	    if (this.addWordDiagonal(rev, r, c)){
		return true;
	    }
	}else if (rowIncrement==-1 && colIncrement==1){
	    rev=new StringBuffer(word).reverse().toString();
	    if (this.addWordRevDiagonal(rev, r, c)){
		return true;
	    }
	}else if (rowIncrement==1 && colIncrement==-1){
	    if (this.addWordRevDiagonal(word, r , c)){
		return true;
	    }
	}else return false;
	return false;
    }

    public boolean addAllWords(){
	int len=wordsToAdd.size();
	int count=0;
	int row=0;
	int col=0;
	int rInc=0;
	int cInc=0;
	
       	for (int wcount=0; wcount<len; wcount++){
	    count=0;
	    String w= wordsToAdd.get(wcount);
	    while (count<1000){
		//System.out.println("wordsToAdd: "+w);
	    if (this.addWord(row, col, w, rInc, cInc)==true){
		addWord(row, col, w, rInc, cInc);
		wordsAdded.add(w);
		//System.out.println(wordsAdded);
		//System.out.println(this.toString());
		//System.out.println(row);
		//System.out.println(col);
		//System.out.println(rInc);
		//System.out.println(cInc);
		count=1000;
	    }else{
	    row=randgen.nextInt()%data.length;
	    //System.out.println(row);
	    col=randgen.nextInt()%data[0].length;
	    //System.out.println(col);
	    rInc= -1+ randgen.nextInt(3);
	    //System.out.println(w);
	    //System.out.println(rInc);
	    cInc= (-1+ randgen.nextInt(3))*-1;
	    //System.out.println(cInc);
	    count++;
	    }
	    }
	}
	//If size ==3 , problem with the stuff
	for (int Acount=wordsAdded.size()-1; Acount>-1; Acount--){
	    if (wordsToAdd.contains(wordsAdded.get(Acount))){
		wordsToAdd.remove(Acount);
	    }
	}return true;
    }
}
