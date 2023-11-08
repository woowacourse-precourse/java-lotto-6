package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import lotto.common.Announcement;
import lotto.common.Constraint;
import lotto.common.ErrorMessage;

public class LottoDrawMachine {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    LottoDrawMachine() {
    }

    public void drawNumberManual() {
        this.winningNumbers = getWinningNumbersFromInput();
        this.bonusNumber = getBonusNumberFromInput();
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private List<Integer> getWinningNumbersFromInput() {
        Announcement.INPUT_WINNING_NUMBERS.speak();
        while (true) {
            try {
                String[] inputStrings = Console.readLine().split(",");
                validateNumeric(inputStrings);
                List<Integer> winningNumbers = Arrays.stream(inputStrings)
                    .map(Integer::parseInt)
                    .toList();
                validateOverSize(winningNumbers, Constraint.LOTTO_MAX_SIZE.getValue());
                validateOutOfRange(
                    winningNumbers,
                    Constraint.LOTTO_MIN_NUMBER.getValue(),
                    Constraint.LOTTO_MAX_NUMBER.getValue()
                );
                validateDuplicated(winningNumbers);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                ErrorMessage.printExceptionMessage(e);
            }
        }
    }

    private int getBonusNumberFromInput() {
        Announcement.INPUT_BONUS_NUMBER.speak();
        while (true) {
            try {
                String inputNumber = Console.readLine();
                validateNumeric(inputNumber);
                int bonusNumber = Integer.parseInt(inputNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                ErrorMessage.printExceptionMessage(e);
            }
        }
    }

    private void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_NUMERIC.getMessage());
        }
    }

    private void validateNumeric(String[] inputStrings) {
        try {
            for (String input : inputStrings) {
                Integer.parseInt(input);
            }
        } catch (Exception exception) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_NUMERIC.getMessage());
        }
    }

    private void validateOverSize(List<Integer> numbers, int constraint) {
        if (numbers.size() != constraint) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OVER_SIZE.getMessage());
        }
    }

    private void validateOutOfRange(List<Integer> numbers, int startInclusive, int endInclusive) {
        for (Integer number : numbers) {
            if (number < startInclusive || number > endInclusive) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            }
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (Set.copyOf(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATED.getMessage());
        }
    }

}
