package lotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

public class Domain {
    static private final int DECIMAL_POINT = 1;
    public Rank ranking(List<Integer> winningNums,Integer bonus,Lotto lotto){
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

    public List<Rank> allRanking(List<Integer> winningNums,Integer bonus,List<Lotto> lottoes){
        return lottoes.stream()
                .map(lotto -> ranking(winningNums,bonus,lotto))
                .collect(Collectors.toList());
    }

    public int calculateProfit(List<Rank> rankingResults){
        return rankingResults.stream()
                .mapToInt(Rank::getPrizeMoney)
                .sum();
    }

    public double calculatePercent(long money, long profit){
        double percent = (double)profit/money*100;
        BigDecimal bigDecimal = new BigDecimal(percent);
        double roundedPercent = bigDecimal
                .setScale(DECIMAL_POINT, RoundingMode.HALF_UP).doubleValue();
        return roundedPercent;
    }
}
