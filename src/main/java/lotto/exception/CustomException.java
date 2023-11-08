package lotto.exception;

public class CustomException {

	private static final String OVER_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
	private static final String OVER_LOTTO_NUMBER_SIZE = "[ERROR] 입력 가능한 당첨 번호는 6개 입니다.";
	private static final String HAS_DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또 번호가 중복 되었습니다.";
	private static final String WRONG_INPUT_LOTTO_NUMBER = "[ERROR] 잘못된 로또 번호 입니다.";
	private static final String WRONG_INPUT_LOTTO_MONEY  = "[ERROR] 잘못된 금액 입니다.";

	public static void rangeException() {
		System.out.println(OVER_LOTTO_NUMBER_RANGE);
	}

	public static void sizeException() {
		System.out.println(OVER_LOTTO_NUMBER_SIZE);
	}

	public static void duplicateException() {
		System.out.println(HAS_DUPLICATE_LOTTO_NUMBER);
	}

	public static void inputLottoNumberException() {
		System.out.println(WRONG_INPUT_LOTTO_NUMBER);
	}

	public static void inputLottoMoneyException() {
		System.out.println(WRONG_INPUT_LOTTO_MONEY);
	}
}
