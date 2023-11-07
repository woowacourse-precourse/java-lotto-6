package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.LottoPurchase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.util.Constants.MAX_RANGE;
import static lotto.util.Constants.MIN_RANGE;
import static lotto.util.Constants.LOTTO_MAX_SIZE;
public class LottoPurchaseService {
    public List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE,MAX_RANGE,LOTTO_MAX_SIZE);
    }
    public List<LottoPurchase> issueLotteryByPurchaseAmount(final int amount) {
        List<LottoPurchase> userLotteries = new ArrayList<>();
        for(int i=0;i<amount;i++){
            userLotteries.add(LottoPurchase.userLotteryFrom(
                    sortedByRandomNumbers(createRandomNumbers())));
        }
        return userLotteries;
    }
    private List<Integer> sortedByRandomNumbers(final List<Integer> randomNumbers) {
        List<Integer> sortedByRandomNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(sortedByRandomNumbers);
        return sortedByRandomNumbers;
    }
}
