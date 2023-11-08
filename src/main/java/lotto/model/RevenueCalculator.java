package lotto.model;

import java.util.List;
import java.util.Map;

public class RevenueCalculator{
        public Double calculateRevenue(int purchase, Map<Rank, Integer> winningInfo) {
            double revenue = 0.0;

            for (Map.Entry<Rank, Integer> entry : winningInfo.entrySet()) {
                Rank rank = entry.getKey();
                int num = entry.getValue();
                revenue += rank.getPrize() * num;

            return revenue;
        }
}
