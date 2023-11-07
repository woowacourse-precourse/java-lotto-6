package lotto.dto;

import lotto.domain.result.CalculateResult;
import lotto.domain.result.MatchResult;

public class ResultDto {
    private final MatchResult matchResult;
    private final CalculateResult calculateResult;

    private ResultDto(MatchResult matchResult, CalculateResult calculateResult) {
        this.matchResult = matchResult;
        this.calculateResult = calculateResult;
    }

    public static ResultDto of(MatchResult matchResult, CalculateResult calculateResult) {
        return new ResultDto(matchResult, calculateResult);
    }

    public MatchResult getLottoMatchResult() {
        return matchResult;
    }

    public CalculateResult getLottoCalculateResult() {
        return calculateResult;
    }
}
