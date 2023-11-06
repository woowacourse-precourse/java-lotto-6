package lotto.global.constant;

import java.util.HashMap;
import java.util.Map;
import static lotto.global.constant.LottoConstant.*;

public class LottoRankAndPrize {

    public static final Map<Integer, Integer> lottoRankAndPrize = new HashMap<>();

    private LottoRankAndPrize(){
        lottoRankAndPrize.put(FIRST_RANK, FIRST_PRIZE_AMOUNT);
        lottoRankAndPrize.put(SECOND_RANK, SECOND_PRIZE_AMOUNT);
        lottoRankAndPrize.put(THIRD_RANK, THIRD_PRIZE_AMOUNT);
        lottoRankAndPrize.put(FOURTH_RANK, FOURTH_PRIZE_AMOUNT);
        lottoRankAndPrize.put(FIFTH_RANK, FIFTH_PRIZE_AMOUNT);
    }
}
