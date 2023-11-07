package lotto.dto;

import java.util.ArrayList;
import java.util.List;

public class ResultDto {

    private final List<Integer> prizeResult = new ArrayList<>();
    private final Double returnRate;

    public ResultDto(List<Integer> totalResult, Double returnRate) {
        prizeResult.addAll(totalResult);
        this.returnRate = returnRate;
    }

    public static ResultDto create(List<Integer> totalResult, Double returnRate) {
        return new ResultDto(totalResult, returnRate);
    }

    public List<Integer> getPrizeResult() {
        return prizeResult;
    }

    public Double getReturnRate() {
        return returnRate;
    }
}
