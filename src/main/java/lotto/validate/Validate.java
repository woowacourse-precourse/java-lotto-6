package lotto.validate;

public class Validate {
	//입력받은 숫자가 1000단위인지
	public static void isThousandMultiple(int inputData) {
		if(inputData % 1000 !=0) throw new IllegalArgumentException("[ERROR] 1000단위의 숫자로 입력 해주세요.");
	}
}
