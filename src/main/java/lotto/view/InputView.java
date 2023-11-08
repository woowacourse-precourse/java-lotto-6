package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionMessage;

public class InputView {

    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";


    public String readPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        String purchaseAmount = Console.readLine();
        validateDigit(purchaseAmount);
        return purchaseAmount;
    }

    private void validateDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_DIGIT.throwIllegalArgumentException();
        }
    }

    public String readWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS);
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER);
        return Console.readLine();
    }
}
