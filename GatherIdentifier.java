package Assignment1;

public class GatherIdentifier implements GatherIdentifierInterface {

	private static final int MAX_AMOUNT_OF_ELEMENTS = 20;
	private static final int NUMBER_INCREASING_ARRAY_SIZE = 2;

	private Identifier[] elements;
	private int amountOfElements;

	public GatherIdentifier() {
		elements = new Identifier[MAX_AMOUNT_OF_ELEMENTS];
		amountOfElements = 0;
	}

	private void copyElements(Identifier[] copyIdentifier, Identifier[] sorceIdentifier, int amount) {
		for (int j = 0; j < amount; j++) {
			copyIdentifier[j] = new Identifier(sorceIdentifier[j]);
		}
	}

	public GatherIdentifier(GatherIdentifier sorce) {

		elements = new Identifier[sorce.elements.length];
		amountOfElements = sorce.amountOfElements;

		copyElements(elements, sorce.elements, amountOfElements);
	}

	public void init() {
		amountOfElements = 0;
	}

	private void increaseSize() {
		Identifier[] newResult = new Identifier[NUMBER_INCREASING_ARRAY_SIZE * elements.length];

		copyElements(newResult, elements, amountOfElements);
		elements = newResult;
	}

	public void addNewElement(Identifier element) {
		// NOT DIFFERENT,NOT ADD

		/*
		 * if (determineDifferentIdentifier(element) == false) { return; }
		 */

		if (amountOfElements == elements.length) {
			increaseSize();
		}

		elements[amountOfElements] = new Identifier(element);
		amountOfElements += 1;
	}

	public Identifier getElement() {

		// return identifiers in a string type

		/*
		 * String result = "";
		 * 
		 * 
		 * 
		 * for(int i=0; i< arraySize(); i++){ result = result +
		 * elements[i].transferString() + " ";
		 * 
		 * }
		 * 
		 * String finalResult = result.trim(); //return finalResult;
		 */
		// ======================================

		String result = "";
		Identifier idt = new Identifier();

		for (int i = 0; i < arraySize(); i++) {
			result = result + elements[i].transferString() + " ";

		}

		String finalResult = result.trim();
		// asd asd de eth jyr
		char[] arrayResult = finalResult.toCharArray();

		if (arrayResult.length == 0) {
			return idt;
		}

		idt.init(arrayResult[0]);

		for (int j = 1; j < arrayResult.length; j++) {
			idt.addElement(arrayResult[j]);
		}

		return idt;

		// 实在不行就add(String)!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

		// ==================================================SS
		/*
		 * GatherIdentifier re = new GatherIdentifier();
		 * 
		 * Identifier idt = new Identifier();
		 * 
		 * for (int i = 0; i < arraySize(); i++) { result = result +
		 * elements[i].transferString() + " ";
		 * 
		 * re.add
		 */
		// System.out.print(elements[i].transferString());
		/*
		 * if(i != arraySize() -1){ System.out.print(" "); }
		 */
	}

	// System.out.print(finalResult + "}");
	// int count =arraySize() ;

	/*
	 * count = count - 1 ; return elements[count - 1];
	 */

	/*
	 * int temp = 0;
	 * 
	 * return elements[temp];
	 */

	public void deleteElement() {
		amountOfElements -= 1;
	}

	public boolean isEmpty() {
		return amountOfElements == 0;
	}

	public int arraySize() {
		return amountOfElements;
	}

	public int arrayLength() {
		return elements.length;
	}

	public int determineArraySize() throws Exception {
		if (amountOfElements > 20) {
			throw new Exception("the amount of elements is > 20");
		}

		return amountOfElements;
	}

	/*
	 * public void printResult() {
	 * 
	 * String result = ""; System.out.print("{");
	 * 
	 * 
	 * 
	 * for(int i=0; i< arraySize(); i++){ result = result +
	 * elements[i].transferString() + " ";
	 * //System.out.print(elements[i].transferString());
	 * 
	 * if(i != arraySize() -1){ System.out.print(" "); }
	 * 
	 * }
	 * 
	 * String finalResult = result.trim(); System.out.print(finalResult + "}"); }
	 */

	// return;
	/*
	 * if (amountOfElements == 0) { System.out.print(""); }
	 */

