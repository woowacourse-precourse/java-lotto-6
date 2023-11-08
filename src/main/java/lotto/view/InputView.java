package lotto.view;

import static lotto.util.Message.InputMessage.INPUT_BUDGET;
import static lotto.util.Message.InputMessage.INPUT_WINNING_NUMBER;
import static lotto.util.Message.InputMessage.INPUT_BONUS_NUMBER;

import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.util.Validator;
import lotto.util.Constant;

public class InputView {
    Validator validator = new Validator();

    public int inputBudget() {
        System.out.println(INPUT_BUDGET.getMessage());
        String input = Console.readLine();
        while (true) {
            try {
                validator.validateBudget(input);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                input = Console.readLine();
            }
        }

        int budget = Integer.parseInt(input);
        return budget / Constant.LOTTO_PRICE;
    }

    public ArrayList<Integer> inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER.getMessage());
        String input = Console.readLine();
        ArrayList<Integer> winningNumber = new ArrayList<>();
        while (true) {
            try {
                validator.validateWinningNumber(input);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                input = Console.readLine();
            }
        }

        return splitNumber(input);
    }

    public int inputBonusNumber(ArrayList<Integer> winningNumber) {
        System.out.println(INPUT_BONUS_NUMBER.getMessage());
        String input = Console.readLine();
        while (true) {
            try {
                validator.validateBonusNumber(input, winningNumber);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                input = Console.readLine();
            }
        }
        return Integer.parseInt(input);
    }

    public ArrayList<Integer> splitNumber(String input) {
        validator.validateWinningNumber(input);
        return Arrays
                .stream(input.split(Constant.COMMA))
                .map(Integer::parseInt)
                        .collect(Collectors.toCollection(ArrayList::new));
    }

}
