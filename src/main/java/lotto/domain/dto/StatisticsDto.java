package lotto.domain.dto;

import lotto.domain.Result;

import java.util.List;

public record StatisticsDto(
        List<Result> results,
        double rate
) {
}
