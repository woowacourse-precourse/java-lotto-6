package lotto.domain;

import lotto.domain.Prize.PrizeType;

import java.util.HashMap;

public class Customer {
    public static final int TICKET_UNIT = 1000;
    private static int BUDGET;
    public int NUMBER_OF_TICKETS;

    public Customer(Integer budget) {
        this.BUDGET = budget;
        this.NUMBER_OF_TICKETS = BUDGET / TICKET_UNIT;
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

    public double getRateOfReturn(HashMap<String, Integer> prizeCountsRecords) {
        int totalProfits = getTotalProfits(prizeCountsRecords);
        double rateOfReturn = (double) totalProfits / BUDGET;
        rateOfReturn = Math.round(rateOfReturn);
        return rateOfReturn;
    }

    public String toString() {
        return System.out.printf("%d개를 구매했습니다.", NUMBER_OF_TICKETS).toString();
    }
}
