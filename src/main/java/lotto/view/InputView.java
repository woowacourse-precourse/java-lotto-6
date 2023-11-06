package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.LottoMessage;

public class InputView {

    public static String readPurchaseAmount() {
        LottoMessage message = LottoMessage.PURCHASE_AMOUNT_INPUT_MESSAGE;
        System.out.println(message.getMessage());

        return Console.readLine();
    }

    public static String readWinningNumbers() {
        LottoMessage message = LottoMessage.WINNING_NUMBERS_INPUT_MESSAGE;
        System.out.println(message.getMessage());

        return Console.readLine();
    }

    public static String readBonusNumber() {
        LottoMessage message = LottoMessage.BONUS_NUMBER_INPUT_MESSAGE;
        System.out.println(message.getMessage());

        return Console.readLine();
    }
}
