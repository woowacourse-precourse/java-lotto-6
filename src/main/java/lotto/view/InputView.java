package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputException;
import lotto.util.Converter;
import lotto.util.Log;

import java.util.List;

public class InputView extends Message {
    private static final Log log = new Log();
    public int purchaseAmountInput() {
        System.out.println(INPUT_PRICE_MESSAGE);
        try {
            String input = Console.readLine();
            InputException.isValid(input);
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
            return purchaseAmountInput();
        }
    }

    public List<Integer> winningNumberInput() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        try {
            String input = Console.readLine();
            InputException.isWinningNumberValid(input);
            return Converter.stringToIntList(input);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
            return winningNumberInput();
        }
    }

    public int bonusNumberInput() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        try {
            String input = Console.readLine();
            InputException.isBounusNumberValid(input);
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
            return bonusNumberInput();
        }
    }
}