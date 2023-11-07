package lotto.domain;

public class Counter {
    public int generateLottoCount(int userMoney) {
        int lottoCount = userMoney / 1000;
        return lottoCount;
    }

    public double calculateProfitRate(int userMoney, long totalPrize) {
        return (userMoney - totalPrize) / (double) userMoney * 100;
    }

}
