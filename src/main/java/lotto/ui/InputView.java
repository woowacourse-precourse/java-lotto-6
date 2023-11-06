package lotto.ui;

import static lotto.domain.Message.INPUT_COST;
import static lotto.domain.Message.INPUT_NUMBERS;
import static lotto.domain.Message.INPUT_BONUS_NUMBERS;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static void readCost() {
        System.out.println(INPUT_COST.getMessage());
    }


    public static void readNumbers() {
        System.out.println(INPUT_NUMBERS.getMessage());
    }

    public static void readBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBERS.getMessage());
    }

}
