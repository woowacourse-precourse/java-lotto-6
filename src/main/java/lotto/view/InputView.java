package lotto.view;

import static lotto.constant.InputMessage.BONUS_NUMBER;
import static lotto.constant.InputMessage.LOTTO_PURCHASE_MONEY;
import static lotto.constant.InputMessage.LOTTO_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readLottoPurchaseMoney() {
        System.out.println(LOTTO_PURCHASE_MONEY);
        return Console.readLine();
    }

    public static String readLottoWinningNumbers() {
        System.out.println(LOTTO_WINNING_NUMBERS);
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println(BONUS_NUMBER);
        return Console.readLine();
    }

}
