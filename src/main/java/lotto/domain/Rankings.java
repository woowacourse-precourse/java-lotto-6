package lotto.domain;

import static lotto.configuration.IntegerConstants.COST_OF_LOTTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rankings {

    private final List<Integer> rankings = new ArrayList<>(
            Collections.nCopies(COST_OF_LOTTO.getValue(), 0));

    public List<Integer> getRankings() {
        return rankings;
    }


}
