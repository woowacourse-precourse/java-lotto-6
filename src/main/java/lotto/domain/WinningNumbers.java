package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class WinningNumbers {

    private static final String NO_DUPLICATE_WINNING_NUMBER_ERROR_MESSAGE = "당첨 번호와 중복된 보너스 번호는 입력할 수 없습니다.";
    private static final String NO_DUPLICATE_ERROR_MESSAGE = "중복된 숫자는 입력할 수 없습니다.";
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "1 ~ 45사이의 숫자만 입력할 수 있습니다.";
    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;

    public WinningNumbers(List<Integer> winningNumber, int bonusNumber) {
        validateOutOfRange(winningNumber);
        validateDuplicateWinningNumber(winningNumber);
        validateDuplicateBonusNumber(winningNumber, bonusNumber);
        this.winningNumber = new WinningNumber(winningNumber);
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    public LottoResults calculateLottoResult(Lotto lotto) {
        int correctCount = winningNumber.calculateCorrectNumberCount(lotto);
        boolean hasBonus = bonusNumber.hasBonus(lotto);
        return LottoResults.getLottoResult(correctCount, hasBonus);
    }

    private void validateDuplicateBonusNumber(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(NO_DUPLICATE_WINNING_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateDuplicateWinningNumber(List<Integer> winningNumber) {
        if (isDuplicateNumbers(winningNumber)) {
            throw new IllegalArgumentException(NO_DUPLICATE_ERROR_MESSAGE);
        }
    }

    private void validateOutOfRange(List<Integer> winningNumber) {
        for (int number : winningNumber) {
            if (isOutOfRange(number)) {
                throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
            }
        }
    }

    private boolean isDuplicateNumbers(List<Integer> winningNumber) {
        return new HashSet<>(winningNumber).size() < 6;
    }

    private boolean isOutOfRange(int number) {
        return 45 < number || number < 1;
    }
}
