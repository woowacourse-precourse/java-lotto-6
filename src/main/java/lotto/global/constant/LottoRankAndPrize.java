package lotto.global.constant;

import java.util.HashMap;
import java.util.Map;
import static lotto.global.constant.LottoConstant.*;

public class LottoRankAndPrize {

    public static final Map<Integer, Integer> lottoRankAndPrize = new HashMap<>();

    private LottoRankAndPrize(){
        lottoRankAndPrize.put(firstRank, firstPrizeAmount);
        lottoRankAndPrize.put(secondRank,secondPrizeAmount);
        lottoRankAndPrize.put(thirdRank, thirdPrizeAmount);
        lottoRankAndPrize.put(fourthRank, fourthPrizeAmount);
        lottoRankAndPrize.put(fifthRank, fifthPrizeAmount);
    }
}
