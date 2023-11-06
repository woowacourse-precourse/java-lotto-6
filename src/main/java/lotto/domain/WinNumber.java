package lotto.domain;

import lotto.view.InputView;

import java.util.Collections;
import java.util.List;

public class WinNumber {
    private static final String INVALID_BONUS_NUMBER_DUPLICATION_ERROR_MESSAGE = "[ERROR] 당첨 번호와 중복됩니다.";
    private final List<Integer> pickNumbers;
    private final int bonusNumber;

    private WinNumber(List<Integer> pickNumbers, int bonusNumber) {
        this.pickNumbers = pickNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinNumber from(List<Integer> pickNumbers, int bonusNumber) {
        try {
            validateDuplicationWithBonusNumber(pickNumbers, bonusNumber);
            return new WinNumber(pickNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return WinNumber.from(InputView.inputWinNumbers(), InputView.inputBonusNumber());
        }
    }

    public List<Integer> getPickNumbers() {
        return Collections.unmodifiableList(pickNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private static void validateDuplicationWithBonusNumber(List<Integer> pickNumbers, int bonusNumber) {
        if (pickNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_DUPLICATION_ERROR_MESSAGE);
        }
    }
}