package lotto.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static lotto.global.constant.LottoConstant.*;

public class LottoResult {

    private static final int NONE = 0;

    private static Map<Integer, Integer> totalRanks;
    private final int lottoPurchasePrice;
    private final int totalPrizeAmount;

    public LottoResult(int lottoPurchasePrice, int totalPrizeAmount) {
        totalRanks = new HashMap<>();
        for(int i = FIRST_RANK; i <= FIFTH_RANK; i++){
            totalRanks.put(i, NONE);
        }
        this.lottoPurchasePrice = lottoPurchasePrice;
        this.totalPrizeAmount = totalPrizeAmount;
    }

    public int getLottoPurchasePrice() {
        return lottoPurchasePrice;
    }

    public int getTotalPrizeAmount() {
        return totalPrizeAmount;
    }
}
