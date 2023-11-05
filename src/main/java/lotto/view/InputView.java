package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputException;
import lotto.util.Converter;

import java.util.List;

public class InputView extends Message{
    public int purchaseAmountInput() {
        System.out.println(INPUT_PRICE_MESSAGE);
        String input = Console.readLine();
        InputException.isValid(input);
        return Integer.parseInt(input);
    }

    public List<Integer> winningNumberInput() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String input = Console.readLine();
        InputException.isWinningNumberValid(input);
        return Converter.stringToIntList(input);
    }

    public int bonusNumberInput() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        InputException.isBounusNumberValid(input);
        return Integer.parseInt(input);
    }
}
