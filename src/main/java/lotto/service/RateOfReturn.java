package lotto.service;

import java.util.Map;

public class RateOfReturn {
    private Map<Reward, Integer> ticketResult;
    private PurchasedLottoTickets purchasedLottoTickets;


    public RateOfReturn(PurchasedLottoTickets purchasedLottoTickets) {
        this.purchasedLottoTickets = purchasedLottoTickets;
        initTicketResult();
    }

    public void initTicketResult() {
        ticketResult = purchasedLottoTickets.eachRankCount();
    }

    public String calculate() {
        double benefit = 0;
        benefit += ticketResult.get(Reward.FIRST_PLACE) * Reward.FIRST_PLACE.getReward();
        benefit += ticketResult.get(Reward.SECOND_PLACE) * Reward.SECOND_PLACE.getReward();
        benefit += ticketResult.get(Reward.THIRD_PLACE) * Reward.THIRD_PLACE.getReward();
        benefit += ticketResult.get(Reward.FOURTH_PLACE) * Reward.FOURTH_PLACE.getReward();
        benefit += ticketResult.get(Reward.FIFTH_PLACE) * Reward.FIFTH_PLACE.getReward();

        double result = benefit / (purchasedLottoTickets.allTicketCount() * 1000) * 100;

        return String.format("%.1f", result);
    }

    public void printRateOfReturn() {
        String benefitRate = calculate();
        System.out.println("총 수익률은 " + benefitRate + "%입니다.");
    }
}
