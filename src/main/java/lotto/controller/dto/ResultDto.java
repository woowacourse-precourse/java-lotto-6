package lotto.controller.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import lotto.domain.Rank;
import lotto.view.RankOutputTemplate;

public class ResultDto {

    private final HashMap<RankOutputTemplate, Integer> rankStore;

    private final Double profitRate;

    public ResultDto(List<Rank> list, Double profitRate) {
        this.rankStore = toMap(list);
        this.profitRate = profitRate;
    }

    private HashMap<RankOutputTemplate, Integer> toMap(List<Rank> list) {
        HashMap<RankOutputTemplate, Integer> map = new HashMap<>();
        for(Rank rank:list){
            Optional<RankOutputTemplate> rankOutputTemplate = RankOutputTemplate.find(rank);
            rankOutputTemplate.ifPresent(template->map.put(template,map.getOrDefault(template,0)+1));
        }
        return map;
    }

    public Double getProfitRate() {
        return profitRate;
    }

    public Integer findCount(RankOutputTemplate rank) {
        return rankStore.getOrDefault(rank,0);
    }
}
