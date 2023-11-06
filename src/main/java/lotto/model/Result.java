package lotto.model;

import lotto.model.value.Matching;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Result {

    private final Map<Matching, Integer> result;

    public Result() {
        result = Arrays.stream(Matching.values())
                .collect(Collectors.toMap(matching -> matching, matching -> 0));
    }

    public Map<Matching, Integer> getResult() {
        return result;
    }
}
