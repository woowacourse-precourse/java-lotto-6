package lotto.repository;

import static lotto.configurations.LottoConfigurations.*;
import static lotto.configurations.SettingValues.*;

public class ReceiptRepository {

    private Integer[] numbersOfRanking;

    private static class SingletonReceipt {
        private static final ReceiptRepository RECEIPT_REPOSITORY = new ReceiptRepository();
    }

    public static ReceiptRepository getInstance() {
        return SingletonReceipt.RECEIPT_REPOSITORY;
    }

    private ReceiptRepository() {
        numbersOfRanking = new Integer[]{0, 0, 0, 0, 0, 0};
    }

    public void increaseNumberOfRanking(Integer ranking) {
        numbersOfRanking[ranking]++;
    }

    public Integer getNumberOfRanking(Integer ranking) {
        return numbersOfRanking[ranking];
    }

    public Long getTotalRewards() {
        Long totalRewards = 0L;

        for (int ranking = FIRST.get(); ranking <= FIFTH.get(); ranking++) {
            totalRewards += (long) numbersOfRanking[ranking] * getReward(ranking);
        }

        return totalRewards;
    }

}
