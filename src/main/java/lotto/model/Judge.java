package lotto.model;

import java.util.List;

public class Judge {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;
    private final List<Lotto> purchasedLotto;

    public Judge(Lotto winningLotto, LottoNumber bonusNumber, User user) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.purchasedLotto = user.getPurchasedLotto();
    }

    public LottoResult draw() {
        LottoResultCount lottoResultCount = new LottoResultCount();
        int matchedCnt = 0;
        for (Lotto purchasedLotto : purchasedLotto) {
            matchedCnt = compareLotto(purchasedLotto);
            updateDrawResult(lottoResultCount, purchasedLotto, matchedCnt);
        }
        return lottoResultCount.toLottoResult();
    }

    private int compareLotto(Lotto purchasedLotto) {
        List<LottoNumber> winningLottoNumbers = winningLotto.getLottoNumbers();
        List<LottoNumber> purchasedLottoLottoNumbers = purchasedLotto.getLottoNumbers();
        return (int) purchasedLottoLottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();
    }

    private boolean isBonusMatched(Lotto purchasedLotto) {
        return purchasedLotto.getLottoNumbers().contains(bonusNumber);
    }

    private void updateDrawResult(LottoResultCount lottoResultCount, Lotto purchasedLotto,int matchedCnt) {
        if (matchedCnt == 6) {
            lottoResultCount.incrementFirst();
        } else if (matchedCnt == 5 && isBonusMatched(purchasedLotto)) {
            lottoResultCount.incrementSecond();
        } else if (matchedCnt == 5) {
            lottoResultCount.incrementThird();
        } else if (matchedCnt == 4) {
            lottoResultCount.incrementFourth();
        } else if (matchedCnt == 3) {
            lottoResultCount.incrementFifth();
        }
    }

    public double calculateReturnRate(LottoResult drawResult, int spentMoney) {
        long winningAmount = drawResult.totalPrize();
        double returnRate = (double) winningAmount / spentMoney * 100;
        return Math.round(returnRate * 10.0) / 10.0;
    }
}
