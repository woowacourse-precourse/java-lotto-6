package lotto.domain;

import java.util.List;

public class LottoWinningNumbers {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoWinningNumbers of(List<Integer> winningNumbers, int bonusNumber) {
        validateBonusNumberNotIncluded(winningNumbers, bonusNumber);
        return new LottoWinningNumbers(winningNumbers, bonusNumber);
    }

    private static void validateBonusNumberNotIncluded(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 중복될 수 없습니다.");
        }
    }

    public boolean hasWinningNumber(int number) {
        return this.winningNumbers.contains(number);
    }

    public int calculateWinningNumberCount(Lotto lotto) {
        return Math.toIntExact(
                this.winningNumbers.stream()
                        .filter(lotto::hasNumber)
                        .count()
        );
    }

    public boolean matchesBonusNumber(Lotto lotto) {
        return lotto.hasNumber(this.bonusNumber);
    }

}
