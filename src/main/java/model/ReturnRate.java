package model;

public class ReturnRate {

    private final double rate;

    public ReturnRate(LottoPrice lottoPrice, WinningPriceResult winningPriceResult) {
        this.rate = (getAllMoney(winningPriceResult) * 0.1) / lottoPrice.lottoPaperCount();
    }

    private long getAllMoney(WinningPriceResult winningPriceResult) {
        int result = 0;

        for (WinningPrice winningPrice : WinningPrice.values()) {
            result += winningPriceResult.getWininngPriceCount(winningPrice) * winningPrice.getWinningPrice();
        }

        return result;
    }

    public double getRate() {
        return rate;
    }
}