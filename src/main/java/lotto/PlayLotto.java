package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayLotto {

    public static int MIN_WIN_CONDITION = 3;
    private final Map<Rank, Integer> lottoResult = new HashMap<>();
    private final List<Integer> prizeNumbers;
    private final int bonusNumber;

    public PlayLotto(List<Integer> prizeNumbers, int bonusNumber) {
        this.prizeNumbers = prizeNumbers;
        this.bonusNumber = bonusNumber;
        lottoResult.put(Rank.FIFTH, 0);
        lottoResult.put(Rank.FOURTH, 0);
        lottoResult.put(Rank.THIRD, 0);
        lottoResult.put(Rank.SECOND, 0);
        lottoResult.put(Rank.FIRST, 0);
    }

    public void lottoResult(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            putResult(lotto);
        }
    }

    public Map<Rank, Integer> getLottoResult() {
        return lottoResult;
    }

    public long prizeSum() {
        long prizeSum = 0;

        for (Rank key : lottoResult.keySet()) {
            prizeSum += key.getPrizeMoney() * lottoResult.get(key);
        }

        return prizeSum;
    }

    private void putResult(Lotto lotto) {
        int count = lotto.countCorrectLottoNumber(prizeNumbers);
        if (count < MIN_WIN_CONDITION) {
            return;
        }
        Rank rank = Rank.of(count, lotto.contains(bonusNumber));
        lottoResult.put(rank, lottoResult.getOrDefault(rank, 0) + 1);
    }
}
