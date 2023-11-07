package lotto.dto;

import lotto.domain.Result;

import java.util.Map;

public record ResultDto(double profit, Map<Result, Integer> statistics) {

}
