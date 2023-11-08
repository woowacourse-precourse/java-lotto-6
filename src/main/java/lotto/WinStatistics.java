package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WinStatistics {

    private final static Integer MATCHES_3 = 5000;
    private final static Integer MATCHES_4 = 50_000;
    private final static Integer MATCHES_5 = 1_500_000;
    private final static Integer MATCHES_5_PLUS_BONUS = 30_000_000;
    private final static Integer MATCHES_6 = 2_000_000_000;
    private final static int INIT_COUNT = 0;

    public static Map<Integer, Integer> result(Map<Integer, List<Integer>> customerLottoNumbers,
        List<Integer> numbers, int bonusNumber) {
        Map<Integer, Integer> resultMap = init();
        for (Integer key : customerLottoNumbers.keySet()) {
            int count = 0;
            count = MatchCheck.winNumCount(customerLottoNumbers, numbers, key, count, bonusNumber);
            MatchCheck.win(resultMap, count);
        }
        return resultMap;
    }
    private static Map<Integer, Integer> init() {
        Map<Integer, Integer> resultMap = new LinkedHashMap<>();
        resultMap.put(MATCHES_3, INIT_COUNT);
        resultMap.put(MATCHES_4, INIT_COUNT);
        resultMap.put(MATCHES_5, INIT_COUNT);
        resultMap.put(MATCHES_5_PLUS_BONUS, INIT_COUNT);
        resultMap.put(MATCHES_6, INIT_COUNT);
        return resultMap;
    }
}
