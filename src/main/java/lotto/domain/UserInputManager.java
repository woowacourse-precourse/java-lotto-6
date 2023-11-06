package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

public class UserInputManager {
	// 구입 금액은 1000원 단위로 입력
	private final static int COST_UNIT = 1000;

	public static int inputPurchaseAmount() {
		System.out.println("구입금액을 입력해 주세요.");
		String userInput = Console.readLine();
		return checkPurchaseAmountIsValid(userInput);
	}

	private static int checkPurchaseAmountIsValid(String userInput) {
		int purchaseAmount;

		try {
			purchaseAmount = Integer.parseInt(userInput);
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
		}

		if (purchaseAmount < COST_UNIT) {
			throw new IllegalArgumentException("[ERROR] " + COST_UNIT + " 이상의 숫자를 입력하세요.");
		}

		if (purchaseAmount % COST_UNIT != 0) {
			throw new IllegalArgumentException("[ERROR] 구입 금액은 " + COST_UNIT + " 단위로 입력해주세요.");
		}

		return purchaseAmount;
	}
}
