package lotto.domain;

import lotto.utils.GameRules;


public class WinNumber {
    private static final String INVALID_BONUS_NUMBER_DUPLICATION_ERROR_MESSAGE = "[ERROR] 당첨 번호와 중복됩니다.";
    private static final String INVALID_WIN_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 1~45 범위 내 번호를 입력해주세요.";
    private final Lotto pickNumbers;
    private final int bonusNumber;

    private WinNumber(Lotto pickNumbers, int bonusNumber) {
        this.pickNumbers = pickNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinNumber from(Lotto pickNumbers, int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateDuplicationWithBonusNumber(pickNumbers, bonusNumber);
        return new WinNumber(pickNumbers, bonusNumber);
    }

    private static void validateDuplicationWithBonusNumber(Lotto pickNumbers, int bonusNumber) {
        if (pickNumbers.getNumber().contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < GameRules.START_RANGE.getValue() || bonusNumber > GameRules.END_RANGE.getValue()) {
            throw new IllegalArgumentException(INVALID_WIN_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public Lotto getPickNumbers() {
        return pickNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}