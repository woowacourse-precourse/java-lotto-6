package lotto.service;

import java.util.Map;
import lotto.readUserInput.PurchaseAmount;

public class RateOfReturn {
    private Map<String, Integer> ticketResult;


    public RateOfReturn(PurchasedLottoTickets purchasedLottoTickets) {
        this.ticketResult = purchasedLottoTickets.eachRankCount();
    }

    public String calculate() {
        double benefit = 0;
        benefit += ticketResult.get("1st") * 2000000000;
        benefit += ticketResult.get("2nd") * 30000000;
        benefit += ticketResult.get("3rd") * 1500000;
        benefit += ticketResult.get("4th") * 50000;
        benefit += ticketResult.get("5th") * 5000;

        double result = benefit / (PurchaseAmount.lottoQuantity * 1000) * 100;

        return String.format("%.1f", result);
    }

    public void printRateOfReturn() {
        String benefitRate = calculate();
        System.out.println("총 수익률은 " + benefitRate + "%입니다.");
    }
}
