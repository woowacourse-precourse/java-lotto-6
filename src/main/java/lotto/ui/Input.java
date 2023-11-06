package lotto.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.InputValidation;
import lotto.domain.Lotto;

public class Input {
    public static char DELIMITER = ',';
    public static final String AMOUNT = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    public static final String BONUS = "\n보너스 번호를 입력해 주세요.";

    public static int readAmount(String input) {
        int amount = InputValidation.validateNumber(input);
        InputValidation.checkSufficient(amount);
        InputValidation.checkDivisible(amount);
        return amount;
    }

    public static List<Integer> readWinningNumber(String input) {
        InputValidation.checkDelimiter(input);
        List<String> vocabulary = Arrays.asList(input.split(DELIMITER + ""));
        List<Integer> numbers = new ArrayList<>();
        for (String word : vocabulary) {
            numbers.add(InputValidation.validateNumber(word));
        }
        return numbers;
    }

    public static int readBonus(String input, Lotto winningNumber) {
        int bonus = InputValidation.validateNumber(input);
        InputValidation.checkRange(bonus);
        InputValidation.checkOverlap(bonus, winningNumber);
        return bonus;
    }
}
