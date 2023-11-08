package lotto;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class CheckValid {
	private static final String ERROR_NUMERIC_INPUT = "[ERROR] 입력은 반드시 숫자여야 합니다.";
	private static final String ERROR_OVERLAP_BONUS = "[ERROR] 입력 번호와 보너스 입력 번호는 중복될 수 없어요.";
	private static final String ERROR_NON_POSITIVE_MONEY = "[ERROR] 구입금액은 0보다 커야 합니다.";
	private static final String ERROR_NON_DIVISIBLE_MONEY = "[ERROR] 구입금액은 1,000원 단위여야 합니다.";
	private static final String ERROR_MINIMUM_MONEY = "[ERROR] 구입금액은 최소 1,000원 이상이어야 합니다.";
	private static final String ERROR_INVALID_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
	private static final String ERROR_EMPTY_NUMBERS = "[ERROR] 로또 번호는 비어 있을 수 없습니다.";
	private static final String ERROR_INVALID_SIZE = "[ERROR] 로또 번호는 6개여야 합니다.";
	private static final String ERROR_DUPLICATE_NUMBERS = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";

	public static void numbers(List<Integer> numbers) {

		for (Integer number : numbers) {
			validateRange(number);
		}
		validateDuplicates(numbers);
		validateEmpty(numbers);
		validateSize(numbers);
	}

	public static void money(String inputMoney) {

		validateDigit(inputMoney);

		int money = Integer.parseInt(inputMoney);

		validateNatural(money);
		validateDivisible(money);
		validateNumber(money);
	}

	public static void bonus(List<Integer> numbers, int bonus) {

		for (Integer number : numbers) {
			validateNoOverLap(number, bonus);
		}
		validateRange(bonus);
	}

	public static void string(String input) {

		validateDigit(input);
	}

	private static void validateDigit(String input) {
		if (!input.matches("-?\\d+")) {
			throw new NumberFormatException(ERROR_NUMERIC_INPUT);
		}
	}

	private static void validateNoOverLap(int number, int bonus) {
		if (number == bonus) {
			throw new IllegalArgumentException(ERROR_OVERLAP_BONUS);
		}
	}

	private static void validateNatural(int money) {
		if (money <= 0) {
			throw new IllegalArgumentException(ERROR_NON_POSITIVE_MONEY);
		}
	}

	private static void validateDivisible(int money) {
		if (money % 1000 != 0) {
			throw new IllegalArgumentException(ERROR_NON_DIVISIBLE_MONEY);
		}
	}

	private static void validateNumber(int money) {
		if (money < 1000) {
			throw new IllegalArgumentException(ERROR_MINIMUM_MONEY);
		}
	}

	private static void validateRange(int number) {
		if (number < 1 || number > 45) {
			throw new NumberFormatException(ERROR_INVALID_RANGE);
		}
	}

	private static void validateEmpty(List<Integer> numbers) {
		if (numbers.isEmpty()) {
			throw new IllegalArgumentException(ERROR_EMPTY_NUMBERS);
		}
	}

	private static void validateSize(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(ERROR_INVALID_SIZE);
		}
	}

	private static void validateDuplicates(List<Integer> numbers) {
		Set<Integer> uniqueNumbers = new HashSet<>(numbers);

		if (uniqueNumbers.size() != numbers.size()) {
			throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBERS);
		}
	}
}