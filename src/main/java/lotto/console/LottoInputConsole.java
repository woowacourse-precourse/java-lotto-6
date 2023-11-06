package lotto.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.Amount;
import lotto.manager.LottoException;
import lotto.util.StringUtil;

public class LottoInputConsole {
    private static final String READ_MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String READ_WINNING_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String READ_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";

    public Amount readPurchaseAmount() {
        System.out.println(READ_MESSAGE_PURCHASE_AMOUNT);
        String purchaseAmount = Console.readLine();

        if (!StringUtil.isNumber(purchaseAmount)) {
            LottoException.PURCHASE_AMOUNT_NOT_NUMBER.throwing();
        }
        return new Amount(purchaseAmount);
    }

    public String readWinningLottoNumbers() {
        System.out.println(System.lineSeparator() + READ_WINNING_LOTTO_NUMBERS);
        String winningLottoNumbers = Console.readLine();

        if (StringUtil.isEmptyOrBlank(winningLottoNumbers)) {
            LottoException.EMPTY_OR_BLANK_INPUT.throwing();
        }
        return winningLottoNumbers;
    }

    public int readBonusNumber() {
        System.out.println(System.lineSeparator() + READ_BONUS_NUMBERS);
        String bonusNumber = Console.readLine();

        if (StringUtil.isNumber(bonusNumber)) {
            LottoException.NOT_NUMBER.throwing();
        }
        return Integer.parseInt(bonusNumber);
    }
}
