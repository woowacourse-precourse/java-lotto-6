package lotto.service.dto;

import java.util.List;
import lotto.domain.Lottos;

public class ResultDTO {
    private final List<Integer> result;
    private final double profitRate;

    public ResultDTO(List<Integer> result, double profitRate) {
        this.result = result;
        this.profitRate = profitRate;
    }

    public List<Integer> getResult() {
        return result;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
