package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> result = new HashMap<>();

    private LottoResult(LottoStorage lottoStorage, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottoStorage.getLottoStorage()) {
            LottoRank lottoRank = LottoRank.of(lotto.sameNumberCounter(winningNumbers), lotto.hasNumber(winningNumbers.getBonusNumber()));
            result.merge(lottoRank, 1, Integer::sum);
        }
    }
    // of -> from
    public static LottoResult of(LottoStorage lottoStorage, WinningNumbers winningNumbers) {
        return new LottoResult(lottoStorage,winningNumbers);
    }

    public long calculatePrice() {
        long prize = 0L;
        for (LottoRank lottoRank : result.keySet()) {
            prize += (long) result.get(lottoRank) * lottoRank.getPrice();
        }
        return prize;
    }

    public int getRankCount(LottoRank lottoRank) {
        if (result.get(lottoRank) == null) {
            return 0;
        }
        return result.get(lottoRank);
    }
}
