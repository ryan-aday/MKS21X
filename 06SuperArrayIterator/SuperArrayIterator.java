private class SuperArrayIterator implements Iterator<String>{
    int start;
    int end;
    SuperArray data;
	
    public SuperArrayIterator(int start, int end){
	this.start=start;
	this.end=end;
    }
    
    public boolean hasNext(){
	return start<end;
    }
    
    public String next(){
	while (hasNext()){
	    start++;
	    return get(start-1);
	}return get(end-1);
    }
    
    public void remove(){
	throw new UnsupportedOperationException();
    }
}
