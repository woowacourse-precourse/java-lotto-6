package lotto;

import java.util.List;

import static lotto.LottoProperty.LOTTO_MIN_NUMBER;
import static lotto.LottoProperty.LOTTO_MAX_NUMBER;

public class BonusNumber {
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
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다");
        }
    }

    private void validateRange(int number) {
        if (number < LOTTO_MIN_NUMBER.getLottoProperty() ||
                number > LOTTO_MAX_NUMBER.getLottoProperty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다");
        }
    }

    private void validateDuplication(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 달라야 합니다");
        }
    }

    public boolean checkBonus(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonus);
    }
}
