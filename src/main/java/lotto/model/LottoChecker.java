package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoChecker {

    public LottoRankInfo createResult(Lottos lottos, List<Integer> winningNumbers, int bonusNumber) {
        List<LottoRank> lottoRanks = createLottoRanks(lottos, winningNumbers, bonusNumber);
        return LottoRankInfo.from(lottoRanks);
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


}
