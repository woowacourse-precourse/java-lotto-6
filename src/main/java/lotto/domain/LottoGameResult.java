package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.enums.LottoRankEnum;
import lotto.utils.Comparer;

public class LottoGameResult {

    List<LottoRankEnum> lottoRanks;

    public void calculateLottoRanks(List<Lotto> lottos, Winning winning) {
        lottoRanks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoRanks.add(calculateLottoResult(lotto, winning));
        }
    }

    public LottoRankEnum calculateLottoResult(Lotto lotto, Winning winning) {
        int sameCount = Comparer.compareLottoToWinning(lotto, winning);
        boolean containsBonus = Comparer.containsBonus(lotto, winning);

        for (LottoRankEnum lottoRank : LottoRankEnum.values()) {
            if (lottoRank.getSameCount() == sameCount) {
                if (lottoRank.isContainsBonus() == containsBonus) {
                    return lottoRank;
                }
                return lottoRank;
            }
        }
        return LottoRankEnum.NOTHING;
    }

}
