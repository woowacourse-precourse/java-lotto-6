package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.constant.Message.INPUT_BONUS_NUMBER;
import static lotto.constant.Message.INPUT_BUDGET;
import static lotto.constant.Message.INPUT_WINNING_NUMBER;

public class InputView {

    public static String inputBudget() {
        System.out.println(INPUT_BUDGET.getMessage());
        return readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER.getMessage());
        return readLine();
    }

    public static String inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        return readLine();
    }
}
