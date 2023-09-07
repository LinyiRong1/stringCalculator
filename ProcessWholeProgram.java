package Assignment1;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;


public class ProcessWholeProgram {

	private static final String FIRST_SET = "Give the first set: ";
	private static final String SECOND_SET = "Give the second set: ";
	private static final int MAX_NUMBER_OF_ELEMENTS = 10;

	GatherIdentifier tempLine;
	GatherIdentifier firstLine;
	GatherIdentifier secondLine;

	private PrintStream out;

	public ProcessWholeProgram() {
		out = new PrintStream(System.out);

	}

	public static void main(String[] args) {
		
		new ProcessWholeProgram().start();
	}

	boolean tempCorrectSet(Scanner in, GatherIdentifier set) {
		try {
			return inputContainsCorrectSet(in, set);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	boolean askSet(Scanner input, String question, GatherIdentifier set) {
		do {
			out.print(question);
			// out.printf("%s", question);

			if (!input.hasNextLine()) {
				out.println();
				// out.printf("\n");
				return false;
			}
		} while (!tempCorrectSet(input, set));
		return true;
	}

	boolean askBothSets(Scanner input, GatherIdentifier set1, GatherIdentifier set2) {

		boolean temp1;
		boolean temp2;
		if (askSet(input, FIRST_SET, set1)) {
			temp1 = true;

			firstLine = new GatherIdentifier(tempLine);

		} else {
			temp1 = false;
			System.exit(0);
		}

		if (askSet(input, SECOND_SET, set2)) {
			temp2 = true;
			secondLine = new GatherIdentifier(tempLine);
		} else {
			temp2 = false;
			System.exit(0);
		}

		return temp1 && temp2;

	}

	void start() {
		Scanner in = new Scanner(System.in);

		GatherIdentifier set1 = new GatherIdentifier();
		GatherIdentifier set2 = new GatherIdentifier();

		while (askBothSets(in, set1, set2)) {

			calculateResults(firstLine, secondLine);
			out.println();
		}
	}

	int ifExceedTheAmountOfElements(GatherIdentifier result, Identifier identifier) {

		result.addNewElement(identifier);

		result.deleteSameElements(result);

		if (result.arraySize() > MAX_NUMBER_OF_ELEMENTS) {
			return 1;
		}
		return 0;
	}

	int ifTheRestOfElementsHaveCorrectForm(char[] theRestOfInputarray, Identifier identifier) throws Exception {

		for (int j = 1; j < theRestOfInputarray.length; j++) {
			if (Character.isLetterOrDigit(theRestOfInputarray[j])) {
				identifier.addElement(theRestOfInputarray[j]);
			} else {

				throw new Exception("Only alphanumeric characters are allowed as elements of an identifier.");
			}
		}

		return 0;
	}

	int ifTheFirstElementIsLetter(Scanner wholeLine, Identifier identifier) throws Exception {

		String theRestOfInput = wholeLine.next();
		char[] theRestOfInputArray = theRestOfInput.toCharArray();

		if (Character.isLowerCase(theRestOfInputArray[0]) || Character.isUpperCase(theRestOfInputArray[0])) {
			identifier.init(theRestOfInputArray[0]);
		} else {
			throw new Exception("An identifier must begin with a letter.");
		}

		int ifTheRestOfElementsHaveCorrectForm = ifTheRestOfElementsHaveCorrectForm(theRestOfInputArray, identifier);
		return ifTheRestOfElementsHaveCorrectForm;
	}

	int ifInputLastElementCorrect(String input) throws Exception {
		char[] charArray = input.toCharArray();

		if (!(input.charAt(input.length() - 1) == '}')) {
			for (int i = 0; i < input.length() - 2; i++) {
				if (charArray[i] == '}') {
					throw new Exception("input instead of eoln");
				}
			}
			throw new Exception("} is missing ");
		}
		return 0;
	}

	int ifInputFirstElementCorrect(String userInput) throws Exception {

		// update===================================================================
		StringBuffer tempString = new StringBuffer(userInput);

		Identifier idt = new Identifier();
		idt.elementIdentifier = tempString;

		// (userInput.charAt(0) == '{')

		if (!(idt.obtainCharElement(0) == '{')) {

			throw new Exception("{ is missing");
		}

		int ifInputLastElementCorrect = ifInputLastElementCorrect(userInput);
		return ifInputLastElementCorrect;
	}

	int ifInputIsEmpty(String userInput) throws Exception {

		if (userInput.length() == 0) {
			return 1;
		}

		int ifInputFirstElementCorrect = ifInputFirstElementCorrect(userInput);
		return ifInputFirstElementCorrect;
	}

	boolean inputContainsCorrectSet(Scanner input, GatherIdentifier set) throws Exception {

		int count = 0;

		String newUserInput = input.nextLine();
		newUserInput = newUserInput.replace((char) 12288, ' ');
		newUserInput = newUserInput.trim();

		int ifInputIsEmpty = ifInputIsEmpty(newUserInput);
		if (ifInputIsEmpty == 1) {
			return false;
		}

		String inputLine = newUserInput.substring(1, newUserInput.length() - 1);
		Scanner wholeLine = new Scanner(inputLine);

		Identifier identifier = new Identifier();
		GatherIdentifier result = new GatherIdentifier();

		while (wholeLine.hasNext()) {
			count = ifTheFirstElementIsLetter(wholeLine, identifier) + ifExceedTheAmountOfElements(result, identifier);
		}

		int exceedCapacity = ifExceedTheAmountOfElements(result, identifier);

		if (exceedCapacity > 0) {
			throw new Exception("TOO MANY IDENTIFIERS");
		}

		if (count != 0) {
			return false;
		}

		tempLine = new GatherIdentifier(result);

		return true;
	}

	public void printResult(GatherIdentifier input) {

		// String result = "";

		System.out.print("{" + input.getElement().transferString() + "}");
		/*
		 * String result = ""; System.out.print("{");
		 * 
		 * for (int i = 0; i < input.arrayLength(); i++) { result = result +
		 * input.getElement().transferString() + " "; //
		 * System.out.print(elements[i].transferString());
		 * 
		 * if(i != arraySize() -1){ System.out.print(" "); }
		 * 
		 * }
		 * 
		 * String finalResult = result.trim(); System.out.print(finalResult + "}");
		 */
	}

	private void calculateResults(GatherIdentifier firstSet, GatherIdentifier secondSet) {

		/*
		 * out.print("difference = "); GatherIdentifier jj =
		 * firstSet.processDifference(secondSet);
		 * 
		 * System.out.println("--------------------------------- ");
		 * 
		 * System.out.print("{");
		 * 
		 * for (int i = 0; i < jj.arraySize(); i++) {
		 * System.out.print(jj.elements[i].transferString());
		 * 
		 * if (i != jj.arraySize() - 1) { System.out.print(" "); } }
		 * System.out.print("}");
		 */
		// i.printResult();
		/*
		 * out.println(); out.print("Intersection = "); GatherIdentifier jj = new
		 * GatherIdentifier(); // firstSet.processIntersection(secondSet).printResult();
		 * 
		 * System.out.println("--------------------------------- ");
		 * 
		 * System.out.print("{");
		 * 
		 * for (int i = 0; i < jj.arraySize(); i++) {
		 * System.out.print(jj.elements[i].transferString());
		 * 
		 * if (i != jj.arraySize() - 1) { System.out.print(" "); } }
		 * System.out.print("}");
		 */

		out.print("difference = ");
		printResult(firstSet.processDifference(secondSet));

		out.println();
		out.print("intersection = ");
		printResult(firstSet.processIntersection(secondSet));

		out.println();
		out.print("union = ");
		printResult(firstSet.processUnion(secondSet));

		out.println();
		out.print("Sym. diff. =  ");
		printResult(firstSet.processSymmetricDifference(secondSet));

		// printResult(jj);

		/*
		 * System.out.println("--------------------------------- ");
		 * 
		 * System.out.print("{");
		 * 
		 * for (int i = 0; i < jj.arraySize(); i++) {
		 * System.out.print(jj.elements[i].transferString());
		 * 
		 * if (i != jj.arraySize() - 1) { System.out.print(" "); } }
		 * System.out.print("}");
		 * System.out.println("------------==+++++++===-----------: "); String result =
		 * ""; System.out.print("{"); // int count = jj.arraySize();
		 * 
		 * for (int i = 0; i < jj.arraySize(); i++) { result = result +
		 * jj.getElement().transferString() + " "; //
		 * System.out.print(elements[i].transferString());
		 * 
		 * if(i != arraySize() -1){ System.out.print(" "); }
		 * 
		 * 
		 * }
		 * 
		 * String finalResult = result.trim(); System.out.print(finalResult + "}");
		 */

		/*
		 * GatherIdentifier jj =firstSet.processUnion(secondSet); System.out.print("{");
		 * 
		 * System.out.println( "??????????" +jj.elements.length);
		 * System.out.println("================================= ");
		 * System.out.println("??************???" + jj.arraySize());
		 * 
		 * 
		 * for (int i = 0; i < jj.arraySize(); i++) {
		 * System.out.print(jj.elements[i].transferString());
		 * 
		 * if (i != jj.arraySize() - 1) { System.out.print(" "); } }
		 * System.out.print("}");
		 */
		// firstSet.processUnion(secondSet).printResult();

	}

}