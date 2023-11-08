package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Message;

public class LottoInputView {

    public static String readPurchaseAmount() {
        System.out.println(Message.INPUT_PURCHASE.getMessage());
        return Console.readLine();
    }

    public static String readWinningNumber() {
        LottoOutputView.lineBreak();
        System.out.println(Message.INPUT_WINNING_NUMBER.getMessage());
        return Console.readLine();
    }

    public static String readBonusNumber() {
        LottoOutputView.lineBreak();
        System.out.println(Message.INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
