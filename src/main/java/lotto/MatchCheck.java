package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MatchCheck {

    private final static Long MATCHES_3 = 5000L;
    private final static Long MATCHES_4 = 50_000L;
    private final static Long MATCHES_5 = 1_500_000L;
    private final static Long MATCHES_5_PLUS_BONUS = 30_000_000L;
    private final static Long MATCHES_6 = 2_000_000_000L;
    private final static int INIT_COUNT = 0;
    private final static int MATCH_PLUS = 1;

    public static Map<Long, Integer> result(Map<Integer, List<Integer>> customerLottoNumbers,
        List<Integer> numbers, int bonusNumber) {
        Map<Long, Integer> resultMap = init();
        for (Integer key : customerLottoNumbers.keySet()) {
            int count = 0;
            count = matchWinNumCount(customerLottoNumbers, numbers, key, count, bonusNumber);
            checkWin(resultMap, count);
        }
        return resultMap;
    }

    private static int matchWinNumCount(Map<Integer, List<Integer>> customerLottoNumbers,
        List<Integer> result, Integer key, int count, int bonusNumber) {
        for (Integer integer : result) {
            if (customerLottoNumbers.get(key).contains(integer)) {
                count++;
            }
        }
        if (count == 5 && customerLottoNumbers.get(key).contains(bonusNumber)) {
            count += 2;
        }
        return count;
    }

    private static Map<Long, Integer> init() {
        Map<Long, Integer> resultMap = new LinkedHashMap<>();
        resultMap.put(MATCHES_3, INIT_COUNT);
        resultMap.put(MATCHES_4, INIT_COUNT);
        resultMap.put(MATCHES_5, INIT_COUNT);
        resultMap.put(MATCHES_5_PLUS_BONUS, INIT_COUNT);
        resultMap.put(MATCHES_6, INIT_COUNT);
        return resultMap;
    }

    private static void checkWin(Map<Long, Integer> resultMap, int count) {
        switch (count) {
            case 3 -> resultMap.put(MATCHES_3, resultMap.get(MATCHES_3) + MATCH_PLUS);
            case 4 -> resultMap.put(MATCHES_4, resultMap.get(MATCHES_4) + MATCH_PLUS);
            case 5 -> resultMap.put(MATCHES_5, resultMap.get(MATCHES_5) + MATCH_PLUS);
            case 6 -> resultMap.put(MATCHES_6, resultMap.get(MATCHES_6) + MATCH_PLUS);
            case 7 -> resultMap.put(MATCHES_5_PLUS_BONUS,
                resultMap.get(MATCHES_5_PLUS_BONUS) + MATCH_PLUS);
        }
    }

}
