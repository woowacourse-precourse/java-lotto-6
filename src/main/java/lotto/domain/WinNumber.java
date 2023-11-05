package lotto.domain;

import lotto.utils.GameRules;
import lotto.view.InputView;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinNumber {
    private static final String INVALID_WIN_NUMBER_DUPLICATION_ERROR_MESSAGE = "[ERROR] 중복된 번호가 존재합니다.";
    private static final String INVALID_WIN_NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 1~45 범위 내 번호를 입력해주세요.";
    private static final String INVALID_BONUS_NUMBER_DUPLICATION_ERROR_MESSAGE = "[ERROR] 당첨 번호와 중복됩니다.";
    private static final String INVALID_NUMBER_COUNT_ERROR_MESSAGE = "[ERROR] 6개의 숫자를 입력해주세요.";
    private final List<Integer> pickNumbers;
    private final int bonusNumber;

    private WinNumber(List<Integer> pickNumbers, int bonusNumber) {
        this.pickNumbers = pickNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinNumber from(List<Integer> pickNumbers, int bonusNumber) {
        try {
            validateNumberCount(pickNumbers);
            validateDuplicationInPickNumber(pickNumbers);
            validateNumberRange(pickNumbers);
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
        if(pickNumbers.contains(bonusNumber))  {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicationInPickNumber(List<Integer> pickNumbers) {
        Set<Integer> winNumbers = new HashSet<>(pickNumbers);
        if (winNumbers.size() != GameRules.NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_WIN_NUMBER_DUPLICATION_ERROR_MESSAGE);
        }
    }

    private static void validateNumberRange(List<Integer> pickNumbers) {
        if (pickNumbers.stream().anyMatch(number -> number < GameRules.START_RANGE.getValue() || number > GameRules.END_RANGE.getValue())) {
            throw new IllegalArgumentException(INVALID_WIN_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private static void validateNumberCount(List<Integer> pickNumbers) {
        if (pickNumbers.size() != GameRules.NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT_ERROR_MESSAGE);
        }
    }
}
