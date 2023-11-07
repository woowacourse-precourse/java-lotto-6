package lotto.View.InputView;

import static lotto.Model.GenerateNumbers.MAX_RANGE;
import static lotto.Model.GenerateNumbers.MIN_RANGE;
import static lotto.View.SystemMessage.ERROR_DUPLICATE_BONUS;
import static lotto.View.SystemMessage.ERROR_INVALID_BONUS;
import static lotto.View.SystemMessage.GUESS_BONUS_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputBonus {

    private final int bonus;
    private final List<Integer> winningNumbers;

    public InputBonus(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
        System.out.println(GUESS_BONUS_NUMBERS.getMessage());
        bonus = generateBonus();
        System.out.println();
    }

    private int generateBonus() {
        int result;
        while (true) {
            try {
                String input = Console.readLine();
                result = validateBonus(input, winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

    private int validateBonus(String input, List<Integer> winningNumbers) {
        int result;
        try {
            result = Integer.parseInt(input);
            if (result < MIN_RANGE || result > MAX_RANGE)
                throw new IllegalArgumentException(ERROR_INVALID_BONUS.getMessage());
            if (winningNumbers.contains(result))
                throw new IllegalArgumentException(ERROR_DUPLICATE_BONUS.getMessage());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_BONUS.getMessage());
        }
        return result;
    }

    public int getBonus() {
        return bonus;
    }
}
