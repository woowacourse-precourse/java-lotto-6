package lotto.dto;

import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ranks {
    List<Rank> ranks;

    public Ranks(List<Rank> ranks) {
        this.ranks = ranks;
    }

    public static Ranks getSortedRanks() {
        List<Rank> reversedRanks = new ArrayList<>(Arrays.asList(Rank.values()));
        Collections.reverse(reversedRanks);
        return new Ranks(reversedRanks);
    }

    public List<Rank> getRanks() {
        return ranks;
    }

    public long countMatches(Rank rank) {
        return ranks.stream().filter(r -> r == rank).count();
    }
}
