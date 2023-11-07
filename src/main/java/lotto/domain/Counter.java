package lotto.domain;

public class Counter {
    public int generateLottoCount(int userMoney) {
        int lottoCount = userMoney / 1000;
        return lottoCount;
    }

    public double calculateProfitRate(int userMoney, long totalPrize) {
        double profitRate = (userMoney - totalPrize) / (double) userMoney * 100;
        return Math.round(profitRate * 10.0) / 10.0;
    }
}
