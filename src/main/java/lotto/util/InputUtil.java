package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Constants;

public class InputUtil {
    Constants constants = new Constants();

    public String inputLottoAmount() {
        System.out.println(constants.AMOUNT_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String inputWinningNumber() {
        System.out.printf(constants.WINNING_NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.printf(constants.BONUS_NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }
}