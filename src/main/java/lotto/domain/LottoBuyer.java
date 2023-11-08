package lotto.domain;

import java.util.List;

public class LottoBuyer {
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
        double originValue = getTotalRevenue(lottoRanks) / (double) payment.get() * (double) 100;
        return Math.round(originValue * 10) / (double) 10;
    }

    private double getTotalRevenue(List<LottoRank> lottoRanks) {
        return lottoRanks.stream()
                .mapToDouble(LottoRank::getPrize)
                .sum();
    }

}
