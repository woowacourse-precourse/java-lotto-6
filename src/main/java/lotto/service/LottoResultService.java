package lotto.service;

import lotto.constant.RankCategory;
import lotto.model.*;
import lotto.model.LottoBundle;
import lotto.model.LottoPurchaseAmount;
import lotto.model.LottoResult;
import lotto.model.ProfitRate;
import lotto.model.BonusNumber;
import lotto.model.WinningNumbers;

import java.util.EnumMap;
import java.util.List;

import static lotto.constant.RankCategory.*;

public class LottoResultService {

    public LottoResult calculateResults(LottoBundle lottoBundle, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        EnumMap<RankCategory, Integer> results = getInitializedEnumMap();
        for (Lotto lotto : lottoBundle.getLottoBundle()) {
            int matchingNumbers = countMatchingNumbers(winningNumbers, lotto);
            boolean bonusStatus = checkBonusStatus(bonusNumber, lotto);
            RankCategory rankCategory = of(matchingNumbers, bonusStatus);
            results.put(rankCategory, results.get(rankCategory) + 1);
        }
        return new LottoResult(results);
    }

    public ProfitRate calculateProfitRate(LottoResult lottoResult, LottoPurchaseAmount lottoPurchaseAmount) {
        int profitSum = getProfitSum(lottoResult);
        return new ProfitRate(((double) profitSum / lottoPurchaseAmount.getAmount()) * 100);
    }

    private int getProfitSum(LottoResult lottoResult) {
        int profitSum = 0;
        for (RankCategory rankCategory : values()) {
            int rankCount = lottoResult.getResults().get(rankCategory);
            profitSum += rankCount * rankCategory.getPrize();
        }
        return profitSum;
    }

    private boolean checkBonusStatus(BonusNumber bonusNumber, Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.getNumber());
    }

    private int countMatchingNumbers(WinningNumbers winningNumbers, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return (int) winningNumbers.getNumbers().stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    private EnumMap<RankCategory, Integer> getInitializedEnumMap() {
        EnumMap<RankCategory, Integer> results = new EnumMap<>(RankCategory.class);
        for (RankCategory rankCategory : values()) {
            results.put(rankCategory, 0);
        }
        return results;
    }

}
