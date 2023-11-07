package lotto.output;

import lotto.constant.NumbersOption;

public class ErrorPrinter {

	private static final String ERROR_SYMBOL = "[ERROR] ";
	private static final String ONLY_NUMBER_MESSAGE = "숫자만 입력해주세요";
	private static final String OUT_OF_RANGE_MESSAGE = NumbersOption.MIN + "~" + NumbersOption.MAX + "의 숫자만 입력해주세요.";
	private static final String OUT_OF_SIZE_MESSAGE = "중복되지 않는 " + NumbersOption.SIZE + "개의 숫자만 입력해주세요.";
	private static final String SEPARATOR_ERROR_MESSAGE = "구분자(" + NumbersOption.SEPARATOR + ")만을 이용해 나눠주세요";
	private static final int LOTTO_PRIZE = 1000;
	private static final String PURCHASE_UNIT_ERROR_MESSAGE = LOTTO_PRIZE + "원 단위로만 입력해주세요.";
	private static final String BONUS_NUMBER_DUPLICATION_MESSAGE = "당첨 번호와 보너스 번호에 중복이 있습니다.";

	public static void printOnlyNumberError() {
		System.out.println(ERROR_SYMBOL + ONLY_NUMBER_MESSAGE);
	}

	public static void printOutOfRange() {
		System.out.println(ERROR_SYMBOL + OUT_OF_RANGE_MESSAGE);
	}

	public static void printOutOfSize() {
		System.out.println(ERROR_SYMBOL + OUT_OF_SIZE_MESSAGE);
	}

	public static void printSeparatorError() {
		System.out.println(ERROR_SYMBOL + SEPARATOR_ERROR_MESSAGE);
	}

	public static void printPurchaseUnitError() {
		System.out.println(ERROR_SYMBOL + PURCHASE_UNIT_ERROR_MESSAGE);
	}
	public static void printBonusNumberError() {
		System.out.println(ERROR_SYMBOL + BONUS_NUMBER_DUPLICATION_MESSAGE);
	}

}
