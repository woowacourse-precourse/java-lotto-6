package lotto.domain;

import java.util.List;

public class LottoBuyer {
    private final Payment payment;
    private final LottoTickets lottoTickets;

    public LottoBuyer(int money) {
        this.payment = new Payment(money);
        this.lottoTickets = new LottoTickets(payment);
    }

    public double getRateOfReturn(List<LottoRank> lottoRanks) {
        return Math.round(getTotalRevenue(lottoRanks) / (double) payment.get()) / 100.0;
    }
    
    private double getTotalRevenue(List<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                .mapToDouble(rank -> rank.getPrize())
                .sum();
    }

}
