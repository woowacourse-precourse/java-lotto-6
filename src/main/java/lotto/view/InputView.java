package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

import java.util.HashSet;
import static lotto.CommonMessages.*;


public class InputView {

    public Integer getPurchaseAmount() {

        System.out.println(PURCHASE_AMOUNT_INPUT.getMessage());

        String input = Console.readLine();
        Integer money = InputValidator.validateToInteger(input);

        return InputValidator.validateCorrectMoney(money);
    }

    public HashSet<Integer> getWinningNumbers() {

        System.out.println(WINNING_AMOUNT_INPUT);
        HashSet<Integer> winningNumbers = new HashSet<>();

        String input = Console.readLine();
        String[] split = input.split(",");

        for (String s : split) {
            winningNumbers.add(Integer.parseInt(s));
        }

        InputValidator.validateWinningNumberSize(winningNumbers);
        return winningNumbers;
    }

    public Integer getBonusNumber() {

        System.out.println(BONUS_NUMBER_INPUT);
        String input = Console.readLine();
        return InputValidator.validateToInteger(input);
    }
}
