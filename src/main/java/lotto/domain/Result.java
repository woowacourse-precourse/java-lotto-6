package lotto.domain;

import static lotto.constants.constants.NULL_POINTER_EXCEPTION;

import java.util.Map;

public class Result {
    private final Map<Ranks, Integer> rankResult;

    public Result(Map<Ranks, Integer> rankResult) {
        this.rankResult = rankResult;
    }

    public void validate(Map<Ranks, Integer> rankResult) {
        if (rankResult != null) {
            throw new NullPointerException(NULL_POINTER_EXCEPTION);
        }
    }

}
