package lotto.domain;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.dto.LottoMatchResponse;

public class PrizeCount {
    private final Map<Prize, Integer> prizeCount;

    {
        this.prizeCount = new LinkedHashMap<>();
        List<Prize> prizes = Stream.of(Prize.values())
                .filter(prize -> !prize.equals(Prize.NONE))
                .sorted(Comparator.reverseOrder())
                .toList();
        prizes.forEach(prize -> prizeCount.put(prize, 0));
    }

    public PrizeCount(List<LottoMatchResponse> matchResponses) {
        for (LottoMatchResponse matchResponse : matchResponses) {
            Prize prize = Prize.valueOf(matchResponse);
            if (prize.equals(Prize.NONE)) {
                continue;
            }
            prizeCount.put(prize, prizeCount.get(prize) + 1);
        }
    }

    public double calculateReturnRate(Money money) {
        return money.calculateReturnRate(getTotalWinningAmount());
    }

    public Map<Prize, Integer> getPrizeCount() {
        return this.prizeCount;
    }

    private long getTotalWinningAmount() {
        return prizeCount.keySet().stream()
                .mapToLong(prize -> prize.calculateAmount(prizeCount.get(prize)))
                .sum();
    }
}