package lotto.domain;

public final class LottoMatcher {

    private final WinningNumbers winningNumbers;

    public LottoMatcher(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int countMatchesForLotto(Lotto lotto) {
        return countMatchedNumbers(lotto);
    }

    public boolean hasMatchingBonusNumber(Lotto lotto) {
        return lotto.numbers().contains(winningNumbers.bonusNumber());
    }

    private int countMatchedNumbers(Lotto lotto) {
        return (int) winningNumbers.drawnNumbers().stream()
            .filter(lotto.numbers()::contains)
            .count();
    }
}
