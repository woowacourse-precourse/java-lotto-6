package lotto;

import java.util.List;

public class BonusNumber {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static int bonus;

    public BonusNumber(int number, List<Integer> winningNumbers) {
        validateRange(number);
        validateDuplication(number, winningNumbers);
        bonus = number;
    }

    private void validateRange(int number) {
        if (number < LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException();
        }
        if (number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean checkBonus(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonus);
    }
}
