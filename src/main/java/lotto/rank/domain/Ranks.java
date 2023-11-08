package lotto.rank.domain;

import java.util.Collections;
import java.util.List;

public class Ranks {
    private final List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        // 방어적 복사를 수행하여 불변성을 유지
        this.ranks = Collections.unmodifiableList(ranks);
    }

    public List<Rank> getRanks() {
        return ranks;
    }
}
