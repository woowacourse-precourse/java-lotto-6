package lotto.service.lotto;

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
    private final int DEFAULT_COUNT = 0;
    private final int INCREASE_NUM = 1;
    private final int PERCENT_MULTIPLIER = 100;


    public LottoResult calculateResults
            (LottoBundle lottoBundle, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        EnumMap<RankCategory, Integer> results = getInitializedEnumMap();
        for (Lotto lotto : lottoBundle.lottoBundle()) {
            int matchingNumbers = countMatchingNumbers(winningNumbers, lotto);
            boolean bonusStatus = checkBonusStatus(bonusNumber, lotto);
            RankCategory rankCategory = of(matchingNumbers, bonusStatus);
            results.put(rankCategory, results.get(rankCategory) + INCREASE_NUM);
        }
        return new LottoResult(results);
    }

    public ProfitRate calculateProfitRate(LottoResult lottoResult, LottoPurchaseAmount lottoPurchaseAmount) {
        int profitSum = getProfitSum(lottoResult);
        return new ProfitRate(((double) profitSum / lottoPurchaseAmount.amount()) * PERCENT_MULTIPLIER);
    }

    private EnumMap<RankCategory, Integer> getInitializedEnumMap() {
        EnumMap<RankCategory, Integer> results = new EnumMap<>(RankCategory.class);
        for (RankCategory rankCategory : values()) {
            results.put(rankCategory, DEFAULT_COUNT);
        }
        return results;
    }

    private int countMatchingNumbers(WinningNumbers winningNumbers, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.numbers();
        return (int) winningNumbers.numbers().stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    private boolean checkBonusStatus(BonusNumber bonusNumber, Lotto lotto) {
        return lotto.numbers().contains(bonusNumber.number());
    }

    private int getProfitSum(LottoResult lottoResult) {
        int profitSum = DEFAULT_COUNT;
        for (RankCategory rankCategory : values()) {
            int rankCount = lottoResult.getResults().get(rankCategory);
            profitSum += rankCount * rankCategory.getPrize();
        }
        return profitSum;
    }


}
