package lotto.domain;

public class LottoCalculator {
    private final int SPECIAL_MATCH = 7;
    private final Lotto winningNumber;
    private final int bonusNumber;

    public LottoCalculator(WinningNumbers winningNumbers) {
        this.winningNumber = winningNumbers.getWinningNumber();
        this.bonusNumber = winningNumbers.getBonusNumber();
    }

    public int countMatchNumbers(Lotto lotto) {
        int matchCount = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winningNumber.getNumbers().contains(number)) {
                matchCount++;
            }
            if (matchCount == 5 && isContainBonusNumber(lotto)) {
                return SPECIAL_MATCH;
            }
        }
        return matchCount;
    }

    private boolean isContainBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
