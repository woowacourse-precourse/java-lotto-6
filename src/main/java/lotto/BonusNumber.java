package lotto;

import java.util.List;

public class BonusNumber {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static int bonus;

    public BonusNumber(String stringNumber, List<Integer> winningNumbers) {
        validate(stringNumber, winningNumbers);
        bonus = Integer.parseInt(stringNumber);
    }

    private void validate(String stringNumber, List<Integer> winningNumbers) {
        int number = validateNumber(stringNumber);
        validateRange(number);
        validateDuplication(number, winningNumbers);
    }

    private int validateNumber(String stringNumber) {
        try {
            return Integer.parseInt(stringNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private void validateRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
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
