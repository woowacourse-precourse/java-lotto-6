package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionMessage;

public class InputView {

    public String readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
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
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String readBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}
