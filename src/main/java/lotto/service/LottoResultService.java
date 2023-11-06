package lotto.service;

import lotto.constant.RankCategory;
import lotto.model.*;
import lotto.model.collections.LottoBundle;

import java.util.EnumMap;
import java.util.List;

public class LottoResultService {

    public LottoResult calculateResults(LottoBundle lottoBundle, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        EnumMap<RankCategory, Integer> results = getInitializedEnumMap();
        for (Lotto lotto : lottoBundle.getLottoBundle()) {
            int matchingNumbers = countMatchingNumbers(winningNumbers, lotto);
            boolean bonusStatus = checkBonusStatus(bonusNumber, lotto);
            RankCategory rankCategory = RankCategory.of(matchingNumbers, bonusStatus);
            results.put(rankCategory, results.get(rankCategory) + 1);
        }
        return new LottoResult(results);
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
        for (RankCategory rankCategory : RankCategory.values()) {
            results.put(rankCategory, 0);
        }
        return results;
    }

}
