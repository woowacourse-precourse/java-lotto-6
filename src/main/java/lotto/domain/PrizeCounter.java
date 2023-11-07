package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class PrizeCounter {

    private final static int INIT_ZERO = 0;
    private final Map<String, Integer> counter;

    public PrizeCounter() {
        this.counter = Arrays.stream(Prize.values())
                .collect(Collectors.toMap(Enum::name, p -> INIT_ZERO));
    }

    public void addCount(String name) {
        counter.put(name, counter.get(name) + 1);
    }

    public Map<String, Integer> getCounter() {
        return counter;
    }
}
