package lotto.domain.answer.rate;

public class LotteryRateService {
    public Double getReturnOnInvestment(Long cash, Long winningPrice) {
        double roi = ((double) winningPrice / (double) cash) * 100.0;
        return Math.round(roi * 100) / 100.0;
    }
}
