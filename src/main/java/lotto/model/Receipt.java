package lotto.model;

import static lotto.configurations.LottoConfigurations.*;
import static lotto.configurations.SettingValues.*;

public class Receipt {

    private final Integer[] numberOfRanking;
    private final Integer numberOfLotto;

    public Receipt(Integer[] numberOfRanking, Integer numberOfLotto) {
        this.numberOfRanking = numberOfRanking;
        this.numberOfLotto = numberOfLotto;
    }

    public Integer getNumberOfFirst() {
        return numberOfRanking[FIRST.get()];
    }

    public Integer getNumberOfSecond() {
        return numberOfRanking[SECOND.get()];
    }

    public Integer getNumberOfThird() {
        return numberOfRanking[THIRD.get()];
    }

    public Integer getNumberOfFourth() {
        return numberOfRanking[FOURTH.get()];
    }

    public Integer getNumberOfFifth() {
        return numberOfRanking[FIFTH.get()];
    }

    public Double getProfitRatio() {
        return (double) calculateTotalRewards() / (double) calculatePurchaseAmount();
    }

    private Long calculateTotalRewards() {
        Long totalRewards = 0L;
        for (int ranking = FIRST.get(); ranking <= FIFTH.get(); ranking++) {
            totalRewards += (long) numberOfRanking[ranking] * getReward(ranking);
        }
        return totalRewards;
    }

    private Long calculatePurchaseAmount() {
        return (long) numberOfLotto * PRICE_OF_LOTTO.get();
    }
}
