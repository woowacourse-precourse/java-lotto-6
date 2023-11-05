package lotto.domain;

public class RateOnReturn {
    private final double rate;

    public RateOnReturn(LottoAmount lottoAmount, LottoResult lottoResult) {
        this.rate = (getMoney(lottoResult) * 0.1) / lottoAmount.getTicketCount();
    }

    private double getMoney(LottoResult lottoResult) {
        int result = 0;
        for (WinningStatistics winningStatistics : WinningStatistics.values()) {
            result += lottoResult.getLottoResultCount(winningStatistics) * winningStatistics.getAmount();
        }
        return result;
    }

    public double getRate() {
        return rate;
    }
}
