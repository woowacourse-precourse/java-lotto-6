package lotto.domain;

import lotto.enums.RankStandard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buyer {
    private int desiredPurchaseAmount;
    private int numberOfLottery;
    private double rateOfReturn;
    private List<Lotto> lottos = new ArrayList<>();
    private Map<Integer, LotteryRankInfo> rankingAccumulator = new HashMap<>();

    public Buyer() {
        rankingAccumulator.put(5, new LotteryRankInfo(RankStandard.Fifth));
        rankingAccumulator.put(4, new LotteryRankInfo(RankStandard.Fourth));
        rankingAccumulator.put(3, new LotteryRankInfo(RankStandard.Third));
        rankingAccumulator.put(2, new LotteryRankInfo(RankStandard.Second));
        rankingAccumulator.put(1, new LotteryRankInfo(RankStandard.First));
    }

    public int getDesiredPurchaseAmount() {
        return desiredPurchaseAmount;
    }

    public void setDesiredPurchaseAmount(int desiredPurchaseAmount) {
        this.desiredPurchaseAmount = desiredPurchaseAmount;
    }

    public int getNumberOfLottery() {
        return numberOfLottery;
    }

    public void setNumberOfLottery(int numberOfLottery) {
        this.numberOfLottery = numberOfLottery;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }

    public void setRateOfReturn(double rateOfReturn) {
        this.rateOfReturn = rateOfReturn;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Integer, LotteryRankInfo> getRankingAccumulator() {
        return rankingAccumulator;
    }
}
