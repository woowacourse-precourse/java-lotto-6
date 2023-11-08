package lotto.rank.domain;

import java.util.Collections;
import java.util.List;

public class Ranks {
    private final List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        this.ranks = Collections.unmodifiableList(ranks);
    }

    public List<Rank> getRanks() {
        return ranks;
    }
}
