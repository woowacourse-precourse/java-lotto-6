package lotto;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class CheckValid {

	public static void numbers(List<Integer> numbers) {
		
		for (Integer number : numbers) {
			validateRange(number);
		}
		validateDuplicates(numbers);
		validateEmpty(numbers);
		validateSize(numbers);
	}

	public static void money(String strMoney) {
		
		validateDigit(strMoney);
		
		int money = Integer.parseInt(strMoney);

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
		String message = "[ERROR] 입력은 반드시 숫자여야 합니다.";
		
		if (!input.matches("-?\\d+")) {
			throw new NumberFormatException(message);
		}
	}

	private static void validateNoOverLap(int number, int bonus) {
		String message = "[ERROR] 입력 번호와 보너스 입력 번호는 중복될 수 없어요";
		
		if (number == bonus) {
			throw new IllegalArgumentException(message);
		}
	}

	private static void validateNatural(int money) {
		String message = "[ERROR] 구입금액은 0보다 커야 합니다.";
		
		if (money <= 0) {
			throw new IllegalArgumentException(message);
		}
	}

	private static void validateDivisible(int money) {
		String message = "[ERROR] 구입금액은 1,000원 단위여야 합니다.";
		
		if (money % 1000 != 0) {
			throw new IllegalArgumentException(message);
		}
	}

	private static void validateNumber(int money) {
		String message = "[ERROR] 구입금액은 최소 1,000원 이상이어야 합니다.";
		
		if (money < 1000) {
			throw new IllegalArgumentException(message);
		}
	}

	private static void validateRange(int number) {
		String message = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
		
		if (number < 1 || number > 45) {
			throw new NumberFormatException(message);
		}
	}

	private static void validateEmpty(List<Integer> numbers) {
		String message = "[ERROR] 로또 번호는 비어 있을 수 없습니다.";
		
		if (numbers.isEmpty()) {
			throw new IllegalArgumentException(message);
		}

	}

	private static void validateSize(List<Integer> numbers) {
		String message = "[ERROR] 로또 번호는 6개여야 합니다.";
		
		if (numbers.size() != 6) {
			throw new IllegalArgumentException(message);
		}
	}

	private static void validateDuplicates(List<Integer> numbers) {
		String message = "[ERROR] 로또 번호에 중복된 숫자가 있습니다.";
		Set<Integer> uniqueNumbers = new HashSet<>(numbers);

		if (uniqueNumbers.size() != numbers.size()) {
			throw new IllegalArgumentException(message);
		}

	}

}
