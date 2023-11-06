package lotto.controller;

import java.util.HashMap;
import lotto.domain.Rank;

public class ResultDto {

    private final HashMap<Rank, Integer> map;

    private final Double profitRate;

    public ResultDto(HashMap<Rank, Integer> map, Double profitRate) {
        this.map = map;
        this.profitRate = profitRate;
    }

    public Double getProfitRate() {
        return profitRate;
    }

    public Integer findCount(Rank rank) {
        return map.getOrDefault(rank,0);
    }
}
