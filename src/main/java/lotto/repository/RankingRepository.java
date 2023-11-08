package lotto.repository;

import static lotto.configurations.LottoConfigurations.*;

import java.util.Arrays;

public class RankingRepository {

    private Integer[] numbersOfRanking;
    private Long totalRewards;

    private static class SingletonReceipt {
        private static final RankingRepository RECEIPT_REPOSITORY = new RankingRepository();
    }

    public static RankingRepository getInstance() {
        return SingletonReceipt.RECEIPT_REPOSITORY;
    }

    private RankingRepository() {
        numbersOfRanking = new Integer[]{0, 0, 0, 0, 0, 0};
        totalRewards = 0L;
    }

    public void increaseNumberOfRanking(Integer ranking) {
        numbersOfRanking[ranking]++;
        totalRewards += getReward(ranking);
    }

    public Integer findNumberOfRankingByRanking(Integer ranking) {
        return numbersOfRanking[ranking];
    }

    public Long findTotalRewards() {
        return totalRewards;
    }

    public void clear() {
        Arrays.fill(numbersOfRanking, 0);
        totalRewards = 0L;
    }

}
