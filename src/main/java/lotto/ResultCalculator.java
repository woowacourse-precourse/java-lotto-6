package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultCalculator {
    private final Map<Lotto, PrizeGrade> result;

    public ResultCalculator(Lottos lottos, Lotto winningLotto) {
        Map<Lotto, PrizeGrade> result = new HashMap<>();
        lottos.getTickets().stream()
                .forEach(lotto -> result.add(lotto, calculatePrizeGrade(lotto, winningLotto)));
        this.result = result;
    }
}
