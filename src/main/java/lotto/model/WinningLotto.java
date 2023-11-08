package lotto.model;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank match(Lotto other) {
        int matchCount = 0;
        for (int number : other.getNumbers()) {
            if (lotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        boolean bonusMatch = other.getNumbers().contains(bonusNumber);
        return LottoRank.valueOf(matchCount, bonusMatch);
    }
}
