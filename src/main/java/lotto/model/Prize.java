package lotto.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Prize {
    private final Map<Integer, Integer> prizeResult = new HashMap<Integer, Integer>();

    public void compareAnswerAndLotto(List<Integer> answer, LottoGame lotto) {
        List<Lotto> lottoGames = lotto.getLottoGames();
        int sameNumCount;

        for (int i = 0; i < lotto.getLottoNumber(); i++) {
            Lotto targetLotto = lottoGames.get(i);
            sameNumCount = numberOfSameNumber(answer, targetLotto);
            saveResult(sameNumCount);
        }
    }

    private int numberOfSameNumber(List<Integer> answer, Lotto lotto) {
        List<Integer> lottoNum = lotto.getLottoNumber();
        int count = 0;

        for (int i = 0; i < lottoNum.size(); i++) {
            if (lottoNum.contains(answer.get(i))) {
                count++;
            }
        }

        return count;
    }

    private void saveResult(int sameNumCount) {
        if (prizeResult.get(sameNumCount) == null) {
            prizeResult.put(sameNumCount, 1);
            return;
        }
        prizeResult.put(sameNumCount, prizeResult.get(sameNumCount) + 1);
    }

    public Map<Integer, Integer> getPrizeResult() {
        return this.prizeResult;
    }

    public void getPrizeMoney() {
        Iterator<Integer> keys = prizeResult.keySet().iterator();
        int prizeMoney = 0;
        while (keys.hasNext()) {
            int key = keys.next();
            prizeMoney += calculatePrizeMoney(key, prizeResult.get(key));
        }

    }

    private int calculatePrizeMoney(int key, int value) {
        if (key == 3) {
            return value * 5_000;
        }
        if (key == 4) {
            return value * 50_000;
        }
        if (key == 5) {
            return value * 1_500_000;
        }
        if (key == 6) {
            return value * 30_000_000;
        }
        return 0;
    }
}
