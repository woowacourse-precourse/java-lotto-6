package lotto.domain;

import java.util.EnumMap;
import java.util.List;

public class LottoMachine {
    EnumMap<LottoRank, Integer> lottoResultMap;
    Lotto winningLotto;
    int bonusNumber;

    public LottoMachine(Lotto winningLotto, int bonusNumber) {
        this.lottoResultMap = new EnumMap<>(LottoRank.class);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void initLottoResultMap() {
        for (LottoRank rank : LottoRank.values()) {
            lottoResultMap.put(rank, 0);
        }
    }

    public EnumMap<LottoRank, Integer> toLottoResult(List<Lotto> lotteries) {
        compareLotteries(lotteries);
        return lottoResultMap;
    }


    private void compareLotteries(List<Lotto> lotteries) {
        initLottoResultMap();
        for (Lotto lotto : lotteries) {
            int matchCount = compareEachLotto(lotto);
            boolean bonusNumberMatched = isBonusNumberMatched(lotto);
            resultMatcher(matchCount, bonusNumberMatched);
        }
    }

    private void resultMatcher(int matchedCount, boolean bonusNumberMatched) {
        LottoRank lottoRank = LottoRank.valueOf(matchedCount, bonusNumberMatched);
        lottoResultMap.put(lottoRank, lottoResultMap.get(lottoRank) + 1);

    }


    private int compareEachLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.toList();
        int matchCount = 0;

        for (Integer number : lottoNumbers) {
            if (winningLotto.isNumberExist(number)) {
                matchCount++;
            }
        }
        return matchCount;

    }

    private boolean isBonusNumberMatched(Lotto lotto) {
        return lotto.isNumberExist(bonusNumber);
    }

}