	/*
	 * for (int i = 0; i < arraySize(); i++) {
	 * 
	 * if (i <( arraySize() - 1)) { System.out.print(elements[i].transferString() +
	 * " "); } else { System.out.print(elements[i].transferString()); }
	 */

	/*
	 * System.out.print(elements[i].transferString() );
	 * 
	 * if (i <( arraySize() - 1)) { System.out.print(" "); }
	 */

	// System.out.print("}");

	/*
	 * public boolean determineDifferentIdentifier(Identifier newIdentifier) {
	 * boolean check;
	 * 
	 * int j = 0;
	 * 
	 * while (j < arraySize()) {
	 * 
	 * if (elements[j].transferString().equals(newIdentifier.transferString())) { //
	 * has same identifier check = false; return check; }
	 * 
	 * j++; }
	 */

	/*
	 * for (int i = 0; i < arraySize(); i++) {
	 * 
	 * if (elements[i].transferString().equals(newIdentifier.transferString())) {
	 * //not different check = false; return check; } }
	 */
	/*
	 * check = true; return check;
	 * 
	 * }
	 */

	// delete same elements from one array
	public void deleteSameElements(GatherIdentifier inputIdentifier) {

		for (int i = 0; i < inputIdentifier.amountOfElements; i++) {
			for (int j = i + 1; j < inputIdentifier.amountOfElements; j++) {

				if (inputIdentifier.elements[i].transferString().equals(inputIdentifier.elements[j].transferString())) {

					inputIdentifier.elements[j] = inputIdentifier.elements[inputIdentifier.amountOfElements - 1];
					inputIdentifier.amountOfElements--;

					j--;
				}
			}
		}
	}

	/*
	 * public void deleteDuplicateElements() {
	 * 
	 * int no_unique_elements =amountOfElements ; int count = 0 ;
	 * 
	 * for (int i = 0; i < no_unique_elements; i++) { for (int j = i + 1; j <
	 * no_unique_elements; j++) {
	 * 
	 * if (elements[i].transferString().equals(elements[j].transferString())) {
	 * 
	 * elements[j] = elements[no_unique_elements - 1]; count ++;
	 * no_unique_elements--;
	 * 
	 * j--; } } }
	 * 
	 * Identifier[] newArray = new Identifier[amountOfElements - count];
	 * 
	 * for (int i = 0; i <amountOfElements - count ; i++ ) { newArray[i] =
	 * elements[i]; System.out.print(newArray[i]. transferString() + " "); }
	 * 
	 * elements = newArray;
	 */

	/*
	 * for (int i = 0; i < amountOfElements; i++) { for (int j = i + 1; j <
	 * amountOfElements; j++) {
	 * 
	 * if (elements[i].transferString().equals(elements[j].transferString())) {
	 * 
	 * elements[j] = elements[amountOfElements - 1];
	 * 
	 * amountOfElements--;
	 * 
	 * j--; } } }
	 */
	// }

	/*
	 * public void addWithoutSameElements(Identifier source) { if
	 * (this.determineSameIdentifier(source)) { return; }
	 * 
	 * elements[amountOfElements] = new Identifier(source); amountOfElements += 1; }
	 */
	/*
	 * public GatherIdentifier deleteIdenticalElements(Identifier member,
	 * GatherIdentifier sorce){
	 * 
	 * for (int i = 0; i < amountOfElements; i++) { if
	 * (sorce.elements[i].transferString().equals(member.transferString())){
	 * 
	 * for (int j = i; j < amountOfElements-1; j++) { sorce.elements[j] =
	 * sorce.elements[j + 1]; } sorce.amountOfElements -= 1;
	 * 
	 * sorce = new GatherIdentifier(sorce,1);
	 * 
	 * return sorce; } } return sorce; }
	 */

