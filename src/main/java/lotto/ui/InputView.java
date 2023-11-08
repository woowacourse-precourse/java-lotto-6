package lotto.ui;

import static lotto.constants.Message.INPUT_COST;
import static lotto.constants.Message.INPUT_NUMBERS;
import static lotto.constants.Message.INPUT_BONUS_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readCost() {
        System.out.println(INPUT_COST.getMessage());
        return Console.readLine();
    }

    public static String readNumbers() {
        System.out.println(INPUT_NUMBERS.getMessage());
        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBERS.getMessage());
        return Console.readLine();
    }

}
