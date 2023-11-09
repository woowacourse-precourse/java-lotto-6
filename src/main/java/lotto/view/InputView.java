package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constant.LottoMessage;
import lotto.util.Parser;

public class InputView {

    public static int readPurchaseAmount() {
        LottoMessage message = LottoMessage.PURCHASE_AMOUNT_INPUT_MESSAGE;
        System.out.println(message.getMessage());

        return Parser.parseToInt(Console.readLine());
    }

    public static List<Integer> readWinningNumbers() {
        LottoMessage message = LottoMessage.WINNING_NUMBERS_INPUT_MESSAGE;
        System.out.println(message.getMessage());

        return Parser.parseToIntListWithComma(Console.readLine());
    }

    public static int readBonusNumber() {
        LottoMessage message = LottoMessage.BONUS_NUMBER_INPUT_MESSAGE;
        OutputView.printNewLine();
        System.out.println(message.getMessage());

        return Parser.parseToInt(Console.readLine());
    }
}