	public GatherIdentifier processDifference(GatherIdentifier newGatherIdentifier) {

		GatherIdentifier differentIdentifiers = new GatherIdentifier();

		// -------------------------------------------------!!!!!!!!!!!!!!!!------------------------------------------------------
		// test , public String transferString() =toString !!!!!!!
		/*
		 * 
		 * for (int i = 0; i < amountOfElements; i++) { for (int j = 0; j <
		 * newGatherIdentifier.amountOfElements; j++) { if
		 * (elements[i].transferString().equals(newGatherIdentifier.elements[j].
		 * transferString())) { differentIdentifiers =
		 * differentIdentifiers.deleteIdenticalElements(elements[i],
		 * differentIdentifiers); } } }
		 */
		// ------------------------------------------------!!!!!!!!!!!!!!!!!!!!-------------------------------------------------------

		/*
		 * for (int i = 0; i <differentIdentifiers. amountOfElements; i++) {
		 * 
		 * if (elements[i].transferString().equals(newGatherIdentifier.elements[j].
		 * transferString())) { differentIdentifiers =
		 * differentIdentifiers.deleteIdenticalElements(elements[i],
		 * differentIdentifiers); }
		 * 
		 * }
		 */

		Identifier[] newIdentifierArray = new Identifier[400000];
		int count = 0;
		Identifier[] temp;

		for (int i = 0; i < amountOfElements; i++) {
			int j;

			for (j = 0; j < newGatherIdentifier.amountOfElements; j++) {
				if (elements[i].transferString().equals(newGatherIdentifier.elements[j].transferString()))
					break;
			}

			if (j == newGatherIdentifier.amountOfElements) {

				newIdentifierArray[count] = elements[i];
				count++;
			}

		}
		temp = new Identifier[count];

		for (int i = 0; i < temp.length; i++) {
			temp[i] = newIdentifierArray[i];

			differentIdentifiers.addNewElement(temp[i]);
		}

		// 得到处理完的数组

		/*
		 * for (int i = 0; i < temp.length; i++) { System.out.println(temp[i] +
		 * "================== "); }
		 */

		/*
		 * for (int i = 0; i < newGatherIdentifier.amountOfElements; i++) { for (int j =
		 * 0; j < amountOfElements; j++) { if
		 * (!newGatherIdentifier.elements[i].transferString()
		 * .equals(elements[j].transferString())) {
		 * 
		 * differentIdentifiers.addWithoutSameElements(newGatherIdentifier.elements[i]);
		 * } } }
		 */

		// should use this or not ????------------------------------------------
		differentIdentifiers.deleteSameElements(differentIdentifiers);

		return differentIdentifiers;

	}

	public GatherIdentifier processIntersection(GatherIdentifier newGatherIdentifier) {

		GatherIdentifier intersectionIdentifier = new GatherIdentifier();

		for (int i = 0; i < amountOfElements; i++) {
			for (int j = 0; j < newGatherIdentifier.amountOfElements; j++) {
				if (elements[i].transferString().equals(newGatherIdentifier.elements[j].transferString())) {
					intersectionIdentifier.addNewElement(elements[i]);
				}
			}

		}

		intersectionIdentifier.deleteSameElements(intersectionIdentifier);

		return intersectionIdentifier;
	}

	public GatherIdentifier processUnion(GatherIdentifier newGatherIdentifier) {

		GatherIdentifier unionIdentifier = new GatherIdentifier(this);

		for (int i = 0; i < newGatherIdentifier.arraySize(); i++) {

			unionIdentifier.addNewElement(newGatherIdentifier.elements[i]);

		}

		unionIdentifier.deleteSameElements(unionIdentifier);

		return unionIdentifier;

	}

	public GatherIdentifier processSymmetricDifference(GatherIdentifier newGatherIdentifier) {

		GatherIdentifier symmetricDifferenceIdentifier = this.processDifference(newGatherIdentifier);

		GatherIdentifier temp = newGatherIdentifier.processDifference(this);

		for (int i = 0; i < temp.arraySize(); i++) {

			symmetricDifferenceIdentifier.addNewElement(temp.elements[i]);

		}

		/*
		 * for (int i = 0; i < newGatherIdentifier.arraySize(); i++) { if
		 * (determineDifferentIdentifier(newGatherIdentifier.elements[i])) {
		 * symmetricDifferenceIdentifier.add(newGatherIdentifier.elements[i]); } }
		 */

		symmetricDifferenceIdentifier.deleteSameElements(symmetricDifferenceIdentifier);

		return symmetricDifferenceIdentifier;
	}

}
