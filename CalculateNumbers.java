
package model;

public class CalculateNumbers {
	private static final String divide = null;
	private static final String add = null;
	private static final String multiply = null;
	private static final String subtract = null;
	
	private int firstNumber;
	private int secondNumber;
	private int thirdNumber;
	private int fourthNumber; 
	
	public int getFirstNumber() {
		return firstNumber;
	}
	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}
	public int getSecondNumber() {
		return secondNumber;
	}
	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}
	
	

		
		int result;
		
		
		public int add(int num1, int num2){
			result = num1+num2;
			return result;
		}
		public int subtract(int num1, int num2){
			result = num1-num2;
			return result;
		}
		//Method for multiplication
		public int multiply(int num1, int num2){
			result = num1*num2;
			return result;
		}
		//Method for division
		public float divide(int num1, int num2){
			result = num1/num2;
			return result;
		}
		
	

@Override
public String toString() {
	return "Calculate Numbers: [addition" + add + "Subtract" + subtract + "multiply" + multiply + "divide" + divide;
}
}