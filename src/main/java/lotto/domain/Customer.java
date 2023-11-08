package lotto.domain;

import lotto.domain.Prize.PrizeType;

import java.util.HashMap;

public class Customer {
    public static final int TICKET_UNIT = 1000;
    public final int budget;
    public int numberOfTickets ;

    public Customer(Integer budget) {
        this.budget = budget;
        this.numberOfTickets = budget / TICKET_UNIT;
    }

    private static int getTotalProfits(HashMap<String, Integer> prizeCountsRecords) {
        int totalProfits = 0;
        int profits;

        for (PrizeType prize : PrizeType.values()) {
            profits = prize.getRewardMoney() * prizeCountsRecords.get(prize.place());
            totalProfits = totalProfits + profits;
        }
        return totalProfits;
    }

    public double getRateOfReturn(HashMap<String, Integer> prizeCountsRecords, int customerBudget) {
        int totalProfits = getTotalProfits(prizeCountsRecords);
        double rateOfReturn = (double) totalProfits / customerBudget;
        return rateOfReturn * 100;
    }

    public String toString() {
        return System.out.printf("%d개를 구매했습니다.", numberOfTickets).toString();
    }
}
