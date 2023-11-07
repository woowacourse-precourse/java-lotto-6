package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String DUPLICATE_WINNING_BONUS_NUMBER_ERROR = "[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.";
    private static final String NOT_INTEGER_BONUS_NUMBER_ERROR = "[ERROR] 보너스 번호는 정수여야 합니다.";
    private static final String INVALID_BONUS_NUMBER_RANGE_ERROR = "[ERROR] 보너스 번호는 %d부터 %d 사이의 수여야 합니다.";
    private final Lotto winningLotto;
    private final int bonusNumber;

    private WinningLotto(Lotto winningLotto, String bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumberValidator(bonusNumber);
    }

    public static WinningLotto create(Lotto winningLotto, String bonusNumber) {
        validateNoDuplicateNumber(winningLotto.getNumbers(), bonusNumber);
        return new WinningLotto(winningLotto, bonusNumber);
    }

    public Lotto getWinningLotto() {
        return this.winningLotto;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private static void validateNoDuplicateNumber(List<Integer> numbers, String bonusNumberStr) {
        List<String> numbersStr = numbers.stream()
                .map(number -> String.valueOf(number))
                .collect(Collectors.toList());
        if (numbersStr.contains(bonusNumberStr)) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_BONUS_NUMBER_ERROR);
        }
    }

    private int bonusNumberValidator(String bonusNumberStr) {
        int bonusNumber = validateNotInteger(bonusNumberStr);
        validateInvalidLottoNumberRange(bonusNumber);
        return bonusNumber;
    }

    private int validateNotInteger(String bonusNumberStr) {
        try {
            return Integer.parseInt(bonusNumberStr);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException(NOT_INTEGER_BONUS_NUMBER_ERROR);
        }
    }

    private void validateInvalidLottoNumberRange(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(String.format(INVALID_BONUS_NUMBER_RANGE_ERROR, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER));
        }
    }
}
