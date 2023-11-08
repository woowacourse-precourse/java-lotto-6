package lotto.dto;

import lotto.domain.result.Result;

import java.util.Map;

public record ResultDto(double profit, Map<Result, Integer> statistics) {

}
