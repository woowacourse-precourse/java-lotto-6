package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningLottoStorage {

    private Map<Rank, Integer> rankStorage;

    public WinningLottoStorage() {
        rankStorage = new HashMap<>();
        initRankStorage();
    }

    private void initRankStorage() {
        rankStorage.put(Rank.CORRECT_ZERO, 0);
        rankStorage.put(Rank.CORRECT_ONE, 0);
        rankStorage.put(Rank.CORRECT_TWO, 0);
        rankStorage.put(Rank.CORRECT_THREE, 0);
        rankStorage.put(Rank.CORRECT_FOUR, 0);
        rankStorage.put(Rank.CORRECT_FIVE, 0);
        rankStorage.put(Rank.CORRECT_FIVE_BONUS, 0);
        rankStorage.put(Rank.CORRECT_SIX, 0);
    }
}
