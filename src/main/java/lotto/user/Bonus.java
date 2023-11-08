package lotto.user;

import lotto.Validation;

import java.util.ArrayList;
import java.util.List;

public class Bonus {
    private static final Validation validation = new Validation();
    private static final int LOTTO_RANGE_MIN = 1;
    private static final int LOTTO_RANGE_MAX = 45;

    public int getBonusNumber(
            String bonusLotto, List<Integer> winningNumbers
    ) {
        validation.checkNull(bonusLotto);
        try {
            int bonusNumber = convertStringToInteger(bonusLotto);
            validateNumber(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력해야 합니다.");
        }
    }

    private void validateNumber(
            int bonusNumber, List<Integer> winningNumbers
    ) {
        validation.checkRange(
                bonusNumber, LOTTO_RANGE_MIN, LOTTO_RANGE_MAX
        );
        List<Integer> totalWinningLotto = new ArrayList<>(winningNumbers);
        totalWinningLotto.add(bonusNumber);
        validation.checkDuplication(totalWinningLotto);
    }

    private static Integer convertStringToInteger(String number) {
        number = number.trim();
        return Integer.parseInt(number);
    }
}
