package lotto.service;

import lotto.domain.Match;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTotalCount {
    private final Map<Match, Integer> totalCount = new HashMap<Match, Integer>();

    public Map<Match, Integer> getTotalCount(List<Match> matches) {
        matchCount(matches);
        return totalCount;
    }

    private void matchCount(List<Match> matches) {
        for (int i = 0; i < matches.size(); i++) {
            if (!totalCount.containsKey(matches.get(i))) {
                putMatch(matches.get(i));
            }
            addCount(matches.get(i));
        }
    }

    private void addCount(Match match) {
        totalCount.replace(match, totalCount.get(match) + 1);
    }

    private void putMatch(Match match) {
        totalCount.put(match, 0);
    }
}
