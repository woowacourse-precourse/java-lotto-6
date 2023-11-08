package lotto.service;

import java.util.Map;
import lotto.readUserInput.PurchaseAmount;

public class RateOfReturn {
    private Map<Reward, Integer> ticketResult;
    private PurchasedLottoTickets purchasedLottoTickets;
    public static final int BENEFIT_ZERO_INITIAL_VALUE = 0;
    public static final int HUNDRED_TO_GET_PERCENTAGE = 100;

    public RateOfReturn(PurchasedLottoTickets purchasedLottoTickets) {
        this.purchasedLottoTickets = purchasedLottoTickets;

    }

    public void initTicketResult() {
        ticketResult = purchasedLottoTickets.eachRankCount();
    }

    public String calculate() {
        double benefit = BENEFIT_ZERO_INITIAL_VALUE;
        benefit += ticketResult.get(Reward.FIRST_PLACE) * Reward.FIRST_PLACE.getReward();
        benefit += ticketResult.get(Reward.SECOND_PLACE) * Reward.SECOND_PLACE.getReward();
        benefit += ticketResult.get(Reward.THIRD_PLACE) * Reward.THIRD_PLACE.getReward();
        benefit += ticketResult.get(Reward.FOURTH_PLACE) * Reward.FOURTH_PLACE.getReward();
        benefit += ticketResult.get(Reward.FIFTH_PLACE) * Reward.FIFTH_PLACE.getReward();

        double result = benefit / (purchasedLottoTickets.allTicketCount() * PurchaseAmount.MIN_PURCHASE_LOTTO)
                * HUNDRED_TO_GET_PERCENTAGE;

        return String.format("%.1f", result);
    }

    public void printRateOfReturn() {
        String benefitRate = calculate();
        System.out.println("총 수익률은 " + benefitRate + "%입니다.");
    }
}
