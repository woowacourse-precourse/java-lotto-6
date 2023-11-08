package lotto.domain;

import lotto.lottomarket.Lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Domain {
    static private final int DECIMAL_POINT = 1;
    public Rank ranking(List<Integer> winningNums, Integer bonus, Lotto lotto){
        int hit = (int)lotto.getNumbers().stream()
                .filter(num-> winningNums.contains(num))
                .count();

        int bonusHit = 0;
        if(hit == 5){
            if(lotto.getNumbers().contains(bonus)){
                bonusHit++;
            }
        }
        Rank rank = Rank.getRank(hit,bonusHit);
        return rank;
    }

    public Map<Rank,Integer> allRanking(List<Integer> winningNums,Integer bonus,List<Lotto> lottoes){
        Map<Rank,Integer> rankingTable = createRankingTable();
        for(Lotto lotto : lottoes){
            Rank rankingResult = ranking(winningNums,bonus,lotto);
            addRankingResult(rankingResult,rankingTable);
        }
        return rankingTable;
    }
    public void addRankingResult(Rank rankingResult,Map<Rank,Integer> rankingTable){
        rankingTable.merge(rankingResult,1,Integer::sum);
    }

    private Map<Rank,Integer> createRankingTable(){
        Map<Rank,Integer> rankingTable = new LinkedHashMap<>();
        for(Rank rank:Rank.values()){
            rankingTable.put(rank,0);
        }
        return rankingTable;
    }

    public long calculateProfit(Map<Rank,Integer> rankingResults){
        return rankingResults.keySet().stream()
                .reduce(0,(profit,rank)->{
                    return profit + rank.getPrizeMoney()*rankingResults.get(rank);
                },Integer::sum);
    }

    public double calculatePercent(long money, long profit){
        double percent = (double)profit/money*100;
        BigDecimal bigDecimal = new BigDecimal(percent);
        double roundedPercent = bigDecimal
                .setScale(DECIMAL_POINT, RoundingMode.HALF_UP).doubleValue();
        return roundedPercent;
    }
}
