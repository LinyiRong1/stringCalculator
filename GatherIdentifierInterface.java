package Assignment1;


public interface GatherIdentifierInterface {
	/*
	 *
	 * Elements: identifiers of the type Identifier from input
	 * Structure: linear
	 * Domain: min:0, max:20
	 *
	 * constructors
	 *
	 * GatherIdentifier(); PRE - POST -A new GatherIdentifier-object has been made
	 * and contains the empty stack.
	 *
	 * GatherIdentifier (GatherIdentifier input); PRE - POST - A new
	 * GatherIdentifier-object has been made and contains a copy of input.
	 *
	 */

	void init();

	/*
	 * PRE -
	 * POST - The stack is empty.
	 */
	void addNewElement(Identifier element);

	/* DO I NEED TO INCREASE SIZE????????
	 * PRE - the amount of elements is less than 20
	 * POST - A copy of element is now on top of the stack.
	 */
	void deleteElement();

	/*USE POP OR TOP?????
	 * PRE - The stack is not empty 
	 * POST - The top of the stack-PRE is returned and deleted.
	 */
	
	
	boolean isEmpty();

	/*
	 * PRE - POST - true: The amount of elements of the stack equals 0. false: the
	 * amount of elements of the stack is greater than 0.
	 */
	int arraySize();
	/*
	 * PRE - POST - The amount of elements of the stack has been returned.
	 */
	
	 int determineArraySize() throws Exception ; 
	/*
	 * PRE - 
	 * POST - success: return the amount of of the stack;
	 *        fail : the amount of elements of stack is >20 ;
	 */
	
	//void printResult() ;
	/*
	 * PRE - 
	 * POST - return a string of the results of identifier
	 
	 */
	
	
//	boolean determineSameIdentifier(Identifier newIdentifier);
	/*
	 * PRE - 
	 * POST - TRUE:  the GatherIdentifier has the same identifier as the new identifier
	 *        FALSE: the GatherIdentifier  does not has the same identifier as the new identifier
	 *        
	 *     
	 */
	
	void deleteSameElements(GatherIdentifier inputIdentifier);
	
	

	 GatherIdentifier processDifference(GatherIdentifier newGatherIdentifier);
	/*
	 * PRE - two GatherIdentifiers
	 * POST - returns GatherIdentifier-object with the differences of
	 * two GatherIdentifiers
	 */
	 GatherIdentifier processIntersection(GatherIdentifier newGatherIdentifier);
	
	/*
	 * PRE - two GatherIdentifiers
	 * POST - GatherIdentifier-object returned containing identifiers which are in both of the GatherIdentifier and newGatherIdentifier.
	 */
	
	 GatherIdentifier processUnion(GatherIdentifier newGatherIdentifier);
	/*
	 * PRE - two GatherIdentifiers 
	 * POST -return GatherIdentifier-object with the all the elements of two GatherIdentifiers
	 */
	
	 GatherIdentifier processSymmetricDifference(GatherIdentifier newGatherIdentifier);
	
	/*
	 * PRE - two GatherIdentifiers 
	 * POST -return GatherIdentifier-object which has all elements of both sets of GatherIdentifier that are not contained in the intersection
	  */
}
