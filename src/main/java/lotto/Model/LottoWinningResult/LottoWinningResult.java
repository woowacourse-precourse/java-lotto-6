package lotto.Model.LottoWinningResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Model.Lotto.Lotto;

public class LottoWinningResult {
    private final Map<Integer, List<Lotto>> matchingResults;


    private LottoWinningResult (List<Lotto> matchedLotto) {
        this.matchingResults = new HashMap<>();

    }

    public void addMatchingLotto(int matchingNumbers, Lotto lotto) {
        matchingResults.computeIfAbsent(matchingNumbers, k -> new ArrayList<>()).add(lotto);
    }

    public Map<Integer, List<Lotto>> getMatchingResults() {
        return matchingResults;
    }


}
