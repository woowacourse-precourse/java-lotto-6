package lotto.domain;

import lotto.dto.Lotto;
import lotto.dto.Ranking;
import lotto.enums.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Buyer {
    private int desiredPurchaseAmount;
    private int numberOfLotto;
    private double rateOfReturn;
    private List<Lotto> lottos = new ArrayList<>();
    private Map<Integer, Ranking> rankingAccumulator = new HashMap<>();

    public Buyer() {
        rankingAccumulator.put(5, new Ranking(Rank.Fifth));
        rankingAccumulator.put(4, new Ranking(Rank.Fourth));
        rankingAccumulator.put(3, new Ranking(Rank.Third));
        rankingAccumulator.put(2, new Ranking(Rank.Second));
        rankingAccumulator.put(1, new Ranking(Rank.First));
    }

    public int getDesiredPurchaseAmount() {
        return desiredPurchaseAmount;
    }

    public void setDesiredPurchaseAmount(int desiredPurchaseAmount) {
        this.desiredPurchaseAmount = desiredPurchaseAmount;
    }

    public int getNumberOfLotto() {
        return numberOfLotto;
    }

    public void setNumberOfLotto(int numberOfLotto) {
        this.numberOfLotto = numberOfLotto;
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

    public Map<Integer, Ranking> getRankingAccumulator() {
        return rankingAccumulator;
    }
}
