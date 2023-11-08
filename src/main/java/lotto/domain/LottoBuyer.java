package lotto.domain;

import java.util.List;

public class LottoBuyer {

    private static final double PERCENTAGE_MULTIPLIER = 100;
    private static final int ROUNDING_FACTOR = 10;
    private final Payment payment;
    private final LottoTickets lottoTickets;

    public LottoBuyer(Payment payment) {
        this.payment = payment;
        this.lottoTickets = new LottoTickets(payment);
    }

    public List<LottoRank> getLottoResult(WinningLottoNumbers winningLottoNumbers) {
        return lottoTickets.getWinningRanks(winningLottoNumbers);
    }

    public String getLottoTicketsInformation() {
        return lottoTickets.toString();
    }

    public int getNumberOfLottoTickets() {
        return lottoTickets.size();
    }

    public double getRateOfReturn(List<LottoRank> lottoRanks) {
        double originValue = getTotalRevenue(lottoRanks) / (double) payment.get() * PERCENTAGE_MULTIPLIER;
        return Math.round(originValue * ROUNDING_FACTOR) / (double) ROUNDING_FACTOR;
    }

    private double getTotalRevenue(List<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                .mapToDouble(LottoRank::getPrize)
                .sum();
    }

}
