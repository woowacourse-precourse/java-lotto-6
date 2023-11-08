package lotto.view;

import static lotto.consts.ViewConst.INPUT_BONUS_NUMBER;
import static lotto.consts.ViewConst.INPUT_LOTTO_MONEY;
import static lotto.consts.ViewConst.INPUT_WIN_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputBuyingMoney() {
        System.out.println(INPUT_LOTTO_MONEY);
        return Console.readLine();
    }

    public static String inputWinNums() {
        System.out.println(INPUT_WIN_NUMBER);
        return Console.readLine();
    }

    public static String inputBonusNum() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
