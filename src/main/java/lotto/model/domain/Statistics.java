package lotto.model.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {
    private Map<Ranking, Integer> results;

    public void makeResultBoard() {
        results = new HashMap<>();
        for(Ranking ranking : Ranking.getAllRankingCase()) {
            results.put(ranking, 0);
        }
    }

    public void createData(List<Ranking> rankings) {
        for(Ranking ranking : rankings) {
            if(ranking == null) {
                continue;
            }
            results.put(ranking, results.get(ranking) + 1);
        }
    }

    private float getRateOfReturn() {
        float revenue = 0;
        for(Ranking ranking : results.keySet()) {
            revenue += (ranking.getAmount() * results.get(ranking));
        }
        return revenue;
    }

    public float calculateRateOfReturn(Purchase purchase) {
        float revenue = getRateOfReturn();
        return (revenue / purchase.getPrice()) * 100;
    }

    public Map<Ranking, Integer> getResults() {
        return results;
    }
}
