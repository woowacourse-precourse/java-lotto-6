package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.config.InputMessage;

public class InputView {

    public static String inputLottoPurchaseMoney() {
        System.out.println(InputMessage.INPUT_MONEY.getMessage());
        return Console.readLine();
    }

    public static String inputLottoWinningNumbers() {
        System.out.println(InputMessage.INPUT_WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    public static String inputLottoBonusNumber() {
        System.out.println(InputMessage.INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
