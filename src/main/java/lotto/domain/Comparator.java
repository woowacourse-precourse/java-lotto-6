package lotto.domain;

public class Comparator {
    WinningLotto winningLotto;

    public Comparator(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoRank compareWithWinningLotto(Lotto purchasedLotto) {
        int hitCountOfLottoNumbers = getHitCountOfLottoNumbers(purchasedLotto);
        boolean hasBonusNumber = isHasBonusNumber(purchasedLotto);

        return LottoRank.valueOf(hitCountOfLottoNumbers, hasBonusNumber);
    }

    private boolean isHasBonusNumber(Lotto purchasedLotto) {
        return purchasedLotto.getNumbers().contains(winningLotto.getBonusNumber());
    }

    private int getHitCountOfLottoNumbers(Lotto purchasedLotto) {
        int hitCount = 0;
        for (int number : winningLotto.getWinningLottoNumbers()) {
            if (purchasedLotto.getNumbers().contains(number))
                hitCount += 1;
        }
        return hitCount;
    }
}
