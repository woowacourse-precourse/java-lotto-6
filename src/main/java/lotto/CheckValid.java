package lotto;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class CheckValid {

	public static void numbers(List<Integer> numbers) {

		validateDigits(numbers);
		validateEmpty(numbers);
		validateLength(numbers);
		validateRange(numbers);
		validateDuplicates(numbers);
	}

	public static void numbers(String inputNums, String bonusUserNum) {

		String[] usernums = inputNums.split(",");
		int bonus = Integer.parseInt(bonusUserNum);

		for (String usernum : usernums) {
			int num = Integer.parseInt(usernum);
			validateDuplicate(num, bonus);
		}

		List<Integer> numbers = new ArrayList<>();

		for (String usernum : usernums) {
			numbers.add(Integer.parseInt(usernum));
		}

		validateEmpty(numbers);
		validateLength(numbers);
		validateRange(numbers);

	}

	public static void money(String strMoney) {
		try {
			int money = Integer.parseInt(strMoney);

			validateNatural(money);
			validateDivisible(money);
			validateNumber(money);

		} catch (NumberFormatException e) {
			String message = "[ERROR] 구입금액은 숫자여야 합니다";
			throw new NumberFormatException(message);
		}
	}

	private static void validateDuplicate(int usernums, int num) {
		String message = "[ERROR] 입력 번호와 보너스 입력 번호는 중복될 수 없어요";
		if (usernums == num) {
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

	private static void validateEmpty(List<Integer> numbers) {
		String message = "[ERROR] 로또 번호는 비어 있을 수 없습니다.";

		if (numbers.isEmpty()) {
			throw new IllegalArgumentException(message);
		}

	}

	private static void validateLength(List<Integer> numbers) {
		String message = "[ERROR] 로또 번호는 6개여야 합니다.";

		if (numbers.size() != 6) {
			throw new IllegalArgumentException(message);
		}
	}

	private static void validateRange(List<Integer> numbers) {
		String message = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

		for (int number : numbers) {
			if (number < 1 || number > 45) {
				throw new IllegalArgumentException(message);
			}
		}

	}

	private static void validateDigits(List<Integer> numbers) {
		String message = "[ERROR] 로또 번호는 반드시 숫자여야만 합니다.";

		for (int number : numbers) {
			if (number < 1 || number > 45) {
				throw new NumberFormatException(message);
			}
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
