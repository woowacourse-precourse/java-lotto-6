package lotto.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Result {

    private final Map<Rank, Integer> result;

    private Result(Map<Rank, Integer> result) {
        this.result = result;
    }

    public static Result from(List<Rank> ranks) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Rank rank : ranks) {
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return new Result(result);
    }

    public void forEachOrdered(Consumer<? super Rank> action) {
        Arrays.stream(Rank.values())
                .forEachOrdered(action);
    }

    public int getResult(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
