package validators;

import java.util.List;

import enums.Error;

public class InputException {
	
	private static final int MIN = 1;
	private static final int MAX = 45;

	public static void checkNumber(String buyAmountText) {
		boolean what = buyAmountText.matches("\\d+");
		if(!what) {
			throw new IllegalArgumentException(Error.WRONG_VALUE.getMessage());
		}
	}

	public static void checkRightAmount(int buyAmount, int lottoPrice) {
		if(buyAmount == 0) {
			throw new IllegalArgumentException(Error.WRONG_AMOUNT.getMessage());
		}
		
		int rest = buyAmount%lottoPrice;
		if(rest != 0) {
			throw new IllegalArgumentException(Error.WRONG_AMOUNT.getMessage());
		}
	}

	public static void checkNumberRange(List<Integer> numbers) {
		for(int number : numbers) {
			if(number < MIN && number > MAX) {
				throw new IllegalArgumentException(Error.WRONG_NUMBER.getMessage());
			}
		}
	}
	
	public static void checkOverlap(List<Integer> numbers) {
		for(int i = 0; i < numbers.size() - 1; i++) {
    		if(numbers.get(i) == numbers.get(i + 1)) {
    			throw new IllegalArgumentException(Error.NUMBER_OVERLAP.getMessage());
    		}
    	}
	}

	public static void checkNull(String numberText) {
		if(numberText == null) {
			throw new IllegalArgumentException(Error.NULL_VALUE.getMessage());
		}
	}

	public static void checkBonusNumberOverlap(int bonusNumber, List<Integer> numbers) {
		for(int number : numbers) {
			if(bonusNumber == number) {
				throw new IllegalArgumentException(Error.NUMBER_OVERLAP.getMessage());
			}
		}
	}
}
