package lotto.controller.dto;

import java.util.HashMap;
import java.util.List;
import lotto.domain.Rank;

public class ResultDto {

    private final HashMap<Rank, Integer> rankStore;

    private final Double profitRate;

    public ResultDto(List<Rank> list, Double profitRate) {
        this.rankStore = toMap(list);
        this.profitRate = profitRate;
    }

    private HashMap<Rank, Integer> toMap(List<Rank> list) {
        HashMap<Rank, Integer> map = new HashMap<>();
        for(Rank rank:list){
            map.put(rank,map.getOrDefault(rank,0)+1);
        }
        return map;
    }

    public Double getProfitRate() {
        return profitRate;
    }

    public Integer findCount(Rank rank) {
        return rankStore.getOrDefault(rank,0);
    }
}
