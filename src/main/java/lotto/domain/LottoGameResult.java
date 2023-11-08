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
            lottoRanks.add(calculateLottoRank(lotto, winning));
        }
    }

    public LottoRankEnum calculateLottoRank(Lotto lotto, Winning winning) {
        int sameCount = Comparer.compareLottoToWinning(lotto, winning);
        boolean containsBonus = Comparer.containsBonus(lotto, winning);

        for (LottoRankEnum lottoRankEnum : LottoRankEnum.values()) {
            if (lottoRankEnum.getSameCount() == sameCount) {
                if (lottoRankEnum.isContainsBonus() == containsBonus) {
                    return lottoRankEnum;
                }
                return lottoRankEnum;
            }
        }
        return LottoRankEnum.NOTHING;
    }

    public List<LottoRankEnum> getLottoRanks() {
        return lottoRanks;
    }
}
