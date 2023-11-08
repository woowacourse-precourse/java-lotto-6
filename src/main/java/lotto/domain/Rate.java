package lotto.domain;

public class Rate {

    private final double rate;

    public Rate(Price price, RankResult rankResult){
        this.rate = (getLottoPrice(rankResult) * 0.1) / price.getPrice();
    }

    private long getLottoPrice(RankResult rankResult){
        int result = 0;

        for(Rank rank : Rank.values()){
            result += rankResult.getRankCount(rank) * rank.getPrize();
        }

        return result;
    }

    public double getRate(){
        return rate;
    }
}
