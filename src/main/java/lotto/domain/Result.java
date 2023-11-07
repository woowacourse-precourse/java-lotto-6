package lotto.domain;

import java.util.List;
import java.util.ArrayList;

public class Result {
    private final List<Rank> Results =  new ArrayList<>();

    public Result() {

    }
    public Result(Rank rank) {
        Results.add(rank);
    }

    public Result add(Rank rank) {
        Results.add(rank);
        return this;
    }

    public List<Rank> getResults() {
        return Results;
    }
}
