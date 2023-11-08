package lotto;

import camp.nextstep.edu.missionutils.Console;

public class userInput {
	private static final String purchaseAmountInput = "구입금액을 입력해 주세요.";
	private static final String winningNumberInput = "당첨 번호를 입력해 주세요.";
	private static final String bonusNumberInput = "보너스 번호를 입력해 주세요.";

	public static String inputPurchaseAmount(){
		System.out.println(purchaseAmountInput);
		return Console.readLine();
	}

	public static String inputWinningNumber(){
		System.out.println(winningNumberInput);
		return Console.readLine();
	}

	public static String inputBonusNumber(){
		System.out.println(bonusNumberInput);
		return Console.readLine();
	}


}
