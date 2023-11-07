package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNIG_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_LOTTO_MESSAGE = "보너스 번호를 입력해 주세요.";


    public static String lottoPurchaseAmountInput() {
        System.out.println(INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public static String winningLottoInput() {
        System.out.println(INPUT_WINNIG_LOTTO_MESSAGE);
        return Console.readLine();

    }

    public static String bonusLottoInput() {
        System.out.println(INPUT_BONUS_LOTTO_MESSAGE);
        return Console.readLine();

    }
}
