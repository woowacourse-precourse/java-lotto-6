package lotto.Model;

import static lotto.Dictionary.LottoDictionary.*;
import static lotto.Domain.LottoResult.Rank.*;

import java.util.ArrayList;
import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGroup;
import lotto.Domain.LottoResult.LottoResult;
import lotto.Domain.WinningLotto.WinningLotto;

public class LottoResultHandlerModel {

    private final LottoResult lottoResult;
    private final WinningLotto winningLotto;
    private final LottoGroup lottoGroup;

    private LottoResultHandlerModel(WinningLotto winningLotto, LottoGroup lottoGroup) {
        lottoResult = LottoResult.from();
        this.winningLotto = winningLotto;
        this.lottoGroup = lottoGroup;
        checkAllWinning();
    }

    public static LottoResultHandlerModel of(WinningLotto winningLotto, LottoGroup lottoGroup) {
        return new LottoResultHandlerModel(winningLotto, lottoGroup);
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public float findProfitRate() {
        float rate = (float) lottoResult.findTotalAward()
                / (lottoGroup.findLottoNumbersSize() * LOTTO_PRICE.getValue()) * 100;

        return (float) (Math.round(rate * 100.0) / 100.0);
    }

    public void checkAllWinning() {
        for (int i = 0; i < lottoGroup.findLottoNumbersSize(); i++) {
            Lotto lottoByIndex = lottoGroup.findLottoByIndex(i);
            Integer matchCount = checkWinning(winningLotto.getLotto(), lottoByIndex);
            Integer rank = convertRank(matchCount, checkBonusNumber(lottoByIndex));
            if (rank != MISS.getValue()) {
                lottoResult.increaseWinningCount(rank);
            }
        }
    }

    private Integer checkWinning(Lotto winningLotto, Lotto purchasedLotto) {
        List<Integer> matchNumbers = new ArrayList<>(purchasedLotto.getNumbers());
        matchNumbers.retainAll(winningLotto.getNumbers());
        return matchNumbers.size();
    }

    private boolean checkBonusNumber(Lotto purchasedLotto) {
        return purchasedLotto.getNumbers().contains(winningLotto.getBonusNumber().getNumber());
    }

    private Integer convertRank(Integer matchCount, boolean isBonusNumberMatched) {
        if (matchCount == 6)
            return FIRST.getValue();
        if (matchCount == 5 && isBonusNumberMatched)
            return SECOND.getValue();
        if (matchCount == 5)
            return THIRD.getValue();
        if (matchCount == 4)
            return FOURTH.getValue();
        if (matchCount == 3)
            return FIFTH.getValue();

        return MISS.getValue();
    }
}