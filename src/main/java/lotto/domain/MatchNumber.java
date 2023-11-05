package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum MatchNumber {
    FIRST("6개 일치", 6, false, "2,000,000,000", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치", 5, true, "30,000,000", 30000000),
    THIRD("5개 일치", 5, false, "1,500,000", 1500000),
    FOURTH("4개 일치", 4, false, "50,000", 50000),
    FIFTH("3개 일치", 3, false, "5,000", 5000);

    private String resultMessage;
    private int matchNumber;
    private boolean isBonusMatch;
    private String moneyMessage;
    private int money;

    MatchNumber(String resultMessage,
                int matchNumber,
                boolean isBonusMatch,
                String moneyMessage,
                int money) {
        this.resultMessage = resultMessage;
        this.matchNumber = matchNumber;
        this.isBonusMatch = isBonusMatch;
        this.moneyMessage = moneyMessage;
        this.money = money;
    }

    public static MatchNumber findByMatchCountAndBonus(int count, boolean isBonusMatch) {
        if (isBonusMatch) {
            List<MatchNumber> matchNumbers = List.of(FIRST, SECOND, FOURTH, FIFTH);
            return Arrays.stream(MatchNumber.values())
                    .filter(match ->
                            match.matchNumber == count)
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("[ERROR] 일치하는 등수를 찾을 수 없습니다."));
        }
        List<MatchNumber> matchNumbers = List.of(FIRST, THIRD, FOURTH, FIFTH);
        return Arrays.stream(MatchNumber.values())
                .filter(match ->
                        match.matchNumber == count)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("[ERROR] 일치하는 등수를 찾을 수 없습니다."));
    }

}
