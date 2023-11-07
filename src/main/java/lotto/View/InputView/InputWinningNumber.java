package lotto.View.InputView;

import static lotto.View.SystemMessage.ERROR_INVALID_RANGE;
import static lotto.View.SystemMessage.GUESS_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputWinningNumber {

    private final String SEPARATOR = ",";
    private final List<Integer> winningNumber;

    public InputWinningNumber() {
        System.out.println(GUESS_WINNING_NUMBERS.getMessage());
        winningNumber = validateInput();
        System.out.println();
    }

    private List<Integer> validateInput() {
        List<Integer> numbers = new ArrayList<>();
        try {
            String input = Console.readLine();
            String[] array = input.split(SEPARATOR);
            for (String number : array) {
                int toNumber = Integer.parseInt(number);
                numbers.add(toNumber);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_RANGE.getMessage());
        }

        return numbers;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

}
