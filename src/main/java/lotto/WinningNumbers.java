package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(String inputWinningLotto, String inputBonus) {
        validateInputLotto(inputWinningLotto);
        this.winningLotto = new Lotto(inputToNumbers(inputWinningLotto));
        validateInputBonus(inputBonus);
        this.bonusNumber = inputToNumber(inputBonus);
    }

    public Lotto getWinningLotto() {
        return this.winningLotto;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateInputLotto(String inputLotto) {
        if (inputLotto.isEmpty() || inputLotto.equals(StringConstants.LINE_SEPARATION)) {
            throw new IllegalArgumentException(Error.EMPTY_INPUT.getMessage());
        }
        if (inputLotto.contains(StringConstants.BLANK)) {
            throw new IllegalArgumentException(Error.CONTAINS_BLANK.getMessage());
        }
        if (!Pattern.matches(StringConstants.REG_NUMBER_COMMA_STRING, inputLotto)) {
            throw new IllegalArgumentException(Error.CONTAINS_NOT_NUMBER_COMMA.getMessage());
        }
        if (inputLotto.contains(StringConstants.COMMA + StringConstants.COMMA)) {
            throw new IllegalArgumentException(Error.CONTAINS_CONTINUAL_COMMA.getMessage());
        }
        if (Pattern.matches(StringConstants.REG_COMMA_EDGE_STRING, inputLotto)) {
            throw new IllegalArgumentException(Error.WITH_COMMA_EDGE.getMessage());
        }
    }

    private void validateInputBonus(String inputBonus) {
        if (inputBonus.isEmpty() || inputBonus.equals(StringConstants.LINE_SEPARATION)) {
            throw new IllegalArgumentException();
        }
        if (inputBonus.contains(StringConstants.BLANK)) {
            throw new IllegalArgumentException();
        }
        if (!Pattern.matches(StringConstants.REG_NUMBER_STRING, inputBonus)) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> inputToNumbers(String inputLotto) {
        List<Integer> numbers = new ArrayList<>();
        for (String splittedInput : inputLotto.split(StringConstants.COMMA)) {
            numbers.add(Integer.parseInt(splittedInput));
        }
        return numbers;
    }

    private int inputToNumber(String inputBonus) {
        int number = Integer.parseInt(inputBonus);
        validateRange(number, NumberConstants.MIN_NUMBER, NumberConstants.MAX_NUMBER);
        validateDuplicates(number);
        return number;
    }

    private void validateRange(int number, int minNumber, int maxNumber) {
        if (number < minNumber) {
            throw new IllegalArgumentException(Error.TOO_SMALL.getMessage());
        }
        if (number > maxNumber) {
            throw new IllegalArgumentException(Error.TOO_LARGE.getMessage());
        }
    }

    private void validateDuplicates(int number) {
        if (winningLotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException(Error.CONTAINS_DUPLICATE.getMessage());
        }
    }
}
