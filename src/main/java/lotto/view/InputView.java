package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

public class InputView {
    private final static String INPUT_BUDGET = "구입금액을 입력해 주세요.";
    private final static String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private final static String LINE_SEPARATOR = "\n";


    public static String inputBudget() {
        System.out.println(INPUT_BUDGET);
        String budget = Console.readLine();
        Validator.checkInputBudget(budget);
        Validator.checkIsEmpty(budget);

        return budget;
    }

    public static String inputWinningNumber() {
        System.out.println(LINE_SEPARATOR + INPUT_WINNING_NUMBER);
        String winningNumber = Console.readLine();
        Validator.checkInputLottoNumber(winningNumber);
        //Validator.checkIsEmpty(winningNumber);

        return winningNumber;
    }

    public static String inputBonusNumber() {
        System.out.println(LINE_SEPARATOR + INPUT_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        Validator.checkInputBonusNumber(bonusNumber);

        return bonusNumber;

    }
}
