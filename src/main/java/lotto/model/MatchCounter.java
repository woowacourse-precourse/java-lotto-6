package lotto.model;

import java.util.HashMap;
import java.util.Map;
import lotto.dto.WinningStatisticDTO;

public class MatchCounter {
    private static final Integer ONE = 1;
    private static final Integer THREE = 3;
    private static final Integer FOUR = 4;
    private static final Integer FIVE = 5;
    private static final Integer SIX = 6;

    private static final String THREE_MATCHED = "three matched";
    private static final String FOUR_MATCHED = "four matched";
    private static final String FIVE_MATCHED = "five matched";
    private static final String FIVE_AND_BONUS_MATCHED = "five and bonus matched";
    private static final String SIX_MATCHED = "six matched";

    private Map<String, Integer> matchCounter;

    public MatchCounter() {
        this.matchCounter = new HashMap<>();
    }

    public void init() {
        matchCounter.put(THREE_MATCHED, 0); // 문자열 상수화
        matchCounter.put(FOUR_MATCHED, 0);
        matchCounter.put(FIVE_MATCHED, 0);
        matchCounter.put(FIVE_AND_BONUS_MATCHED, 0);
        matchCounter.put(SIX_MATCHED, 0);
    }

    public String matchingKeyByCount(Integer lottoCount, Integer bonusCount) {
        if (bonusCount.equals(ONE)) {
            return FIVE_AND_BONUS_MATCHED;
        }
        if (lottoCount.equals(THREE)) {
            return THREE_MATCHED;
        }
        if (lottoCount.equals(FOUR)) {
            return FOUR_MATCHED;
        }
        if (lottoCount.equals(FIVE)) {
            return FIVE_MATCHED;
        }
        if (lottoCount.equals(SIX)) {
            return SIX_MATCHED;
        }

        throw new IllegalArgumentException(); // 에러문 추가
    }

    public void increaseCountByKey(String key) {
        matchCounter.put(key, matchCounter.get(key) + ONE);
    }

    public WinningStatisticDTO createWinningStatisticDTO() {
        return new WinningStatisticDTO(
                matchCounter.get(THREE_MATCHED),
                matchCounter.get(FOUR_MATCHED),
                matchCounter.get(FIVE_MATCHED),
                matchCounter.get(FIVE_AND_BONUS_MATCHED),
                matchCounter.get(SIX_MATCHED)
        );
    }
}
