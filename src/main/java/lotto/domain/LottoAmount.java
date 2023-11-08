package lotto.domain;

import lotto.view.InputView;

public class LottoAmount {
	private static final int LOTTO_PRICE = 1000;

	public static int inputAmount() {
		while (true) {
			try {
				int amount = validateNum(InputView.inputAmountOfMoney());
				validateDivide(amount);
				return amount / LOTTO_PRICE;
			} catch (IllegalArgumentException e) {
				System.out.println("[ERROR] 수가 아닙니다.");
			}
		}
	}

	private static void validateDivide(int amount) {
		if (amount % LOTTO_PRICE != 0) {
			System.out.println("[ERROR] 1000으로 나누어떨어지지 않습니다.");
			throw new IllegalArgumentException();
		}
		if (amount <= 0) {
			System.out.println("[ERROR] 금액은 양수여야 합니다.");
			throw new IllegalArgumentException();
		}
	}

	private static int validateNum(String input) {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("[ERROR] 수가 아닙니다.");
			throw new IllegalArgumentException();
		}
	}
}
