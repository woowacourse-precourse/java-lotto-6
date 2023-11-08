package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.common.Announcement;
import lotto.common.Constraint;
import lotto.common.ErrorMessage;

public class LottoDrawMachine {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    LottoDrawMachine() {
//        this.winningNumbers = new ArrayList<>();
    }

    public void drawNumberManual() {
        // winningNumber 입력 받기
        this.winningNumbers = getWinningNumbersFromInput();
        System.out.println(this.winningNumbers);
        // bonusNumber 입력받기
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
                String[] inputNumbers = Console.readLine().split(",");
                validateNumericOfInputStrings(inputNumbers);
                List<Integer> winningNumbers = Arrays.stream(inputNumbers)
                    .map(Integer::parseInt)
                    .toList();
                validateOverSize(winningNumbers, Constraint.LOTTO_MAX_SIZE.getValue());
                validateOutOfRange(
                    winningNumbers,
                    Constraint.LOTTO_MIN_NUMBER.getValue(),
                    Constraint.LOTTO_MAX_NUMBER.getValue()
                );
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                ErrorMessage.printExceptionMessage(e);
            }
        }
    }

    private void validateNumericOfInputStrings(String[] inputStrings) {
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
}
