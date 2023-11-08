package lotto.View;

import camp.nextstep.edu.missionutils.Console;


public class InputView {

    private static final String PURCHASE_SUM_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";



    public static Integer inputPurchaseSum() {
        OutputView.printInputMessage(PURCHASE_SUM_INPUT_MESSAGE);
        String input = Console.readLine();

        try {
            checkInputPurchaseSumValid(input);
            return Integer.parseInt(input);

        } catch(IllegalArgumentException e) {
            InputView.inputPurchaseSum();
        }

        return null;
    }

    private static void checkInputPurchaseSumValid(String input) {
        Validation.checkNotNumber(input);
        Validation.checkNotInteger(input);
        Validation.checkNotDivided(input);
    }

}
