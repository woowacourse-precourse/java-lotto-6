package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class PrizeResult {

    List<Result> ranking = new ArrayList<>();

    public PrizeResult(List<Integer> lottoMatch, List<Boolean> hasBonusMatch) {

    }

    public List<Result> getRanking() {
        return ranking;
    }
}
