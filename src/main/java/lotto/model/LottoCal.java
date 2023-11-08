package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Domain.LottoRate;

public class LottoCal {
    private static final int SECOND_REQUIRE = 5;
    private static final int SECOND_REQUIRE_SUCCESS = 7;
    private Map<Integer, Integer> prizeCount;

    public LottoCal() {
        prizeCount = new HashMap<>();
        prizeCountReset();
    }

    public void prizeCountReset() {
        LottoRate values[] = LottoRate.values();
        for (LottoRate obj :
                values) {
            prizeCount.put(obj.getRank(), 0);
        }
    }

    public void count(List<Integer> lotto, List<Integer> userLotto, int userBonus) {

        boolean bonusCheck = userLotto.contains(userBonus);
        lotto.retainAll(userLotto);
        int count = lotto.size();
        if (count == SECOND_REQUIRE && bonusCheck) {
            count = SECOND_REQUIRE_SUCCESS;
        }
        addPrizeCount(count);

    }

    public void addPrizeCount(int count) {
        for (Integer key : prizeCount.keySet()) {
            if (key == count) {
                prizeCount.put(key, prizeCount.get(key) + 1);
            }
        }
    }


    public Map<Integer, Integer> getPrizeCount() {
        return prizeCount;
    }
}
