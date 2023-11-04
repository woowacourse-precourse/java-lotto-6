package lotto.model;

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

    public Map<Ranking, Integer> createData(List<Ranking> rankings) {
        for(Ranking ranking : rankings) {
            if(ranking == null) {
                continue;
            }
            results.put(ranking, results.get(ranking) + 1);
        }
        return results;
    }

    public float getRateOfReturn() {
        float revenue = 0;
        for(Ranking ranking : results.keySet()) {
            revenue += (ranking.getAmount() * results.get(ranking));
        }
        return revenue;
    }

    public Map<Ranking, Integer> getResults() {
        return results;
    }
}
