package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String READ_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String READ_WINNER_NUMBERS_MESSAGE = "당첨 번호를 쉼표(,)로 구분하여 입력해 주세요.";
    private static final String READ_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요";

    public static String readPurchaseAmount() {
        System.out.println(READ_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public static String readLottoNumbers() {
        System.out.println(READ_WINNER_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println(READ_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
