package lotto.view;

import lotto.utils.StringUtils;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.utils.Constants.*;

public class InputView {
    public static int inputBuyLotto() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return readInt();
    }

    private static int readInt() {
        String inputInt = readLine();
        return StringUtils.stringToInt(inputInt);
    }

    public static String inputWinningNumbers() {
        System.out.println();
        System.out.println(WINNING_NUMBER_MESSAGE);
        return readLine();
    }

    public static int inputBonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_MESSAGE);
        return readInt();
    }
}
