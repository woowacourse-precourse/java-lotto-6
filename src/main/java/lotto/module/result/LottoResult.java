package lotto.module.result;

import java.util.HashMap;
import java.util.Map;

/**
 * 로또 당첨 결과를 담은 클래스
 */
public class LottoResult {
    private final Map<Integer, Integer> result = new HashMap<>();

    private LottoResult() {
    }

    public static LottoResult newInstance() {
        return new LottoResult();
    }

    public void add(int rank) {
        result.put(rank, result.getOrDefault(rank, 1) + 1);
    }

    public Map<Integer, Integer> getResult() {
        return new HashMap<>(result);
    }

    public int getRankCount(int rank) {
        return result.get(rank);
    }

}
