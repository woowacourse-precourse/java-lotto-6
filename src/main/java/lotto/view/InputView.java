package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_LOTTO_PURCHASE_AMOUNT = "구입 금액을 입력해 주세요";
    private static final String INPUT_LOTTO_PRIZE_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String inputPurchaseAmount() {
        System.out.println(INPUT_LOTTO_PURCHASE_AMOUNT);
        return Console.readLine();
    }

}
