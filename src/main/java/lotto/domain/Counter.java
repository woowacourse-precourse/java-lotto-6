package lotto.domain;

public class Counter {
    public int generateLottoCount(int userMoney) {
        int lottoCount = userMoney / 1000;
        return lottoCount;
    }

    public double calculateProfitRate(int userMoney, long totalPrize) {
        double profitRate = (totalPrize - userMoney) / (double) userMoney * 100;
        return 100 + (Math.round(profitRate * 10.0) / 10.0);
    }
}
