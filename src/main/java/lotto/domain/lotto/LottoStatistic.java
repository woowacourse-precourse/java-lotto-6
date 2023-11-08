package lotto.domain.lotto;

import java.util.Map;
import java.util.TreeMap;

public class LottoStatistic {

    private final Map<LottoResult, Integer> answer = new TreeMap<>();

    public LottoStatistic() {
        for (LottoResult result : LottoResult.values()) {
            answer.put(result, 0);
        }
    }

    public Map<LottoResult, Integer> getAnswer() {
        return answer;
    }

    public void addLottoResult(LottoResult result) {
        answer.put(result, answer.get(result) + 1);
    }

    public Long getTotalMoney() {
        return answer.entrySet().stream()
                .mapToLong(m -> (long) m.getKey().getPrizeMoney() * m.getValue())
                .sum();
    }

}
