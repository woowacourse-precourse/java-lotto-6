package lotto.validate;

import java.util.*;

public class Validate {
	//입력받은 숫자가 1000단위인지
	public static void isThousandMultiple(int inputData) {
		if(inputData % 1000 !=0) throw new IllegalArgumentException("[ERROR] 1000단위의 숫자로 입력 해주세요.");
	}
	//입력받은 숫자가 1000미만인지
	public static void isMinimumAmount(int inputData) {
	    if (inputData < 1000) throw new IllegalArgumentException("[ERROR] 1000이상의 숫자로 입력 해주세요.");
	}
	//6개의 숫자를 중복없이 입력한게 맞는지
	public static void isValidSixNumberInput(String inputData) {
		Set<Integer> sixNumber = new HashSet<>();
		for(String number : inputData.split(",")) {
			sixNumber.add(Integer.parseInt(number));
		}
		if(sixNumber.size() !=6) throw new IllegalArgumentException("[ERROR] 중복없는 6개의 숫자로 입력 해주세요.");
	}
	
	
}
