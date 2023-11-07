package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    private InputView() {
    }

    public static String inputPurchaseAmount() {
        return printMessageAndInputWithLineBreak(PURCHASE_AMOUNT_MESSAGE);
    }

    public static String inputLottoNumbers() {
        return printMessageAndInputWithLineBreak(LOTTO_NUMBERS_MESSAGE);
    }

    public static String inputBonusNumbers() {
        return printMessageAndInputWithLineBreak(BONUS_NUMBER_MESSAGE);
    }

    private static String printMessageAndInputWithLineBreak(String message) {
        System.out.println(message);
        String input = Console.readLine();
        System.out.println();

        return input;
    }
}
