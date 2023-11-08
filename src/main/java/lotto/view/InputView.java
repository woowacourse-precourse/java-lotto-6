package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import static lotto.util.Instruction.*;

public class InputView {

    private InputView() {
    }

    public static String inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(INPUT_LOTTO_WINNING_NUMBERS_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_LOTTO_BONUS_NUMBER_MESSAGE.getMessage());
        return Console.readLine();
    }
}
