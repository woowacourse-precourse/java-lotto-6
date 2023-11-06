package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrizeResult {

    private final Map<Prize, Integer> result;

    public PrizeResult(List<Prize> prizes) {
        this.result = createResult(prizes);
    }

    private Map<Prize, Integer> createResult(List<Prize> prizes) {
        Map<Prize, Integer> result = new EnumMap<>(Prize.class);
        putPrize(prizes, result);
        return result;
    }

    private static void putPrize(List<Prize> prizes, Map<Prize, Integer> result) {
        List<Prize> types = Arrays.stream(Prize.values()).skip(1).collect(Collectors.toList());
        for (Prize type : types) {
            int count = Collections.frequency(prizes, type);
            result.put(type, count);
        }
    }

    public Map<Prize, Integer> getResult() {
        return result;
    }
}
