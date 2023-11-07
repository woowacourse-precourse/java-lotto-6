package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Constants;
import lotto.validator.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputUtil {
    InputValidator validator = new InputValidator();
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