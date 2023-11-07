package lotto.domain;

import lotto.enums.LottoRankEnum;
import lotto.utils.Comparer;

public class LottoGameResult {

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
