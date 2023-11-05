package lotto.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Result {

    private final Map<LottoPrize, Integer> result;

    private Result(Map<LottoPrize, Integer> result) {
        this.result = result;
    }

    public static Result from(List<LottoPrize> lottoPrizes) {
        Map<LottoPrize, Integer> result = new EnumMap<>(LottoPrize.class);
        for (LottoPrize lottoPrize : lottoPrizes) {
            result.put(lottoPrize, result.getOrDefault(lottoPrize, 0) + 1);
        }
        return new Result(result);
    }

    public void forEachOrdered(Consumer<? super LottoPrize> action) {
        Arrays.stream(LottoPrize.values())
                .forEachOrdered(action);
    }

    public int getResult(LottoPrize lottoPrize) {
        return result.getOrDefault(lottoPrize, 0);
    }
}
