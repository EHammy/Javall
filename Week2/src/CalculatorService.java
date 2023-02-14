public class CalculatorService {
	public boolean checkPositive(int inputNumber) {
		boolean isPositive = false;
		
		
		if (inputNumber >= 0) {
			isPositive = true;
		}
		return isPositive;
	}
	
	public boolean checkNegative(int inputNumber) {

		boolean isNegative = false;
		
		
		if (inputNumber <= 0) {
			isNegative = true;
		}
		return isNegative;

	}
	
	public boolean checkEvenNumber(int inputNumber) {
		boolean isEven = false;
		if (Math.abs(inputNumber) % 2 == 0) {
			isEven = true;
		}
		return isEven;
	}
	
	public boolean checkOddNumber(int inputNumber) {
		boolean isOdd = false;
		if (Math.abs(inputNumber) % 2 == 1) {
			isOdd = true;
		}
		return isOdd;
	}
	
	
	public boolean checkWhetherPrimeOrNot(int inputNumber) {
		boolean isPrime = true;
		int checkingNumber = Math.abs(inputNumber) / 2;
		for (int idx = 2; idx <= checkingNumber; idx++) {
			if (inputNumber % idx == 0) {
				isPrime = false;
				
				break;
			}
		}
		return isPrime;
	}
}
