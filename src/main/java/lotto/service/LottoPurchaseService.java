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
    public static List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(MAX_RANGE,MIN_RANGE,LOTTO_MAX_SIZE);
    }
    public static List<LottoPurchase> issueLotteryByPurchaseAmount(final int amount) {
        List<LottoPurchase> userLotteries = new ArrayList<>();
        for(int i=0;i<amount;i++){
            userLotteries.add(LottoPurchase.createUserLottery(
                    sortedByLottoNumber(createRandomNumbers())));
        }
        return userLotteries;
    }
    private static List<Integer> sortedByLottoNumber(List<Integer> lotto) {
        Collections.sort(lotto);
        return lotto;
    }
}
