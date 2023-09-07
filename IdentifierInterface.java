package Assignment1;

public interface IdentifierInterface {
	/*
	 *
	 * Elements:  type Char 
	 * Structure: linear
	 *  Domain: first character must be letter,characters which are alphanumeric, no empty.
	 * 
	 * 
	 * constructors
	 *
	 * Identifier(); PRE - POST -A new Identifier-object has been made and contains
	 * the empty . contains undefined values
	 *
	 * Identifier (Identifier source); PRE - POST - A new Identifier-object has been
	 * made and contains a copy of value inside the source.
	 *
	 */

	void init(char source);

	/*
	 * PRE -source only should be letter POST - the identifier contains char
	 * source,the length is 1;
	 */
	int length();

	/*
	 * PRE - POST - The length of content inside the Identifier is returned.
	 */
	void addElement(char element);

	/*
	 * PRE - element is alphanumeric 
	 * POST - an element is alphanumeric of type char
	 * is added to the end of row of elements the size increased by 1.
	 */

	char obtainCharElement(int index);
	/*
	 * PRE - index is smaller the length, index >= 0 
	 * POST - return the char at
	 * certain index
	 */


	String transferString();
	/*
	 * PRE - POST - The identifier is returned as a String.
	 */

}
