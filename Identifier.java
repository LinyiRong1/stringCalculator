package Assignment1;



public class Identifier implements IdentifierInterface {

	public StringBuffer elementIdentifier;
	
	public Identifier() {
		elementIdentifier = new StringBuffer();
	}
	

	public Identifier(Identifier newIdentifier) {
		this.elementIdentifier = newIdentifier.elementIdentifier;
	}
	
	
	public void init(char source) {
		elementIdentifier = new StringBuffer();
		elementIdentifier.append(source);
		
		
	}
	
	public void addElement(char element){
		
		elementIdentifier.append(element);
		}		
	
	
	
	public char obtainCharElement(int index){
			
		return elementIdentifier.charAt(index);
		
	
	}
	
	public int length() {
		return elementIdentifier.length();
	}
	
	public String transferString() {
		return elementIdentifier.toString();
	}
	
	/*
	 * public void addString(String in){ elementIdentifier.append(in);
	 * 
	 * }
	 */
	
	

}
