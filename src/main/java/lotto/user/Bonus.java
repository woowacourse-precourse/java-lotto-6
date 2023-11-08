package lotto.user;

import lotto.Validation;

import java.util.ArrayList;
import java.util.List;

public class Bonus {
    private static final Validation validation = new Validation();

    public int getBonusNumber(String bonusLotto, List<Integer> winningNumbers) {
        validation.checkNull(bonusLotto);
        try {
            int bonusNumber = convertStringToInteger(bonusLotto);
            validateNumber(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력해야 합니다.");
        }
    }

    private void validateNumber(int bonusNumber, List<Integer> winningNumbers) {
        validation.checkRange(bonusNumber, 1, 45);
        List<Integer> totalWinningLotto = new ArrayList<>(winningNumbers);
        totalWinningLotto.add(bonusNumber);
        validation.checkDuplication(totalWinningLotto);
    }

    private static Integer convertStringToInteger(String number) {
        number = number.trim();
        return Integer.parseInt(number);
    }
}
