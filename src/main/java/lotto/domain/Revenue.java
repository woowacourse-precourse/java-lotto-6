package lotto.domain;

import java.util.Map;

public class Revenue {

    public String calculateRevenue(int payment, Map<Integer, Integer> winningTicketsCount) {
        double revenue = winningTicketsCount.get(5) * 5000 + winningTicketsCount.get(4) * 50000 + winningTicketsCount.get(3) * 1500000 + winningTicketsCount.get(2) * 30000000 + winningTicketsCount.get(1) * 2000000000;
        double temp = revenue / payment * 100;
        String revenueRate = String.format("%.1f", temp);
        return revenueRate;
    }
}
