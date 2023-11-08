package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
	private static final String ASK_LOTTO_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	private static final String ASK_LOTTO_RESULT = "당첨 번호를 입력해 주세요.";
	private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
	
    public static String requestLottoPurchaseAmount() {
    	System.out.println(ASK_LOTTO_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public static String requestWinningNumbers() {
    	System.out.println();
    	System.out.println(ASK_LOTTO_RESULT);
        return Console.readLine();
    }

    public static String requestBonusNumber() {
    	System.out.println();
    	System.out.println(ASK_BONUS_NUMBER);
        return Console.readLine();
    }
}
