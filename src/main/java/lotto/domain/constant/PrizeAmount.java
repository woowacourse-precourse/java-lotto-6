package lotto.domain.constant;

import static lotto.domain.constant.LottoConstant.MATCH_ALL_FIVE_COUNT;
import static lotto.domain.constant.LottoConstant.MATCH_ALL_FOUR_COUNT;
import static lotto.domain.constant.LottoConstant.MATCH_ALL_SEVEN_COUNT;
import static lotto.domain.constant.LottoConstant.MATCH_ALL_SIX_COUNT;
import static lotto.domain.constant.LottoConstant.MATCH_ALL_THREE_COUNT;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PrizeAmount {
    private static Map<Integer, PrizeAmount> prizeAmounts = new HashMap();

    private int lottoCount;
    private int bonusCount;
    private int amount;

    private PrizeAmount(int lottoCount, int bonusCount, int amount) {
        this.lottoCount = lottoCount;
        this.bonusCount = bonusCount;
        this.amount = amount;
    }

    public PrizeAmount(){
        gernerate();
    }

    private void gernerate(){
        prizeAmounts.put(MATCH_ALL_THREE_COUNT, new PrizeAmount(3,0,5000));
        prizeAmounts.put(MATCH_ALL_FOUR_COUNT, new PrizeAmount(4,0,50000));
        prizeAmounts.put(MATCH_ALL_FIVE_COUNT, new PrizeAmount(5,0,1500000));
        prizeAmounts.put(MATCH_ALL_SIX_COUNT, new PrizeAmount(5,1,30000000));
        prizeAmounts.put(MATCH_ALL_SEVEN_COUNT, new PrizeAmount(6,0,2000000000));
    }

    public static Map<Integer, PrizeAmount> getPrizeAmounts() {
        return Collections.unmodifiableMap(prizeAmounts);
    }

    public int getAmount() {
        return this.amount;
    }
}
