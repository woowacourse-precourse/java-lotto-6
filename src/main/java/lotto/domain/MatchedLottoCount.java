package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchedLottoCount {

    private List<Integer> matchedLottoCount;

    public MatchedLottoCount() {
        matchedLottoCount = initializeLottoResult();
    }

    private List<Integer> initializeLottoResult() {
        List<Integer> matchedLottoCount = new ArrayList<>(8);
        for (int i = 0; i < 8; i++) {
            matchedLottoCount.add(0);
        }

        return matchedLottoCount;
    }

    public void incrementLottoCount(int index) {
        this.matchedLottoCount.set(index, matchedLottoCount.get(index) + 1);
    }

    public List<Integer> getMatchedLottoCount() {
        return matchedLottoCount;
    }

    public int getPlaceCount(int place) {
        return this.matchedLottoCount.get(place);
    }

}
