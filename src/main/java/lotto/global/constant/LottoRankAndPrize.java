package lotto.global.constant;

import java.util.HashMap;
import java.util.Map;
import static lotto.global.constant.LottoConstant.*;

public enum LottoRankAndPrize {

    FIRST_RANK(FIRST_PRIZE, FIRST_RANK_LOTTO_MATCHED, false),
    SECOND_RANK(SECOND_PRIZE, SECOND_RANK_LOTTO_MATCHED, true),
    THIRD_RANK(THIRD_PRIZE, THIRD_RANK_LOTTO_MATCHED, false),
    FOURTH_RANK(FOURTH_PRIZE, FOURTH_RANK_LOTTO_MATCHED, false),
    FIFTH_RANK(FIFTH_PRIZE, FIFTH_RANK_LOTTO_MATCHED, false),
    NO_RANK(0,0,false);

    private final int prize;
    private final int lottoMatched;
    private final boolean bonusMatched;

    LottoRankAndPrize(int prize, int lottoMatched, boolean bonusMatched) {
        this.prize = prize;
        this.lottoMatched = lottoMatched;
        this.bonusMatched = bonusMatched;
    }

    public static LottoRankAndPrize determineRankByLottoMatched(int lottoMatched){
        for(LottoRankAndPrize rankAndPrize : LottoRankAndPrize.values()) {
            if(rankAndPrize.lottoMatched == lottoMatched) {
                return rankAndPrize;
            }
        }
        return NO_RANK;
    }
}
