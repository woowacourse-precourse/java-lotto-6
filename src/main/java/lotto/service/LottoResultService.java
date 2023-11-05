package lotto.service;

import lotto.constant.RankCategory;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningNumbers;
import lotto.model.collections.LottoBundle;

import java.util.EnumMap;
import java.util.List;

public class LottoResultService {

    public LottoResult calculateResults(LottoBundle lottoBundle, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        EnumMap<RankCategory, Integer> results = getInitializedEnumMap();
        for (Lotto lotto : lottoBundle.getLottoBundle()) {
            RankCategory rankCategory = determineRank(lotto, winningNumbers, bonusNumber);
            results.put(rankCategory, results.get(rankCategory) + 1);
        }
        return new LottoResult(results);
    }

    protected EnumMap<RankCategory, Integer> getInitializedEnumMap() {
        EnumMap<RankCategory,Integer> results = new EnumMap<>(RankCategory.class);
        for (RankCategory rankCategory : RankCategory.values()) {
            results.put(rankCategory, 0);
        }
        return results;
    }

    protected RankCategory determineRank(Lotto lotto, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        boolean bonusState = hasBonusState(lotto, bonusNumber);
        int matchCount = getMatchCount(lotto, winningNumbers);

        if (matchCount == 6) {
            return RankCategory.FIRST;
        }
        if (matchCount == 5 && bonusState) {
            return RankCategory.SECOND;
        }
        if (matchCount == 5) {
            return RankCategory.THIRD;
        }
        if (matchCount == 4) {
            return RankCategory.FOURTH;
        }
        if (matchCount == 3) {
            return RankCategory.THIRD;
        }
        return RankCategory.NONE;
    }

    protected boolean hasBonusState(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber.getNumber())) {
            return true;
        }
        return false;
    }

    protected int getMatchCount(Lotto lotto, WinningNumbers winningNumbers) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        return (int) winningNumbers.getNumbers().stream()
                .filter(lottoNumbers::contains)
                .count();
    }


    /**
     * 수익률 계산
     * */

}
