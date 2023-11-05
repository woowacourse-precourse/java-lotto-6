package lotto.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoPrize, Integer> result;

    public LottoResult() {
        this.result = new HashMap<>();
         Arrays.stream(LottoPrize.values())
                 .forEach(lottoPrize -> result.put(lottoPrize, 0));
    }

    public void countPrizes(LottoWallet lottoWallet, WinningLotto winningLotto) {
        List<Lotto> wallet = lottoWallet.getWallet();
        for (Lotto lotto : wallet) {
            LottoPrize lottoPrize = lotto.checkPrize(winningLotto);
            result.put(lottoPrize, result.get(lottoPrize) + 1); // 기존 값에 1을 더해서 다시 넣음
        }
    }

    public Integer getCount(LottoPrize lottoPrize) {
        return result.get(lottoPrize);
    }
}
