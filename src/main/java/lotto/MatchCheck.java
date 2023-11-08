package lotto;

import java.util.List;
import java.util.Map;

public class MatchCheck {
    private final static Integer MATCHES_3 = 5000;
    private final static Integer MATCHES_4 = 50_000;
    private final static Integer MATCHES_5 = 1_500_000;
    private final static Integer MATCHES_5_PLUS_BONUS = 30_000_000;
    private final static Integer MATCHES_6 = 2_000_000_000;
    private final static int MATCH_PLUS = 1;

    public static void win(Map<Integer, Integer> resultMap, int count) {
        switch (count) {
            case 3 -> resultMap.put(MATCHES_3, resultMap.get(MATCHES_3) + MATCH_PLUS);
            case 4 -> resultMap.put(MATCHES_4, resultMap.get(MATCHES_4) + MATCH_PLUS);
            case 5 -> resultMap.put(MATCHES_5, resultMap.get(MATCHES_5) + MATCH_PLUS);
            case 6 -> resultMap.put(MATCHES_6, resultMap.get(MATCHES_6) + MATCH_PLUS);
            case 7 -> resultMap.put(MATCHES_5_PLUS_BONUS,
                resultMap.get(MATCHES_5_PLUS_BONUS) + MATCH_PLUS);
        }
    }

    public static int winNumCount(Map<Integer, List<Integer>> customerLottoNumbers,
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

}
