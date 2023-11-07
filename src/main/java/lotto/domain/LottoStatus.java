package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.model.Rank;

public class LottoStatus {
    private final Map<Rank, Integer> rankingStatus;

    public LottoStatus() {
        this.rankingStatus = Stream.of(Rank.values())
                .collect(Collectors.toMap(e -> e,e->0,(v1, v2)->v1,()-> new EnumMap<>(Rank.class)));

    }

    public void increaseRankingCount(int rank){
        Rank selectedRank = rankingStatus.keySet()
                .stream()
                .filter(key -> key.getOrder() == rank)
                .findFirst()
                .orElse(Rank.NOT_FOUND);
        Integer previousValue  = rankingStatus.getOrDefault(selectedRank,0);
        rankingStatus.put(selectedRank, ++previousValue);
    }

    public Integer calculateTotalRevenue(){
        return this.rankingStatus
                .keySet()
                .stream()
                .filter(this::isPresent)
                .map(this::calculateEachRevenue)
                .reduce(Integer::sum)
                .orElse(0);
    }

    private boolean isPresent(Rank rank){
        return rankingStatus.get(rank) != 0;
    }
    private Integer calculateEachRevenue(Rank rank){
        int prize = rank.getPrize();
        int count = rankingStatus.get(rank);
        return prize * count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
         rankingStatus.keySet()
                .forEach(key -> sb
                        .append(key)
                        .append(rankingStatus.get(key))
                        .append("개\n"));
         return sb.toString();
    }
}
