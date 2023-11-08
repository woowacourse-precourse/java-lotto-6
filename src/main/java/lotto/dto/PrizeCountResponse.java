package lotto.dto;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.domain.Prize;

public class PrizeCountResponse {
    private final Map<Prize, Integer> prizeCount;

    {
        this.prizeCount = new LinkedHashMap<>();
        List<Prize> prizes = Stream.of(Prize.values())
                .filter(prize -> !prize.equals(Prize.NONE))
                .sorted(Comparator.reverseOrder())
                .toList();
        prizes.forEach(prize -> prizeCount.put(prize, 0));
    }

    public PrizeCountResponse(Map<Prize, Integer> prizeCount) {
        prizeCount.forEach(this.prizeCount::put);
    }

    public Map<Prize, Integer> getPrizeCount() {
        return Collections.unmodifiableMap(this.prizeCount);
    }
}