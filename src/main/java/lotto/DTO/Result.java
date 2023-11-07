package lotto.DTO;

import lotto.Model.Winning;

import java.util.Arrays;
import java.util.EnumMap;

public class Result {
    private final EnumMap<Winning, Integer> result = new EnumMap<>(Winning.class);

    public Result() {
        Arrays.stream(Winning.values())
                .forEach(value -> result.put(value, 0));
    }

    public void winningResult(Winning winning) {
        result.put(winning, result.get(winning) + 1);
    }

    public int getCountLottoResult(Winning winning){
        return result.get(winning);
    }
}
