package lotto.output;

public class ErrorPrinter {

	private static final String ERROR_SYMBOL = "[ERROR]";
	private static final String ONLY_NUMBER_MESSAGE = "숫자만 입력해주세요";
	private static final String OUT_OF_RANGE_MESSAGE = "1~45 사이의 숫자만 입력해주세요.";
	private static final String OUT_OF_SIZE_MESSAGE = "중복되지 않는 6개의 숫자만 입력해주세요.";
	private static final String SEPARATOR_ERROR_MESSAGE = "구분자(,)만을 이용해 나눠주세요";

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

}
