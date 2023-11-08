package lotto;

public class LottoComparator {

    public LottoResult compare(WinningLotto winningLotto, Lotto userLotto) {
        long matchCount = userLotto.getNumbers().stream()
                .filter(winningLotto.getWinningNumbers()::contains)
                .count();

        boolean bonusMatch = userLotto.getNumbers().contains(winningLotto.getBonusNumber());

        return new LottoResult((int) matchCount, bonusMatch);
    }
}
