package lotto.domain;

public class Rate {

    private long getLottoPrice(RankResult rankResult){
        int result = 0;

        for(Rank rank : Rank.values()){
            result += rankResult.getRankCount(rank) * rank.getPrize();
        }

        return result;
    }
}
