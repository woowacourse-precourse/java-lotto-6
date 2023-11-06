package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.Amount;
import lotto.manager.Exception;
import lotto.util.Util;

public class InputConsole {
    private static final String READ_MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";

    public Amount readPurchaseAmount() {
        System.out.println(READ_MESSAGE_PURCHASE_AMOUNT);
        String purchaseAmount = Console.readLine();

        if (!Util.isNumber(purchaseAmount)) {
            Exception.PURCHASE_AMOUNT_NOT_NUMBER.throwing();
        }
        return new Amount(purchaseAmount);
    }

    public String readWinningLottoNumbers() {
        System.out.println(READ_WINNING_LOTTO_NUMBERS);
        String winningLottoNumbers = Console.readLine();

        if (Util.isEmptyOrBlank(winningLottoNumbers)) {
            Exception.EMPTY_OR_BLANK_INPUT.throwing();
        }
        return winningLottoNumbers;
    }
}
