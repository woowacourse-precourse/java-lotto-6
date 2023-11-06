package lotto.domain;

import java.util.List;
import java.util.ArrayList;

import lotto.domain.Rank;

public class Result {
    private final List<Rank> Results =  new ArrayList<>();

    public Result add(Rank rank) {
        Results.add(rank);
        return this;
    }
    public List<Rank> getResults() {
        return Results;
    }
}
