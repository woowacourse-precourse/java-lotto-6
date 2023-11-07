package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRankCount {
    public static final int RANK_COUNT = 5;
    private final List<Integer> rankCount;

    LottoRankCount() {
        rankCount = new ArrayList<>(Collections.nCopies(RANK_COUNT, 0));
    }

    public void increaseRankCount(int rank) {
        Integer count = rankCount.get(rank - 1);
        rankCount.set(rank, count++);
    }

    public List<Integer> getRankCount() {
        return rankCount;
    }
}
