package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static lotto.domain.LottoRank.calculateLottoRank;

public class LottoResult {
    private final Map<LottoRank, Integer> lottoResult;

    public LottoResult() {
        lottoResult = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank
                        .values())
                .forEach(lottoRank -> lottoResult.put(lottoRank, 0));
    }

    public void calculateLottoResult(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        lottos.stream()
                .map(lotto -> {
                    int matchingNumbers = lotto.countMatchingNumbers(winningNumber);
                    boolean containsBonusNumber = lotto.isContainBonusNumber(bonusNumber);
                    return calculateLottoRank(matchingNumbers, containsBonusNumber);
                })
                .forEach(this::updateCount);
    }

    public void updateCount(LottoRank lottoRank) {
        lottoResult.put(lottoRank, lottoResult.get(lottoRank) + 1);
    }

    public int getCount(LottoRank lottoRank) {
        return lottoResult.get(lottoRank);
    }
}
