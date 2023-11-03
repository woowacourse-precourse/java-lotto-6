package lotto.model;

import java.util.List;

public class WinningNumbers {

    private static final String WINNING_NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE = "[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.";
    private static final String INVALID_WINNING_NUMBERS_COUNT_EXCEPTION_MESSAGE = "[ERROR] 당첨 번호는 6개 입력해야 합니다.";
    private static final String DUPLICATE_WINNING_NUMBERS_EXCEPTION_MESSAGE = "[ERROR] 당첨 번호는 서로 다른 숫자로 입력해야 합니다.";

    private final List<Integer> winningNumbers;
    private final int bonus;

    public WinningNumbers(List<Integer> winningNumbers, int bonus) {
        validateNumberInRange(winningNumbers);
        validateWinningNumbersCount(winningNumbers);
        validateDuplicate(winningNumbers);
        validateForDuplicateWinningNumbersAndBonus(winningNumbers, bonus);
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    public Rank findRank(Lotto lotto) {
        int matchingNumber = countMatchingNumber(lotto);
        boolean bonusMatch = isEqualToBonus(lotto);

        if (Rank.isEqualsToFirstRankMatchingNumber(matchingNumber)) {
            return Rank.FIRST;
        }
        if (Rank.isEqualsToSecondRankMatchingNumber(matchingNumber) && Rank.isSameBonus(bonusMatch)) {
            return Rank.SECOND;
        }
        if (Rank.isEqualsToThirdRankMatchingNumber(matchingNumber) && !Rank.isSameBonus(bonusMatch)) {
            return Rank.THIRD;
        }
        if (Rank.isEqualsToFourthRankMatchingNumber(matchingNumber)) {
            return Rank.FOURTH;
        }
        if (Rank.isEqualsToFifthRankMatchingNumber(matchingNumber)) {
            return Rank.FIFTH;
        }
        return Rank.NONE;
    }

    private int countMatchingNumber(Lotto lotto) {
        return (int) winningNumbers.stream()
                .filter(winningNumber -> lotto.hasNumber(winningNumber))
                .count();
    }

    private boolean isEqualToBonus(Lotto lotto) {
        return lotto.hasNumber(bonus);
    }

    private void validateNumberInRange(List<Integer> winningNumbers) {
        for (final Integer winningNumber : winningNumbers) {
            if (isWinningNumberValid(winningNumber)) {
                throw new IllegalArgumentException(WINNING_NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE);
            }
        }
    }

    private boolean isWinningNumberValid(Integer winningNumber) {
        return winningNumber < LottoConstants.START_NUMBER || winningNumber > LottoConstants.END_NUMBER;
    }

    private void validateWinningNumbersCount(List<Integer> winningNumbers) {
        if (isNotSameWinningNumbersSize(winningNumbers)) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private boolean isNotSameWinningNumbersSize(List<Integer> winningNumbers) {
        return winningNumbers.size() != LottoConstants.LOTTO_NUMBER_SIZE;
    }

    private void validateDuplicate(List<Integer> winningNumbers) {
        if (isNotSameWinningNumbersSize(removeDuplicateWinningNumbers(winningNumbers))) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBERS_EXCEPTION_MESSAGE);
        }
    }

    private List<Integer> removeDuplicateWinningNumbers(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .distinct()
                .toList();
    }

    private void validateForDuplicateWinningNumbersAndBonus(List<Integer> winningNumbers, int bonus) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복이 되면 안 됩니다,");
        }
    }
}
