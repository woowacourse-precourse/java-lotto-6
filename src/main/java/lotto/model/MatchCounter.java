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

    private Map<String, Integer> matchCounter;

    public MatchCounter() {
        this.matchCounter = new HashMap<>();
    }

    public void init() {
        matchCounter.put("three number matched", 0); // 문자열 상수화
        matchCounter.put("four number matched", 0);
        matchCounter.put("five number matched", 0);
        matchCounter.put("five number and bonus number matched", 0);
        matchCounter.put("six number matched", 0);
    }

    public String matchingKeyByCount(Integer lottoCount, Integer bonusCount) {
        if (bonusCount.equals(ONE)) {
            return "five number and bonus number matched"; // 상수화 하기
        }
        if (lottoCount.equals(THREE)) {
            return "three number matched";
        }
        if (lottoCount.equals(FOUR)) {
            return "four number matched";
        }
        if (lottoCount.equals(FIVE)) {
            return "five number matched";
        }
        if (lottoCount.equals(SIX)) {
            return "six number matched";
        }

        throw new IllegalArgumentException(); // 에러문 추가
    }

    public void increaseCountByKey(String key) {
        matchCounter.put(key, matchCounter.get(key) + ONE);
    }

    public WinningStatisticDTO createWinningStatisticDTO() {
        return new WinningStatisticDTO(
                matchCounter.get("three number matched"),
                matchCounter.get("four number matched"),
                matchCounter.get("five number matched"),
                matchCounter.get("five number and bonus number matched"),
                matchCounter.get("siz number matched")
        );
    }
}
