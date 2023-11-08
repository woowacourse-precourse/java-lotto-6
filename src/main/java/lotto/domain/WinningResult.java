package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import lotto.WinningResultDTO;

public class WinningResult {

    private static final int INITIAL_VALUE = 0;
    private static final int ADDING_COUNT = 1;
    private final Map<Rank, Integer> result = new EnumMap<>(Rank.class);

    public WinningResult() {
        init();
    }

    public void updateResult(Rank rank) {
        result.put(rank, result.get(rank) + ADDING_COUNT);
    }

    public WinningResultDTO getResult() {
        return WinningResultDTO.from(result);
    }

    public int getTotalPrize() {
        return result.keySet().stream()
                .map(rank -> rank.getPrize() * result.get(rank))
                .reduce(Integer::sum)
                .orElse(0);
    }

    private void init() {
        Arrays.stream(Rank.values())
                .forEach(rank -> result.put(rank, INITIAL_VALUE));
    }
}