package lotto.ui;

import static lotto.domain.Message.INPUT_COST;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readCost() {
        System.out.println(INPUT_COST.getMessage());
        return Console.readLine();
    }


    public static String readNumbers() {
        System.out.println(INPUT_COST.getMessage());
        return Console.readLine();
    }

}
