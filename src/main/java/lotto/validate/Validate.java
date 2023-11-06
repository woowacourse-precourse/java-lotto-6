package lotto.validate;

import java.util.*;

public class Validate {
	//입력받은 숫자가 1000단위인지
	public static void thousandMultiple(int inputData) {
		if(inputData % 1000 !=0) throw new IllegalArgumentException("[ERROR] 1000단위의 숫자로 입력 해주세요.");
	}
	
	//입력받은 데이터는 숫자,콤마 이외에 안됨.
	public static void validateFormat(String inputData) {
	    String pattern = "^\\d+(?:,\\d+)*$";
	    if (!inputData.matches(pattern)) {
	        throw new IllegalArgumentException("[ERROR] 입력 값은 숫자와 콤마만 포함해야 하며 공백을 포함할 수 없습니다.");
	    }
	}
	
	//입력받은 숫자가 1000미만인지
	public static void minimumAmount(int inputData) {
	    if (inputData < 1000) throw new IllegalArgumentException("[ERROR] 1000이상의 숫자로 입력 해주세요.");
	}
	
	//입력받은 숫자가 1~45의 숫자가 맞는지
	public static void numberInRange(String inputData) {
		List<Integer> numbers = new ArrayList<>();
		for(String number : inputData.split(",")) numbers.add(Integer.parseInt(number));
		for(int number : numbers) if(number >45 || number < 1) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
	}
	public static void numberInRange(int inputData) {
		if(inputData >45 || inputData < 1) throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
	}
	
	//6개의 숫자를 중복없이 입력한게 맞는지
	public static void validSixNumberInput(String inputData) {
		Set<Integer> sixNumber = new HashSet<>();
		for(String number : inputData.split(",")) {
			sixNumber.add(Integer.parseInt(number));
		}
		if(sixNumber.size() !=6) throw new IllegalArgumentException("[ERROR] 중복없는 6개의 숫자로 입력 해주세요.");
	}
	
	public static void numericInput(String inputData) {
		for(char word : inputData.toCharArray()) {
			if(!Character.isDigit(word)) throw new IllegalArgumentException("[ERROR] 숫자만 입력 해주세요.");
		}
	}
	
	public static void bonusNumberUniqueness(List<Integer> winningNumbers,int bonusNumber) {
		for(int number : winningNumbers) {
			if(number == bonusNumber) throw new IllegalArgumentException("[ERROR] 보너스번호가 당첨번호랑 중복됩니다.");
		}
	}
}
