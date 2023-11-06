package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private final List<Integer> counted;
    private final List<Boolean> checked;

    public LottoResult(List<Integer> counted, List<Boolean> checked) {
        this.counted = counted;
        this.checked = checked;
    }

    public List<Rank> getRanks() {
        List<Rank> ranks = new ArrayList<>();
        for (int i = 0; i < counted.size(); i++) {
            ranks.add(getRank(counted.get(i), checked.get(i)));
        }
        return ranks;
    }

    private Rank getRank(int count, boolean check) {
        if (count == Rank.THREE_MATCH.getCounted()) {
            return Rank.THREE_MATCH;
        }
        if (count == Rank.FOUR_MATCH.getCounted()) {
            return Rank.FOUR_MATCH;
        }
        if (count == Rank.FIVE_MATCH_AND_BONUS.getCounted() && Rank.FIVE_MATCH_AND_BONUS.getChecked()) {
            return Rank.FIVE_MATCH_AND_BONUS;
        }
        if (count == Rank.FIVE_MATCH.getCounted()) {
            return Rank.FIVE_MATCH;
        }
        if (count == Rank.SIX_MATCH.getCounted()) {
            return Rank.SIX_MATCH;
        }
        return null;
    }
}