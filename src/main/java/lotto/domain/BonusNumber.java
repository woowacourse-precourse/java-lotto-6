package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.Number.*;
import static lotto.constant.message.ErrorMessage.*;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, Lotto winningNumber) {
        validate(bonusNumber, winningNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber, Lotto winningNumber) {
        isDistinct(bonusNumber, winningNumber);
        isInRange(bonusNumber);
    }

    private void isDistinct(int bonusNumber, Lotto winningNumber) throws IllegalArgumentException {
        List<Integer> tempWinningNumber = winningNumber.getLottoNumber();
        Set<Integer> tempLotto = new HashSet<>(tempWinningNumber);
        tempLotto.add(bonusNumber);
        if (tempWinningNumber.size() == tempLotto.size()) {
            System.out.println(IS_NOT_DISTINCT);
            throw new IllegalArgumentException();
        }
    }

    private void isInRange(int bonusNumber) throws IllegalArgumentException {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            System.out.println(IS_NOT_IN_RANGE);
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
