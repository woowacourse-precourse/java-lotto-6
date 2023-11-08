package lotto.Constants;

import java.util.Arrays;
import java.util.Map;

public enum MatchTypes {
    THREE_MATCH(3, 0, 5000, "3개 일치 (5,000원) - %d개\n"),
    FOUR_MATCH(4, 0, 50000, "4개 일치 (50,000원) - %d개\n"),
    FIVE_MATCH(5, 0, 1500000, "5개 일치 (1,500,000원) - %d개\n"),
    FIVE_MATCH_WITH_BONUS(5, 1, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    SIX_MATCH(6, 0, 2000000000, "6개 일치 (2,000,000,000원) - %d개\n");

    private Integer matchNum;
    private Integer bonusMatch;
    private Integer prize;
    private String message;

    MatchTypes(Integer matchNum, Integer bonusMatch, Integer prize, String message) {
        this.matchNum = matchNum;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
        this.message = message;
    }


    public static MatchTypes findMatchType(Integer matchCount, Integer hasBonusMatch) {
        return Arrays.stream(MatchTypes.values())
                .filter(pc -> pc.matchNum.equals(matchCount))
                .filter(pc -> (hasBonusMatch.equals(1) && pc.bonusMatch.equals(1))
                        || (hasBonusMatch.equals(0) && pc.bonusMatch.equals(0)))
                .findAny()
                .orElse(null);
    }

    public static Integer calculateTotalPrize(Map<MatchTypes, Integer> drawResult) {
        return Arrays.stream(MatchTypes.values())
                .filter(drawResult::containsKey)
                .mapToInt(type -> type.prize * drawResult.get(type))
                .sum();
    }

    public String getMessage() {
        return this.message;
    }
}
