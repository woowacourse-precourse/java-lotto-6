package lotto.Domain;

public class Rate {
    private final double rate;
    public Rate(Money money, RankResult rankResult){
        this.rate = (getAllMoney(rankResult)*0.1) / money.getTicket();
    }

    private long getAllMoney(RankResult rankResult){
        int result =0;

        for(Rank rank : Rank.values()){
            result += rankResult.getRankcount(rank) * rank.getMoney();
        }
        return result;
    }

    public double getRate(){
        return rate;
    }
}
