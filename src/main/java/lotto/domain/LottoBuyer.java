package lotto.domain;

import java.util.List;

public class LottoBuyer {
    private final Payment payment;
    private final LottoTickets lottoTickets;

    public LottoBuyer(Payment payment, LottoTickets lottoTickets) {
        this.payment = payment;
        this.lottoTickets = lottoTickets;
    }

    public double getRateOfReturn(List<LottoRank> lottoRanks) {
        double originValue = getTotalRevenue(lottoRanks) / (double) payment.get() * (double) 100;
        return Math.round(originValue * 10) / (double) 10;
    }

    private double getTotalRevenue(List<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                .mapToDouble(rank -> rank.getPrize())
                .sum();
    }

}
