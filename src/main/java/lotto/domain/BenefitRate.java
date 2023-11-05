package lotto.domain;

public class BenefitRate {

    private final double benefitRate;

    public BenefitRate(Money money, RankResult rankResult) {
        this.benefitRate = (getBenefitMoney(rankResult) * 0.1) / money.getTicket();
    }

    private double getBenefitMoney(RankResult rankResult) {
        int result = 0;

        for(Rank rank : Rank.values()) {
            result += rankResult.getRankResultCnt(rank) * rank.getMoney();
        }

        return result;
    }

    public double getBenefit() {
        return benefitRate;
    }
}
