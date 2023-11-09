package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.InputMessage.*;

public class InputView {

    public static String readMoney() {
        System.out.println(ENTER_TOTAL_PURCHASE_MONEY.getInputMessage());
        return readLine();
    }

    public static String readBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER.getInputMessage());
        return readLine();
    }

    public static String readWinningLottoCombination() {
        System.out.println(ENTER_WINNING_LOTTO_NUMBER.getInputMessage());
        return readLine();
    }


}