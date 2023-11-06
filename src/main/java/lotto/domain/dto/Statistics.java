package lotto.domain.dto;

import lotto.domain.Result;

import java.util.List;

public record Statistics(
        List<Result> results,
        double rate
) {
    public int count(Result target) {
        return (int) results.stream().filter(it -> it == target).count();
    }
}
