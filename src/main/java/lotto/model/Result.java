package lotto.model;

import java.util.HashMap;

public class Result {
    private final HashMap<Rank,Integer> result;

    public Result(HashMap<Rank, Integer> result) {
        this.result = result;
    }
}
