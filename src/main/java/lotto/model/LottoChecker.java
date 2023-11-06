package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {

    public Map<LottoRank, Integer> createResult(Lottos lottos, List<Integer> winningNumbers, int bonusNumber) {
        List<LottoRank> lottoRanks = createLottoRanks(lottos, winningNumbers, bonusNumber);
        return createEnumMap(lottoRanks);
    }

    public List<LottoRank> createLottoRanks(Lottos lottos, List<Integer> winningNumbers, int bonusNumber) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        for (Lotto lotto : lottos.getLottos()) {
            long matchCount = lotto.compareLottoNumbers(winningNumbers);
            boolean bonus = lotto.compareBonusNumber(bonusNumber);
            lottoRanks.add(LottoRank.valueOf(matchCount, bonus));
        }
        return lottoRanks;
    }

    public Map<LottoRank, Integer> createEnumMap(List<LottoRank> lottoRanks) {
        Map<LottoRank, Integer> result = new EnumMap(LottoRank.class);
        Arrays.stream(LottoRank.values()).forEach(lottoRank -> result.put(lottoRank, 0));
        lottoRanks.stream().forEach(lottoRank -> result.put(lottoRank, result.get(lottoRank) + 1));
        return result;
    }


}
