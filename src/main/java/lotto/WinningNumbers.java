package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(String inputWinningLotto, String inputBonus) {
        validateInputLotto(inputWinningLotto);
        validateInputBonus(inputBonus);
        this.winningLotto = new Lotto(inputToNumbers(inputWinningLotto));
        this.bonusNumber = inputToNumber(inputBonus);
    }

    public Lotto getWinningLotto() {
        return this.winningLotto;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validateInputLotto(String inputLotto) {
        if (inputLotto.isEmpty() || inputLotto.equals(LINE_SEPARATION)) {
            throw new IllegalArgumentException();
        }
        if (inputLotto.contains(BLANK)) {
            throw new IllegalArgumentException();
        }
        if (!Pattern.matches("^[0-9,]+$", inputLotto)) {
            throw new IllegalArgumentException();
        }
        if (inputLotto.contains(COMMA + COMMA)) {
            throw new IllegalArgumentException();
        }
        if (Pattern.matches("^(,.*|.*,|,)$", inputLotto)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputBonus(String inputBonus) {
        if (inputBonus.isEmpty() || inputBonus.equals(LINE_SEPARATION)) {
            throw new IllegalArgumentException();
        }
        if (inputBonus.contains(BLANK)) {
            throw new IllegalArgumentException();
        }
        if (!Pattern.matches("^[0-9]+$", inputBonus)) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> inputToNumbers(String inputLotto) {
        List<Integer> numbers = new ArrayList<>();
        for (String splittedInput : inputLotto.split(COMMA)) {
            numbers.add(Integer.parseInt(splittedInput));
        }
        return numbers;
    }

    private int inputToNumber(String inputBonus) {
        int number = Integer.parseInt(inputBonus);
        validateRange(number, MIN_NUMBER, MAX_NUMBER);
        validateDuplicates(number);
        return number;
    }

    private void validateRange(int number, int minNumber, int maxNumber) {
        if (number < minNumber) {
            throw new IllegalArgumentException();
        }
        if (number > maxNumber) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicates(int number) {
        if (winningLotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException();
        }
    }
}
