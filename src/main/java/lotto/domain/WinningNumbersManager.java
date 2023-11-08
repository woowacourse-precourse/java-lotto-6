package lotto.domain;

import java.util.List;

public class WinningNumbersManager {
    private static final String WINNING_NUMBERS_SIZE_6_REQUIRED = "당첨 번호는 6개여야합니다";
    private static final String WINNING_NUMBERS_RANGE_ERROR = "당첨 번호는 1~45 사이의 숫자여야합니다";
    private static final String BONUS_NUMBER_OVERLAP_WITH_WINNING_NUMBERS = "보너스 번호는 당첨 번호와 중복되면 안됩니다";
    private static final String BONUS_NUMBERS_RANGE_ERROR = "보너스 번호는 1~45 사이의 숫자여야합니다";

    private List<Integer> winningNumbers;
    private int bonusNumber;

    void inputWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbersSize(winningNumbers);
        validateNumberRange(winningNumbers);
        validateDuplicateNumber(winningNumbers);
    }

    private static void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SIZE_6_REQUIRED);
        }
    }

    private void validateDuplicateNumber(List<Integer> winningNumbers) {
        long removeDuplicatedSize = winningNumbers.stream().distinct().count();
        if (winningNumbers.size() != removeDuplicatedSize) {
            throw new IllegalArgumentException(WINNING_NUMBERS_RANGE_ERROR);
        }
    }

    private void validateNumberRange(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            validateNumberRange(number);
        }
    }

    private void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(BONUS_NUMBERS_RANGE_ERROR);
        }
    }

    public void inputBonusNumber(Integer bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Integer inputBonusNumber) {
        validateNumberRange(inputBonusNumber);
        validateIsOverlapWithWinningNumber(inputBonusNumber);
    }

    private void validateIsOverlapWithWinningNumber(Integer inputBonusNumber) {
        for (Integer number : winningNumbers) {
            if (number.equals(inputBonusNumber)) {
                throw new IllegalArgumentException(BONUS_NUMBER_OVERLAP_WITH_WINNING_NUMBERS);
            }
        }
    }

    public WinningStatus getWinningStatus(List<Lotto> lottos) {
        WinningStatus winningStatus = new WinningStatus();

        for (Lotto lotto : lottos) {
            PrizeType status = getWinningStatus(lotto);
            winningStatus.add(status);
        }

        return winningStatus;
    }

    private PrizeType getWinningStatus(Lotto lotto) {
        int matchNumber = lotto.countMatchNumber(winningNumbers);
        boolean isMatchWithBonusNumber = lotto.isMatch(bonusNumber);

        return PrizeType.valueOfMatchCount(matchNumber, isMatchWithBonusNumber);
    }
}
